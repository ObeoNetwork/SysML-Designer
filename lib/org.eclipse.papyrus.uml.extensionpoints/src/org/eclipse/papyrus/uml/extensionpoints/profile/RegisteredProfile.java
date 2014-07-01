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
package org.eclipse.papyrus.uml.extensionpoints.profile;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.uml.extensionpoints.Activator;
import org.eclipse.papyrus.uml.extensionpoints.Registry;
import org.eclipse.papyrus.uml.extensionpoints.standard.ExtensionIds;
import org.eclipse.papyrus.uml.extensionpoints.standard.RegisteredElementExtensionPoint;
import org.eclipse.swt.graphics.Image;

/**
 * Class that manages registered profile extension point
 */
public class RegisteredProfile extends RegisteredElementExtensionPoint implements IRegisteredProfile {

	/** name of the extension point (main element name) in the DTD */
	private static final String TAG_PROFILE = "profile";

	/** name of the <code>qualified name</code>attribute in the DTD */
	private static final String ATT_QUALIFIED_NAMES = "qualifiednames";

	/**
	 * Creates a new RegisteredProfile.
	 * 
	 * @param configElt
	 * @param ordinal
	 */
	public RegisteredProfile(IConfigurationElement configElt, int ordinal) {
		super(configElt, ordinal);
		qualifiednames = getAttribute(configElt, ATT_QUALIFIED_NAMES, "", false);
	}

	public URI getUri() {
		return super.uri;
	}
	
	public String getPath() {
		return super.path;
	}
	
	public String getQualifiedNames() {
		//?should this field really be defined on the superclass? is it not specific to profiles?
		return super.qualifiednames;
	}
	
	// /**
	// * Creates a new RegisteredProfile.
	// * @param name the name displayed to users
	// * @param uri the uri where the profile file can be found
	// */
	// public RegisteredProfile(String _name, URI _uri) {
	// this(_name, _uri, "", "", "", "");
	// }
	//
	// /**
	// * Creates a new RegisteredProfile.
	// * @param _name the name displayed to users
	// * @param _uri the uri where the profile file can be found
	// * @param qualifiedNames the list of sub profiles
	// * @param iconPath plugin relative path to the icon
	// * @param description description of the profile
	// * @param provider provider of the profile
	// */
	// public RegisteredProfile(String _name, URI _uri, String qualifiedNamesList, String iconPath,
	// String description, String provider) {
	// configElement = null;
	// ordinal = -1;
	//		
	// name = _name;
	// path = "undefined";
	// qualifiednames = qualifiedNamesList;
	// qualifiedNamesList = "";
	// this.iconPath = iconPath;
	// this.description = description;
	// this.provider = provider;
	//		
	// uri = _uri;
	// }

	/**
	 * Returns a registered profile using its name. If several profiles are found, the first found
	 * is returned
	 * 
	 * @param name
	 *        the name of the profile to find
	 * @return the RegistredProfile with given name or <code>null</code> if no profile was found.
	 */
	public static IRegisteredProfile getRegisteredProfile(String name) {
		return getRegisteredProfile(name, null);
	}

	/**
	 * Returns a registered profile using its name and a given path. If several profiles are found,
	 * the first found is returned.
	 * 
	 * @param name
	 *        the name of the profile to find
	 * @param path
	 *        the path of the profile file
	 * @return the RegistredProfile with given name or <code>null</code> if no profile was found.
	 */
	public static IRegisteredProfile getRegisteredProfile(String name, String path) {
		Assert.isNotNull(name);
		IRegisteredProfile[] profiles = Registry.getRegisteredProfiles().toArray(new IRegisteredProfile[0]);
		for(int i = 0; i < profiles.length; i++) {
			IRegisteredProfile profile = profiles[i];

			// name corresponds. is path equal?
			if(name.equals(profile.getName())) {
				// no path indicated => first name that corresponds => profile returned
				if(path == null) {
					return profile;
				} else if(path.equals(profile.getPath())) {
					return profile;
				}
			}
		}
		return null;
	}

	/**
	 * Returns the list of registred profiles in the platform, using the papyrus extension point.
	 * 
	 * @return the list of registred profiles in the platform
	 */
	public static List<IRegisteredProfile> getRegisteredProfiles() {

		// the list has not been already built. Creates a new one and fill it.
		List<IRegisteredProfile> profiles = new ArrayList<IRegisteredProfile>();

		// // At least two element : Standard uml profile and Ecore uml profile
		// RegisteredProfile UmlStdProfile = new RegisteredProfile("Standard",
		// URI.createURI(UMLResource.STANDARD_PROFILE_URI), "", "icons/uml.gif",
		// "UML Standard Profile", "Eclipse.org");
		// profiles.add(UmlStdProfile);
		// RegisteredProfile UmlEcoreProfile
		// = new RegisteredProfile("Ecore", URI.createURI(UMLResource.ECORE_PROFILE_URI), "",
		// "icons/ecore.gif", "Ecore Profile", "Eclipse.org");
		// profiles.add(UmlEcoreProfile);

		// Reading data from plugins
		IConfigurationElement[] configElements = Platform.getExtensionRegistry().getConfigurationElementsFor(
				ExtensionIds.PROFILE_EXTENSION_ID);

		// Read configuration elements for the current extension
		for(int j = 0; j < configElements.length; j++) {
			IRegisteredProfile proxy = parseProfileExtension(configElements[j], profiles.size());

			if(proxy != null) {
				profiles.add(proxy);
			}
		} // end of configElements loop

		return profiles;
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
	private static IRegisteredProfile parseProfileExtension(IConfigurationElement configElt, int ordinal) {
		if(!TAG_PROFILE.equals(configElt.getName())) {
			return null;
		}
		try {
			return new RegisteredProfile(configElt, ordinal);
		} catch (Exception e) {
			String name = configElt.getAttribute(ExtensionIds.ATT_NAME);
			if(name == null) {
				name = "[missing name attribute]";
			}
			String msg = "Failed to load profile named " + name + " in "
					+ configElt.getDeclaringExtension().getExtensionPointUniqueIdentifier();
			Activator.log(msg);
			return null;
		}
	}
}
