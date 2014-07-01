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
package org.eclipse.papyrus.sysml.activities;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Operation;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Control Operator</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.activities.ControlOperator#getBase_Operation <em>Base Operation</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.activities.ControlOperator#getBase_Behavior <em>Base Behavior</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.sysml.activities.ActivitiesPackage#getControlOperator()
 * @model
 * @generated
 */
public interface ControlOperator extends EObject {

	/**
	 * Returns the value of the '<em><b>Base Behavior</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Behavior</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Behavior</em>' reference.
	 * @see #setBase_Behavior(Behavior)
	 * @see org.eclipse.papyrus.sysml.activities.ActivitiesPackage#getControlOperator_Base_Behavior()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Behavior getBase_Behavior();

	/**
	 * Returns the value of the '<em><b>Base Operation</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Operation</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Operation</em>' reference.
	 * @see #setBase_Operation(Operation)
	 * @see org.eclipse.papyrus.sysml.activities.ActivitiesPackage#getControlOperator_Base_Operation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Operation getBase_Operation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.sysml.activities.ControlOperator#getBase_Behavior <em>Base Behavior</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Behavior</em>' reference.
	 * @see #getBase_Behavior()
	 * @generated
	 */
	void setBase_Behavior(Behavior value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.sysml.activities.ControlOperator#getBase_Operation <em>Base Operation</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Operation</em>' reference.
	 * @see #getBase_Operation()
	 * @generated
	 */
	void setBase_Operation(Operation value);

} // ControlOperator
