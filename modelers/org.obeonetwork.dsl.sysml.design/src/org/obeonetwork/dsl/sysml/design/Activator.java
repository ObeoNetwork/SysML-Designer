/*******************************************************************************
 * Copyright (c) 2009, 2011, 2012 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.sysml.design;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.UMLPackage;
import org.osgi.framework.BundleContext;

import fr.obeo.dsl.viewpoint.business.api.componentization.ViewpointRegistry;
import fr.obeo.dsl.viewpoint.description.Viewpoint;

/**
 * The activator class controls the plug-in life cycle.
 * 
 * @author Axel Richard <a href="mailto:axel.richard@obeo.fr">axel.richard@obeo.fr</a>
 */
public class Activator extends AbstractUIPlugin {
	/**
	 * The plug-in ID.
	 */
	public static final String PLUGIN_ID = "org.obeonetwork.dsl.sysml.design";

	/**
	 * SysML pathmap.
	 */
	public static final String SYSML_PROFILES_PATHMAP = "pathmap://SysML_PROFILES/";

	/**
	 * Standard pathmap.
	 */
	public static final String STANDARD_PROFILES_PATHMAP = "pathmap://UML_PROFILES/";

	/**
	 * Path to SysML profile model.
	 */
	protected static final String SYSML_PROFILE_PATH = "SysML.profile.uml";

	/**
	 * Path to Standard profile model.
	 */
	protected static final String STANDARD_PROFILE_PATH = "Standard.profile.uml";

	/**
	 * The shared instance.
	 */
	private static Activator plugin;

	/**
	 * The viewpoints.
	 */
	private static Set<Viewpoint> viewpoints;

	/**
	 * SysML Profile URI.
	 */
	private static URI sysMLProfileURI;

	/**
	 * Standard Profile URI.
	 */
	private static URI standardProfileURI;

	/**
	 * SysML Profile.
	 */
	private static Profile sysMLProfile;

	/**
	 * Standard Profile.
	 */
	private static Profile standardProfile;

	/**
	 * The constructor.
	 */
	public Activator() {
		final URI sysMLProfilesURI = URI.createURI(SYSML_PROFILES_PATHMAP);
		sysMLProfileURI = sysMLProfilesURI.appendSegment(SYSML_PROFILE_PATH);
		loadSysMLProfile();

		final URI standardProfilesURI = URI.createURI(STANDARD_PROFILES_PATHMAP);
		standardProfileURI = standardProfilesURI.appendSegment(STANDARD_PROFILE_PATH);
		loadStandardProfile();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		viewpoints = new HashSet<Viewpoint>();
		viewpoints.addAll(ViewpointRegistry.getInstance().registerFromPlugin(
				PLUGIN_ID + "/description/sysml.odesign"));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		if (viewpoints != null) {
			for (final Viewpoint viewpoint : viewpoints) {
				ViewpointRegistry.getInstance().disposeFromPlugin(viewpoint);
			}
			viewpoints.clear();
			viewpoints = null;
		}
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	public static URI getSysMLProfileURI() {
		return sysMLProfileURI;
	}

	public static URI getStandardProfileURI() {
		return standardProfileURI;
	}

	public static Profile getSysMLProfile() {
		return sysMLProfile;
	}

	public static Profile getStandardProfile() {
		return standardProfile;
	}

	/**
	 * Log message.
	 * 
	 * @param severity
	 *            Severity
	 * @param message
	 *            Message
	 * @param exception
	 *            ESception
	 */
	public static void log(int severity, String message, Throwable exception) {
		getDefault().getLog().log(new Status(severity, PLUGIN_ID, message, exception));
	}

	/**
	 * Loads the SysML profile. In case of errors, a message is logged in the plugin logger and the eclipse
	 * error log
	 */
	protected static void loadSysMLProfile() {

		final ResourceSet resourceSet = new ResourceSetImpl();

		try {
			final Resource resource = resourceSet.getResource(sysMLProfileURI, true);
			sysMLProfile = (Profile)EcoreUtil.getObjectByType(resource.getContents(),
					UMLPackage.Literals.PACKAGE);
		} catch (WrappedException we) {
			Activator.log(Status.ERROR, "Can't get the SysML profile !", we);
		}
	}

	/**
	 * Loads the Standard profile. In case of errors, a message is logged in the plugin logger and the eclipse
	 * error log
	 */
	protected static void loadStandardProfile() {

		final ResourceSet resourceSet = new ResourceSetImpl();

		try {
			final Resource resource = resourceSet.getResource(standardProfileURI, true);
			standardProfile = (Profile)EcoreUtil.getObjectByType(resource.getContents(),
					UMLPackage.Literals.PACKAGE);
		} catch (WrappedException we) {
			Activator.log(Status.ERROR, "Can't get the Standard profile !", we);
		}
	}
}
