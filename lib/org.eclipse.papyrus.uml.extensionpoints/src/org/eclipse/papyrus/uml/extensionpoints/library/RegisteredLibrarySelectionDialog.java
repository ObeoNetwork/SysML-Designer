/*******************************************************************************
 * Copyright (c) 2006, 2014 CEA List and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *     Christian W. Damus (CEA) - bug 422257
 *     Dr. David H. Akehurst - enable programmatic registration 
 *******************************************************************************/
package org.eclipse.papyrus.uml.extensionpoints.library;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.extensionpoints.Activator;
import org.eclipse.papyrus.uml.extensionpoints.standard.ExtensionLabelProvider;
import org.eclipse.papyrus.uml.extensionpoints.Registry;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * 
 */
public class RegisteredLibrarySelectionDialog extends ElementListSelectionDialog {

	/**
	 * 
	 */
	private EList<PackageImport> importedLibraries;

	/**
	 * 
	 */
	private List<String> importedLibrariesNames;

	/**
	 * 
	 */
	private IRegisteredLibrary[] regLibraries;

	/**
	 * 
	 */
	private Package currentModel;

	/**
	 * 
	 * 
	 * @param umlModel
	 * @param parent
	 */
	public RegisteredLibrarySelectionDialog(Composite parent, Package umlModel) {
		super(parent.getShell(), new ExtensionLabelProvider());

		currentModel = umlModel;
		importedLibraries = umlModel.getPackageImports();
		importedLibrariesNames = getImportedLibraryNames(importedLibraries);

		// Retrieve registered Libraries
		regLibraries = Registry.getRegisteredLibraries().toArray(new IRegisteredLibrary[0]);
		// remove already applied Libraries from the list
		regLibraries = removeAlreadyImportededFromSelection();

		this.setTitle("Apply Libraries from Papyrus repository :");
		this.setElements(regLibraries);
	}

	/**
	 * 
	 */
	public void run() {
		this.open();
		this.treatSelection();
	}

	/**
	 * 
	 * 
	 * @param appliedLibraries
	 * 
	 * @return
	 */
	private List<String> getImportedLibraryNames(EList<? extends PackageImport> appliedLibraries) {

		List<String> Libraries = new ArrayList<String>();
		Iterator<? extends PackageImport> importedIt = appliedLibraries.iterator();

		while(importedIt.hasNext()) {
			PackageImport currentImport = importedIt.next();
			String currentName = currentImport.getImportedPackage().getName();
			Libraries.add(currentName);
		}

		return Libraries;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	private IRegisteredLibrary[] removeAlreadyImportededFromSelection() {

		List<IRegisteredLibrary> Libraries = new ArrayList<IRegisteredLibrary>();

		for(int i = 0; i < regLibraries.length; i++) {

			String currentName = regLibraries[i].getName();
			if(!importedLibrariesNames.contains(currentName)) {
				Libraries.add(regLibraries[i]);
			}
		}

		IRegisteredLibrary[] cleandList;
		cleandList = Libraries.toArray(new IRegisteredLibrary[Libraries.size()]);

		return cleandList;
	}

	/**
	 * 
	 */
	private void treatSelection() {

		// User selection
		Object[] selection = this.getResult();

		if(selection == null) { // Cancel was selected
			return;
		}

		for(int i = 0; i < selection.length; i++) {
			IRegisteredLibrary currentLibrary = (IRegisteredLibrary)(selection[i]);
			URI modelUri = currentLibrary.getUri();
			addModelLibraryImportFromURI(currentModel, modelUri);

		}
	}

	protected boolean addModelLibraryImportFromURI(Package currentModel, URI modelUri) {
		Resource modelResource = EMFHelper.getResourceSet(currentModel).getResource(modelUri, true);

		if(modelResource.getContents().size() <= 0) {
			Activator.log("The selected uri (" + modelUri.toString() + ") does not contain any model library !");
			return false;
		}

		// Try to reach model
		Element root = (Element)modelResource.getContents().get(0);

		if(root instanceof Package) {

			// Import model library
			Package libToImport = (Package)(modelResource.getContents().get(0));
			// create import package
			PackageImport modelLibImport = UMLFactory.eINSTANCE.createPackageImport();
			modelLibImport.setImportedPackage(libToImport);

			return currentModel.getPackageImports().add(modelLibImport);
		}

		Activator.log("The selected uri (" + modelUri.toString() + ") does not contain any model library !");
		return false;
	}
}
