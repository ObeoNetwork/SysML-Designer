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
package org.eclipse.papyrus.uml.extensionpoints.standard;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.uml.extensionpoints.Activator;
import org.eclipse.swt.graphics.Image;

/**
 * Abstract Class that introduces the basic functionalities for Papyrus UML2 extension points
 */
public abstract class RegisteredElementExtensionPoint {

	/** Name of the registered element */
	public String name;

	/** path of the file that implements the registered element */
	public String path;

	/** URI to the extension file */
	public URI uri;

	/** concatened String that contains the different qualified names of sub-profiles to be applied */
	public String qualifiednames;

	/** the value of the description attribute */
	protected String description;

	/** the value of the icon path attribute */
	protected String iconPath;

	/** the value of the provider attribute */
	protected String provider;

	/** configuration element for this extension point */
	public final IConfigurationElement configElement;

	/** index of the registered profile */
	public final int ordinal;

	/**
	 * Creates a new AbstractExtensionPoint.
	 *
	 * @param configElt
	 *        the configuration element for the extension point
	 * @param ordinal
	 *        the place of the extension point in the list of registered elements
	 */
	public RegisteredElementExtensionPoint(IConfigurationElement configElt, int ordinal) {
		this.configElement = configElt;
		this.ordinal = ordinal;

		name = getAttribute(configElt, ExtensionIds.ATT_NAME, "undefined", true);
		path = getAttribute(configElt, ExtensionIds.ATT_PATH, "undefined", true);
		description = getAttribute(configElt, ExtensionIds.ATT_DESCRIPTION, "", false);
		provider = getAttribute(configElt, ExtensionIds.ATT_PROVIDER, "", false);
		iconPath = getAttribute(configElt, ExtensionIds.ATT_ICON_PATH, "", false);

		uri = URI.createURI(path);
	}

	/**
	 * Returns the given value for the specified element
	 *
	 * @param defaultValue
	 *        value given to the property if it is not already set
	 * @param isRequired
	 *        <code>true</code> if the property must be set
	 * @param configElt
	 *        configuration element from which to retrieve property value
	 * @param name
	 *        name of the property
	 * @return the value of the given property, or the specified defaultValue
	 */
	protected static String getAttribute(IConfigurationElement configElt, String name, String defaultValue, boolean isRequired) {
		String value = configElt.getAttribute(name);

		if(value != null) {
			return value;
		} else if(defaultValue != null) {
			return defaultValue;
		}

		if(isRequired) {
			throw new IllegalArgumentException("Missing " + name + " attribute");
		}

		return null;
	}

	/**
	 * Returns the icon associated to the given configuration element
	 *
	 * @return the icon which path is in extension
	 */
	protected Image getImage(String iconPath, IConfigurationElement configElement) {

		// no image associated to this plug-in
		if(iconPath == null || "".equals(iconPath)) { //$NON-NLS-1$
			return null;
		}

		String extensionPluginId = "";
		if(configElement != null) {
			IExtension extension = configElement.getDeclaringExtension();
			extensionPluginId = extension.getContributor().getName();
		} else {
			// assumes that the icon comes from this plugin
			extensionPluginId = Activator.PLUGIN_ID;
		}

		return Activator.getImage(extensionPluginId, iconPath);
	}

	/**
	 * Get the image associated to the registered element
	 *
	 * @return an icon for the transformation or <code>null</code> if no icon is associated to the
	 *         profile
	 */
	public Image getImage() {
		return getImage(iconPath, configElement);
	}

	/**
	 * Returns the name of the extension point
	 *
	 * @return the name of the extension point
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the extension point
	 *
	 * @param name
	 *        the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns the description of the extension point
	 *
	 * @return the description of the extension point
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description of the extension point
	 *
	 * @param description
	 *        the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the provider of the extension point
	 *
	 * @return the provider of the extension point
	 */
	public String getProvider() {
		return provider;
	}

	/**
	 * Sets the provider of the extension point
	 *
	 * @param provider
	 *        the provider to set
	 */
	public void setProvider(String provider) {
		this.provider = provider;
	}
}
