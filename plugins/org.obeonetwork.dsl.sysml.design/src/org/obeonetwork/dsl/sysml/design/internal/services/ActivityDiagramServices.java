package org.obeonetwork.dsl.sysml.design.internal.services;

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

public class ActivityDiagramServices {
	/**
	 * A singleton instance to be accessed by other java services.
	 */
	public static final ActivityDiagramServices INSTANCE = new ActivityDiagramServices();

	public static final String ACTIVITIES_PROFILE = "SysML::Activities"; //$NON-NLS-1$

	public static final String CONTINUOUS_STEREOTYPE = "Continuous"; //$NON-NLS-1$

	public static final String DISCRETE_STEREOTYPE = "Discrete"; //$NON-NLS-1$

	private final String probabilityStereotype = "Probability"; //$NON-NLS-1$

	/**
	 * Hidden constructor.
	 */
	private ActivityDiagramServices() {
		super();
	}

	private void applyProbability(Element element) {
		if (!canApplyProbability(element)) {
			return;
		}
		final Package parentPkg = element.getNearestPackage();
		if (parentPkg != null) {
			// Apply continuous or discrete stereotype
			SysmlElementServices.INSTANCE.createAssociatedStereotype(element, ACTIVITIES_PROFILE,
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
		if (!(CONTINUOUS_STEREOTYPE.equals(stereotypeName) || DISCRETE_STEREOTYPE.equals(stereotypeName))) {
			return false;
		}
		final Package parentPkg = element.getNearestPackage();
		if (parentPkg != null) {
			// Apply continuous or discrete stereotype
			SysmlElementServices.INSTANCE.createAssociatedStereotype(element, ACTIVITIES_PROFILE,
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
	public void setRateStereotype(Element element, String stereotypeName) {
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
		final String qualifiedStereotypeName = ACTIVITIES_PROFILE + "::" + probabilityStereotype; //$NON-NLS-1$
		SysmlElementServices.INSTANCE.deleteAssociatedStereotype(element, qualifiedStereotypeName);
	}

	/**
	 * Unapply Continuous/Discrete stereotype.
	 *
	 * @param element
	 *            selected element
	 */
	public void unapplyRateStereotype(Element element, String stereotypeName) {
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
		final String qualifiedStereotypeName = ACTIVITIES_PROFILE + "::" + stereotypeName; //$NON-NLS-1$
		SysmlElementServices.INSTANCE.deleteAssociatedStereotype(element, qualifiedStereotypeName);
	}
}
