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
package org.obeonetwork.dsl.sysml.design.internal.listeners;

import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManagerListener;
import org.eclipse.sirius.viewpoint.description.Viewpoint;

/**
 * Session listener.
 *
 * @author Frederic Bats <a href="mailto:frederic.bats@obeo.fr">frederic.bats@obeo.fr</a>
 */
public class SysMLSessionManagerListener implements SessionManagerListener {

	private final ActivityEdgeListener activityEdgeListener = new ActivityEdgeListener();

	public void notify(Session updated, int notification) {
		// Nothing
	}

	public void notifyAddSession(Session newSession) {
		newSession.getTransactionalEditingDomain().addResourceSetListener(activityEdgeListener);

	}

	public void notifyRemoveSession(Session removedSession) {
		removedSession.getTransactionalEditingDomain().removeResourceSetListener(activityEdgeListener);
	}

	public void viewpointDeselected(Viewpoint deselectedSirius) {
		// Nothing
	}

	public void viewpointSelected(Viewpoint selectedSirius) {
		// Nothing
	}
}
