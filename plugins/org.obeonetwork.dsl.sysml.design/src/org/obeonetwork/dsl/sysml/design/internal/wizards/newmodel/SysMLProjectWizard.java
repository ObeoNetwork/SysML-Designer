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
package org.obeonetwork.dsl.sysml.design.internal.wizards.newmodel;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.business.api.modelingproject.ModelingProject;
import org.eclipse.sirius.business.api.session.Session;
import org.eclipse.sirius.ext.base.Option;
import org.eclipse.sirius.ui.business.api.viewpoint.ViewpointSelectionCallback;
import org.eclipse.sirius.ui.tools.api.project.ModelingProjectManager;
import org.eclipse.sirius.viewpoint.description.Viewpoint;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.obeonetwork.dsl.sysml.design.SysMLDesignerPlugin;
import org.obeonetwork.dsl.sysml.design.internal.wizards.Messages;
import org.obeonetwork.dsl.uml2.design.api.wizards.UmlProjectUtils;
import org.obeonetwork.dsl.uml2.design.internal.wizards.newmodel.AbstractNewUmlModelWizard;

/**
 * Sysml project wizard.
 *
 * @author Melanie Bats <a href="mailto:melanie.bats@obeo.fr">melanie.bats@obeo.fr</a>
 */
public class SysMLProjectWizard extends AbstractNewUmlModelWizard {
	protected SysmlModelWizardInitModelPage modelPage;

	protected WizardNewProjectCreationPage newProjectPage;

	@Override
	public void addPages() {
		// we're not calling the super as we want to control the project
		// creation, we don't want the default
		// page.
		// super.addPages();

		newProjectPage = new WizardNewProjectCreationPage("Project"); //$NON-NLS-1$
		newProjectPage.setInitialProjectName(""); //$NON-NLS-1$
		newProjectPage.setTitle("Create a SysML Modeling project"); //$NON-NLS-1$
		newProjectPage.setDescription("Enter a project name"); //$NON-NLS-1$
		addPage(newProjectPage);

		modelPage = new SysmlModelWizardInitModelPage(Messages.SysMLModelWizard_UI_InitModelPageId);
		modelPage.setTitle(Messages.SysMLModelWizard_UI_InitModelPageTitle);
		modelPage.setDescription(Messages.SysMLModelWizard_UI_InitModelPageDescription);
		addPage(modelPage);
	}

	@Override
	public boolean performFinish() {
		try {
			project = ModelingProjectManager.INSTANCE.createNewModelingProject(
					newProjectPage.getProjectName(), newProjectPage.getLocationPath(), true,
					new NullProgressMonitor());
			rootObjectName = modelPage.getInitialObjectName();
			newUmlModelFileName = modelPage.getInitialObjectName().toLowerCase() + UmlProjectUtils.DOT
					+ UmlProjectUtils.MODEL_FILE_EXTENSION;

			super.performFinish();
			Display.getDefault().syncExec(new Runnable() {

				public void run() {
					// Create default empty UML model
					org.obeonetwork.dsl.uml2.design.api.wizards.UmlProjectUtils
							.createSemanticResource(project, rootObjectName, newUmlModelFileName);

					// Enable UML viewpoints
					final Option<ModelingProject> created = ModelingProject.asModelingProject(project);
					if (created.some()) {
						final Session session = created.get().getSession();
						if (session != null) {
							session.getTransactionalEditingDomain().getCommandStack()

									.execute(new RecordingCommand(session.getTransactionalEditingDomain()) {
								@Override
								protected void doExecute() {
									final ViewpointSelectionCallback selection = new ViewpointSelectionCallback();
									for (final Viewpoint previouslySelected : session
											.getSelectedViewpoints(false)) {
										selection.deselectViewpoint(previouslySelected, session,
												new NullProgressMonitor());
									}
									selection.selectViewpoint(
											ViewpointRegistry.getInstance().getViewpoint(URI.createURI(
													"viewpoint:/org.obeonetwork.dsl.sysml.design/SysML")), //$NON-NLS-1$
											session, new NullProgressMonitor());
								}
							});
						}
					}
				}
			});
		} catch (final CoreException e) {
			SysMLDesignerPlugin.log(IStatus.ERROR, Messages.SysMLModelWizard_UI_Error_CreatingSysMLModel, e);
			return false;
		}

		return true;
	}
}
