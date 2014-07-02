/*****************************************************************************
 * Copyright (c) 2010, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - filter out EObjects that are Resources (CDO)
 *  Christian W. Damus (CEA) - Support read-only state at object level (CDO)
 *  Christian W. Damus (CEA) - bug 323802
 *  Christian W. Damus (CEA) - bug 429826
 *  Christian W. Damus (CEA) - bug 408491
 *  Christian W. Damus (CEA) - bug 432813
 *  Christian W. Damus (CEA) - bug 422257
 *  Melanie Bats (Obeo) - Clone EMFHelper and keep only the getResourceSet method
 *  to simplify dependencies of org.eclipse.papyrus.sysml 
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.utils;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * A Helper class for manipulating EMF Objects
 * 
 * @author Camille Letavernier
 */
public class EMFHelper {
	/**
	 * Returns the resourceSet owning this eObject, or null if it is detached
	 *
	 * @param eObject
	 */
	public static ResourceSet getResourceSet(EObject eObject) {
		Resource resource = (eObject == null) ? null : eObject.eResource();
		return (resource == null) ? null : resource.getResourceSet();
	}
}
