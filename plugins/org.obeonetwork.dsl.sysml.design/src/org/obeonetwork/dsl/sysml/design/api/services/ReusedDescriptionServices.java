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

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DSemanticDiagramSpec;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.description.DiagramElementMapping;
import org.eclipse.sirius.diagram.description.Layer;
import org.eclipse.sirius.ui.business.api.dialect.DialectEditor;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.obeonetwork.dsl.sysml.design.internal.services.ISysmlConstants;
import org.obeonetwork.dsl.sysml.design.internal.services.SysmlElementServices;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

/**
 * A set of services to handle the Reused Description diagram.
 *
 * @author Melanie Bats <a href="mailto:melanie.bats@obeo.fr">melanie.bats@obeo.fr</a>
 */
@SuppressWarnings("restriction")
public class ReusedDescriptionServices extends org.obeonetwork.dsl.uml2.core.api.services.ReusedDescriptionServices {

	/**
	 * Get all valid attributes of a class.
	 *
	 * @param cur
	 *            Current element
	 * @param validForDiagram
	 *            Predicate
	 * @return List of valid elements
	 */
	private List<EObject> allValidAttributes(Class cur, Predicate<EObject> validForDiagram) {
		final List<EObject> result = Lists.newArrayList();
		Iterators.addAll(result, Iterators.filter(cur.getAttributes().iterator(), validForDiagram));
		return result;
	}

	/**
	 * Get all valid elements in session.
	 *
	 * @param cur
	 *            Current element
	 * @param validForDiagram
	 *            Predicate
	 * @return List of valid elements
	 */
	private List<EObject> allValidSessionElements(EObject cur, Predicate<EObject> validForDiagram) {
		final Session found = SessionManager.INSTANCE.getSession(cur);
		final List<EObject> result = Lists.newArrayList();
		if (found != null) {
			for (final Resource res : found.getSemanticResources()) {
				Iterators.addAll(result, Iterators.filter(res.getAllContents(), validForDiagram));
			}
		}
		return result;
	}

	public void createAssociatedStereotype(Element e, String profileQualifiedName, String stereotypeName) {
		SysmlElementServices.INSTANCE.createAssociatedStereotype(e, profileQualifiedName, stereotypeName);
	}

	/**
	 * Check if an element is a container.
	 *
	 * @param container
	 *            Semantic container
	 * @param containerView
	 *            Container view
	 * @return True if element is valid for the given container view
	 */
	public boolean existValidElementsForContainerView(final EObject container, final EObject containerView) {
		if (container instanceof Element && containerView instanceof DSemanticDecorator) {
			final Session session = SessionManager.INSTANCE.getSession(container);
			// Get all available mappings applicable for the selected element in the
			// current container
			final List<DiagramElementMapping> semanticElementMappings = getMappings(
					(DSemanticDecorator)containerView, session);

			return semanticElementMappings.size() > 0;
		}
		return false;
	}

	/**
	 * Get all the valid elements for a block definition diagram.
	 *
	 * @param cur
	 *            Current semantic element
	 * @return List of elements visible on a block definition diagram
	 */
	private List<EObject> getValidsForBlockDefinitionDiagram(EObject cur) {
		final Predicate<EObject> validForDiagram = new Predicate<EObject>() {

			public boolean apply(EObject input) {

				return "Model".equals(input.eClass().getName()) || "Package".equals(input.eClass().getName()) //$NON-NLS-1$ //$NON-NLS-2$
						|| input instanceof Interface
						|| input instanceof InstanceSpecification
								&& hasStereotype((InstanceSpecification)input, "Unit") //$NON-NLS-1$
						|| input instanceof InstanceSpecification
								&& hasStereotype((InstanceSpecification)input, "Dimension") //$NON-NLS-1$
						|| input instanceof DataType || input instanceof Actor
						|| input instanceof Class && hasStereotype((Class)input, "Block") //$NON-NLS-1$
						|| input instanceof Class && hasStereotype((Class)input, "ConstraintBlock"); //$NON-NLS-1$
			}
		};
		return allValidSessionElements(cur, validForDiagram);
	}

	/**
	 * Get all the valid elements for an internal block diagram.
	 *
	 * @param cur
	 *            Current semantic element
	 * @return List of elements visible on an internal block diagram
	 */
	private List<EObject> getValidsForInternalBlockDiagram(Class cur) {
		final Predicate<EObject> validForDiagram = new Predicate<EObject>() {

			public boolean apply(EObject input) {
				return !(input instanceof Port) && input instanceof Property;
			}
		};
		return allValidAttributes(cur, validForDiagram);
	}

	/**
	 * Get all the valid elements for an internal block diagram.
	 *
	 * @param cur
	 *            Current semantic element
	 * @return List of elements visible on an internal block diagram
	 */
	private List<EObject> getValidsForParametricBlockDiagram(Class cur) {
		final boolean isValueBindingLayerActive = isValueBindingLayerActive(cur);
		final Predicate<EObject> validForDiagram = new Predicate<EObject>() {

			public boolean apply(EObject input) {
				if (!isValueBindingLayerActive) {
					return !(input instanceof Port) && input instanceof Property
							&& hasStereotype((Element)input, "ConstraintProperty"); //$NON-NLS-1$
				}
				return !(input instanceof Port) && input instanceof Property;
			}
		};
		return allValidAttributes(cur, validForDiagram);
	}

	/**
	 * Get all the valid elements for a requirement diagram.
	 *
	 * @param cur
	 *            Current semantic element
	 * @return List of elements visible on a requirement diagram
	 */
	private List<EObject> getValidsForRequirementDiagram(Element cur, final DDiagram diagram) {

		isVerifyLayerActive(diagram);
		isSatisfyLayerActive(diagram);
		isRefineLayerActive(diagram);

		final Predicate<EObject> validForClassDiagram = new Predicate<EObject>() {

			public boolean apply(EObject input) {
				return input instanceof Package || "Class".equals(input.eClass().getName()) //$NON-NLS-1$
						&& ((Class)input).getAppliedStereotype(ISysmlConstants.SYSML_REQUIREMENT) != null
						|| isVerifyLayerActive(diagram)
								&& (input instanceof Class && isTestClass((Class)input)
										|| input instanceof Operation && ((Operation)input)
												.getAppliedStereotype(ISysmlConstants.SYSML_TESTCASE) != null)
						|| isSatisfyLayerActive(diagram) && input instanceof Class
								&& ((Class)input).getAppliedStereotype(ISysmlConstants.SYSML_BLOCK) != null
						|| isRefineLayerActive(diagram)
								&& (input instanceof Behavior || input instanceof BehavioredClassifier);
			}

			private boolean isTestClass(Class input) {
				for (final Operation operation : input.getAllOperations()) {
					if (operation.getAppliedStereotype(ISysmlConstants.SYSML_TESTCASE) != null) {
						return true;
					}
				}
				return false;
			}
		};
		return allValidSessionElements(cur, validForClassDiagram);
	}

	public List<EObject> getValidsForSysmlDiagram(final Element element,
			final DSemanticDecorator containerView) {
		// Get representation
		DRepresentation representation = null;
		if (containerView instanceof DRepresentation) {
			representation = (DRepresentation)containerView;
		} else if (containerView instanceof DDiagramElement) {
			representation = ((DDiagramElement)containerView).getParentDiagram();
		}
		List<EObject> results = null;
		if (representation instanceof DSemanticDiagramSpec) {
			final DiagramDescription description = ((DSemanticDiagramSpec)representation).getDescription();

			if ("Block Definition Diagram".equals(description.getName())) { //$NON-NLS-1$
				results = getValidsForBlockDefinitionDiagram(element);
			} else if ("Internal Block Diagram".equals(description.getName())) { //$NON-NLS-1$
				results = getValidsForInternalBlockDiagram((Class)element);
			} else if ("Parametric Diagram".equals(description.getName())) { //$NON-NLS-1$
				results = getValidsForParametricBlockDiagram((Class)element);
			} else if ("Requirement Diagram".equals(description.getName())) { //$NON-NLS-1$
				results = getValidsForRequirementDiagram(element, (DDiagram)representation);
			}
		}

		return results;
	}

	/**
	 * Check if an UML element has a stereotype defined as parameter.
	 *
	 * @param element
	 *            UML element
	 * @param stereotype
	 *            Stereotype name to check
	 * @return True if the UML element has the given stereotype
	 */
	protected boolean hasStereotype(Element element, String stereotypeName) {
		for (final EObject stereotype : element.getStereotypeApplications()) {
			if (stereotypeName.equals(stereotype.eClass().getName())) {
				return true;
			}
		}
		return false;
	}

	private boolean isLayerActive(DDiagram diagram, String layerName) {
		for (final Layer layer : diagram.getActivatedLayers()) {
			if (layerName.equals(layer.getName())) {
				return true;
			}
		}
		return false;
	}

	protected boolean isRefineLayerActive(DDiagram diagram) {
		return isLayerActive(diagram, "Refine"); //$NON-NLS-1$
	}

	protected boolean isSatisfyLayerActive(DDiagram diagram) {
		return isLayerActive(diagram, "Satisfy"); //$NON-NLS-1$
	}

	public boolean isValidAttributesContainer(EObject container, EObject containerView) {
		// [container.oclAsType(ecore::EObject).existValidElementsForContainerView(containerView.oclAsType(ecore::EObject))/]
		return existValidElementsForContainerView(container, containerView)
				&& !(containerView instanceof DDiagram);
	}

	/**
	 * Check if value binding layer is active.
	 *
	 * @param cur
	 *            Current semantic element
	 * @return True if value binding layer is active otherwise false
	 */
	private boolean isValueBindingLayerActive(EObject cur) {
		final IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getActiveEditor();

		if (editor instanceof DialectEditor) {
			final DialectEditor dialectEditor = (DialectEditor)editor;
			final DRepresentation representation = dialectEditor.getRepresentation();
			if (representation instanceof DDiagram) {
				final DDiagram diagram = (DDiagram)representation;
				final List<Layer> layers = diagram.getActivatedLayers();
				for (final Layer layer : layers) {
					if ("PAR ValueBinding Layer".equals(layer.getName())) { //$NON-NLS-1$
						return true;
					}
				}
			}
		}
		return false;
	}

	protected boolean isVerifyLayerActive(DDiagram diagram) {
		return isLayerActive(diagram, "Verify"); //$NON-NLS-1$
	}
}
