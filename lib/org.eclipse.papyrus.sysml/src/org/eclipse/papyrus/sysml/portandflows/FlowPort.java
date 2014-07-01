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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Image;
import org.eclipse.uml2.uml.Port;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Flow Port</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.portandflows.FlowPort#getBase_Port <em>Base Port</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.portandflows.FlowPort#isAtomic <em>Is Atomic</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.portandflows.FlowPort#isConjugated <em>Is Conjugated</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.portandflows.FlowPort#getDirection <em>Direction</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.sysml.portandflows.PortandflowsPackage#getFlowPort()
 * @model
 * @generated
 */
public interface FlowPort extends EObject {

	/**
	 * Returns the value of the '<em><b>Base Port</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Port</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Port</em>' reference.
	 * @see #setBase_Port(Port)
	 * @see org.eclipse.papyrus.sysml.portandflows.PortandflowsPackage#getFlowPort_Base_Port()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Port getBase_Port();

	/**
	 * Returns the value of the '<em><b>Direction</b></em>' attribute.
	 * The default value is <code>"inout"</code>.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.sysml.portandflows.FlowDirection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Direction</em>' attribute.
	 * @see org.eclipse.papyrus.sysml.portandflows.FlowDirection
	 * @see #setDirection(FlowDirection)
	 * @see org.eclipse.papyrus.sysml.portandflows.PortandflowsPackage#getFlowPort_Direction()
	 * @model default="inout" unique="false" required="true" ordered="false"
	 * @generated
	 */
	FlowDirection getDirection();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation" required="true" ordered="false"
	 * @generated
	 */
	Image getIcon();

	/**
	 * Sets the value of the ' {@link org.eclipse.papyrus.sysml.portandflows.FlowPort#getBase_Port
	 * <em>Base Port</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Port</em>' reference.
	 * @see #getBase_Port()
	 * @generated
	 */
	void setBase_Port(Port value);

	/**
	 * Returns the value of the '<em><b>Is Atomic</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Atomic</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Is Atomic</em>' attribute.
	 * @see org.eclipse.papyrus.sysml.portandflows.PortandflowsPackage#getFlowPort_IsAtomic()
	 * @model default="false" unique="false" dataType="org.eclipse.uml2.types.Boolean" required="true" transient="true" changeable="false"
	 *        volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isAtomic();

	/**
	 * Returns the value of the '<em><b>Is Conjugated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Conjugated</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Is Conjugated</em>' attribute.
	 * @see #setIsConjugated(boolean)
	 * @see org.eclipse.papyrus.sysml.portandflows.PortandflowsPackage#getFlowPort_IsConjugated()
	 * @model unique="false" dataType="org.eclipse.uml2.types.Boolean" ordered="false"
	 * @generated
	 */
	boolean isConjugated();

	/**
	 * Sets the value of the ' {@link org.eclipse.papyrus.sysml.portandflows.FlowPort#getDirection
	 * <em>Direction</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *        the new value of the '<em>Direction</em>' attribute.
	 * @see org.eclipse.papyrus.sysml.portandflows.FlowDirection
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(FlowDirection value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.sysml.portandflows.FlowPort#isConjugated <em>Is Conjugated</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Is Conjugated</em>' attribute.
	 * @see #isConjugated()
	 * @generated
	 */
	void setIsConjugated(boolean value);

} // FlowPort
