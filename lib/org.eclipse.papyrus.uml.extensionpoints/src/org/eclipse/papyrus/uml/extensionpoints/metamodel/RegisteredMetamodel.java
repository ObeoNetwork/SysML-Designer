/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *     Dr. David H. Akehurst - enable programmatic registration
 *******************************************************************************/
package org.eclipse.papyrus.uml.extensionpoints.metamodel;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.uml.extensionpoints.Activator;
import org.eclipse.papyrus.uml.extensionpoints.standard.ExtensionIds;
import org.eclipse.papyrus.uml.extensionpoints.standard.RegisteredElementExtensionPoint;

/**
 * Class that manages registered metamodel extension point
 */
public class RegisteredMetamodel extends RegisteredElementExtensionPoint implements IRegisteredMetamodel {

	/** name of the extension point (main element name) in the DTD */
	private static final String TAG_METAMODEL = "metamodel";

	/**
	 * Creates a new RegisteredMetamodel.
	 * 
	 * @param configElt
	 * @param ordinal
	 */
	public RegisteredMetamodel(IConfigurationElement configElt, int ordinal) {
		super(configElt, ordinal);
	}

	public URI getUri() {
		return super.uri;
	}
	
	public String getPath() {
		return super.path;
	}
	
	/**
	 * Returns the list of registered metamodels in the platform, using the Papyrus extension point.
	 * 
	 * @return the list of registered metamodels in the platform
	 */
	public static List<IRegisteredMetamodel> getRegisteredMetamodels() {
		List<IRegisteredMetamodel> metamodels = new ArrayList<IRegisteredMetamodel>();
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(
				ExtensionIds.METAMODEL_EXTENSION_ID);

		// Read configuration elements for the current extension
		for(int j = 0; j < configElements.length; j++) {
			IRegisteredMetamodel proxy = parseMetamodelExtension(configElements[j], metamodels.size());

			if(proxy != null) {
				metamodels.add(proxy);
			}
		} // end of configElements loop
		// // Default elements : UML, Ecore metamodels
		// RegisteredMetamodel UMLMetamodel
		// = new RegisteredMetamodel("uml", URI.createURI(UMLResource.UML_METAMODEL_URI));
		// metamodels.add(UMLMetamodel);
		// RegisteredMetamodel EcoreMetamodel
		// = new RegisteredMetamodel("ecore", URI.createURI(UMLResource.ECORE_METAMODEL_URI));
		// metamodels.add(EcoreMetamodel);

		return metamodels;
	}

	/**
	 * Returns a registered metamodel using its name. If several mdetamodels are found, the first
	 * found is returned
	 * 
	 * @param name
	 *        the name of the metamodel to find
	 * @return the RegisteredMetamodel with given name or <code>null</code> if no metamodel was
	 *         found.
	 */
	public static IRegisteredMetamodel getRegisteredMetamodel(String name) {
		return getRegisteredMetamodel(name, null);
	}

	/**
	 * Returns a registered metamodel using its name and a given path. If several metamodels are
	 * found, the first found is returned.
	 * 
	 * @param name
	 *        the name of the metamodel to find
	 * @param path
	 *        the path of the metamodel file
	 * @return the RegisteredMetamodel with given name or <code>null</code> if no metamodel was
	 *         found.
	 */
	public static IRegisteredMetamodel getRegisteredMetamodel(String name, String path) {
		Assert.isNotNull(name);
		IRegisteredMetamodel[] metamodels = getRegisteredMetamodels().toArray(new IRegisteredMetamodel[0]);
		for(int i = 0; i < metamodels.length; i++) {
			IRegisteredMetamodel metamodel = metamodels[i];

			// name corresponds. is path equal?
			if(name.equals(metamodel.getName())) {
				// no path indicated => first name that corresponds => profile returned
				if(path == null) {
					return metamodel;
				} else if(path.equals(metamodel.getPath())) {
					return metamodel;
				}
			}
		}
		return null;
	}

	/**
	 * Retrieve all information from the configuration element
	 * 
	 * @param ordinal
	 *        index in the set of registered profiles
	 * @param configElt
	 *        the configuration element from which to retrieve the registered profile
	 * @return the registered profile
	 */
	private static IRegisteredMetamodel parseMetamodelExtension(IConfigurationElement configElt, int ordinal) {
		if(!TAG_METAMODEL.equals(configElt.getName())) {
			return null;
		}
		try {
			return new RegisteredMetamodel(configElt, ordinal);
		} catch (Exception e) {
			String name = configElt.getAttribute(ExtensionIds.ATT_NAME);
			if(name == null) {
				name = "[missing name attribute]";
			}
			String msg = "Failed to load metamodel named " + name + " in "
					+ configElt.getDeclaringExtension().getExtensionPointUniqueIdentifier();
			Activator.log(msg);
			return null;
		}
	}
}
