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
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.obeonetwork.dsl.sysml.design.internal.services.SysmlElementServices;

import com.google.common.collect.Lists;

/**
 * A set of services to handle the Parametric diagram.
 *
 * @author Melanie Bats <a href="mailto:melanie.bats@obeo.fr">melanie.bats@obeo.fr</a>
 */
public class ParametricDiagramServices extends SysmlAbstractDiagramServices {
	/**
	 * Get all blocks.
	 *
	 * @param container
	 *            Container
	 * @return All blocks.
	 */
	public List<Class> getAllBlocks(Element container) {
		// Replace expression :
		// [container.getRootContainer().eAllContents(uml::Package)->union(container.getRootContainer().eAllContents(uml::Class)->select(isBlock()))/]
		final List<Class> blocks = Lists.newArrayList();
		for (final Iterator<EObject> iterator = SysmlElementServices.INSTANCE.getRootContainer(container)
				.eAllContents(); iterator.hasNext();) {
			final EObject element = iterator.next();
			if (element instanceof Class && SysmlElementServices.INSTANCE.isBlock((Class)element)) {
				blocks.add((Class)element);
			}
		}
		return blocks;
	}

	/**
	 * @see SysmlElementServices#getRootContainer(EObject)
	 */
	public EObject getRootContainer(EObject eObject) {
		return SysmlElementServices.INSTANCE.getRootContainer(eObject);
	}

	/**
	 * Checks if element has the stereotype constraint property.
	 *
	 * @param element
	 *            Named element
	 * @return True if element is a constraint property otherwise false
	 */
	public boolean isConstraintProperty(NamedElement element) {
		return SysmlElementServices.INSTANCE.isConstraintProperty(element);
	}

	/**
	 * Checks if an element is a valid root of a parametric diagram.
	 *
	 * @param element
	 *            Named element
	 * @return True if element could be a root of a parametric diagram otherwise false
	 */
	public boolean isValidParametricDiagramRoot(Class element) {
		// Replace the acceleo expression : [getStereotypeApplications()->filter(sysml::blocks::Block)->size()
		// > 0/]
		return SysmlElementServices.INSTANCE.isBlock(element);
	}
}
