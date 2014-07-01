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
package org.eclipse.papyrus.uml.extensionpoints.library;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.uml.extensionpoints.Activator;
import org.eclipse.papyrus.uml.extensionpoints.standard.ExtensionIds;
import org.eclipse.papyrus.uml.extensionpoints.standard.RegisteredElementExtensionPoint;

/**
 * Class that manages registered library extension point
 */
public class RegisteredLibrary extends RegisteredElementExtensionPoint implements IRegisteredLibrary {

	/** name of the extension point (main element name) in the DTD */
	private static final String TAG_LIBRARY = "library";

	/**
	 * Main constructor.
	 * 
	 * @param configElt
	 *        the configuration element that defines the given library
	 * @param ordinal
	 *        the place in the list of registered libraries
	 */
	public RegisteredLibrary(IConfigurationElement configElt, int ordinal) {
		super(configElt, ordinal);
	}

	public URI getUri() {
		return super.uri;
	}
	
	public String getPath() {
		return super.path;
	}
	
	/**
	 * Returns the list of registered libraries in the platform, using the Papyrus extension point.
	 * 
	 * @return the list of registered libraries in the platform
	 */
	public static List<IRegisteredLibrary> getRegisteredLibraries() {

		List<IRegisteredLibrary> libraries = new ArrayList<IRegisteredLibrary>();

		// // Default elements : UML, Ecore, Java, XML PrimitiveTypes model library
		// RegisteredLibrary UmlPrimitiveTypes
		// = new RegisteredLibrary("UMLPrimitiveTypes",
		// URI.createURI(UMLResource.UML_PRIMITIVE_TYPES_LIBRARY_URI));
		// libraries.add(UmlPrimitiveTypes);
		// RegisteredLibrary EcorePrimitiveTypes
		// = new RegisteredLibrary("EcorePrimitiveTypes",
		// URI.createURI(UMLResource.ECORE_PRIMITIVE_TYPES_LIBRARY_URI));
		// libraries.add(EcorePrimitiveTypes);
		// RegisteredLibrary JavaPrimitiveTypes
		// = new RegisteredLibrary("JavaPrimitiveTypes",
		// URI.createURI(UMLResource.JAVA_PRIMITIVE_TYPES_LIBRARY_URI));
		// libraries.add(JavaPrimitiveTypes);
		// RegisteredLibrary XMLPrimitiveTypes
		// = new RegisteredLibrary("XMLPrimitiveTypes",
		// URI.createURI(UMLResource.XML_PRIMITIVE_TYPES_LIBRARY_URI));
		// libraries.add(XMLPrimitiveTypes);

		// Look for the rest in plugins
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(
				ExtensionIds.LIBRARY_EXTENSION_ID);

		// Read configuration elements for the current extension
		for(int j = 0; j < configElements.length; j++) {
			IRegisteredLibrary proxy = parseLibraryExtension(configElements[j], libraries.size());

			if(proxy != null) {
				libraries.add(proxy);
			}
		} // end of configElements loop

		return libraries;
	}

	/**
	 * Parse data from extensions.
	 * 
	 * @param ordinal
	 * @param configElt
	 * @return
	 */
	private static IRegisteredLibrary parseLibraryExtension(IConfigurationElement configElt, int ordinal) {
		if(!TAG_LIBRARY.equals(configElt.getName())) {
			return null;
		}
		try {
			return new RegisteredLibrary(configElt, ordinal);
		} catch (Exception e) {

			String name = configElt.getAttribute(ExtensionIds.ATT_NAME);
			if(name == null) {
				name = "[missing name attribute]";
			}
			String msg = "Failed to load library named " + name + " in "
					+ configElt.getDeclaringExtension().getExtensionPointUniqueIdentifier();
			Activator.log(msg);
			return null;
		}
	}
}
