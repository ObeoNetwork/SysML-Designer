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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.sysml14.activities.Probability;
import org.eclipse.papyrus.sysml14.activities.Rate;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.DecisionNode;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Expression;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.ObjectNode;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterSet;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.obeonetwork.dsl.sysml.design.internal.services.SysmlElementServices;

/**
 * Services For Activity Diagram.
 *
 * @author Frederic Bats <a href="mailto:frederic.bats@obeo.fr">frederic.bats@obeo.fr</a>
 */
public class ActivityDiagramServices {
	private final String activitiesProfile = "SysML::Activities"; //$NON-NLS-1$

	private final String continuesStereotype = "Continuous"; //$NON-NLS-1$

	private final String discreteStereotype = "Discrete"; //$NON-NLS-1$

	private final String probabilityStereotype = "Probability"; //$NON-NLS-1$

	private void applyProbability(Element element) {
		if (!canApplyProbability(element)) {
			return;
		}
		final Package parentPkg = element.getNearestPackage();
		if (parentPkg != null) {
			// Apply continuous or discrete stereotype
			SysmlElementServices.INSTANCE.createAssociatedStereotype(element, activitiesProfile,
					probabilityStereotype);
			// Create a new probability ValueSpecification (expression)
			final Expression probability = UMLFactory.eINSTANCE.createExpression();
			probability.setName("Probability"); //$NON-NLS-1$
			parentPkg.getPackagedElements().add(probability);
			setProbabilityStereotypeValue(element, probability);
		}
	}

	/**
	 * Apply generic Rate Stereotype (continuous or discrete);
	 *
	 * @param element
	 *            selected element (activity edge or ActivityParameterNode)
	 * @param stereotypeName
	 *            name of the stereotype to apply
	 */
	private boolean applyRateStereotype(Element element, String stereotypeName) {
		if (!(element instanceof Parameter || element instanceof ActivityEdge)) {
			return false;
		}
		if (!(continuesStereotype.equals(stereotypeName) || discreteStereotype.equals(stereotypeName))) {
			return false;
		}
		final Package parentPkg = element.getNearestPackage();
		if (parentPkg != null) {
			// Apply continuous or discrete stereotype
			SysmlElementServices.INSTANCE.createAssociatedStereotype(element, activitiesProfile,
					stereotypeName);
			// Create a new rate instanceSpecification
			final InstanceSpecification rate = UMLFactory.eINSTANCE.createInstanceSpecification();
			rate.setName("Rate"); //$NON-NLS-1$
			parentPkg.getPackagedElements().add(rate);
			setRateStereotypeValue(element, rate);
			return true;
		}
		return false;
	}

	/**
	 * Can be applied stereotype Probability.
	 *
	 * @param element
	 *            selected element
	 * @return true if ActivityEdge is a descisionNode or an ObjectNode
	 */
	public boolean canApplyProbability(Element element) {
		/*
		 * Probability can be applied to ActivityEdge if source is a Descision node or an ObjectNode
		 * Probability can be applied if source is output parameterSet
		 */
		boolean result = false;
		if (element instanceof ActivityEdge) {
			final ActivityNode source = ((ActivityEdge)element).getSource();
			if (source instanceof DecisionNode || source instanceof ObjectNode) {
				result = true;
			}
		} else if (element instanceof ParameterSet) {
			// widget ParameterSet are not implemented
			result = false;
		}
		return result;
	}

	/**
	 * Delete rate stereotype value
	 *
	 * @param element
	 *            selected element
	 */
	public void deleteRateStereotypeValue(Element element) {
		final Rate sterApp = UMLUtil.getStereotypeApplication(element, Rate.class);
		if (sterApp != null) {
			final InstanceSpecification rate = sterApp.getRate();
			if (rate != null) {
				final EList<EObject> references = rate.eCrossReferences();
				if (references.size() == 2) {
					// 2 references expected the package and the stereotype
					rate.destroy();
				}
			}
		}
	}

	/**
	 * Is the Continuous Stereotype applied.
	 *
	 * @param element
	 *            selected Activity Edge
	 * @return true if stereotype is applied
	 */
	public boolean hasContinuousStereotypeApplied(ActivityEdge element) {
		return SysmlElementServices.INSTANCE.hasStereotype(element, continuesStereotype);
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
			result = SysmlElementServices.INSTANCE.hasStereotype(parameter, continuesStereotype);
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
		return SysmlElementServices.INSTANCE.hasStereotype(element, discreteStereotype);
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
			result = SysmlElementServices.INSTANCE.hasStereotype(parameter, discreteStereotype);
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
		setRateStereotype(element, continuesStereotype);
	}

	/**
	 * Apply Discrete stereotype.
	 *
	 * @param element
	 *            selected element
	 */
	public void setDiscreteStereotype(Element element) {
		setRateStereotype(element, discreteStereotype);
	}

	/**
	 * Apply Probability stereotype to an Activity Edge.
	 *
	 * @param edge
	 *            selected edge
	 */
	public void setProbabilityStereotype(ActivityEdge edge) {
		// get all edges which have the same source as the selected edge
		final ActivityNode source = edge.getSource();
		source.getOutgoings();

		for (final ActivityEdge outgoingEdge : source.getOutgoings()) {
			if (!SysmlElementServices.INSTANCE.hasStereotype(outgoingEdge, probabilityStereotype)) {
				applyProbability(outgoingEdge);
			}
		}
	}

	/**
	 * Set the Probability expression to a value.
	 *
	 * @param element
	 *            selected Element
	 * @param probability
	 *            new value
	 */
	private void setProbabilityStereotypeValue(Element element, Expression probability) {
		final Probability sterApp = UMLUtil.getStereotypeApplication(element, Probability.class);
		if (sterApp != null) {
			sterApp.setProbability(probability);
		}
	}

	/**
	 * Apply Rate Stereotype (continuous or discrete);
	 *
	 * @param element
	 *            selected element (activity edge or ActivityParameterNode)
	 * @param stereotypeName
	 *            name of the stereotype to apply
	 */
	private void setRateStereotype(Element element, String stereotypeName) {
		if (element instanceof ActivityEdge) {
			applyRateStereotype(element, stereotypeName);
		} else if (element instanceof ActivityParameterNode) {
			final ActivityParameterNode paramNode = (ActivityParameterNode)element;
			final Parameter parameter = paramNode.getParameter();
			if (parameter == null) {
				return;
			}
			if (applyRateStereotype(parameter, stereotypeName)) {
				// parameter must be set to streaming
				parameter.setIsStream(true);
			}
		}
	}

	/**
	 * Set the Rate value for Rate Stereotype attribute.
	 *
	 * @param element
	 *            element stereotyped as Rate (continuous or discrete)
	 * @param newValue
	 *            new Rate value
	 */
	public void setRateStereotypeValue(Element element, InstanceSpecification newValue) {
		final Rate sterApp = UMLUtil.getStereotypeApplication(element, Rate.class);
		if (sterApp != null) {
			sterApp.setRate(newValue);
		}
	}

	/**
	 * Unapply Probability stereotype.
	 *
	 * @param element
	 *            selected element
	 */
	private void unapplyProbabilityStereotype(Element element) {
		// Delete Probability expression associated to the element
		final Probability sterApp = UMLUtil.getStereotypeApplication(element, Probability.class);
		if (sterApp != null) {
			final ValueSpecification probability = sterApp.getProbability();
			if (probability != null) {
				final EList<EObject> references = probability.eCrossReferences();
				if (references.size() == 2) {
					// 2 references expected the package and the stereotype
					probability.destroy();
				}
			}
		}
		// unapply the Probability Stereotype
		final String qualifiedStereotypeName = activitiesProfile + "::" + probabilityStereotype; //$NON-NLS-1$
		SysmlElementServices.INSTANCE.deleteAssociatedStereotype(element, qualifiedStereotypeName);
	}

	/**
	 * Unapply Continuous/Discrete stereotype.
	 *
	 * @param element
	 *            selected element
	 */
	private void unapplyRateStereotype(Element element, String stereotypeName) {
		if (element instanceof ActivityEdge) {
			unsetRateStereotype(element, stereotypeName);
		} else if (element instanceof ActivityParameterNode) {
			final ActivityParameterNode paramNode = (ActivityParameterNode)element;
			final Parameter parameter = paramNode.getParameter();
			if (parameter == null) {
				return;
			}
			unsetRateStereotype(parameter, stereotypeName);
		}
	}

	/**
	 * Unapply Continuous Stereotype.
	 *
	 * @param element
	 *            Selected element
	 */
	public void unsetContinuousStereotype(Element element) {
		unapplyRateStereotype(element, continuesStereotype);
	}

	/**
	 * Unapply Discrete Stereotype.
	 *
	 * @param element
	 *            Selected element
	 */
	public void unsetDiscreteStereotype(Element element) {
		unapplyRateStereotype(element, discreteStereotype);
	}

	/**
	 * Unapply Probability Stereotype.
	 *
	 * @param element
	 *            Selected element
	 */
	public void unsetProbabilityStereotype(ActivityEdge edge) {
		final ActivityNode source = edge.getSource();
		for (final ActivityEdge outgoingEdge : source.getOutgoings()) {
			if (SysmlElementServices.INSTANCE.hasStereotype(outgoingEdge, probabilityStereotype)) {
				unapplyProbabilityStereotype(outgoingEdge);
			}
		}
	}

	/**
	 * Unapply Continuous/Discrete stereotype.
	 *
	 * @param element
	 *            selected element
	 */
	private void unsetRateStereotype(Element element, String stereotypeName) {
		deleteRateStereotypeValue(element);
		final String qualifiedStereotypeName = activitiesProfile + "::" + stereotypeName; //$NON-NLS-1$
		SysmlElementServices.INSTANCE.deleteAssociatedStereotype(element, qualifiedStereotypeName);
	}
}
