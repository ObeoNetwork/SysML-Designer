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
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.obeonetwork.dsl.sysml.design.internal.services.SysmlElementServices;

import com.google.common.collect.Lists;

/**
 * A set of services to handle the Satisfy table.
 *
 * @author Melanie Bats <a href="mailto:melanie.bats@obeo.fr">melanie.bats@obeo.fr</a>
 */
public class VerifyTableServices {
	/**
	 * Get all test cases.
	 *
	 * @param container
	 *            Container
	 * @return All test cases.
	 */
	public List<Operation> getAllTestCases(Element container) {
		final List<Operation> testcases = Lists.newArrayList();
		for (final Iterator<EObject> iterator = SysmlElementServices.INSTANCE.getRootContainer(container)
				.eAllContents(); iterator.hasNext();) {
			final EObject element = iterator.next();
			if (element instanceof Operation && SysmlElementServices.INSTANCE.isTestCase((Operation)element)) {
				testcases.add((Operation)element);
			}
		}
		return testcases;
	}

	/**
	 * Get all verify requirements.
	 *
	 * @param container
	 *            Package
	 * @return All verify requirements.
	 */
	public List<NamedElement> getAllVerifyReqts(Package container) {
		final List<NamedElement> results = Lists.newArrayList();
		for (final Iterator<EObject> iterator = SysmlElementServices.INSTANCE.getRootContainer(container)
				.eAllContents(); iterator.hasNext();) {
			final EObject element = iterator.next();
			if (element instanceof Abstraction
					&& SysmlElementServices.INSTANCE.isVerify((NamedElement)element)) {
				results.add((NamedElement)element);
			}
		}
		return results;
	}
}
