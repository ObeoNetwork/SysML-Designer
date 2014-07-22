/*******************************************************************************
 * Copyright (c) 2009, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.sysml.design.ui.wizards.newmodel;

import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.ui.business.api.viewpoint.ViewpointSelectionCallback;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.swt.widgets.Display;
import org.obeonetwork.dsl.uml2.design.ui.extension.editor.UmlViewpoints;
import org.obeonetwork.dsl.uml2.design.ui.wizards.newmodel.UMLProjectWizard;

/**
 * Sysml project wizard.
 * 
 * @author Melanie Bats <a href="mailto:melanie.bats@obeo.fr">melanie.bats@obeo.fr</a>
 */
public class SysMLProjectWizard extends UMLProjectWizard {
	/**
	 * SysML viewpoint name defined in odesign.
	 */
	private final String SYSML_VP = "SysML";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addPages() {
		super.addPages();
		newProjectPage.setTitle("Create a SysML Modeling project");
		modelPage.setTitle(Messages.SysMLModelWizard_UI_InitModelPageTitle);
	}

	@Override
	public boolean performFinish() {
		// Call the UML model wizard to create the default UML model and the modeling project
		super.performFinish();
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				final Option<ModelingProject> created = ModelingProject.asModelingProject(project);
				if (created.some()) {
					// Enable SysML viewpoint
					ModelingProject modelingProject = created.get();
					enableSysMLViewpoints(modelingProject.getSession());
				}
			}
		});
		return true;
	}

	public static void enableSysMLViewpoints(final Session session) {
		if (session != null) {
			session.getTransactionalEditingDomain().getCommandStack()
					.execute(new RecordingCommand(session.getTransactionalEditingDomain()) {
						@Override
						protected void doExecute() {
							ViewpointSelectionCallback selection = new ViewpointSelectionCallback();
							for (Viewpoint previouslySelected : session.getSelectedViewpoints(false)) {
								selection.deselectViewpoint(previouslySelected, session,
										new NullProgressMonitor());
							}
							selection.selectViewpoint(UmlViewpoints.fromViewpointRegistry().dashboard(),
									session, new NullProgressMonitor());
							selection.selectViewpoint(UmlViewpoints.fromViewpointRegistry().capture(),
									session, new NullProgressMonitor());
							selection.selectViewpoint(SysmlViewpoints.fromViewpointRegistry().sysml(),
									session, new NullProgressMonitor());
						}
					});
		}
	}
}
