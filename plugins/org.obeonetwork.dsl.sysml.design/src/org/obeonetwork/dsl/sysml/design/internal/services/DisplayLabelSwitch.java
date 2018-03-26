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
package org.obeonetwork.dsl.sysml.design.internal.services;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.sysml14.activities.Probability;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityParameterNode;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.ControlFlow;
import org.eclipse.uml2.uml.Expression;
import org.eclipse.uml2.uml.ObjectFlow;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ValueSpecification;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * Specific SysML labels for Sysml.
 *
 * @author Frederic Bats <a href="mailto:frederic.bats@obeo.fr">frederic.bats@obeo.fr</a>
 */
public class DisplayLabelSwitch extends org.obeonetwork.dsl.uml2.core.internal.services.DisplayLabelSwitch {

	private final static String CONTROL_OPERATOR = "ControlOperator"; //$NON-NLS-1$

	private final static String SQUARE_BRACKET_OPEN = "["; //$NON-NLS-1$

	private final static String SQUARE_BRACKET_CLOSE = "]"; //$NON-NLS-1$

	private final static String BRACKET_OPEN = "{"; //$NON-NLS-1$

	private final static String BRACKET_CLOSE = "}"; //$NON-NLS-1$

	private final String continuousStereotype = "Continuous"; //$NON-NLS-1$

	private final String discreteStereotype = "Discrete"; //$NON-NLS-1$

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String caseActivity(Activity object) {
		String label = defaultCase(object);
		if (SysmlElementServices.INSTANCE.hasStereotype(object, CONTROL_OPERATOR)) {
			label = label + SPACE + SQUARE_BRACKET_OPEN + CONTROL_OPERATOR + SQUARE_BRACKET_CLOSE;
		}
		return label;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String caseActivityEdge(ActivityEdge object) {
		String label = defaultCase(object);
		if (SysmlElementServices.INSTANCE.hasStereotype(object, "Probability")) { //$NON-NLS-1$
			final Probability sterApp = UMLUtil.getStereotypeApplication(object, Probability.class);
			final ValueSpecification valSpec = sterApp.getProbability();
			if (valSpec instanceof Expression) {
				valSpec.getName();
				label = SPACE + BRACKET_OPEN + "probability=" + valSpec.getName() + BRACKET_CLOSE; //$NON-NLS-1$
			}
		}
		return label;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String caseActivityParameterNode(ActivityParameterNode object) {
		final String label = defaultCase(object);
		final Parameter param = object.getParameter();
		String postfix = ""; //$NON-NLS-1$
		String streamLabel = ""; //$NON-NLS-1$
		if (param != null) {
			final String stereotypes = computeStereotypes(param);
			if (stereotypes != null && !stereotypes.isEmpty()) {
				postfix = System.lineSeparator() + stereotypes;
			}
			if (param.isStream() && !(SysmlElementServices.INSTANCE.hasStereotype(param, continuousStereotype)
					|| SysmlElementServices.INSTANCE.hasStereotype(param, discreteStereotype))) {

				streamLabel = BRACKET_OPEN + "stream" + BRACKET_CLOSE; //$NON-NLS-1$
			}
		}
		return streamLabel + label + postfix;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String caseCallBehaviorAction(CallBehaviorAction object) {
		final Behavior behavior = object.getBehavior();
		String prefix = ""; //$NON-NLS-1$
		if (behavior != null) {
			final String stereotypes = computeStereotypes(behavior);
			if (stereotypes != null && !stereotypes.isEmpty()) {
				prefix = stereotypes + System.lineSeparator();
			}
		}
		return prefix + defaultCase(object);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String caseCallOperationAction(CallOperationAction object) {
		final Operation operation = object.getOperation();
		String prefix = ""; //$NON-NLS-1$
		if (operation != null) {
			final String stereotypes = computeStereotypes(operation);
			if (stereotypes != null && !stereotypes.isEmpty()) {
				prefix = stereotypes + System.lineSeparator();
			}
		}
		return prefix + defaultCase(object);
	}

	@Override
	public String caseControlFlow(ControlFlow object) {
		return null;
	}

	@Override
	public String caseObjectFlow(ObjectFlow object) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String defaultCase(EObject object) {
		final org.obeonetwork.dsl.uml2.core.internal.services.DisplayLabelSwitch labelSwitch = new org.obeonetwork.dsl.uml2.core.internal.services.DisplayLabelSwitch();
		final String label = labelSwitch.doSwitch(object);
		return label;
	}
}
