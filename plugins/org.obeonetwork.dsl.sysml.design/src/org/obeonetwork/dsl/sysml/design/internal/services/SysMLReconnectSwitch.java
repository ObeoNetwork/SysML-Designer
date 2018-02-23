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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.obeonetwork.dsl.uml2.core.api.utils.UmlReconnectSwitch;

/**
 * A switch that handle the edge reconnections for each SysML types.
 *
 * @author Melanie Bats<a href="mailto:melanie.bats@obeo.fr">melanie.bats@obeo.fr</a>
 */
public class SysMLReconnectSwitch extends UmlReconnectSwitch {

	/**
	 * The current reconnection kind.
	 */
	private boolean isReconnectingSource;

	/**
	 * The old pointed element.
	 */
	private Class oldPointedClass;

	/**
	 * The new pointed element.
	 */
	private Class newPointedClass;

	/**
	 * The sub requirement.
	 */
	private Class requirement;

	@Override
	public Element caseClass(Class class_) {
		if (isReconnectingSource()) {
			oldPointedClass.getNestedClassifiers().remove(requirement);
			newPointedClass.getNestedClassifiers().add(requirement);
		} else {
			class_.getNestedClassifiers().remove(oldPointedClass);
			final EObject parent = class_.eContainer();
			if (parent instanceof Package) {
				((Package)parent).getPackagedElements().add(oldPointedClass);
			} else if (parent instanceof Class) {
				((Class)parent).getNestedClassifiers().add(oldPointedClass);
			}
			class_.getNestedClassifiers().add(newPointedClass);
		}

		return class_;
	}

	private boolean isReconnectingSource() {
		return isReconnectingSource;
	}

	public void setNewPointedClass(Class newPointedClass) {
		this.newPointedClass = newPointedClass;
	}

	public void setOldPointedClass(Class oldPointedClass) {
		this.oldPointedClass = oldPointedClass;
	}

	public void setReconnectingSource(boolean isReconnectingSource) {
		this.isReconnectingSource = isReconnectingSource;
	}

	public void setSubRequirement(Class requirement) {
		this.requirement = requirement;
	}
}
