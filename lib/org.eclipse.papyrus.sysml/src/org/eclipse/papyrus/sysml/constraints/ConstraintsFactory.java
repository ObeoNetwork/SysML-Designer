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
package org.eclipse.papyrus.sysml.constraints;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.sysml.constraints.ConstraintsPackage
 * @generated
 */
public interface ConstraintsFactory extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	ConstraintsFactory eINSTANCE = org.eclipse.papyrus.sysml.constraints.internal.impl.ConstraintsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Constraint Block</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Constraint Block</em>'.
	 * @generated
	 */
	ConstraintBlock createConstraintBlock();

	/**
	 * Returns a new object of class '<em>Constraint Property</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Constraint Property</em>'.
	 * @generated
	 */
	ConstraintProperty createConstraintProperty();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	ConstraintsPackage getConstraintsPackage();

} // ConstraintsFactory
