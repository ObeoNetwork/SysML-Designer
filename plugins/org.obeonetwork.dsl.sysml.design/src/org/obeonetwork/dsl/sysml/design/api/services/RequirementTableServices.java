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

import org.eclipse.papyrus.sysml14.requirements.Requirement;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Stereotype;
import org.obeonetwork.dsl.sysml.design.internal.services.ISysmlConstants;
import org.obeonetwork.dsl.sysml.design.internal.services.SysmlElementServices;

import com.google.common.collect.Lists;

/**
 * A set of services to handle the Requirement table.
 *
 * @author Melanie Bats <a href="mailto:melanie.bats@obeo.fr">melanie.bats@obeo.fr</a>
 */
public class RequirementTableServices {

	public String getIdForRequirement(final Element element) {
		final Stereotype requirement = element.getAppliedStereotype(ISysmlConstants.SYSML_REQUIREMENT);
		if (requirement != null) {
			final Object id = element.getValue(requirement, "id"); //$NON-NLS-1$
			return id == null ? "" : String.valueOf(id); //$NON-NLS-1$
		}
		return null;
	}

	/**
	 * @see SysmlElementServices#getRequirement(Class)
	 */
	public Requirement getRequirement(Class element) {
		return SysmlElementServices.INSTANCE.getRequirement(element);
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
		final List<Object> requirements = Lists.newArrayList();
		for (final Object element : elements) {
			if (element instanceof Class && SysmlElementServices.INSTANCE.isRequirement((Class)element)) {
				requirements.add(element);
			}
		}
		return requirements;
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

	public String getTextForRequirement(final Element element) {
		final Stereotype requirement = element.getAppliedStereotype(ISysmlConstants.SYSML_REQUIREMENT);
		if (requirement != null) {
			final Object id = element.getValue(requirement, "text"); //$NON-NLS-1$
			return id == null ? "" : String.valueOf(id); //$NON-NLS-1$
		}
		return null;
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
			final Stereotype requirement = r.getAppliedStereotype(ISysmlConstants.SYSML_REQUIREMENT);
			r.setValue(requirement, "id", id); //$NON-NLS-1$
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
			final Stereotype requirement = r.getAppliedStereotype(ISysmlConstants.SYSML_REQUIREMENT);
			r.setValue(requirement, "text", text); //$NON-NLS-1$
		}
	}
}
