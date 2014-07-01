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
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.Parameter;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Rate</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.activities.Rate#getBase_Parameter <em>Base Parameter</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.activities.Rate#getBase_ActivityEdge <em>Base Activity Edge</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.activities.Rate#getRate <em>Rate</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.sysml.activities.ActivitiesPackage#getRate()
 * @model
 * @generated
 */
public interface Rate extends EObject {

	/**
	 * Returns the value of the '<em><b>Base Activity Edge</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Activity Edge</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Activity Edge</em>' reference.
	 * @see #setBase_ActivityEdge(ActivityEdge)
	 * @see org.eclipse.papyrus.sysml.activities.ActivitiesPackage#getRate_Base_ActivityEdge()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ActivityEdge getBase_ActivityEdge();

	/**
	 * Returns the value of the '<em><b>Base Parameter</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Parameter</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Parameter</em>' reference.
	 * @see #setBase_Parameter(Parameter)
	 * @see org.eclipse.papyrus.sysml.activities.ActivitiesPackage#getRate_Base_Parameter()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Parameter getBase_Parameter();

	/**
	 * Returns the value of the '<em><b>Rate</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rate</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Rate</em>' reference.
	 * @see #setRate(InstanceSpecification)
	 * @see org.eclipse.papyrus.sysml.activities.ActivitiesPackage#getRate_Rate()
	 * @model ordered="false"
	 * @generated
	 */
	InstanceSpecification getRate();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.sysml.activities.Rate#getBase_ActivityEdge <em>Base Activity Edge</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Activity Edge</em>' reference.
	 * @see #getBase_ActivityEdge()
	 * @generated
	 */
	void setBase_ActivityEdge(ActivityEdge value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.sysml.activities.Rate#getBase_Parameter <em>Base Parameter</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Parameter</em>' reference.
	 * @see #getBase_Parameter()
	 * @generated
	 */
	void setBase_Parameter(Parameter value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.sysml.activities.Rate#getRate <em>Rate</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Rate</em>' reference.
	 * @see #getRate()
	 * @generated
	 */
	void setRate(InstanceSpecification value);

} // Rate
