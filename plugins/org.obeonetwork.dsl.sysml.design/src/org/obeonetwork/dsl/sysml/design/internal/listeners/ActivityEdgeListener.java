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

import java.util.Iterator;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ActivityNode;
import org.obeonetwork.dsl.sysml.design.api.services.ActivityDiagramServices;
import org.obeonetwork.dsl.sysml.design.internal.services.SysmlElementServices;

/**
 * To listen ActivityEdge changes. In SysML if an activityEdgge is created on aDecision node or parametersSet
 * if an edge outgoing from this node is stereotyped as Probability all edge have to be stereotyped as
 * Probability.
 *
 * @author Frederic Bats <a href="mailto:frederic.bats@obeo.fr">frederic.bats@obeo.fr</a>
 */
public class ActivityEdgeListener extends ResourceSetListenerImpl {

	@Override
	public boolean isPrecommitOnly() {
		return true;
	}

	@Override
	public Command transactionAboutToCommit(ResourceSetChangeEvent event) throws RollbackException {

		for (final Iterator<?> iter = event.getNotifications().iterator(); iter.hasNext();) {
			final Notification notification = (Notification)iter.next();
			final Object notifier = notification.getNotifier();

			// An activityEdge is created
			if (notifier instanceof ActivityEdge && Notification.SET == notification.getEventType()) {
				final ActivityEdge activityEdge = (ActivityEdge)notifier;
				final ActivityNode source = activityEdge.getSource();

				boolean isProbability = false;
				if (source != null) {
					for (final ActivityEdge edge : source.getOutgoings()) {
						if (SysmlElementServices.INSTANCE.hasStereotype(edge, "Probability")) { //$NON-NLS-1$
							isProbability = true;
							break;
						}
					}
				}
				if (isProbability) {
					final Session session = SessionManager.INSTANCE.getSession(activityEdge);
					final TransactionalEditingDomain editingDomain = session.getTransactionalEditingDomain();
					return new RecordingCommand(editingDomain) {

						@Override
						protected void doExecute() {
							final ActivityDiagramServices actService = new ActivityDiagramServices();
							actService.setProbabilityStereotype(activityEdge);
						}
					};
				}
			}
		}
		return null;
	}
}
