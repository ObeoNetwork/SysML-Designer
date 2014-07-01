/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.portandflows;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.sysml.portandflows.PortandflowsPackage
 * @generated
 */
public interface PortandflowsFactory extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	PortandflowsFactory eINSTANCE = org.eclipse.papyrus.sysml.portandflows.internal.impl.PortandflowsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Flow Port</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Flow Port</em>'.
	 * @generated
	 */
	FlowPort createFlowPort();

	/**
	 * Returns a new object of class '<em>Flow Property</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Flow Property</em>'.
	 * @generated
	 */
	FlowProperty createFlowProperty();

	/**
	 * Returns a new object of class '<em>Flow Specification</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Flow Specification</em>'.
	 * @generated
	 */
	FlowSpecification createFlowSpecification();

	/**
	 * Returns a new object of class '<em>Item Flow</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Item Flow</em>'.
	 * @generated
	 */
	ItemFlow createItemFlow();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	PortandflowsPackage getPortandflowsPackage();

} // PortandflowsFactory
