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
package org.eclipse.papyrus.sysml.allocations;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.sysml.allocations.AllocationsPackage
 * @generated
 */
public interface AllocationsFactory extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	AllocationsFactory eINSTANCE = org.eclipse.papyrus.sysml.allocations.internal.impl.AllocationsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Allocate</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Allocate</em>'.
	 * @generated
	 */
	Allocate createAllocate();

	/**
	 * Returns a new object of class '<em>Allocate Activity Partition</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Allocate Activity Partition</em>'.
	 * @generated
	 */
	AllocateActivityPartition createAllocateActivityPartition();

	/**
	 * Returns a new object of class '<em>Allocated</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Allocated</em>'.
	 * @generated
	 */
	Allocated createAllocated();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	AllocationsPackage getAllocationsPackage();

} // AllocationsFactory
