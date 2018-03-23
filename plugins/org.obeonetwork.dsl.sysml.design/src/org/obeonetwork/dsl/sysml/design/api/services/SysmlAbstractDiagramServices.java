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
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.obeonetwork.dsl.sysml.design.internal.services.LabelServices;
import org.obeonetwork.dsl.sysml.design.internal.services.SysmlElementServices;
import org.obeonetwork.dsl.uml2.core.api.services.AbstractDiagramServices;

/**
 * A set of services used by SysML diagrams.
 *
 * @author Melanie Bats <a href="mailto:melanie.bats@obeo.fr">melanie.bats@obeo.fr</a>
 */
public abstract class SysmlAbstractDiagramServices extends AbstractDiagramServices {
	/**
	 * Compute displayed label of the given element
	 *
	 * @param element
	 *            the {@link Element} for which to retrieve a label.
	 * @return the computed label.
	 */
	public String computeSysmlDisplayLabel(NamedElement element) {
		return LabelServices.INSTANCE.computeSysmlDisplayLabel(element);
	}

	/**
	 * Compute the default label of the given element.
	 *
	 * @param element
	 *            the {@link NamedElement} for which to retrieve a label.
	 * @return the computed label.
	 */
	public String computeSysmlLabel(NamedElement element) {
		return LabelServices.INSTANCE.computeSysmlLabel(element);
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
		SysmlElementServices.INSTANCE.deleteAssociatedStereotype(e, steQualified);
	}

	/**
	 * Is it a specific SysML label.
	 *
	 * @param element
	 *            uml element
	 * @return true if the label is redefined in SysML Specification
	 */
	public boolean isRedefinedLabel(EObject element) {
		if (element instanceof CallBehaviorAction || element instanceof CallOperationAction
				|| element instanceof Activity || element instanceof ActivityParameterNode
				|| element instanceof ActivityEdge) {
			return true;
		}
		return false;
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
