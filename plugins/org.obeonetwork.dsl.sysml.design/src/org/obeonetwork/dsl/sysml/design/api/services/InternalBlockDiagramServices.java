/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.sysml.design.api.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.papyrus.sysml14.deprecatedelements.FlowPort;
import org.eclipse.papyrus.sysml14.portsandflows.FlowDirection;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DNodeContainer;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.EncapsulatedClassifier;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.obeonetwork.dsl.sysml.design.internal.services.PortServices;
import org.obeonetwork.dsl.sysml.design.internal.services.SysmlElementServices;

import com.google.common.collect.Lists;

/**
 * A set of services to handle the Internal Block diagram.
 *
 * @author Melanie Bats <a href="mailto:melanie.bats@obeo.fr">melanie.bats@obeo.fr</a>
 */
public class InternalBlockDiagramServices extends SysmlAbstractDiagramServices {

	public Port createProxyPort(final EObject container) {
		final EncapsulatedClassifier classifier;
		if (container instanceof EncapsulatedClassifier) {
			classifier = (EncapsulatedClassifier)container;
		} else if (container instanceof Property) {
			if (((Property)container).getType() instanceof EncapsulatedClassifier) {
				classifier = (EncapsulatedClassifier)((Property)container).getType();
			} else {
				throw new IllegalArgumentException();
			}
		} else {
			throw new IllegalArgumentException();
		}
		final Port port = UMLFactory.eINSTANCE.createPort();
		classifier.getOwnedAttributes().add(port);
		SysmlElementServices.INSTANCE.createAssociatedStereotype(port, "SysML::PortsAndFlows", "ProxyPort");
		return port;
	}

	/**
	 * Get all non constraint blocks.
	 *
	 * @param container
	 *            Container
	 * @return All blocks.
	 */
	public List<Class> getAllNonConstraintBlocks(EObject container) {
		// Replace expression :
		// [container.getRootContainer().eAllContents(uml::Package)->union(container.getRootContainer().eAllContents(uml::Class)->select(isBlock()))/]
		final List<Class> blocks = Lists.newArrayList();
		for (final Iterator<EObject> iterator = SysmlElementServices.INSTANCE.getRootContainer(container)
				.eAllContents(); iterator.hasNext();) {
			final EObject element = iterator.next();
			if (element instanceof Class && SysmlElementServices.INSTANCE.isBlock((Class)element)
					&& !SysmlElementServices.INSTANCE.isConstraintBlock((Class)element)) {
				blocks.add((Class)element);
			}
		}
		return blocks;
	}

	/**
	 * Returns the list of all connectors that can be displayed on the following diagram.
	 *
	 * @param diagram
	 *            an IDB diagram.
	 * @return the list of all connectors that can be displayed on the following diagram.
	 */
	public List<Connector> getConnectorsToDisplay(final DSemanticDiagram diagram) {
		final Session session = SessionManager.INSTANCE.getSession(diagram.getTarget());

		final Set<Port> allDisplayedPorts = new LinkedHashSet<Port>();
		for (final DDiagramElement diagramElement : diagram.getDiagramElements()) {
			if (diagramElement.getTarget() instanceof Port) {
				final Port port = (Port)diagramElement.getTarget();
				allDisplayedPorts.add(port);
			}
		}

		final Set<Connector> result = new LinkedHashSet<Connector>();
		for (final Port displayedPort : allDisplayedPorts) {
			for (final Setting inverse : session.getSemanticCrossReferencer()
					.getInverseReferences(displayedPort)) {
				if (inverse.getEStructuralFeature() == UMLPackage.eINSTANCE.getConnectorEnd_Role()
						&& inverse.getEObject() instanceof ConnectorEnd
						&& inverse.getEObject().eContainer() instanceof Connector) {
					final ConnectorEnd connectorEnd = (ConnectorEnd)inverse.getEObject();
					// FIXME check part with port and propertyPath for nested port.
					result.add((Connector)connectorEnd.eContainer());
				}
			}
		}

		return new ArrayList<Connector>(result);
	}

	/**
	 * Get the flow port.
	 *
	 * @param element
	 *            Named element
	 * @return Flow port
	 */
	private FlowPort getFlowPort(NamedElement element) {
		for (final EObject stereotype : element.getStereotypeApplications()) {
			if (stereotype instanceof FlowPort) {
				return (FlowPort)stereotype;
			}
		}
		return null;
	}

	/**
	 * Get the parent view of an element. This method is used by the add related elements function to retrieve
	 * the parent view.
	 *
	 * @param element
	 *            element
	 * @return Parent view
	 */
	public DNodeContainer getParentView(Element element) {
		final Session session = SessionManager.INSTANCE.getSession(element);
		final Collection<Setting> refs = session.getSemanticCrossReferencer()
				.getInverseReferences(element.eContainer());
		for (final Setting setting : refs) {
			if (setting.getEObject() instanceof DNodeContainer) {
				return (DNodeContainer)setting.getEObject();
			}
		}
		return null;
	}

	/**
	 * Get port types.
	 *
	 * @param container
	 *            Container
	 * @return Port types
	 */
	public List<Classifier> getPortTypes(EObject container) {
		final List<Classifier> results = Lists.newArrayList();
		for (final Iterator<EObject> iterator = SysmlElementServices.INSTANCE.getRootContainer(container)
				.eAllContents(); iterator.hasNext();) {
			final EObject element = iterator.next();
			if (element instanceof Classifier
					&& !SysmlElementServices.INSTANCE.isConstraintBlock((Classifier)element)
					&& (SysmlElementServices.INSTANCE.isBlock((Classifier)element)
							|| element instanceof PrimitiveType || element instanceof DataType
							|| element instanceof Interface)) {
				results.add((Classifier)element);
			}
		}
		return results;
	}

	public boolean isDelegationOf(Port source, Port target) {
		return PortServices.INSTANCE.isDelegationOf(source, target);
	}

	public boolean isDualWith(Port source, Port target) {
		return PortServices.INSTANCE.isDualWith(source, target);
	}

	/**
	 * @see SysmlElementServices#isFlowPort(Element)
	 */
	public boolean isFlowPort(Element element) {
		return SysmlElementServices.INSTANCE.isFlowPort(element);
	}

	public boolean isInFlowPort(NamedElement element) {
		final FlowPort port = getFlowPort(element);
		return port != null && port.getDirection().equals(FlowDirection.IN);
	}

	/**
	 * Checks if element an element is an in port.
	 *
	 * @param element
	 *            Named element
	 * @return True if element is an in port otherwise false
	 */
	public boolean isInPort(NamedElement element) {
		return isPort(element) && ((Port)element).getRequireds().size() > 0;
	}

	/**
	 * @see PortServices#isNotDelegationOf(Port, Port)
	 */
	public boolean isNotDelegationOf(Port source, Port target) {
		return PortServices.INSTANCE.isNotDelegationOf(source, target);
	}

	public boolean isOutFlowPort(NamedElement element) {
		final FlowPort port = getFlowPort(element);
		return port != null && port.getDirection().equals(FlowDirection.OUT);
	}

	/**
	 * Checks if element an element is an out port.
	 *
	 * @param element
	 *            Named element
	 * @return True if element is an out port otherwise false
	 */
	public boolean isOutPort(NamedElement element) {
		return isPort(element) && ((Port)element).getProvideds().size() > 0;
	}

	/**
	 * Checks if element has the stereotype port.
	 *
	 * @param element
	 *            Named element
	 * @return True if element is a port otherwise false
	 */
	public boolean isPort(NamedElement element) {
		return element instanceof Port && !SysmlElementServices.INSTANCE.isFlowPort(element);
	}

	/**
	 * Checks if an element is a valid root of an internal block diagram.
	 *
	 * @param element
	 *            Named element
	 * @return True if element could be a root of an internal block diagram otherwise false
	 */
	public boolean isValidInternalBlockDiagramRoot(Class element) {
		// Replace the acceleo expression : [getStereotypeApplications()->filter(sysml::blocks::Block)->size()
		// > 0/]
		return SysmlElementServices.INSTANCE.isBlock(element);
	}
}
