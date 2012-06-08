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

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.papyrus.sysml.blocks.Dimension;
import org.eclipse.papyrus.sysml.blocks.Unit;
import org.eclipse.papyrus.sysml.constraints.ConstraintBlock;
import org.eclipse.papyrus.sysml.constraints.ConstraintProperty;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.obeonetwork.dsl.sysml.design.Activator;
import org.obeonetwork.dsl.uml2.design.services.EcoreServices;

import fr.obeo.dsl.viewpoint.DSemanticDiagram;
import fr.obeo.dsl.viewpoint.business.api.session.Session;
import fr.obeo.dsl.viewpoint.business.api.session.SessionManager;
import fr.obeo.dsl.viewpoint.description.Layer;

/**
 * Utility services for SysML.
 * 
 * @author Axel RICHARD <a
 *         href="mailto:axel.richard@obeo.fr">axel.richard@obeo.fr</a>
 */
public class SysMLServices {

	/**
	 * Checks if the given profile is already applied on the given _package. It
	 * checks both the local appliance and the ancestors appliance.
	 * 
	 * @param currentPackage
	 *            : the local package.
	 * @param profile
	 *            : the profile applied.
	 * @return true if the profile is actually applied, false otherwise.
	 */
	private static Boolean isProfileApplied(Package currentPackage,
			Profile profile) {
		final EList<Profile> allProfiles = currentPackage
				.getAllAppliedProfiles();
		final Iterator<Profile> it = allProfiles.iterator();
		while (it.hasNext()) {
			if (it.next().getQualifiedName()
					.equalsIgnoreCase(profile.getQualifiedName()))
				return true;
		}
		return false;
	}

	/**
	 * Apply each profiles to the given Package. The first parameter is the
	 * package. The second is the profile to apply.
	 * 
	 * In case of error when the profile is applied, a message is logged in the
	 * activator logger. In case of multiple application of the profile, a
	 * message is logged in the activator logger.
	 * 
	 * @param p
	 *            : the given Package
	 * @param profileQualifiedName
	 *            : the profile qualified name you want to apply.
	 */
	private void applySysMLProfile(Package p, String profileQualifiedName) {

		Resource profileResource = null;

		if (profileQualifiedName.startsWith("SysML")) {
			profileResource = TransactionUtil.getEditingDomain(p)
					.getResourceSet()
					.getResource(Activator.getSysMLProfileURI(), true);
		} else if (profileQualifiedName.startsWith("Standard")) {
			profileResource = TransactionUtil.getEditingDomain(p)
					.getResourceSet()
					.getResource(Activator.getStandardProfileURI(), true);
		}

		final Session session = SessionManager.INSTANCE.getSession(p);
		SessionManager.INSTANCE.addResource(session, profileResource);

		Package profilePackage = null;

		if (profileResource != null && profileResource.getContents().size() > 0) {
			final EObject libRoot = profileResource.getContents().get(0);
			if (libRoot instanceof Package && libRoot.eContainer() == null) {
				profilePackage = (Package) libRoot;
			}
		}

		final String[] profiles = profileQualifiedName.split(":{2}");
		// search the profile in the package hierarchy
		for (int index = 1; index < profiles.length - 1; index++) {
			profilePackage = profilePackage.getNestedPackage(profiles[index]);
		}

		Profile profile = (Profile) profilePackage;

		if (profileQualifiedName.startsWith("SysML")) {
			profile = (Profile) profilePackage
					.getNestedPackage(profiles[profiles.length - 1]);
		}

		if (profile == null) {
			final String message = "Can't apply the profile "
					+ profileQualifiedName + " on " + p.getQualifiedName();
			Activator.log(Status.WARNING, message, null);
		} else if (isProfileApplied(p, profile)) {
			// final String message = "The profile "
			// + profile.getQualifiedName()
			// + " is already applied on " + p.getQualifiedName();
			// final IStatus status = new Status(Status.INFO,
			// Activator.PLUGIN_ID, message);
			// Activator.getLogger().log(status);
		} else {
			p.applyProfile(profile);
		}

	}

	/**
	 * Create the Associated Stereotype with the given element.
	 * 
	 * @param e
	 *            : the given element for which you want to apply the
	 *            stereotype.
	 * @param profileQualifiedName
	 *            : the qualified name of the stereotype's profile you want to
	 *            apply (ex. : SysML::Blocks for a Block).
	 * @param stereotypeName
	 *            : the name of the stereotype you want to apply.
	 */
	public void createAssociatedStereotype(Element e,
			String profileQualifiedName, String stereotypeName) {

		applySysMLProfile(e.getModel(), profileQualifiedName);

		final Element element = e;
		final String stereotypeQualifiedName = profileQualifiedName + "::"
				+ stereotypeName;

		final Stereotype stereotype = element
				.getApplicableStereotype(stereotypeQualifiedName);
		final EList<Stereotype> appliedStereotypes = element
				.getAppliedStereotypes();

		if (stereotype == null) {
			final String message = "Can't apply the setereotype "
					+ stereotypeQualifiedName + " on " + element.toString();
			Activator.log(Status.WARNING, message, null);
		} else if (appliedStereotypes != null
				&& appliedStereotypes.contains(stereotype)) {
			final String message = "The stereotype "
					+ stereotype.getQualifiedName() + " is already applied on "
					+ element.toString();
			Activator.log(Status.INFO, message, null);
		} else {
			element.applyStereotype(stereotype);
		}

	}

	/**
	 * Delete the Associated Stereotype with the given element.
	 * 
	 * @param e
	 *            : the given element for which you want to delete the
	 *            stereotype.
	 * @param steQualified
	 *            : the qualified name of the stereotype you want to delete (ex.
	 *            : SysML::Blocks::Block).
	 */
	public void deleteAssociatedStereotype(Element e, String steQualified) {
		final Element element = e;

		if (element != null && steQualified != null) {
			final Stereotype stereotype = element
					.getAppliedStereotype(steQualified);
			element.unapplyStereotype(stereotype);
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
	 * @return true if the given element is an instance of the type, false
	 *         otherwise.
	 */
	public boolean isInstanceOf(Element e, String type) {
		if (e.eClass().getName().equalsIgnoreCase(type)) {
			return true;
		}
		return false;

	}

	/**
	 * Set the dimension feature for the given PrimitiveType stereotyped with a
	 * ValueType.
	 * 
	 * @param pt
	 *            : the given Element (a PrimitiveType stereotyped with a
	 *            ValueType).
	 * @param is
	 *            : the new Dimension (an InstanceSpecification stereotyped with
	 *            a Dimension).
	 */
	public void setDimensionForPrimitiveType(Element pt,
			InstanceSpecification is) {
		if (is != null && pt != null) {
			Stereotype valueType = pt
					.getAppliedStereotype("SysML::Blocks::ValueType");
			Dimension newDimension = (Dimension) is.getStereotypeApplication(is
					.getAppliedStereotype("SysML::Blocks::Dimension"));
			pt.setValue(valueType, "dimension", newDimension);
		}
	}

	/**
	 * Set the unit feature for the given PrimitiveType stereotyped with a
	 * ValueType.
	 * 
	 * @param pt
	 *            : the given Element (a PrimitiveType stereotyped with a
	 *            ValueType).
	 * @param is
	 *            : the new Unit (an InstanceSpecification stereotyped with a
	 *            Unit).
	 */
	public void setUnitForPrimitiveType(Element pt, InstanceSpecification is) {
		if (is != null && pt != null) {
			Stereotype valueType = pt
					.getAppliedStereotype("SysML::Blocks::ValueType");
			Unit newUnit = (Unit) is.getStereotypeApplication(is
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
			Stereotype requirement = r
					.getAppliedStereotype("SysML::Requirements::Requirement");
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
			Stereotype requirement = r
					.getAppliedStereotype("SysML::Requirements::Requirement");
			r.setValue(requirement, "text", text);
		}
	}

	/**
	 * Returns the root container; it may be this object itself
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
			DSemanticDiagram d = (DSemanticDiagram) object;
			for (Layer layer : d.getActivatedLayers()) {
				if (layerID.equals(layer.getName())) {
					return true;
				}
			}
		}
		return false;
	}

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
			Type type = ((Property) element).getType();
			if (type != null) {
				Collection<EObject> elementStereotypes = element
						.getStereotypeApplications();
				Collection<EObject> typeStereotypes = type
						.getStereotypeApplications();
				for (EObject typeStereotype : typeStereotypes) {
					if (typeStereotype instanceof ConstraintBlock) {
						if (elementStereotypes == null
								|| elementStereotypes.isEmpty()) {
							createAssociatedStereotype(element,
									"SysML::Constraints", "ConstraintProperty");
							break;
						} else {
							for (EObject elementStereotype : elementStereotypes) {
								if (!(elementStereotype instanceof ConstraintProperty)) {
									createAssociatedStereotype(element,
											"SysML::Constraints",
											"ConstraintProperty");
									break;
								}
							}
						}
					} else if (typeStereotype instanceof Block) {
						for (EObject elementStereotype : elementStereotypes) {
							if (elementStereotype instanceof ConstraintProperty) {
								deleteAssociatedStereotype(element,
										"SysML::Constraints::ConstraintProperty");
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
		deleteAssociatedStereotype(e, "SysML::Requirements::Requirement");
		EObject root = getRootContainer(e);
		for (Iterator<EObject> iterator = root.eAllContents(); iterator
				.hasNext();) {
			EObject object = iterator.next();
			if (object instanceof Abstraction) {
				Element supplier = ((Abstraction) object).getSupplier(e
						.getName());
				if (supplier != null) {
					Stereotype s = ((Abstraction) object)
							.getAppliedStereotype("SysML::Requirements::Satisfy");
					if (s != null) {
						deleteAssociatedStereotype(((Abstraction) object),
								"SysML::Requirements::Satisfy");
					} else {
						s = ((Abstraction) object)
								.getAppliedStereotype("SysML::Requirements::DeriveReqt");
						if (s != null) {
							deleteAssociatedStereotype(((Abstraction) object),
									"SysML::Requirements::DeriveReqt");
						} else {
							s = ((Abstraction) object)
									.getAppliedStereotype("Standard::Refine");
							if (s != null) {
								deleteAssociatedStereotype(
										((Abstraction) object),
										"Standard::Refine");
							} else {
								s = ((Abstraction) object)
										.getAppliedStereotype("SysML::Requirements::Verify");
								if (s != null) {
									deleteAssociatedStereotype(
											((Abstraction) object),
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
}
