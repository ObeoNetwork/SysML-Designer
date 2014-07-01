/*******************************************************************************
 * Copyright (c) 2007 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.uml.extensionpoints.utils;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.papyrus.uml.extensionpoints.Activator;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Stereotype;

/**
 * Some utils extracted from com.cea.utils classes (package and element)
 */
public class Util {

	/**
	 * Check if the StereotypedElement has the given stereotype.
	 *
	 * @param stereotypeName
	 *        name of the stereotype
	 * @param elt
	 *        element to check
	 *
	 * @return true if a stereotype whith the same name was found
	 */
	public static boolean hasStereotype(Element elt, String stereotypeName) {
		boolean has = false;

		if(elt != null) {
			Iterator i = elt.getAppliedStereotypes().iterator();
			Stereotype currentStereotype;
			while(i.hasNext() && !has) {
				currentStereotype = (Stereotype)i.next();
				if(currentStereotype.getName().equals(stereotypeName)) {
					has = true;
				}
			}
		}
		return has;
	}

	/**
	 * Returns the resourceSet associated to the specified EObject. If no eResource is associated to
	 * the EObject, creates a new ResourceSet, using {@link ResourceSetImpl}.
	 *
	 * @param eObject
	 *        the object from which the ResourceSet is retrieved
	 * @return the ResourceSet in which the eObject is managed, or a new one if no resource is
	 *         associated to the eObject
	 * @deprecated Registered Libraries/Profiles should not be loaded into the current resource set. Use {@link #getSharedResourceSet()} instead
	 */
	@Deprecated
	public static ResourceSet getResourceSet(EObject eObject) {
		if(eObject != null && eObject.eResource() != null) {
			return eObject.eResource().getResourceSet();
		} else {
			// standalone registrations
			/*
			 * EPackage.Registry.INSTANCE.put("http://www.eclipse.org/uml2/1.0.0/UML",
			 * UMLPackage.eINSTANCE);
			 * Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("uml2", new
			 * UMLResourceFactoryImpl());
			 * Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecore", new
			 * EcoreResourceFactoryImpl());
			 * Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("*", new
			 * XMIResourceFactoryImpl());
			 */
			Activator.log("should not create a new ResourceSetImpl");
			return new ResourceSetImpl();
		}
	}

	/**
	 * Creates and returns a temporary resource set. The resource set can be used to load libraries
	 * without polluting the current ModelSet.
	 *
	 * It is configured with XMI Load options, to allow safe loading of resources
	 *
	 * @return
	 *         A temporary resource set
	 *
	 */
	public static ResourceSet createTemporaryResourceSet() {
		ResourceSet tmpResourceSet = new ResourceSetImpl();

		tmpResourceSet.getLoadOptions().put(XMLResource.OPTION_DEFER_ATTACHMENT, true);
		tmpResourceSet.getLoadOptions().put(XMLResource.OPTION_DEFER_IDREF_RESOLUTION, true);
		tmpResourceSet.getLoadOptions().put(XMIResource.OPTION_LAX_FEATURE_PROCESSING, Boolean.TRUE);
		tmpResourceSet.getLoadOptions().put(XMLResource.OPTION_RECORD_UNKNOWN_FEATURE, Boolean.TRUE);

		return tmpResourceSet;
	}

	/**
	 * @deprecated Share resource set never reloads resources. Use a temporary resource set instead
	 * @return
	 *
	 * @see {@link #createTemporaryResourceSet()}
	 */
	@Deprecated
	public static ResourceSet getSharedResourceSet() {
		return createTemporaryResourceSet();
	}

}
