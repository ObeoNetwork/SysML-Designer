/*******************************************************************************
 * Copyright (c) 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.sysml.design.api.services;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.UMLFactory;
import org.obeonetwork.dsl.sysml.design.internal.services.LabelServices;
import org.obeonetwork.dsl.sysml.design.internal.services.SysmlElementServices;
import org.obeonetwork.dsl.uml2.design.api.services.DashboardServices;

/**
 * Utility services for extending dashboard for SysML.
 *
 * @author Melanie Bats <a href="mailto:melanie.bats@obeo.fr">melanie.bats@obeo.fr</a>
 */
public class SysMLDashboardServices extends DashboardServices {
	private static final String BLOCK_DEFINITION_DIAGRAM = "Block Definition Diagram"; //$NON-NLS-1$

	private static final String INTERNAL_BLOCK_DIAGRAM = "Internal Block Diagram"; //$NON-NLS-1$

	private static final String PARAMETRIC_DIAGRAM = "Parametric Diagram"; //$NON-NLS-1$

	private static final String REQUIREMENT_DIAGRAM = "Requirement Diagram"; //$NON-NLS-1$

	private static final String REQUIREMENT_TABLE = "Requirement Table"; //$NON-NLS-1$

	private static final String DERIVE_REFINE_REQUIREMENT_TABLE = "Derive Refine Requirement Table"; //$NON-NLS-1$

	private static final String SATISFY_TABLE = "Satisfy Table"; //$NON-NLS-1$

	private static final String VERIFY_TABLE = "Verify Table"; //$NON-NLS-1$

	private static final String REFINE_TABLE = "Refine Table"; //$NON-NLS-1$

	public void createBlockDefinitionDiagram(Model element) {
		createRepresentation(element, BLOCK_DEFINITION_DIAGRAM);
	}

	public void createDeriveRefineRequirementTable(Model element) {
		createRepresentation(element, DERIVE_REFINE_REQUIREMENT_TABLE);
	}

	public void createInternalBlockDiagram(Class element) {
		createRepresentation(element, INTERNAL_BLOCK_DIAGRAM);
	}

	public void createParametricDiagram(Class element) {
		createRepresentation(element, PARAMETRIC_DIAGRAM);
	}

	public void createRefineTable(Model element) {
		createRepresentation(element, REFINE_TABLE);
	}

	public void createRequirementDiagram(Model element) {
		createRepresentation(element, REQUIREMENT_DIAGRAM);
	}

	public void createRequirementTable(Model element) {
		createRepresentation(element, REQUIREMENT_TABLE);
	}

	public void createSatisfyTable(Model element) {
		createRepresentation(element, SATISFY_TABLE);
	}

	public void createVerifyTable(Model element) {
		createRepresentation(element, VERIFY_TABLE);
	}

	/**
	 * Get a block.
	 *
	 * @param parent
	 *            Parent
	 * @return Block
	 */
	private Class getBlock(org.eclipse.uml2.uml.Package parent) {
		final Class block = UMLFactory.eINSTANCE.createClass();
		parent.getPackagedElements().add(block);
		SysmlElementServices.INSTANCE.createAssociatedStereotype(block, "SysML::Blocks", "Block"); //$NON-NLS-1$ //$NON-NLS-2$
		final String label = LabelServices.INSTANCE.computeSysmlLabel(block);
		block.setName(label);
		return block;
	}

	/**
	 * Create a block under a package.
	 *
	 * @param pkg
	 *            The package
	 * @return A block
	 */
	public Class initBlockForPackage(org.eclipse.uml2.uml.Package pkg) {
		final Class block = getBlock(pkg);
		return block;
	}
}
