/*******************************************************************************
 * Copyright (c) 2008, 2011, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.sysml.examples.wizards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.obeonetwork.dsl.sysml.examples.Activator;

/**
 * This will allow the user to unzip the sysml alarmradio example module.
 * 
 * @author <a href="mailto:laurent.goubet@obeo.fr">Laurent Goubet</a>
 * @author Frederic Thomas <a
 *         href="mailto:frederic.thomas@obeo.fr">frederic.thomas@obeo.fr</a>
 * @author Axel RICHARD <a
 *         href="mailto:axel.richard@obeo.fr">axel.richard@obeo.fr</a>
 */
public class AlarmRadioExampleWizard extends AbstractExampleWizard {
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.sysml.examples.wizards.AbstractExampleWizard#getProjectDescriptors()
	 */
	@Override
	protected Collection<ProjectDescriptor> getProjectDescriptors() {
		final List<ProjectDescriptor> projects = new ArrayList<ProjectDescriptor>(
				2);

		// Assume the version of OCL is an indication of the Eclipse version
		final String bundleName = "org.obeonetwork.dsl.sysml.examples";
		String baseName = "org.obeonetwork.sysml.alarmradio.example";

		projects.add(new ProjectDescriptor(bundleName,
				"examples/" + baseName + ".zip", baseName)); //$NON-NLS-1$ //$NON-NLS-2$ 
		return projects;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.obeonetwork.dsl.sysml.examples.wizards.AbstractExampleWizard#log(java.lang.Exception)
	 */
	@Override
	protected void log(Exception e) {
		if (e instanceof CoreException) {
			Activator.getDefault().getLog()
					.log(((CoreException) e).getStatus());
		} else {
			Activator
					.getDefault()
					.getLog()
					.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
							IStatus.ERROR, e.getMessage(), e));
		}
	}
}
