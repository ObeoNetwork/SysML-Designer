/*******************************************************************************
 * Copyright (c) 2009, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.sysml.design.internal.services;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;

/**
 * Manage the diagram elements' labels.
 *
 * @author Melanie Bats <a href="mailto:melanie.bats@obeo.fr">melanie.bats@obeo.fr</a>
 */
public class LabelServices {
	/**
	 * A singleton instance to be accessed by other java services.
	 */
	public static final LabelServices INSTANCE = new LabelServices();

	/**
	 * Hidden constructor.
	 */
	private LabelServices() {

	}

	/**
	 * Compute displayed label of the given element
	 * 
	 * @param element
	 *            the {@link Element} for which to retrieve a label.
	 * @return the computed label.
	 */
	public String computeSysmlDisplayLabel(NamedElement element) {
		final DisplayLabelSwitch genLabel = new DisplayLabelSwitch();
		return genLabel.doSwitch(element);
	}

	/**
	 * Compute the default label of the given element.
	 *
	 * @param element
	 *            the {@link Element} for which to retrieve a label.
	 * @return the computed label.
	 */
	public String computeSysmlLabel(NamedElement element) {
		final ComputeLabelSwitch genLabel = new ComputeLabelSwitch();

		return genLabel.doSwitch(element);
	}
}
