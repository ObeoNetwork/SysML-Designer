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

import org.eclipse.jface.viewers.LabelProvider;

/**
 * 
 */
public class ExtensionLabelProvider extends LabelProvider {

	/**
	 * 
	 * 
	 * @param obj
	 * 
	 * @return
	 */
	@Override
	public String getText(Object obj) {

		if(obj instanceof RegisteredElementExtensionPoint) {
			return ((RegisteredElementExtensionPoint)obj).name;
		} else {
			return "unknown object";
		}
	}
}
