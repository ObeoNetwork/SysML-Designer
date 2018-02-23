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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.sirius.viewpoint.DSemanticDecorator;
import org.eclipse.uml2.uml.NamedElement;
import org.obeonetwork.dsl.sysml.design.internal.services.LabelServices;
import org.obeonetwork.dsl.uml2.core.api.services.AbstractDiagramServices;

/**
 * A set of services used by SysML diagrams.
 *
 * @author Melanie Bats <a href="mailto:melanie.bats@obeo.fr">melanie.bats@obeo.fr</a>
 */
public abstract class SysmlAbstractDiagramServices extends AbstractDiagramServices {
	/**
	 * Compute the label of the given element.
	 *
	 * @param element
	 *            the {@link NamedElement} for which to retrieve a label.
	 * @return the computed label.
	 */
	public String computeSysmlLabel(NamedElement element) {
		return LabelServices.INSTANCE.computeSysmlLabel(element);
	}

	/**
	 * Open the select existing element dialog.
	 *
	 * @param selectedContainer
	 *            Selected element
	 * @param selectedContainerView
	 * @param diagram
	 *            Current diagram
	 */
	public void openSelectExistingElementsDialog(EObject selectedContainer,
			DSemanticDecorator selectedContainerView, DDiagram diagram) {
		final ReusedDescriptionServices services = new ReusedDescriptionServices();
		services.openSelectExistingElementsDialog(selectedContainer, selectedContainerView, diagram);
	}
}
