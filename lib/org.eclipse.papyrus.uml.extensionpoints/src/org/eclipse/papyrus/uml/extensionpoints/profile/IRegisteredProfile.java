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
package org.eclipse.papyrus.uml.extensionpoints.profile;

import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.uml.extensionpoints.IRegisteredItem;

public interface IRegisteredProfile extends IRegisteredItem {
	String getQualifiedNames();
}
