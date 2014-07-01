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
package org.eclipse.papyrus.uml.extensionpoints.standard;

import java.util.Collection;
import java.util.Comparator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.papyrus.uml.extensionpoints.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;

/**
 * Shows a list of registered elements to the user with a text entry field for a string pattern used
 * to filter the list of resources.
 * 
 * @since 1.9.0
 */
public class FilteredRegisteredElementsSelectionDialog extends FilteredItemsSelectionDialog {

	/** ID for this dialog preferences section */
	protected static final String DIALOG_SETTINGS = Activator.PLUGIN_ID + "dialogs.registeredelement";

	/** label provider for the table viewer */
	private RegisteredElementsLabelProvider registeredElementsLabelProvider;

	/** label viewer for the details view */
	private RegisteredElementsDetailsLabelProvider registeredElementsDetailsLabelProvider;

	/** all elements that can be selected by the dialog */
	Object[] totalInput;

	/** elements already selected */
	Collection<Object> alreadySelected;

	/** list that displays already selected elements */
	private TableViewer selectedElementList;

	/** Content provider for selected element list */
	private ArrayContentProvider contentProvider;

	/** title of the extended area */
	protected String extendedAreaTitle;

	/**
	 * Creates a new instance of the class
	 * 
	 * @param shell
	 *        the parent shell
	 * @param multi
	 *        the multiple selection flag
	 * @param input
	 *        the input in which selection is done
	 */
	public FilteredRegisteredElementsSelectionDialog(Shell shell, boolean multi, Object[] input, Collection<Object> alreadySelected, String title, String extendedAreaTitle) {
		super(shell, multi);
		setTitle(title);
		setInitialPattern("**");
		this.totalInput = input;
		this.extendedAreaTitle = extendedAreaTitle;
		this.alreadySelected = alreadySelected;
		registeredElementsLabelProvider = new RegisteredElementsLabelProvider();
		registeredElementsDetailsLabelProvider = new RegisteredElementsDetailsLabelProvider();
		setListLabelProvider(registeredElementsLabelProvider);
		setDetailsLabelProvider(registeredElementsDetailsLabelProvider);

		contentProvider = new ArrayContentProvider();
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Control createExtendedContentArea(Composite parent) {
		Composite content = new Composite(parent, SWT.NONE);
		GridData gd = new GridData(GridData.FILL_BOTH);
		content.setLayoutData(gd);

		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		content.setLayout(layout);

		// Title of the window
		createExtendedAreaHeader(content);

		// list of already selected elements
		selectedElementList = new TableViewer(content, SWT.BORDER | SWT.V_SCROLL | SWT.VIRTUAL);
		selectedElementList.setContentProvider(contentProvider);
		selectedElementList.setLabelProvider(registeredElementsLabelProvider);
		selectedElementList.setInput(alreadySelected);
		selectedElementList.setItemCount(contentProvider.getElements(alreadySelected).length);
		gd = new GridData(GridData.FILL_BOTH);
		selectedElementList.getTable().setLayoutData(gd);

		return content;
	}

	protected void createExtendedAreaHeader(Composite parent) {
		Composite header = new Composite(parent, SWT.NONE);

		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		layout.marginWidth = 0;
		layout.marginHeight = 0;
		header.setLayout(layout);

		Label label = new Label(header, SWT.NONE);
		label.setText(extendedAreaTitle + " (Read-only table)");
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		label.setLayoutData(gd);

		header.setLayoutData(gd);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getElementName(Object item) {
		return registeredElementsLabelProvider.getText(item);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#validateItem(java.lang.Object)
	 */
	@Override
	protected IStatus validateItem(Object item) {
		return new Status(IStatus.OK, Activator.PLUGIN_ID, "");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.dialogs.FilteredItemsSelectionDialog#createFilter()
	 */
	@Override
	protected ItemsFilter createFilter() {
		return new RegisteredElementExtensionPointFilter() {
		};
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Comparator<RegisteredElementExtensionPoint> getItemsComparator() {
		Comparator<RegisteredElementExtensionPoint> comp = new Comparator<RegisteredElementExtensionPoint>() {

			public int compare(RegisteredElementExtensionPoint o1, RegisteredElementExtensionPoint o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};
		return comp;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void fillContentProvider(AbstractContentProvider contentProvider, ItemsFilter itemsFilter, IProgressMonitor progressMonitor) throws CoreException {
		if(progressMonitor != null) {
			progressMonitor.beginTask("Displaying registered elements", totalInput.length);
		}
		for(int i = 0; i < totalInput.length; i++) {
			Object o = totalInput[i];
			if(!alreadySelected.contains(o)) {
				contentProvider.add(o, itemsFilter);
			}
			progressMonitor.worked(1);
		}
		if(progressMonitor != null) {
			progressMonitor.done();
		}

	}

	/**
	 * Filter for extension points
	 */
	private class RegisteredElementExtensionPointFilter extends ItemsFilter {

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean isConsistentItem(Object item) {
			if(item instanceof RegisteredElementExtensionPoint) {
				return true;
			}
			return false;
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public boolean matchItem(Object item) {
			if(!(item instanceof RegisteredElementExtensionPoint)) {
				return false;
			}
			return matches(registeredElementsLabelProvider.getText(item));
		}
	}
}
