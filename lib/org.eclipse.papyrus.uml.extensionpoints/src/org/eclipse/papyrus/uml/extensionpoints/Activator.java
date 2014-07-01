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
package org.eclipse.papyrus.uml.extensionpoints;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

/**
 * Main plugin class, in charge of its lifetime circle.
 */
public class Activator extends AbstractUIPlugin {

	/** shared instance of this plugin */
	private static Activator plugin;

	/** ID of the plugin */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.uml.extensionpoints";

	/** Resource Bundle */
	private static final String RESOURCE_NAME = PLUGIN_ID + ".ViewPlugin";

	/** Resource bundle associated to this plugin */
	private ResourceBundle resourceBundle;

	/**
	 * The constructor.
	 */
	public Activator() {
		super();
		plugin = this;
		try {
			resourceBundle = ResourceBundle.getBundle(RESOURCE_NAME);
		} catch (MissingResourceException mre) {
			resourceBundle = null;
		}
	}

	/**
	 * Returns the shared instance.
	 * 
	 * @return the shared instance of this plugin
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns the string from the plugin's resource bundle, or 'key' if not found.
	 * 
	 * @param key
	 *        the key that identifies the resource
	 * @return the string corresponding to the key
	 */
	public static String getResourceString(String key) {
		ResourceBundle bundle = Activator.getDefault().getResourceBundle();
		try {
			return (bundle != null) ? bundle.getString(key) : key;
		} catch (MissingResourceException e) {
			return key;
		}
	}

	/**
	 * Returns the plugin's resource bundle.
	 * 
	 * @return the plugin's resource bundle
	 */
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	/**
	 * Returns an <code>org.eclipse.swt.graphics.Image</code> identified by its key.<BR>
	 * By default, it returns a default image. This image is the image placed in the directory <em>resources/icons/default.gif</em>
	 * 
	 * @param key
	 *        the key of the image
	 * @return the Image
	 */
	public static Image getImage(String key) {
		ImageRegistry registry = getDefault().getImageRegistry();
		Image image = registry.get(key);
		if(image == null) {
			ImageDescriptor desc = AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, key);
			registry.put(key, desc);
			image = registry.get(key);
		}
		return image;
	}

	/**
	 * Returns an <code>org.eclipse.swt.graphics.Image</code> identified by its key and its owning
	 * plugin.<BR>
	 * 
	 * @param pluginID
	 *        the plugin id where to retrieve the image
	 * @param key
	 *        the key of the image
	 * @return the Image
	 */
	public static Image getImage(String pluginID, String key) {
		ImageRegistry registry = getDefault().getImageRegistry();
		Image image = registry.get(key);
		if(image == null) {
			ImageDescriptor desc = AbstractUIPlugin.imageDescriptorFromPlugin(pluginID, key);
			registry.put(key, desc);
			image = registry.get(key);
		}
		return image;
	}

	/**
	 * Log a message and an exception in the plugin's log.
	 * 
	 * @param message
	 *        the message to log
	 * @param e
	 *        the exception to log
	 */
	public static void log(String message, Exception e) {
		getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.OK, message, e));
	}

	/**
	 * Log a message in the plugin's log.
	 * 
	 * @param message
	 *        the message to log
	 */
	public static void log(String message) {
		getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.OK, message, null));
	}

	/**
	 * Log a message in the plugin's log.
	 * 
	 * @param message
	 *        the message to log
	 */
	public static void log(Exception e) {
		getDefault().getLog().log(
			new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.OK, e.getLocalizedMessage(), e));
	}

	/**
	 * Log a message in the plugin's log.
	 * 
	 * @param message
	 *        the message to log
	 */
	public static void debug(String message) {
		getDefault().getLog().log(new Status(IStatus.INFO, Activator.PLUGIN_ID, IStatus.OK, message, null));
	}
}
