/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Dr. David H. Akehurst - enable programmatic registration
 *******************************************************************************/
package org.eclipse.papyrus.uml.extensionpoints;

import org.eclipse.emf.common.util.URI;
import org.eclipse.swt.graphics.Image;

public interface IRegisteredItem {
	
	/** Name of the registered item */
	String getName();
	
	/** URI to the file that is the registered item */
	URI getUri();
	
	/** Path of the file that implements the registered element */
	String getPath();
	
	/** Identifier for the provider of this item */
	String getProvider();
	
	/** Long description of the registered item */
	String getDescription();
	
	Image getImage();
}
