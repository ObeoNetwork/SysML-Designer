/*******************************************************************************
 * Copyright (c) 2018 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.sysml.design.api.services;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;

/**
 * Utility services for SysML.
 *
 * @author Frederic Bats <a href="mailto:frederic.bats@obeo.fr">frederic.bats@obeo.fr</a>
 */
public class SysmlElementServices {

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
		org.obeonetwork.dsl.sysml.design.internal.services.SysmlElementServices.INSTANCE
				.createAssociatedStereotype(e, profileQualifiedName, stereotypeName);
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
		org.obeonetwork.dsl.sysml.design.internal.services.SysmlElementServices.INSTANCE
				.deleteAssociatedStereotype(e, steQualified);
	}

	/**
	 * Get requirement id.
	 *
	 * @param element
	 *            Requirement
	 * @return Id
	 */
	public String getRequirementId(Class element) {
		return org.obeonetwork.dsl.sysml.design.internal.services.SysmlElementServices.INSTANCE
				.getRequirementId(element);
	}

	/**
	 * Returns the root container; it may be this object itself.
	 *
	 * @param eObject
	 *            the object to get the root container for.
	 * @return the root container.
	 */
	public EObject getRootContainer(EObject eObject) {
		return org.obeonetwork.dsl.sysml.design.internal.services.SysmlElementServices.INSTANCE
				.getRootContainer(eObject);
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
	public boolean hasStereotype(Element element, String stereotypeName) {
		return org.obeonetwork.dsl.sysml.design.internal.services.SysmlElementServices.INSTANCE
				.hasStereotype(element, stereotypeName);
	}

	/**
	 * Checks if element has the stereotype block.
	 *
	 * @param element
	 *            Named element
	 * @return True if element is a block otherwise false
	 */
	public boolean isBlock(Element element) {
		return org.obeonetwork.dsl.sysml.design.internal.services.SysmlElementServices.INSTANCE
				.isBlock(element);
	}

	/**
	 * Checks if element has the stereotype constraint block.
	 *
	 * @param element
	 *            Named element
	 * @return True if element is a constraint block otherwise false
	 */
	public boolean isConstraintBlock(Classifier element) {
		return org.obeonetwork.dsl.sysml.design.internal.services.SysmlElementServices.INSTANCE
				.isConstraintBlock(element);
	}

	/**
	 * Checks if element has the stereotype flow port.
	 *
	 * @param element
	 *            Named element
	 * @return True if element is a flow port otherwise false
	 */
	public boolean isFlowPort(Element element) {
		return org.obeonetwork.dsl.sysml.design.internal.services.SysmlElementServices.INSTANCE
				.isFlowPort(element);
	}

	/**
	 * Checks if element has the stereotype requirement.
	 *
	 * @param element
	 *            Named element
	 * @return True if element is a requirement otherwise false
	 */
	public boolean isRequirement(Element element) {
		return org.obeonetwork.dsl.sysml.design.internal.services.SysmlElementServices.INSTANCE
				.isRequirement(element);
	}
}
