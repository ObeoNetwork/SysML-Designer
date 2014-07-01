/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.util.UMLUtil;

@Deprecated
public class ElementUtil {

	/**
	 * Check if the StereotypedElement has the given stereotype, or if one of
	 * its stereotype is inherits from the stereotype passed in parameter. This
	 * method currently exists in UMLUtils, this one is a copy created to avoid
	 * some dependencies propagated by UMLUtils (jface...). Current UMLUtils
	 * plug-in should probably be separated into two parts one depending on UML2
	 * plug-in only, and the other bringing ui related features;
	 * 
	 * @deprecated prefer using {@link UMLUtil#getStereotypeApplication(Element, Class)}
	 */
	@Deprecated
	public static EObject hasStereotype(Element elt, EClass stereotypeClass) {
		return UMLUtil.getStereotypeApplication(elt, stereotypeClass.getClass());
	}

	/**
	 * Convenient method to retrieve the StereotypeApplication by passing an
	 * element of the static profile.
	 * 
	 * @deprecated prefer using {@link UMLUtil#getStereotypeApplication(Element, Class)}
	 */
	@Deprecated
	public static <T extends EObject> T getStereotypeApplication(Element element, java.lang.Class<T> clazz) {
		return UMLUtil.getStereotypeApplication(element, clazz);
	}
}
