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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.uml.extensionpoints.Activator;
import org.eclipse.papyrus.uml.extensionpoints.Registry;
import org.eclipse.papyrus.uml.extensionpoints.profile.IRegisteredProfile;
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
public class RegisteredProfileAsLibrarySelectionDialog extends ElementListSelectionDialog {

	/**
	 * 
	 */
	private EList<PackageImport> importedProfiles;

	/**
	 * 
	 */
	private List<String> importedProfilesNames;

	/**
	 * 
	 */
	private IRegisteredProfile[] regProfiles;

	/**
	 * 
	 */
	private Package currentPackage;

	/**
	 * 
	 * 
	 * @param umlPackage
	 * @param parent
	 */
	public RegisteredProfileAsLibrarySelectionDialog(Composite parent, Package umlPackage) {
		super(parent.getShell(), new ExtensionLabelProvider());

		currentPackage = umlPackage;
		importedProfiles = umlPackage.getPackageImports();
		importedProfilesNames = getImportedProfileNames(importedProfiles);

		// Retrieve registered profiles
		regProfiles = Registry.getRegisteredProfiles().toArray(new IRegisteredProfile[0]);
		// remove already applied profiles from the list
		regProfiles = removeAlreadyImportedFromSelection();

		this.setTitle("Apply profiles from Papyrus repository :");
		this.setElements(regProfiles);
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public boolean run() {
		this.open();
		return this.treatSelection();
	}

	/**
	 * 
	 * 
	 * @param appliedProfiles
	 * 
	 * @return
	 */
	private List<String> getImportedProfileNames(EList<? extends PackageImport> importedProfiles) {

		List<String> Libraries = new ArrayList<String>();
		Iterator<? extends PackageImport> importedIt = importedProfiles.iterator();

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
	private IRegisteredProfile[] removeAlreadyImportedFromSelection() {

		List<IRegisteredProfile> profiles = new ArrayList<IRegisteredProfile>();

		for(int i = 0; i < regProfiles.length; i++) {

			String currentName = regProfiles[i].getName();
			if(!importedProfilesNames.contains(currentName)) {
				profiles.add(regProfiles[i]);
			}
		}

		IRegisteredProfile[] cleandList;
		cleandList = profiles.toArray(new IRegisteredProfile[profiles.size()]);

		return cleandList;
	}

	/**
	 * 
	 * 
	 * @return
	 */
	private boolean treatSelection() {

		// User selection
		Object[] selection = this.getResult();
		boolean hasChanged = false;

		if(selection == null) { // Cancel was selected
			return hasChanged;
		}

		for(int i = 0; i < selection.length; i++) {

			IRegisteredProfile currentProfile = (IRegisteredProfile)(selection[i]);
			URI modelUri = currentProfile.getUri();

			PackageImport pi = getModelLibraryImportFromURI(modelUri);

			if(pi != null) {
				currentPackage.getPackageImports().add(pi);
			}
		}
		return hasChanged;
	}

	/**
	 * 
	 * 
	 * @param uri
	 * 
	 * @return
	 */
	public PackageImport getModelLibraryImportFromURI(URI uri) {

		ResourceSet resourceSet = EMFHelper.getResourceSet(currentPackage);
		Resource modelResource = resourceSet.getResource(uri, true);

		if(modelResource.getContents().size() <= 0) {
			Activator.getDefault().getLog().log(
					new Status(IStatus.ERROR, Activator.PLUGIN_ID, "No element found in model from URI "
					+ uri.toString()));
			return null;
		}

		// Try to reach model
		Element root = (Element)modelResource.getContents().get(0);

		if(root instanceof Package) {

			// Import model library
			Package libToImport = (Package)(modelResource.getContents().get(0));
			// create import package
			PackageImport modelLibImport = UMLFactory.eINSTANCE.createPackageImport();
			modelLibImport.setImportedPackage(libToImport);

			return modelLibImport;
		}
		Activator.getDefault().getLog().log(
				new Status(IStatus.ERROR, Activator.PLUGIN_ID, "The selected uri (" + uri.toString()
				+ ") does not contain any model library !"));
		return null;
	}
}
