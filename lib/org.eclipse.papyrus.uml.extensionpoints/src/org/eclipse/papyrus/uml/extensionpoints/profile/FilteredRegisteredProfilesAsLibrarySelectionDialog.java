/*******************************************************************************
 * Copyright (c) 2000, 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.uml.extensionpoints.profile;

import java.util.Collection;

import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.papyrus.uml.extensionpoints.Activator;
import org.eclipse.papyrus.uml.extensionpoints.standard.FilteredRegisteredElementsSelectionDialog;
import org.eclipse.swt.widgets.Shell;

/**
 * Shows a list of registered libraries to the user with a text entry field for a string pattern
 * used to filter the list of resources.
 * 
 * @since 1.9.0
 */
public class FilteredRegisteredProfilesAsLibrarySelectionDialog extends FilteredRegisteredElementsSelectionDialog {

	/** ID for this dialog preferences section */
	protected static final String DIALOG_SETTINGS = Activator.PLUGIN_ID + "dialogs.registeredprofilesaslibraries";

	/**
	 * Creates a new instance of the class
	 * 
	 * @param shell
	 *        the parent shell
	 * @param multi
	 *        the multiple selection flag
	 * @param input
	 *        the input in which selection is done
	 * @param alreadySelected
	 *        list of already selected items
	 */
	public FilteredRegisteredProfilesAsLibrarySelectionDialog(Shell shell, boolean multi, Object[] input, Collection alreadySelected) {
		super(shell, multi, input, alreadySelected, "Profiles to import: ", "Profiles already imported: ");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IDialogSettings getDialogSettings() {
		IDialogSettings settings = Activator.getDefault().getDialogSettings().getSection(DIALOG_SETTINGS);
		if(settings == null) {
			settings = Activator.getDefault().getDialogSettings().addNewSection(DIALOG_SETTINGS);
		}
		return settings;
	}
}
