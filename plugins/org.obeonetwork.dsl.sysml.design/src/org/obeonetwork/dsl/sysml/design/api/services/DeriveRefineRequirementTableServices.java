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
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.obeonetwork.dsl.sysml.design.internal.services.SysmlElementServices;

import com.google.common.collect.Lists;

/**
 * A set of services to handle the Derive and Refine Requirement table.
 *
 * @author Melanie Bats <a href="mailto:melanie.bats@obeo.fr">melanie.bats@obeo.fr</a>
 */
public class DeriveRefineRequirementTableServices {
	/**
	 * Get all derive requirements.
	 *
	 * @param container
	 *            Package
	 * @return All derive requirements.
	 */
	public List<NamedElement> getAllDeriveReqts(Package container) {
		final List<NamedElement> results = Lists.newArrayList();
		for (final Iterator<EObject> iterator = SysmlElementServices.INSTANCE.getRootContainer(container)
				.eAllContents(); iterator.hasNext();) {
			final EObject element = iterator.next();
			if (element instanceof Abstraction
					&& SysmlElementServices.INSTANCE.isDeriveReqt((NamedElement)element)) {
				results.add((NamedElement)element);
			}
		}
		return results;
	}

	/**
	 * Get all refine requirements.
	 *
	 * @param container
	 *            Package
	 * @return All refine requirements.
	 */
	public List<NamedElement> getAllRefine(Package container) {
		final List<NamedElement> results = Lists.newArrayList();
		for (final Iterator<EObject> iterator = SysmlElementServices.INSTANCE.getRootContainer(container)
				.eAllContents(); iterator.hasNext();) {
			final EObject element = iterator.next();
			if (element instanceof Abstraction
					&& SysmlElementServices.INSTANCE.isRefine((NamedElement)element)) {
				results.add((NamedElement)element);
			}
		}
		return results;
	}
}
