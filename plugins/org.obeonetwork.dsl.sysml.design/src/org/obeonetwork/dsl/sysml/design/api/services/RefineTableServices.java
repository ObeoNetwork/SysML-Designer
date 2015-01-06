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

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.UseCase;
import org.obeonetwork.dsl.sysml.design.internal.services.SysmlElementServices;

import com.google.common.collect.Lists;

/**
 * A set of services to handle the Satisfy table.
 *
 * @author Melanie Bats <a href="mailto:melanie.bats@obeo.fr">melanie.bats@obeo.fr</a>
 */
public class RefineTableServices {

	/**
	 * Get all behaviors.
	 *
	 * @param container
	 *            Container
	 * @return All behaviors.
	 */
	public List<Element> getAllBehaviors(Element container) {
		final List<Element> results = Lists.newArrayList();
		for (final Iterator<EObject> iterator = SysmlElementServices.INSTANCE.getRootContainer(container)
				.eAllContents(); iterator.hasNext();) {
			final EObject element = iterator.next();
			if (element instanceof StateMachine || element instanceof Activity || element instanceof UseCase
					|| element instanceof Collaboration) {
				results.add((Element)element);
			}
		}
		return results;
	}
}
