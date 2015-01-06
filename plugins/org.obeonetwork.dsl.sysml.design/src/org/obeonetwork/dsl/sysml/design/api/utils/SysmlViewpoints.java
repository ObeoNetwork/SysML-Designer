/*******************************************************************************
 * Copyright (c) 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.sysml.design.api.utils;

import org.eclipse.emf.common.util.URI;
import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.viewpoint.description.Viewpoint;

public class SysmlViewpoints {

	private ViewpointRegistry registry;

	public SysmlViewpoints(ViewpointRegistry registry) {
		this.registry = registry;
	}

	public Viewpoint sysml() {
		return registry.getViewpoint(URI.createURI("viewpoint:/org.obeonetwork.dsl.sysml.design/SysML"));
	}

	public static SysmlViewpoints fromViewpointRegistry() {
		return new SysmlViewpoints(ViewpointRegistry.getInstance());
	}
}
