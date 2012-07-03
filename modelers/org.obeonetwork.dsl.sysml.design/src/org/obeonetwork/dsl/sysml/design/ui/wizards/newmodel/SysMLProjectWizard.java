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

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;
import org.eclipse.ui.wizards.newresource.BasicNewResourceWizard;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.obeonetwork.dsl.sysml.design.Activator;
import org.obeonetwork.dsl.uml2.design.UMLDesignerPlugin;
import org.obeonetwork.dsl.uml2.design.ui.wizards.newmodel.UmlModelWizardInitModelPage;

import com.google.common.collect.Maps;

import fr.obeo.dsl.common.tools.api.util.Option;
import fr.obeo.dsl.common.tools.api.util.Options;
import fr.obeo.dsl.viewpoint.business.api.componentization.ViewpointRegistry;
import fr.obeo.dsl.viewpoint.business.api.modelingproject.ModelingProject;
import fr.obeo.dsl.viewpoint.business.api.session.Session;
import fr.obeo.dsl.viewpoint.description.Viewpoint;
import fr.obeo.dsl.viewpoint.ui.business.api.viewpoint.ViewpointSelectionCallback;
import fr.obeo.dsl.viewpoint.ui.tools.api.project.ModelingProjectManager;

/**
 * Sysml project wizard.
 * 
 * @author Melanie Bats <a href="mailto:melanie.bats@obeo.fr">melanie.bats@obeo.fr</a>
 */
public class SysMLProjectWizard extends BasicNewResourceWizard {
	/**
	 * Dot constant.
	 */
	public static final String DOT = ".";

	/**
	 * The UML file extension.
	 */
	public static final String MODEL_FILE_EXTENSION = "uml"; //$NON-NLS-1$

	/**
	 * The model page.
	 */
	private UmlModelWizardInitModelPage modelPage;

	/**
	 * The new project page.
	 */
	private WizardNewProjectCreationPage newProjectPage;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addPages() {
		super.addPages();

		newProjectPage = new WizardNewProjectCreationPage("Project"); //$NON-NLS-1$
		newProjectPage.setInitialProjectName("");
		newProjectPage.setTitle("Create a SysML Modeling project");
		newProjectPage.setDescription("Enter a project name"); //$NON-NLS-1$
		addPage(newProjectPage);

		modelPage = new UmlModelWizardInitModelPage(Messages.SysMLModelWizard_UI_InitModelPageId);
		modelPage.setTitle(Messages.SysMLModelWizard_UI_InitModelPageTitle);
		modelPage.setDescription(Messages.SysMLModelWizard_UI_InitModelPageDescription);
		addPage(modelPage);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean performFinish() {
		try {
			getContainer().run(
					true,
					false,
					new InitProject(newProjectPage.getProjectName(), newProjectPage.getLocationPath(),
							modelPage.getInitialObjectName()));
		} catch (InvocationTargetException e) {
			Activator.log(IStatus.ERROR, Messages.SysMLModelWizard_UI_Error_CreatingSysMLModel, e);
			return false;
		} catch (InterruptedException e) {
			Activator.log(IStatus.ERROR, Messages.SysMLModelWizard_UI_Error_CreatingSysMLModel, e);
			return false;
		}
		return true;
	}

	/**
	 * Init Project.
	 * 
	 * @author Melanie Bats <a href="mailto:melanie.bats@obeo.fr">melanie.bats@obeo.fr</a>
	 */
	class InitProject extends WorkspaceModifyOperation {

		/**
		 * Project name.
		 */
		private String projectName;

		/**
		 * Project location path.
		 */
		private IPath locationPath;

		/**
		 * Semantic root element initial name.
		 */
		private String initialObjectName;

		/**
		 * Constructor.
		 * 
		 * @param projectName
		 *            Project name
		 * @param locationPath
		 *            Project location path
		 * @param initialObjectName
		 *            Semantic root element initial name
		 */
		public InitProject(String projectName, IPath locationPath, String initialObjectName) {
			this.projectName = projectName;
			this.locationPath = locationPath;
			this.initialObjectName = initialObjectName;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException,
				InterruptedException {
			final IProject project = ModelingProjectManager.INSTANCE.createNewModelingProject(projectName,
					locationPath, true);
			final Option<IFile> optionalNewfile = createSemanticResource(project);
			if (optionalNewfile.some() && optionalNewfile.get().exists()) {
				selectAndReveal(optionalNewfile.get());
			} else {
				selectAndReveal(project);
			}
		}

		/**
		 * Create the semantic resource.
		 * 
		 * @param project
		 *            Project
		 * @return Semantic resource
		 */
		private Option<IFile> createSemanticResource(final IProject project) {
			final Session session;
			final Option<ModelingProject> modelingProject = ModelingProject.asModelingProject(project);
			if (modelingProject.some()) {
				session = modelingProject.get().getSession();
			} else {
				session = null;
			}
			if (session == null) {
				return Options.newNone();
			}

			final String platformPath = '/' + project.getName() + '/' + initialObjectName.toLowerCase() + DOT
					+ MODEL_FILE_EXTENSION;
			session.getTransactionalEditingDomain().getCommandStack()
					.execute(new RecordingCommand(session.getTransactionalEditingDomain()) {
						@Override
						protected void doExecute() {
							final URI semanticModelURI = URI.createPlatformResourceURI(platformPath, true);
							final Resource res = new ResourceSetImpl().createResource(semanticModelURI);
							// Add the initial model object to the contents.
							final EObject rootObject = createInitialModel(initialObjectName);

							if (rootObject != null) {
								res.getContents().add(rootObject);
							}
							try {
								res.save(Maps.newHashMap());
							} catch (IOException e) {
								UMLDesignerPlugin.log(IStatus.ERROR,
										Messages.SysMLModelWizard_UI_Error_CreatingSysMLModel, e);
							}

							session.addSemanticResource(semanticModelURI, true);
							final ViewpointSelectionCallback callback = new ViewpointSelectionCallback();

							for (Viewpoint vp : ViewpointRegistry.getInstance().getViewpoints()) {
								if ("UML Structural Modeling".equals(vp.getName())) {
									callback.selectViewpoint(vp, session);
								} else if ("UML Behavioral Modeling".equals(vp.getName())) {
									callback.selectViewpoint(vp, session);
								} else if ("SysML".equals(vp.getName())) {
									callback.selectViewpoint(vp, session);
								}
							}
							session.save();
						}
					});
			return Options.newSome(ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(platformPath)));
		}

		/**
		 * Creates the semantic root element from the given operation arguments.
		 * 
		 * @param initialObjectName2
		 *            Name of initial root element
		 * @return the semantic root {@link EObject}
		 */
		private EObject createInitialModel(String initialObjectName2) {
			final EClassifier found = UMLPackage.eINSTANCE.getEClassifier(initialObjectName2);
			if (found instanceof EClass) {
				return UMLFactory.eINSTANCE.create((EClass)found);
			} else {
				return UMLFactory.eINSTANCE.createModel();
			}
		}
	}
}
