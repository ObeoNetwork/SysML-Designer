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

import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Parameter;
import org.obeonetwork.dsl.sysml.design.internal.services.SysmlElementServices;

/**
 * Services For Activity Diagram.
 *
 * @author Frederic Bats <a href="mailto:frederic.bats@obeo.fr">frederic.bats@obeo.fr</a>
 */
public class ActivityDiagramServices {

	/**
	 * Can be applied stereotype Probability.
	 *
	 * @param element
	 *            selected element
	 * @return true if ActivityEdge is a descisionNode or an ObjectNode
	 */
	public boolean canApplyProbability(Element element) {
		return org.obeonetwork.dsl.sysml.design.internal.services.ActivityDiagramServices.INSTANCE
				.canApplyProbability(element);
	}

	/**
	 * Is the Continuous Stereotype applied.
	 *
	 * @param element
	 *            selected Activity Edge
	 * @return true if stereotype is applied
	 */
	public boolean hasContinuousStereotypeApplied(ActivityEdge element) {
		return SysmlElementServices.INSTANCE.hasStereotype(element,
				org.obeonetwork.dsl.sysml.design.internal.services.ActivityDiagramServices.CONTINUOUS_STEREOTYPE);
	}

	/**
	 * Is the Continuous Stereotype applied.
	 *
	 * @param element
	 *            selected Activity Parameter Node
	 * @return true if stereotype is applied
	 */
	public boolean hasContinuousStereotypeApplied(ActivityParameterNode element) {
		boolean result = true;
		final Parameter parameter = element.getParameter();
		if (parameter != null) {
			result = SysmlElementServices.INSTANCE.hasStereotype(parameter,
					org.obeonetwork.dsl.sysml.design.internal.services.ActivityDiagramServices.CONTINUOUS_STEREOTYPE);
		}
		return result;
	}

	/**
	 * Is the Discrete Stereotype applied.
	 *
	 * @param element
	 *            selected Activity Edge
	 * @return true if stereotype is applied
	 */
	public boolean hasDiscreteStereotypeApplied(ActivityEdge element) {
		return SysmlElementServices.INSTANCE.hasStereotype(element,
				org.obeonetwork.dsl.sysml.design.internal.services.ActivityDiagramServices.DISCRETE_STEREOTYPE);
	}

	/**
	 * Is the Discrete Stereotype applied.
	 *
	 * @param element
	 *            selected Activity Parameter Node
	 * @return true if stereotype is applied
	 */
	public boolean hasDiscreteStereotypeApplied(ActivityParameterNode element) {
		boolean result = true;
		final Parameter parameter = element.getParameter();
		if (parameter != null) {
			result = SysmlElementServices.INSTANCE.hasStereotype(parameter,
					org.obeonetwork.dsl.sysml.design.internal.services.ActivityDiagramServices.DISCRETE_STEREOTYPE);
		}
		return result;
	}

	/**
	 * Apply Continuous stereotype.
	 *
	 * @param element
	 *            selected element
	 */
	public void setContinuousStereotype(Element element) {
		org.obeonetwork.dsl.sysml.design.internal.services.ActivityDiagramServices.INSTANCE.setRateStereotype(
				element,
				org.obeonetwork.dsl.sysml.design.internal.services.ActivityDiagramServices.CONTINUOUS_STEREOTYPE);
	}

	/**
	 * Apply Discrete stereotype.
	 *
	 * @param element
	 *            selected element
	 */
	public void setDiscreteStereotype(Element element) {
		org.obeonetwork.dsl.sysml.design.internal.services.ActivityDiagramServices.INSTANCE.setRateStereotype(
				element,
				org.obeonetwork.dsl.sysml.design.internal.services.ActivityDiagramServices.DISCRETE_STEREOTYPE);
	}

	/**
	 * Apply Probability stereotype to an Activity Edge.
	 *
	 * @param edge
	 *            selected edge
	 */
	public void setProbabilityStereotype(ActivityEdge edge) {
		org.obeonetwork.dsl.sysml.design.internal.services.ActivityDiagramServices.INSTANCE
				.setProbabilityStereotype(edge);
	}

	/**
	 * Unapply Continuous Stereotype.
	 *
	 * @param element
	 *            Selected element
	 */
	public void unsetContinuousStereotype(Element element) {
		org.obeonetwork.dsl.sysml.design.internal.services.ActivityDiagramServices.INSTANCE
				.unapplyRateStereotype(element,
						org.obeonetwork.dsl.sysml.design.internal.services.ActivityDiagramServices.CONTINUOUS_STEREOTYPE);
	}

	/**
	 * Unapply Discrete Stereotype.
	 *
	 * @param element
	 *            Selected element
	 */
	public void unsetDiscreteStereotype(Element element) {
		org.obeonetwork.dsl.sysml.design.internal.services.ActivityDiagramServices.INSTANCE
				.unapplyRateStereotype(element,
						org.obeonetwork.dsl.sysml.design.internal.services.ActivityDiagramServices.DISCRETE_STEREOTYPE);
	}

	/**
	 * Unapply Probability Stereotype.
	 *
	 * @param element
	 *            Selected element
	 */
	public void unsetProbabilityStereotype(ActivityEdge edge) {
		org.obeonetwork.dsl.sysml.design.internal.services.ActivityDiagramServices.INSTANCE
				.unsetProbabilityStereotype(edge);
	}

}
