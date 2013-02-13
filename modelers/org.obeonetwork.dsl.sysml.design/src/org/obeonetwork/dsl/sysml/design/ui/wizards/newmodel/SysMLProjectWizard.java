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

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.widgets.Display;
import org.obeonetwork.dsl.uml2.design.UMLDesignerPlugin;
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
		try {
			final InitProject runnable = new InitProject(newProjectPage.getProjectName(),
					newProjectPage.getLocationPath(), modelPage.getInitialObjectName());
			getContainer().run(true, false, runnable);
			updatePerspective();
			Display.getDefault().syncExec(new Runnable() {

				public void run() {
					runnable.enableViewpointsAndReveal(UML_STRUCTURAL_VP, UML_BEHAVIORAL_VP, SYSML_VP);
				}
			});
		} catch (InvocationTargetException e) {
			UMLDesignerPlugin.log(IStatus.ERROR, Messages.SysMLModelWizard_UI_Error_CreatingSysMLModel, e);
			return false;
		} catch (InterruptedException e) {
			UMLDesignerPlugin.log(IStatus.ERROR, Messages.SysMLModelWizard_UI_Error_CreatingSysMLModel, e);
			return false;
		}
		return true;

	}
}
