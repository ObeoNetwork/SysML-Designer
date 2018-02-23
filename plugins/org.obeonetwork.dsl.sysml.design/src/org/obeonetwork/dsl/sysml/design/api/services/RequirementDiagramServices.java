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

import java.util.Collection;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.sysml14.requirements.Requirement;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.DNodeList;
import org.eclipse.sirius.diagram.EdgeTarget;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Stereotype;
import org.obeonetwork.dsl.sysml.design.internal.services.ISysmlConstants;
import org.obeonetwork.dsl.sysml.design.internal.services.SysMLReconnectSwitch;
import org.obeonetwork.dsl.sysml.design.internal.services.SysmlElementServices;
import org.obeonetwork.dsl.uml2.core.internal.services.NodeInverseRefsServices;

/**
 * A set of services to handle the Requirement diagram.
 *
 * @author Melanie Bats <a href="mailto:melanie.bats@obeo.fr">melanie.bats@obeo.fr</a>
 */
public class RequirementDiagramServices extends SysmlAbstractDiagramServices {

	private static final String REQUIREMENT_ID_ATTRIBUTE_NAME = "id"; //$NON-NLS-1$

	private static final String REQUIREMENT_TEXT_ATTRIBUTE_NAME = "text"; //$NON-NLS-1$

	/**
	 * Delete the given requirement.
	 *
	 * @param requirement
	 *            the requirement to delete.
	 */
	public void deleteRequirement(final Class requirement) {
		EcoreUtil.remove(requirement);
	}

	/**
	 * Retrieve the cross references of the abstraction of all the UML elements displayed as node in a
	 * Diagram.
	 *
	 * @param diagram
	 *            a diagram.
	 * @return the list of cross reference of the given element type
	 */
	public Collection<EObject> getAbstractionInverseRefs(DDiagram diagram) {
		return NodeInverseRefsServices.INSTANCE.getNodeInverseRefs(diagram, "Abstraction"); //$NON-NLS-1$
	}

	/**
	 * Get requirement id.
	 *
	 * @param element
	 *            Requirement
	 * @return Id
	 */
	public String getRequirementId(Class element) {
		final Requirement requirement = SysmlElementServices.INSTANCE.getRequirement(element);
		return requirement.getId();
	}

	/**
	 * Get requirement text.
	 *
	 * @param element
	 *            Requirement
	 * @return Text
	 */
	public String getRequirementText(Class element) {
		final Requirement requirement = SysmlElementServices.INSTANCE.getRequirement(element);
		return requirement.getText();
	}

	public boolean isNotBlockOrRequirement(Element element) {
		return element instanceof Class && !SysmlElementServices.INSTANCE.isBlock(element)
				&& !SysmlElementServices.INSTANCE.isRequirement(element) && !(element instanceof Activity)
				&& !(element instanceof StateMachine);
	}

	/**
	 * Checks if element has the stereotype refine.
	 *
	 * @param element
	 *            Named element
	 * @return True if element is a refine otherwise false
	 */
	public boolean isRefine(NamedElement element) {
		return SysmlElementServices.INSTANCE.isRefine(element);
	}

	/**
	 * @see SysmlElementServices#isTestCase(NamedElement)
	 */
	public boolean isTestCase(NamedElement element) {
		return SysmlElementServices.INSTANCE.isTestCase(element);
	}

	/**
	 * Generic service used to process treatments on a reconnect The processing has to be defined by
	 * overriding the corresponding caseXXX.
	 *
	 * @param context
	 *            Element attached to the existing edge
	 * @param edgeView
	 *            Represents the graphical new edge
	 * @param sourceView
	 *            Represents the graphical element pointed by the edge before reconnecting
	 * @param targetView
	 *            Represents the graphical element pointed by the edge after reconnecting
	 * @param source
	 *            Represents the semantic element pointed by the edge before reconnecting
	 * @param target
	 *            Represents the semantic element pointed by the edge after reconnecting
	 * @return the Element attached to the edge once it has been modified
	 */
	public Element reconnectRequirement(Element context, DEdge edgeView, EdgeTarget sourceView,
			EdgeTarget targetView, Class source, Class target) {
		final SysMLReconnectSwitch reconnectService = new SysMLReconnectSwitch();

		// The edgeview represents the new graphical edge
		// with testing of its source and target nodes we can
		// know if the user reconnected the source or the target of the edge
		reconnectService.setReconnectingSource(edgeView.getSourceNode().equals(targetView));
		final Class requirement = (Class)((DNodeList)edgeView.getTargetNode()).getTarget();

		reconnectService.setSubRequirement(requirement);
		reconnectService.setOldPointedClass(source);
		reconnectService.setNewPointedClass(target);
		return reconnectService.doSwitch(context);
	}

	/**
	 * Sets the identifier of the requirement applied on the given element. Does nothing if the requirement
	 * stereotype is not applied on the given element.
	 *
	 * @param element
	 *            the element to modify.
	 * @param id
	 *            the identifier of the requirement to set.
	 */
	public Element setRequirementId(final Element element, final String id) {
		final Stereotype requirement = element.getAppliedStereotype(ISysmlConstants.SYSML_REQUIREMENT);
		if (requirement != null) {
			element.setValue(requirement, REQUIREMENT_ID_ATTRIBUTE_NAME, id);
		}
		return element;
	}

	/**
	 * Sets the text of the requirement applied on the given element. Does nothing if the requirement
	 * stereotype is not applied on the given element.
	 *
	 * @param element
	 *            the element to modify.
	 * @param text
	 *            the text of the requirement to set.
	 */
	public Element setRequirementText(final Element element, final String text) {
		final Stereotype requirement = element.getAppliedStereotype(ISysmlConstants.SYSML_REQUIREMENT);
		if (requirement != null) {
			element.setValue(requirement, REQUIREMENT_TEXT_ATTRIBUTE_NAME, text);
		}
		return element;
	}

}
