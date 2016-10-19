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
package org.obeonetwork.dsl.sysml.design.internal.services;

import java.util.Iterator;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.papyrus.sysml.blocks.Dimension;
import org.eclipse.papyrus.sysml.constraints.ConstraintBlock;
import org.eclipse.papyrus.sysml.constraints.ConstraintProperty;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.papyrus.sysml.requirements.DeriveReqt;
import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.eclipse.papyrus.sysml.requirements.Satisfy;
import org.eclipse.papyrus.sysml.requirements.TestCase;
import org.eclipse.papyrus.sysml.requirements.Verify;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.profile.standard.Refine;
import org.obeonetwork.dsl.sysml.design.SysMLDesignerPlugin;

/**
 * Utility services for SysML.
 *
 * @author Axel Richard <a href="mailto:axel.richard@obeo.fr">axel.richard@obeo.fr</a>
 * @author Melanie Bats <a href="mailto:melanie.bats@obeo.fr">melanie.bats@obeo.fr</a>
 */
public class SysmlElementServices {
	/**
	 * A singleton instance to be accessed by other java services.
	 */
	public static final SysmlElementServices INSTANCE = new SysmlElementServices();

	/**
	 * Hidden constructor.
	 */
	private SysmlElementServices() {

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
		if (isProfileApplied(p, profileQualifiedName)) {
			return;
		}
		Profile parentProfile = null;
		if (profileQualifiedName.startsWith("SysML")) { //$NON-NLS-1$
			parentProfile = SysMLDesignerPlugin.getSysMLProfile();
		} else if (profileQualifiedName.startsWith("Standard")) { //$NON-NLS-1$
			parentProfile = SysMLDesignerPlugin.getStandardProfile();
		}

		Package profilePackage = parentProfile;

		final String[] profiles = profileQualifiedName.split(":{2}"); //$NON-NLS-1$
		// search the profile in the package hierarchy
		for (int index = 1; index < profiles.length - 1; index++) {
			profilePackage = profilePackage.getNestedPackage(profiles[index]);
		}

		Profile profile = (Profile)profilePackage;

		if (profileQualifiedName.startsWith("SysML")) { //$NON-NLS-1$
			profile = (Profile)profilePackage.getNestedPackage(profiles[profiles.length - 1]);
		}

		if (profile == null) {
			final String message = "Can't apply the profile " + profileQualifiedName + " on " //$NON-NLS-1$ //$NON-NLS-2$
					+ p.getQualifiedName();
			SysMLDesignerPlugin.log(IStatus.WARNING, message, null);
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
		final String stereotypeQualifiedName = profileQualifiedName + "::" + stereotypeName; //$NON-NLS-1$

		final Stereotype stereotype = element.getApplicableStereotype(stereotypeQualifiedName);
		final EList<Stereotype> appliedStereotypes = element.getAppliedStereotypes();

		if (stereotype == null) {
			final String message = "Can't apply the setereotype " + stereotypeQualifiedName + " on " //$NON-NLS-1$ //$NON-NLS-2$
					+ element.toString();
			SysMLDesignerPlugin.log(IStatus.WARNING, message, null);
		} else if (appliedStereotypes != null && appliedStereotypes.contains(stereotype)) {
			final String message = "The stereotype " + stereotype.getQualifiedName() //$NON-NLS-1$
					+ " is already applied on " + element.toString(); //$NON-NLS-1$
			SysMLDesignerPlugin.log(IStatus.INFO, message, null);
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
			final String message = "Can't delete the stereotype application because the element or the stereotypeName keys are not correct"; //$NON-NLS-1$
			SysMLDesignerPlugin.log(IStatus.INFO, message, null);
		}
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
		for (final EObject stereotype : element.getStereotypeApplications()) {
			if (stereotype instanceof Requirement) {
				return (Requirement)stereotype;
			}
		}
		return null;
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
	 * Check if a profile is applied on a package based on its qualified name.
	 *
	 * @param currentPackage
	 *            Package
	 * @param profileQualifiedName
	 *            Profile qualified name
	 * @return True if profile is laready applied otherwised false
	 */
	private boolean isProfileApplied(Package currentPackage, String profileQualifiedName) {
		final EList<Profile> allProfiles = currentPackage.getAllAppliedProfiles();
		final Iterator<Profile> it = allProfiles.iterator();
		while (it.hasNext()) {
			final Profile cur = it.next();
			if (profileQualifiedName.equalsIgnoreCase(cur.getQualifiedName())) {
				return true;
			}
		}
		return false;
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
	 * Checks if element has the stereotype requirement.
	 *
	 * @param element
	 *            Named element
	 * @return True if element is a requirement otherwise false
	 */
	public boolean isRequirement(Element element) {
		return isStereotype(element, Requirement.class);
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
		for (final EObject stereotype : element.getStereotypeApplications()) {
			if (sysmlStereotype.isInstance(stereotype)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks if element has the stereotype test case.
	 *
	 * @param element
	 *            Named element
	 * @return True if element is a test case otherwise false
	 */
	public boolean isTestCase(NamedElement element) {
		for (final EObject stereotype : element.getStereotypeApplications()) {
			if (stereotype instanceof TestCase) {
				return true;
			}
		}
		return false;
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

}
