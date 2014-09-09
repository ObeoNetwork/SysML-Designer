/*******************************************************************************
 * Copyright (c) 2009, 2011, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.sysml.design.services;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.papyrus.sysml.blocks.Dimension;
import org.eclipse.papyrus.sysml.blocks.Unit;
import org.eclipse.papyrus.sysml.blocks.ValueType;
import org.eclipse.papyrus.sysml.constraints.ConstraintBlock;
import org.eclipse.papyrus.sysml.constraints.ConstraintProperty;
import org.eclipse.papyrus.sysml.portandflows.FlowDirection;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.papyrus.sysml.requirements.DeriveReqt;
import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.eclipse.papyrus.sysml.requirements.Satisfy;
import org.eclipse.papyrus.sysml.requirements.TestCase;
import org.eclipse.papyrus.sysml.requirements.Verify;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.diagram.DDiagramElement;
import org.eclipse.sirius.diagram.DEdge;
import org.eclipse.sirius.diagram.DNodeContainer;
import org.eclipse.sirius.diagram.DNodeList;
import org.eclipse.sirius.diagram.DSemanticDiagram;
import org.eclipse.sirius.diagram.EdgeTarget;
import org.eclipse.sirius.diagram.business.internal.metamodel.spec.DSemanticDiagramSpec;
import org.eclipse.sirius.diagram.description.DiagramDescription;
import org.eclipse.sirius.diagram.description.Layer;
import org.eclipse.sirius.ui.business.api.dialect.DialectEditor;
import org.eclipse.sirius.viewpoint.DRepresentation;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.BehavioredClassifier;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.DataType;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.UseCase;
import org.eclipse.uml2.uml.profile.standard.Refine;
import org.obeonetwork.dsl.sysml.design.Activator;
import org.obeonetwork.dsl.uml2.design.services.EcoreServices;
import org.obeonetwork.dsl.uml2.design.services.UIServices;
import org.obeonetwork.dsl.uml2.design.services.UMLServices;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;

/**
 * Utility services for SysML.
 * 
 * @author Axel Richard <a href="mailto:axel.richard@obeo.fr">axel.richard@obeo.fr</a>
 * @author Melanie Bats <a href="mailto:melanie.bats@obeo.fr">melanie.bats@obeo.fr</a>
 */
public class SysMLServices {

	/**
	 * Sysml requirement stereotype.
	 */
	private static final String SYSML_REQUIREMENT = "SysML::Requirements::Requirement";

	/**
	 * Sysml testcase stereotype.
	 */
	private static final String SYSML_TESTCASE = "SysML::Requirements::TestCase";

	/**
	 * Sysml block stereotype.
	 */
	private static final String SYSML_BLOCK = "SysML::Blocks::Block";

	/**
	 * Check if a profile is applied on a package based on its qualified name.
	 * 
	 * @param currentPackage
	 *            Package
	 * @param profileQualifiedName
	 *            Profile qualified name
	 * @return True if profile is laready applied otherwised false
	 */
	private static Boolean isProfileApplied(Package currentPackage, String profileQualifiedName) {
		final EList<Profile> allProfiles = currentPackage.getAllAppliedProfiles();
		final Iterator<Profile> it = allProfiles.iterator();
		while (it.hasNext()) {
			Profile cur = it.next();
			if (profileQualifiedName.equalsIgnoreCase(cur.getQualifiedName()))
				return true;
		}
		return false;
	}

	/**
	 * Apply each profiles to the given Package. The first parameter is the package. The second is the profile
	 * to apply. In case of error when the profile is applied, a message is logged in the activator logger. In
	 * case of multiple application of the profile, a message is logged in the activator logger.
	 * 
	 * @param p
	 *            : the given Package
	 * @param profileQualifiedName
	 *            : the profile qualified name you want to apply.
	 */
	private void applySysMLProfile(Package p, String profileQualifiedName) {
		if (isProfileApplied(p, profileQualifiedName))
			return;
		Profile parentProfile = null;
		if (profileQualifiedName.startsWith("SysML")) {
			parentProfile = Activator.getSysMLProfile();
		} else if (profileQualifiedName.startsWith("Standard")) {
			parentProfile = Activator.getStandardProfile();
		}

		Package profilePackage = parentProfile;

		final String[] profiles = profileQualifiedName.split(":{2}");
		// search the profile in the package hierarchy
		for (int index = 1; index < profiles.length - 1; index++) {
			profilePackage = profilePackage.getNestedPackage(profiles[index]);
		}

		Profile profile = (Profile)profilePackage;

		if (profileQualifiedName.startsWith("SysML")) {
			profile = (Profile)profilePackage.getNestedPackage(profiles[profiles.length - 1]);
		}

		if (profile == null) {
			final String message = "Can't apply the profile " + profileQualifiedName + " on "
					+ p.getQualifiedName();
			Activator.log(Status.WARNING, message, null);
		} else {
			p.applyProfile(profile);
		}
	}

	/**
	 * Create the Associated Stereotype with the given element.
	 * 
	 * @param e
	 *            : the given element for which you want to apply the stereotype.
	 * @param profileQualifiedName
	 *            : the qualified name of the stereotype's profile you want to apply (ex. : SysML::Blocks for
	 *            a Block).
	 * @param stereotypeName
	 *            : the name of the stereotype you want to apply.
	 */
	public void createAssociatedStereotype(Element e, String profileQualifiedName, String stereotypeName) {

		applySysMLProfile(e.getModel(), profileQualifiedName);

		final Element element = e;
		final String stereotypeQualifiedName = profileQualifiedName + "::" + stereotypeName;

		final Stereotype stereotype = element.getApplicableStereotype(stereotypeQualifiedName);
		final EList<Stereotype> appliedStereotypes = element.getAppliedStereotypes();

		if (stereotype == null) {
			final String message = "Can't apply the setereotype " + stereotypeQualifiedName + " on "
					+ element.toString();
			Activator.log(Status.WARNING, message, null);
		} else if (appliedStereotypes != null && appliedStereotypes.contains(stereotype)) {
			final String message = "The stereotype " + stereotype.getQualifiedName()
					+ " is already applied on " + element.toString();
			Activator.log(Status.INFO, message, null);
		} else {
			element.applyStereotype(stereotype);
		}
	}

	/**
	 * Delete the Associated Stereotype with the given element.
	 * 
	 * @param e
	 *            : the given element for which you want to delete the stereotype.
	 * @param steQualified
	 *            : the qualified name of the stereotype you want to delete (ex. : SysML::Blocks::Block).
	 */
	public void deleteAssociatedStereotype(Element e, String steQualified) {
		final Element element = e;

		if (element != null && steQualified != null) {
			final Stereotype stereotype = element.getAppliedStereotype(steQualified);
			if (stereotype != null) {
				element.unapplyStereotype(stereotype);
			}
		} else {
			final String message = "Can't delete the stereotype application because the element or the stereotypeName keys are not correct";
			Activator.log(Status.INFO, message, null);
		}
	}

	/**
	 * Determines if the given element is an instance of the type.
	 * 
	 * @param e
	 *            : the given Element.
	 * @param type
	 *            : the type passed as a String.
	 * @return true if the given element is an instance of the type, false otherwise.
	 */
	public boolean isInstanceOf(Element e, String type) {
		if (e.eClass().getName().equalsIgnoreCase(type)) {
			return true;
		}
		return false;

	}

	/**
	 * Set the dimension feature for the given PrimitiveType stereotyped with a ValueType.
	 * 
	 * @param pt
	 *            : the given Element (a PrimitiveType stereotyped with a ValueType).
	 * @param is
	 *            : the new Dimension (an InstanceSpecification stereotyped with a Dimension).
	 */
	public void setDimensionForPrimitiveType(Element pt, InstanceSpecification is) {
		if (is != null && pt != null) {
			final Stereotype valueType = pt.getAppliedStereotype("SysML::Blocks::ValueType");
			final Dimension newDimension = (Dimension)is.getStereotypeApplication(is
					.getAppliedStereotype("SysML::Blocks::Dimension"));
			pt.setValue(valueType, "dimension", newDimension);
		}
	}

	/**
	 * Set the unit feature for the given PrimitiveType stereotyped with a ValueType.
	 * 
	 * @param pt
	 *            : the given Element (a PrimitiveType stereotyped with a ValueType).
	 * @param is
	 *            : the new Unit (an InstanceSpecification stereotyped with a Unit).
	 */
	public void setUnitForPrimitiveType(Element pt, InstanceSpecification is) {
		if (is != null && pt != null) {
			final Stereotype valueType = pt.getAppliedStereotype("SysML::Blocks::ValueType");
			final Unit newUnit = (Unit)is.getStereotypeApplication(is
					.getAppliedStereotype("SysML::Blocks::Unit"));
			pt.setValue(valueType, "unit", newUnit);
		}
	}

	/**
	 * Set the id feature for the given Class stereotyped with a Requirement.
	 * 
	 * @param r
	 *            : the given Element (a Class stereotyped with a Requirement).
	 * @param id
	 *            : the new id (a string).
	 */
	public void setIdForRequirement(Element r, String id) {
		if (r != null && id != null) {
			final Stereotype requirement = r.getAppliedStereotype(SYSML_REQUIREMENT);
			r.setValue(requirement, "id", id);
		}
	}

	/**
	 * Set the text feature for the given Class stereotyped with a Requirement.
	 * 
	 * @param r
	 *            : the given Element (a Class stereotyped with a Requirement).
	 * @param text
	 *            : the new text (a string).
	 */
	public void setTextForRequirement(Element r, String text) {
		if (r != null && text != null) {
			final Stereotype requirement = r.getAppliedStereotype(SYSML_REQUIREMENT);
			r.setValue(requirement, "text", text);
		}
	}

	/**
	 * Returns the root container; it may be this object itself.
	 * 
	 * @param eObject
	 *            the object to get the root container for.
	 * @return the root container.
	 */
	public EObject getRootContainer(EObject eObject) {
		return EcoreUtil.getRootContainer(eObject);
	}

	/**
	 * Check if the given layer is activated.
	 * 
	 * @param object
	 *            the semantic diagram
	 * @param layerID
	 *            the given layer represented by his ID.
	 * @return true if the given layer is activated, false otherwise.
	 */
	public boolean isLayerActivated(EObject object, String layerID) {
		if (object instanceof DSemanticDiagram) {
			final DSemanticDiagram d = (DSemanticDiagram)object;
			for (Layer layer : d.getActivatedLayers()) {
				if (layerID.equals(layer.getName())) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Get UML String type.
	 * 
	 * @param object
	 *            the object for which to find the corresponding String type
	 * @return the found String element or null
	 */
	public Type getUmlStringType(EObject object) {
		return EcoreServices.INSTANCE.findTypeByName(object, "String");
	}

	/**
	 * Update stereotype of element if needed.
	 * 
	 * @param element
	 *            the given Element.
	 * @return th element updated.
	 */
	public Element updateStereotype(Element element) {
		if (element instanceof Property) {
			final Type type = ((Property)element).getType();
			if (type != null) {
				final Collection<EObject> elementStereotypes = element.getStereotypeApplications();
				final Collection<EObject> typeStereotypes = type.getStereotypeApplications();
				for (EObject typeStereotype : typeStereotypes) {
					if (typeStereotype instanceof ConstraintBlock) {
						if (elementStereotypes == null || elementStereotypes.isEmpty()) {
							createAssociatedStereotype(element, "SysML::Constraints", "ConstraintProperty");
							break;
						} else {
							for (EObject elementStereotype : elementStereotypes) {
								if (!(elementStereotype instanceof ConstraintProperty)) {
									createAssociatedStereotype(element, "SysML::Constraints",
											"ConstraintProperty");
									break;
								}
							}
						}
					} else if (typeStereotype instanceof Block) {
						for (EObject elementStereotype : elementStereotypes) {
							if (elementStereotype instanceof ConstraintProperty) {
								deleteAssociatedStereotype(element, "SysML::Constraints::ConstraintProperty");
								break;
							}
						}
					}
				}
			}
		}
		return element;
	}

	/**
	 * Delete the requirement and his stereotype.
	 * 
	 * @param e
	 *            the Requirement to delete.
	 */
	public void deleteRequirement(NamedElement e) {
		deleteAssociatedStereotype(e, SYSML_REQUIREMENT);
		final EObject root = getRootContainer(e);
		for (final Iterator<EObject> iterator = root.eAllContents(); iterator.hasNext();) {
			final EObject object = iterator.next();
			if (object instanceof Abstraction) {
				final Element supplier = ((Abstraction)object).getSupplier(e.getName());
				if (supplier != null) {
					Stereotype s = ((Abstraction)object).getAppliedStereotype("SysML::Requirements::Satisfy");
					if (s != null) {
						deleteAssociatedStereotype((Abstraction)object, "SysML::Requirements::Satisfy");
					} else {
						s = ((Abstraction)object).getAppliedStereotype("SysML::Requirements::DeriveReqt");
						if (s != null) {
							deleteAssociatedStereotype((Abstraction)object, "SysML::Requirements::DeriveReqt");
						} else {
							s = ((Abstraction)object).getAppliedStereotype("Standard::Refine");
							if (s != null) {
								deleteAssociatedStereotype((Abstraction)object, "Standard::Refine");
							} else {
								s = ((Abstraction)object).getAppliedStereotype("SysML::Requirements::Verify");
								if (s != null) {
									deleteAssociatedStereotype((Abstraction)object,
											"SysML::Requirements::Verify");
								}
							}
						}
					}
					EcoreUtil.delete(object);
				}
			}
		}
		EcoreUtil.delete(e);
	}

	/**
	 * Get all the valid elements for a requirement diagram.
	 * 
	 * @param cur
	 *            Current semantic element
	 * @return List of elements visible on a requirement diagram
	 */
	public List<EObject> getValidsForRequirementDiagram(Element cur, DDiagram diagram) {

		final boolean isVerifyLayerActive = isVerifyLayerActive(diagram);
		final boolean isSatisfyLayerActive = isSatisfyLayerActive(diagram);
		final boolean isRefineLayerActive = isRefineLayerActive(diagram);

		Predicate<EObject> validForClassDiagram = new Predicate<EObject>() {

			public boolean apply(EObject input) {
				return input instanceof Package
						|| ("Class".equals(input.eClass().getName()) && ((Class)input)
								.getAppliedStereotype(SYSML_REQUIREMENT) != null)
						|| (isVerifyLayerActive && ((input instanceof Class && isTestClass((Class)input)) || (input instanceof Operation && ((Operation)input)
								.getAppliedStereotype(SYSML_TESTCASE) != null)))
						|| (isSatisfyLayerActive && ((input instanceof Class && ((Class)input)
								.getAppliedStereotype(SYSML_BLOCK) != null)))
						|| (isRefineLayerActive && (input instanceof Behavior || input instanceof BehavioredClassifier));
			}

			private boolean isTestClass(Class input) {
				for (Operation operation : input.getAllOperations()) {
					if (operation.getAppliedStereotype(SYSML_TESTCASE) != null)
						return true;
				}
				return false;
			}
		};
		return allValidSessionElements(cur, validForClassDiagram);
	}

	private boolean isVerifyLayerActive(DDiagram diagram) {
		return isLayerActive(diagram, "Verify");
	}

	private boolean isSatisfyLayerActive(DDiagram diagram) {
		return isLayerActive(diagram, "Satisfy");
	}

	private boolean isRefineLayerActive(DDiagram diagram) {
		return isLayerActive(diagram, "Refine");
	}

	private boolean isLayerActive(DDiagram diagram, String layerName) {
		for (Layer layer : diagram.getActivatedLayers()) {
			if (layerName.equals(layer.getName()))
				return true;
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
	public List<EObject> getValidsForBlockDefinitionDiagram(EObject cur) {
		Predicate<EObject> validForDiagram = new Predicate<EObject>() {

			public boolean apply(EObject input) {

				return "Model".equals(input.eClass().getName())
						|| "Package".equals(input.eClass().getName())
						|| input instanceof Interface
						|| (input instanceof InstanceSpecification && hasStereotype(
								(InstanceSpecification)input, "Unit"))
						|| (input instanceof InstanceSpecification && hasStereotype(
								(InstanceSpecification)input, "Dimension")) || input instanceof DataType
						|| input instanceof Actor
						|| (input instanceof Class && hasStereotype((Class)input, "Block"))
						|| (input instanceof Class && hasStereotype((Class)input, "ConstraintBlock"));
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
	public List<EObject> getValidsForInternalBlockDiagram(Class cur) {
		Predicate<EObject> validForDiagram = new Predicate<EObject>() {

			public boolean apply(EObject input) {
				return (!(input instanceof Port) && (input instanceof Property));
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
	public List<EObject> getValidsForParametricBlockDiagram(Class cur) {
		final boolean isValueBindingLayerActive = isValueBindingLayerActive(cur);
		Predicate<EObject> validForDiagram = new Predicate<EObject>() {

			public boolean apply(EObject input) {
				if (!isValueBindingLayerActive) {
					return !(input instanceof Port) && (input instanceof Property)
							&& hasStereotype((Element)input, "ConstraintProperty");
				} else {
					return !(input instanceof Port) && (input instanceof Property);
				}
			}
		};
		return allValidAttributes(cur, validForDiagram);
	}

	private boolean isValueBindingLayerActive(EObject cur) {
		IEditorPart editor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.getActiveEditor();

		if (editor instanceof DialectEditor) {
			DialectEditor dialectEditor = (DialectEditor)editor;
			DRepresentation representation = dialectEditor.getRepresentation();
			if (representation instanceof DDiagram) {
				DDiagram diagram = (DDiagram)representation;
				List<Layer> layers = diagram.getActivatedLayers();
				for (Layer layer : layers) {
					if ("PAR ValueBinding Layer".equals(layer.getName()))
						return true;
				}
			}
		}
		return false;
	}

	/**
	 * Get all the valid elements for an internal block diagram.
	 * 
	 * @param cur
	 *            Current semantic element
	 * @return List of elements visible on an internal block diagram
	 */
	public List<EObject> getValidsForParametricBlockDiagramValueBindingFilter(Class cur) {
		Predicate<EObject> validForDiagram = new Predicate<EObject>() {

			public boolean apply(EObject input) {
				return !(input instanceof Port) && (input instanceof Property)
						&& !hasStereotype((Element)input, "ConstraintProperty");
			}
		};
		return allValidAttributes(cur, validForDiagram);
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
	private boolean hasStereotype(Element element, String stereotypeName) {
		for (EObject stereotype : element.getStereotypeApplications()) {
			if (stereotypeName.equals(stereotype.eClass().getName()))
				return true;
		}
		return false;
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
		Session found = SessionManager.INSTANCE.getSession(cur);
		List<EObject> result = Lists.newArrayList();
		if (found != null) {
			for (Resource res : found.getSemanticResources()) {
				Iterators.addAll(result, Iterators.filter(res.getAllContents(), validForDiagram));
			}
		}
		return result;
	}

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
		List<EObject> result = Lists.newArrayList();
		Iterators.addAll(result, Iterators.filter(cur.getAttributes().iterator(), validForDiagram));
		return result;
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
		Class requirement = (Class)((DNodeList)edgeView.getTargetNode()).getTarget();

		reconnectService.setSubRequirement(requirement);
		reconnectService.setOldPointedClass(source);
		reconnectService.setNewPointedClass(target);
		return reconnectService.doSwitch(context);
	}

	/**
	 * Set dimension.
	 * 
	 * @param dataType
	 *            Datatype
	 * @param instanceSpecification
	 *            Dimension
	 */
	public void setDimension(Element dataType, InstanceSpecification instanceSpecification) {
		if (dataType.getStereotypeApplications() != null) {
			EObject stereotype = dataType.getStereotypeApplications().get(0);
			if (stereotype instanceof ValueType) {
				ValueType valueType = (ValueType)stereotype;
				if (instanceSpecification.getStereotypeApplications() != null) {
					stereotype = instanceSpecification.getStereotypeApplications().get(0);
					if (stereotype instanceof Dimension) {
						Dimension dimension = (Dimension)stereotype;
						valueType.setDimension(dimension);
					}
				}
			}
		}
	}

	/**
	 * Set unit.
	 * 
	 * @param dataType
	 *            Datatype
	 * @param instanceSpecification
	 *            unit
	 */
	public void setUnit(Element dataType, InstanceSpecification instanceSpecification) {
		if (dataType.getStereotypeApplications() != null) {
			EObject stereotype = dataType.getStereotypeApplications().get(0);
			if (stereotype instanceof ValueType) {
				ValueType valueType = (ValueType)stereotype;
				if (instanceSpecification.getStereotypeApplications() != null) {
					stereotype = instanceSpecification.getStereotypeApplications().get(0);
					if (stereotype instanceof Unit) {
						Unit unit = (Unit)stereotype;
						valueType.setUnit(unit);
					}
				}
			}
		}
	}

	/**
	 * Checks if an element is a valid root of a block definition diagram.
	 * 
	 * @param element
	 *            Named element
	 * @return True if element could be a root of a block definition diagram otherwise false
	 */
	public boolean isValidBlockDefinitionDiagramRoot(NamedElement element) {
		// Replace the acceleo expression : [self.oclIsKindOf(uml::Package) or
		// self->filter(uml::Class).getStereotypeApplications()->filter(sysml::blocks::Block)->size() > 0/]
		if (element instanceof Package) {
			return true;
		} else if (element instanceof Class) {
			return isBlock((Class)element);
		}
		return false;
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
		return isBlock(element);
	}

	/**
	 * Checks if an element is a valid root of a parametric diagram.
	 * 
	 * @param element
	 *            Named element
	 * @return True if element could be a root of a parametric diagram otherwise false
	 */
	public boolean isValidParametricDiagramRoot(Class element) {
		// Replace the acceleo expression : [getStereotypeApplications()->filter(sysml::blocks::Block)->size()
		// > 0/]
		return isBlock(element);
	}

	/**
	 * Checks if element has the stereotype block.
	 * 
	 * @param element
	 *            Named element
	 * @return True if element is a block otherwise false
	 */
	public boolean isBlock(Element element) {
		return isStereotype(element, Block.class);
	}

	/**
	 * Get all non constraint blocks.
	 * 
	 * @param container
	 *            Container
	 * @return All blocks.
	 */
	public List<Class> getAllNonConstraintBlocks(EObject container) {
		SysMLServices service = new SysMLServices();
		// Replace expression :
		// [container.getRootContainer().eAllContents(uml::Package)->union(container.getRootContainer().eAllContents(uml::Class)->select(isBlock()))/]
		List<Class> blocks = Lists.newArrayList();
		for (Iterator<EObject> iterator = service.getRootContainer(container).eAllContents(); iterator
				.hasNext();) {
			EObject element = iterator.next();
			if (element instanceof Class && (isBlock((Class)element) && !isConstraintBlock((Class)element))) {
				blocks.add(((Class)element));
			}
		}
		return blocks;
	}

	/**
	 * Get all non constraint blocks.
	 * 
	 * @param container
	 *            Container
	 * @return All blocks.
	 */
	public List<Class> getAllConstraintBlocks(EObject container) {
		SysMLServices service = new SysMLServices();
		// Replace expression :
		// [container.getRootContainer().eAllContents(uml::Package)->union(container.getRootContainer().eAllContents(uml::Class)->select(isBlock()))/]
		List<Class> blocks = Lists.newArrayList();
		for (Iterator<EObject> iterator = service.getRootContainer(container).eAllContents(); iterator
				.hasNext();) {
			EObject element = iterator.next();
			if (element instanceof Class && isConstraintBlock((Class)element)) {
				blocks.add(((Class)element));
			}
		}
		return blocks;
	}

	/**
	 * Checks if element has the stereotype constraint block.
	 * 
	 * @param element
	 *            Named element
	 * @return True if element is a constraint block otherwise false
	 */
	public boolean isConstraintBlock(Classifier element) {
		return isStereotype(element, ConstraintBlock.class);
	}

	/**
	 * Checks if element has the stereotype requirement.
	 * 
	 * @param element
	 *            Named element
	 * @return True if element is a requirement otherwise false
	 */
	public boolean isRequirement(Element element) {
		return isStereotype(element, Requirement.class);
	}

	public boolean isNotBlockOrRequirement(Element element) {
		return element instanceof Class && !isBlock((Class)element) && !isRequirement((Class)element)
				&& !(element instanceof Activity) && !(element instanceof StateMachine);
	}

	/**
	 * Get requirement.
	 * 
	 * @param element
	 *            Named element
	 * @return True if element is a requirement otherwise false
	 */
	public Requirement getRequirement(Class element) {
		// Replace acceleo expression :
		// [getStereotypeApplications()->filter(sysml::requirements::Requirement)->size() > 0/]
		for (EObject stereotype : element.getStereotypeApplications()) {
			if (stereotype instanceof Requirement) {
				return (Requirement)stereotype;
			}
		}
		return null;
	}

	/**
	 * Get requirement id.
	 * 
	 * @param element
	 *            Requirement
	 * @return Id
	 */
	public String getRequirementId(Class element) {
		Requirement requirement = getRequirement(element);
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
		Requirement requirement = getRequirement(element);
		return requirement.getText();
	}

	/**
	 * Set requirement id.
	 * 
	 * @param element
	 *            Requirement
	 * @param newId
	 *            Id
	 */
	public void setRequirementId(Class element, String newId) {
		Requirement requirement = getRequirement(element);
		requirement.setId(newId);
	}

	/**
	 * Set requirement text.
	 * 
	 * @param element
	 *            Requirement
	 * @param newText
	 *            Text
	 */
	public void setRequirementText(Class element, String newText) {
		Requirement requirement = getRequirement(element);
		requirement.setText(newText);
	}

	/**
	 * Checks if element has the stereotype value type.
	 * 
	 * @param element
	 *            Named element
	 * @return True if element is a value type otherwise false
	 */
	public boolean isValueType(NamedElement element) {
		for (EObject stereotype : element.getStereotypeApplications()) {
			if (stereotype instanceof ValueType) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Get value type.
	 * 
	 * @param element
	 *            Element
	 * @return Value type
	 */
	public EObject getValueType(Element element) {
		// Replace acceleo expression :
		// getStereotypeApplications()->filter(sysml::blocks::ValueType)->select(not(base_DataType->filter(uml::PrimitiveType)->isEmpty()))
		for (EObject stereotype : element.getStereotypeApplications()) {
			if (stereotype instanceof ValueType) {
				return stereotype;
			}
		}
		return null;
	}

	/**
	 * Checks if element has the stereotype dimension.
	 * 
	 * @param element
	 *            Named element
	 * @return True if element is a dimension otherwise false
	 */
	public boolean isDimension(InstanceSpecification element) {
		return isStereotype(element, Dimension.class);
	}

	/**
	 * Checks if element has the stereotype unit.
	 * 
	 * @param element
	 *            Named element
	 * @return True if element is a unit otherwise false
	 */
	public boolean isUnit(InstanceSpecification element) {
		// Replace acceleo expression:
		// [self.getStereotypeApplications()->filter(sysml::blocks::Unit)->size() > 0/]
		for (EObject stereotype : element.getStereotypeApplications()) {
			if (stereotype instanceof Unit) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if element is a valid property.
	 * 
	 * @param element
	 *            Named element
	 * @return True if element is a valid property otherwise false
	 */
	public boolean isValidProperty(Property element, DSemanticDiagram diagram) {
		// Replace acceleo expression: [if diagram.isLayerActivated('BDD Parametric Layer') = false then
		// getStereotypeApplications()->filter(sysml::constraints::ConstraintProperty)->size() = 0 and
		// not(oclIsKindOf(uml::Port)) else not(oclIsKindOf(uml::Port)) endif/]
		SysMLServices service = new SysMLServices();

		if (!service.isLayerActivated(diagram, "BDD Parametric Layer")) {
			if (element.getStereotypeApplications().size() == 0 && !(element instanceof Port)) {
				return true;
			}
			for (EObject stereotype : element.getStereotypeApplications()) {
				if (!(stereotype instanceof ConstraintProperty) && !(element instanceof Port)) {
					return true;
				}
			}
		} else {
			if (!(element instanceof Port)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Get requirements defined in a package.
	 * 
	 * @param pkg
	 *            Package
	 * @return Requirements
	 */
	public List<Object> getRequirements(Package pkg) {
		return getRequirements(pkg.getPackagedElements().toArray());
	}

	/**
	 * Get requirement defined under a requirement.
	 * 
	 * @param class_
	 *            Requirement
	 * @return Sub requirements
	 */
	public List<Object> getRequirements(Classifier class_) {
		return getRequirements(class_.eContents().toArray());
	}

	/**
	 * Get requirements.
	 * 
	 * @param elements
	 *            Possible requirements
	 * @return Requirements
	 */
	private List<Object> getRequirements(Object[] elements) {
		// Replace acceleo expression:
		// self->union(self.getStereotypeApplications()->filter(sysml::requirements::Requirement))
		List<Object> requirements = Lists.newArrayList();
		for (Object element : elements) {
			if (element instanceof Class && isRequirement((Class)element)) {
				requirements.add(element);
			}
		}
		return requirements;
	}

	/**
	 * Checks if element has the stereotype flow port.
	 * 
	 * @param element
	 *            Named element
	 * @return True if element is a flow port otherwise false
	 */
	public boolean isFlowPort(Element element) {
		return isStereotype(element, FlowPort.class);
	}

	/**
	 * Checks if element has the stereotype port.
	 * 
	 * @param element
	 *            Named element
	 * @return True if element is a port otherwise false
	 */
	public boolean isPort(NamedElement element) {
		return element instanceof Port && !isFlowPort(element);
	}

	/**
	 * Check if element has the SysML stereotype given in parameters.
	 * 
	 * @param element
	 *            Element to check
	 * @param sysmlStereotype
	 *            stereotype
	 * @return True if the elements has the stereotype otherwise false
	 */
	@SuppressWarnings("rawtypes")
	private boolean isStereotype(Element element, java.lang.Class sysmlStereotype) {
		for (EObject stereotype : element.getStereotypeApplications()) {
			if (sysmlStereotype.isInstance(stereotype)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Get the flow port.
	 * 
	 * @param element
	 *            Named element
	 * @return Flow port
	 */
	public FlowPort getFlowPort(NamedElement element) {
		for (EObject stereotype : element.getStereotypeApplications()) {
			if (stereotype instanceof FlowPort) {
				return (FlowPort)stereotype;
			}
		}
		return null;
	}

	public boolean isOutFlowPort(NamedElement element) {
		FlowPort port = getFlowPort(element);
		return port.getDirection().equals(FlowDirection.OUT);
	}

	public boolean isInFlowPort(NamedElement element) {
		FlowPort port = getFlowPort(element);
		return port.getDirection().equals(FlowDirection.IN);
	}

	/**
	 * Checks if element has the stereotype constraint property.
	 * 
	 * @param element
	 *            Named element
	 * @return True if element is a constraint property otherwise false
	 */
	public boolean isConstraintProperty(NamedElement element) {
		return isStereotype(element, ConstraintProperty.class);
	}

	/**
	 * Checks if element has the stereotype test case.
	 * 
	 * @param element
	 *            Named element
	 * @return True if element is a test case otherwise false
	 */
	public boolean isTestCase(NamedElement element) {
		for (EObject stereotype : element.getStereotypeApplications()) {
			if (stereotype instanceof TestCase) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if element has the stereotype derive requirement.
	 * 
	 * @param element
	 *            Named element
	 * @return True if element is a derive requirement otherwise false
	 */
	public boolean isDeriveReqt(NamedElement element) {
		return isStereotype(element, DeriveReqt.class);
	}

	/**
	 * Checks if element has the stereotype refine.
	 * 
	 * @param element
	 *            Named element
	 * @return True if element is a refine otherwise false
	 */
	public boolean isRefine(NamedElement element) {
		return isStereotype(element, Refine.class);
	}

	/**
	 * Checks if element has the stereotype satisfy.
	 * 
	 * @param element
	 *            Named element
	 * @return True if element is a satisfy otherwise false
	 */
	public boolean isSatisfy(NamedElement element) {
		return isStereotype(element, Satisfy.class);
	}

	/**
	 * Checks if element has the stereotype verify.
	 * 
	 * @param element
	 *            Named element
	 * @return True if element is a verify otherwise false
	 */
	public boolean isVerify(NamedElement element) {
		return isStereotype(element, Verify.class);
	}

	/**
	 * Get all blocks.
	 * 
	 * @param container
	 *            Container
	 * @return All blocks.
	 */
	public List<Class> getAllBlocks(Element container) {
		SysMLServices service = new SysMLServices();
		// Replace expression :
		// [container.getRootContainer().eAllContents(uml::Package)->union(container.getRootContainer().eAllContents(uml::Class)->select(isBlock()))/]
		List<Class> blocks = Lists.newArrayList();
		for (Iterator<EObject> iterator = service.getRootContainer(container).eAllContents(); iterator
				.hasNext();) {
			EObject element = iterator.next();
			if (element instanceof Class && isBlock((Class)element)) {
				blocks.add(((Class)element));
			}
		}
		return blocks;
	}

	/**
	 * Get all actors.
	 * 
	 * @param element
	 *            element
	 * @return All actors.
	 */
	public List<Element> getAllActorsAndContainers(Element element) {
		List<Element> results = Lists.newArrayList();
		UMLServices service = new UMLServices();

		List<Package> models = service.getAllAvailableRootPackages(element);
		results.addAll(models);
		for (Package pkg : models) {
			for (Iterator<EObject> iterator = pkg.eAllContents(); iterator.hasNext();) {
				EObject iter = iterator.next();
				if (iter instanceof Actor || iter instanceof Package) {
					results.add((Element)iter);
				}
			}
		}

		return results;
	}

	/**
	 * Get all value types.
	 * 
	 * @param container
	 *            Container
	 * @return All value types.
	 */
	public List<ValueType> getAllValueTypes(EObject container) {
		List<ValueType> valuetypes = Lists.newArrayList();
		for (Iterator<EObject> iterator = getRootContainer(container).eAllContents(); iterator.hasNext();) {
			EObject element = iterator.next();
			if (element instanceof ValueType && isValueType((NamedElement)element)) {
				valuetypes.add(((ValueType)element));
			}
		}
		return valuetypes;
	}

	/**
	 * Get all test cases.
	 * 
	 * @param container
	 *            Container
	 * @return All test cases.
	 */
	public List<Operation> getAllTestCases(Element container) {
		List<Operation> testcases = Lists.newArrayList();
		for (Iterator<EObject> iterator = getRootContainer(container).eAllContents(); iterator.hasNext();) {
			EObject element = iterator.next();
			if (element instanceof Operation && isTestCase((Operation)element)) {
				testcases.add(((Operation)element));
			}
		}
		return testcases;
	}

	/**
	 * Get all behaviors.
	 * 
	 * @param container
	 *            Container
	 * @return All behaviors.
	 */
	public List<Element> getAllBehaviors(Element container) {
		List<Element> results = Lists.newArrayList();
		for (Iterator<EObject> iterator = getRootContainer(container).eAllContents(); iterator.hasNext();) {
			EObject element = iterator.next();
			if (element instanceof StateMachine || element instanceof Activity || element instanceof UseCase
					|| element instanceof Collaboration) {
				results.add((Element)element);
			}
		}
		return results;
	}

	/**
	 * Get all dimensions.
	 * 
	 * @param container
	 *            Package
	 * @return All dimensions.
	 */
	public List<InstanceSpecification> getAllDimensions(Element valueType) {
		List<InstanceSpecification> results = Lists.newArrayList();
		for (Iterator<EObject> iterator = valueType.getModel().eAllContents(); iterator.hasNext();) {
			EObject element = iterator.next();
			if (element instanceof InstanceSpecification && isDimension((InstanceSpecification)element)) {
				results.add(((InstanceSpecification)element));
			}
		}
		return results;
	}

	/**
	 * Get dimension.
	 * 
	 * @param container
	 *            Package
	 * @return Dimension.
	 */
	public Dimension getDimension(Element valueType) {
		for (EObject stereotype : valueType.getStereotypeApplications()) {
			if (stereotype instanceof ValueType) {
				return ((ValueType)stereotype).getDimension();
			}
		}
		return null;
	}

	/**
	 * Get dimension name.
	 * 
	 * @param dimension
	 *            Dimension
	 * @return Name
	 */
	public String getName(Dimension dimension) {
		return dimension.getBase_InstanceSpecification().getName();
	}

	/**
	 * Get unit.
	 * 
	 * @param container
	 *            Package
	 * @return Unit.
	 */
	public Unit getUnit(Element valueType) {
		for (EObject stereotype : valueType.getStereotypeApplications()) {
			if (stereotype instanceof ValueType) {
				return ((ValueType)stereotype).getUnit();
			}
		}
		return null;
	}

	/**
	 * Get unit name.
	 * 
	 * @param unit
	 *            Unit
	 * @return Name
	 */
	public String getName(Unit unit) {
		return unit.getBase_InstanceSpecification().getName();
	}

	/**
	 * Get all units.
	 * 
	 * @param container
	 *            Package
	 * @return All units.
	 */
	public List<InstanceSpecification> getAllUnits(Element valueType) {
		List<InstanceSpecification> results = Lists.newArrayList();
		for (Iterator<EObject> iterator = valueType.getModel().eAllContents(); iterator.hasNext();) {
			EObject element = iterator.next();
			if (element instanceof InstanceSpecification && isUnit((InstanceSpecification)element)) {
				results.add(((InstanceSpecification)element));
			}
		}
		return results;
	}

	/**
	 * Get all derive requirements.
	 * 
	 * @param container
	 *            Package
	 * @return All derive requirements.
	 */
	public List<NamedElement> getAllDeriveReqts(Package container) {
		SysMLServices service = new SysMLServices();
		List<NamedElement> results = Lists.newArrayList();
		for (Iterator<EObject> iterator = service.getRootContainer(container).eAllContents(); iterator
				.hasNext();) {
			EObject element = iterator.next();
			if (element instanceof Abstraction && isDeriveReqt((NamedElement)element)) {
				results.add(((NamedElement)element));
			}
		}
		return results;
	}

	/**
	 * Get all refine requirements.
	 * 
	 * @param container
	 *            Package
	 * @return All refine requirements.
	 */
	public List<NamedElement> getAllRefine(Package container) {
		SysMLServices service = new SysMLServices();
		List<NamedElement> results = Lists.newArrayList();
		for (Iterator<EObject> iterator = service.getRootContainer(container).eAllContents(); iterator
				.hasNext();) {
			EObject element = iterator.next();
			if (element instanceof Abstraction && isRefine((NamedElement)element)) {
				results.add(((NamedElement)element));
			}
		}
		return results;
	}

	/**
	 * Get all satisfy requirements.
	 * 
	 * @param container
	 *            Package
	 * @return All satisfy requirements.
	 */
	public List<NamedElement> getAllSatisfyReqts(Package container) {
		SysMLServices service = new SysMLServices();
		List<NamedElement> results = Lists.newArrayList();
		for (Iterator<EObject> iterator = service.getRootContainer(container).eAllContents(); iterator
				.hasNext();) {
			EObject element = iterator.next();
			if (element instanceof Abstraction && isSatisfy((NamedElement)element)) {
				results.add(((NamedElement)element));
			}
		}
		return results;
	}

	/**
	 * Get all verify requirements.
	 * 
	 * @param container
	 *            Package
	 * @return All verify requirements.
	 */
	public List<NamedElement> getAllVerifyReqts(Package container) {
		SysMLServices service = new SysMLServices();
		List<NamedElement> results = Lists.newArrayList();
		for (Iterator<EObject> iterator = service.getRootContainer(container).eAllContents(); iterator
				.hasNext();) {
			EObject element = iterator.next();
			if (element instanceof Abstraction && isVerify((NamedElement)element)) {
				results.add(((NamedElement)element));
			}
		}
		return results;
	}

	/**
	 * Get port types.
	 * 
	 * @param container
	 *            Container
	 * @return Port types
	 */
	public List<Classifier> getPortTypes(EObject container) {
		SysMLServices service = new SysMLServices();
		List<Classifier> results = Lists.newArrayList();
		for (Iterator<EObject> iterator = service.getRootContainer(container).eAllContents(); iterator
				.hasNext();) {
			EObject element = iterator.next();
			if (element instanceof Classifier
					&& !isConstraintBlock((Classifier)element)
					&& (isBlock((Classifier)element) || element instanceof PrimitiveType || element instanceof DataType || element instanceof Interface)) {
				results.add(((Classifier)element));
			}
		}
		return results;
	}

	public void unsetDimension(EObject valueType) {
		((ValueType)((Element)valueType).getStereotypeApplications()).setDimension(null);
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
			DiagramDescription description = ((DSemanticDiagramSpec)representation).getDescription();

			if ("Block Definition Diagram".equals(description.getName())) {
				results = getValidsForBlockDefinitionDiagram(element);
			} else if ("Internal Block Diagram".equals(description.getName())) {
				results = getValidsForInternalBlockDiagram((Class)element);
			} else if ("Parametric Diagram".equals(description.getName())) {
				results = getValidsForParametricBlockDiagram((Class)element);
			} else if ("Requirement Diagram".equals(description.getName())) {
				results = getValidsForRequirementDiagram(element, (DDiagram)representation);
			}
		}

		return results;
	}

	public boolean isValidAttributesContainer(EObject container, EObject containerView) {
		// [container.oclAsType(ecore::EObject).existValidElementsForContainerView(containerView.oclAsType(ecore::EObject))/]
		UIServices service = new UIServices();
		return service.existValidElementsForContainerView(container, containerView)
				&& !(containerView instanceof DDiagram);
	}

	/**
	 * Get satisfied requirements.
	 * 
	 * @param element
	 *            Block
	 * @return Requirements satisfied by the given block
	 */
	public List<Class> getSatisfiedRequirements(Class element) {
		List<Class> results = Lists.newArrayList();
		Collection<Setting> xRefs = SessionManager.INSTANCE.getSession(element).getSemanticCrossReferencer()
				.getInverseReferences(element);
		for (Setting xRef : xRefs) {
			EObject eObject = xRef.getEObject();
			if (eObject instanceof Abstraction) {
				for (Element supplier : ((Abstraction)eObject).getSuppliers()) {
					if (supplier instanceof Class) {
						for (EObject stereotype : supplier.getStereotypeApplications()) {
							if (stereotype instanceof Requirement) {
								results.add((Class)supplier);
							}
						}
					}
				}
			}
		}
		return results;
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
		Session session = SessionManager.INSTANCE.getSession(element);
		Collection<Setting> refs = session.getSemanticCrossReferencer().getInverseReferences(
				element.eContainer());
		for (Setting setting : refs) {
			if (setting.getEObject() instanceof DNodeContainer) {
				return (DNodeContainer)setting.getEObject();
			}
		}
		return null;
	}
}
