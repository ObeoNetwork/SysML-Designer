/*******************************************************************************
 * Copyright (c) 2009, 2011, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.sysml.design.services;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.uml2.uml.Port;

/**
 * Port services.
 * 
 * @author Axel Richard <a href="mailto:axel.richard@obeo.fr">axel.richard@obeo.fr</a>
 */
public class PortServices {

	/**
	 * Tests if the port can me connected from their direction, their types and their location. The direction
	 * must not be equal.
	 * 
	 * @param source
	 *            the source port
	 * @param target
	 *            the target port
	 * @return true if the type are equals and the directions are opposite
	 */
	public boolean isDualWith(Port source, Port target) {
		System.out.println(source.getName() + "->" + target.getName());
		return isConnectableWith(source, target, true);
	}

	/**
	 * Tests if the port can me connected from their direction, their types and their location. The direction
	 * must be equal.
	 * 
	 * @param source
	 *            the source port
	 * @param target
	 *            the target port
	 * @return true if the type are equals and the directions equivalent
	 */
	public boolean isDelegationOf(Port source, Port target) {
		return isConnectableWith(source, target, false);
	}

	/**
	 * Tests if the port can me connected from their direction and types.
	 * 
	 * @param source
	 *            the source port
	 * @param target
	 *            the target port
	 * @param isOppositeDirection
	 *            test the opposite direction if true, the same direction otherwise
	 * @return true if the type are equals and the directions allowed
	 */
	public boolean isConnectableWith(Port source, Port target, boolean isOppositeDirection) {
		if (source == target)
			return false;

		boolean result = false;

		if (source.getType() == null && target.getType() == null) {
			result = true;
		} else {
			result = EcoreUtil.equals(source.getType(), target.getType());
		}

		if (result) {
			final FlowPort sourcePort = getFlowPortApplication(source);
			final FlowPort targetPort = getFlowPortApplication(target);

			if (sourcePort == null && targetPort == null)
				return true;

			if (sourcePort != null && targetPort != null) {
				if (isOppositeDirection) {
					return sourcePort.getDirection() != targetPort.getDirection();
				}
				return sourcePort.getDirection() == targetPort.getDirection();
			}
		}
		return false;

	}

	/**
	 * Return the first flow port stereotype application.
	 * 
	 * @param port
	 *            the port
	 * @return the flowport application or null if any.
	 */
	private FlowPort getFlowPortApplication(Port port) {
		for (EObject application : port.getStereotypeApplications()) {
			if (application instanceof FlowPort) {
				return (FlowPort)application;
			}
		}
		return null;
	}
}
