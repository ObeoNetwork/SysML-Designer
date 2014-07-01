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
package org.eclipse.papyrus.uml.extensionpoints.metamodel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.extensionpoints.Activator;
import org.eclipse.papyrus.uml.extensionpoints.Registry;
import org.eclipse.papyrus.uml.extensionpoints.standard.ExtensionLabelProvider;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * 
 */
public class RegisteredMetamodelSelectionDialog extends ElementListSelectionDialog {

	/**
	 * 
	 */
	private EList<PackageImport> importedMetamodels;

	/**
	 * 
	 */
	private List<String> importedMetamodelsNames;

	/**
	 * 
	 */
	private IRegisteredMetamodel[] regMetamodels;

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
	public RegisteredMetamodelSelectionDialog(Composite parent, Package umlModel) {
		super(parent.getShell(), new ExtensionLabelProvider());

		currentModel = umlModel;
		importedMetamodels = umlModel.getPackageImports();
		importedMetamodelsNames = getImportedMetamodelsNames(importedMetamodels);

		// Retrieve registered Libraries
		regMetamodels = Registry.getRegisteredMetamodels().toArray(new IRegisteredMetamodel[0]);
		// remove already applied Libraries from the list
		regMetamodels = removeAlreadyImportedFromSelection();

		this.setTitle("Import Metamodel from Papyrus repository :");
		this.setElements(regMetamodels);
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
	private List<String> getImportedMetamodelsNames(EList<? extends PackageImport> importedMetamodels) {

		List<String> Metamodels = new ArrayList<String>();
		Iterator<? extends PackageImport> importedIt = importedMetamodels.iterator();

		while(importedIt.hasNext()) {
			PackageImport currentImport = importedIt.next();
			String currentName = currentImport.getImportedPackage().getName();
			Metamodels.add(currentName);
		}

		return Metamodels;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	private IRegisteredMetamodel[] removeAlreadyImportedFromSelection() {

		List<IRegisteredMetamodel> Metamodels = new ArrayList<IRegisteredMetamodel>();

		for(int i = 0; i < regMetamodels.length; i++) {

			String currentName = regMetamodels[i].getName();
			if(!importedMetamodelsNames.contains(currentName)) {
				Metamodels.add(regMetamodels[i]);
			}
		}

		IRegisteredMetamodel[] cleanedList;
		cleanedList = Metamodels.toArray(new IRegisteredMetamodel[Metamodels.size()]);

		return cleanedList;
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
			IRegisteredMetamodel currentLibrary = (IRegisteredMetamodel)(selection[i]);
			URI modelUri = currentLibrary.getUri();
			addModelImportFromURI(currentModel, modelUri);

		}
	}

	protected boolean addModelImportFromURI(Package currentModel, URI modelUri) {
		Resource modelResource = EMFHelper.getResourceSet(currentModel).getResource(modelUri, true);

		if(modelResource.getContents().size() <= 0) {
			Activator.log("The selected uri (" + modelUri.toString() + ") does not contain any model library !");
			return false;
		}

		// Try to reach model
		Element root = (Element)modelResource.getContents().get(0);

		if(root instanceof Package) {

			// Import model library
			Package modelToImport = (Package)(modelResource.getContents().get(0));
			// create import package
			PackageImport modelImport = UMLFactory.eINSTANCE.createPackageImport();
			modelImport.setImportedPackage(modelToImport);

			return currentModel.getPackageImports().add(modelImport);
		}

		Activator.log("The selected uri (" + modelUri.toString() + ") does not contain any model library !");
		return false;
	}
}
