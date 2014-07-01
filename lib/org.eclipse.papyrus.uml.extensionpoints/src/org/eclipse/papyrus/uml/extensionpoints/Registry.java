/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dr. David H. Akehurst - enable programmatic registration
 *****************************************************************************/
package org.eclipse.papyrus.uml.extensionpoints;

import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.papyrus.uml.extensionpoints.library.IRegisteredLibrary;
import org.eclipse.papyrus.uml.extensionpoints.library.RegisteredLibrary;
import org.eclipse.papyrus.uml.extensionpoints.metamodel.IRegisteredMetamodel;
import org.eclipse.papyrus.uml.extensionpoints.metamodel.RegisteredMetamodel;
import org.eclipse.papyrus.uml.extensionpoints.profile.IRegisteredProfile;
import org.eclipse.papyrus.uml.extensionpoints.profile.RegisteredProfile;

public class Registry {
	
	/** attribute that acts as a cache for the list of registered libraries */
	private static List<IRegisteredLibrary> registeredLibraries;
	
	public static List<IRegisteredLibrary> getRegisteredLibraries() {
		if(null == registeredLibraries) {
			registeredLibraries = RegisteredLibrary.getRegisteredLibraries();
		}
		return registeredLibraries;
	}
	
	public static void addRegisteredLibrary(IRegisteredLibrary lib) {
		if(null == registeredLibraries) {
			registeredLibraries = RegisteredLibrary.getRegisteredLibraries();
		}
		registeredLibraries.add(lib);
	}
	
	/** attribute that acts as a cache for the list of registered metamodels */
	private static List<IRegisteredMetamodel> registeredMetamodels;
	
	public static List<IRegisteredMetamodel> getRegisteredMetamodels() {
		if(null == registeredMetamodels) {
			registeredMetamodels = RegisteredMetamodel.getRegisteredMetamodels();
		}
		return registeredMetamodels;
	}
	
	public static void addRegisteredMetamodel(IRegisteredMetamodel lib) {
		if(null == registeredMetamodels) {
			registeredMetamodels = RegisteredMetamodel.getRegisteredMetamodels();
		}
		registeredMetamodels.add(lib);
	}	
	
	/** attribute that acts as a cache for the list of registered profiles */
	private static List<IRegisteredProfile> registeredProfiles;
	
	public static List<IRegisteredProfile> getRegisteredProfiles() {
		if(null == registeredProfiles) {
			registeredProfiles = RegisteredProfile.getRegisteredProfiles();
		}
		return registeredProfiles;
	}
	public static IRegisteredProfile getRegisteredProfile(String name, String path) {
		Assert.isNotNull(name);
		List<IRegisteredProfile> profiles = Registry.getRegisteredProfiles();
		for(int i = 0; i < profiles.size(); i++) {
			IRegisteredProfile profile = profiles.get(i);

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
	public static void addRegisteredProfile(IRegisteredProfile lib) {
		if(null == registeredProfiles) {
			registeredProfiles = RegisteredProfile.getRegisteredProfiles();
		}
		registeredProfiles.add(lib);
	}	
}
