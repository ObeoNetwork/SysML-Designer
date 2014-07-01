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

import org.eclipse.papyrus.uml.extensionpoints.Activator;

/** Interface that stores IDs adn constants for the extension point */
public class ExtensionIds {

	/** ID for the profile extension */
	public static String PROFILE_EXTENSION_ID = Activator.PLUGIN_ID + "." + "UMLProfile";

	/** ID for the library extension point */
	public static String LIBRARY_EXTENSION_ID = Activator.PLUGIN_ID + "." + "UMLLibrary";

	/** ID for the metamodel extension point */
	public static String METAMODEL_EXTENSION_ID = Activator.PLUGIN_ID + "." + "UMLMetamodel";

	/** name of the <code>name</code> attribute in the DTD */
	public final static String ATT_NAME = "name";

	/** name of the <code>path</code> attribute in the DTD */
	public final static String ATT_PATH = "path";

	/** name of the <code>icon</code> attribute in the DTD */
	public final static String ATT_ICON_PATH = "iconpath";

	/** name of the <code>description</code> attribute in the DTD */
	public final static String ATT_DESCRIPTION = "description";

	/** name of the <code>provider</code>attribute in the DTD */
	public final static String ATT_PROVIDER = "provider";
}
