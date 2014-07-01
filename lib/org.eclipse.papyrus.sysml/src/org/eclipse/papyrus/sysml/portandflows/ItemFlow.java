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
import org.eclipse.uml2.uml.InformationFlow;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Item Flow</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.portandflows.ItemFlow#getBase_InformationFlow <em>Base Information Flow</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.portandflows.ItemFlow#getItemProperty <em>Item Property</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.sysml.portandflows.PortandflowsPackage#getItemFlow()
 * @model
 * @generated
 */
public interface ItemFlow extends EObject {

	/**
	 * Returns the value of the '<em><b>Base Information Flow</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Information Flow</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Information Flow</em>' reference.
	 * @see #setBase_InformationFlow(InformationFlow)
	 * @see org.eclipse.papyrus.sysml.portandflows.PortandflowsPackage#getItemFlow_Base_InformationFlow()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	InformationFlow getBase_InformationFlow();

	/**
	 * Returns the value of the '<em><b>Item Property</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Item Property</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Item Property</em>' reference.
	 * @see #setItemProperty(Property)
	 * @see org.eclipse.papyrus.sysml.portandflows.PortandflowsPackage#getItemFlow_ItemProperty()
	 * @model ordered="false"
	 * @generated
	 */
	Property getItemProperty();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.sysml.portandflows.ItemFlow#getBase_InformationFlow <em>Base Information Flow</em>}'
	 * reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Information Flow</em>' reference.
	 * @see #getBase_InformationFlow()
	 * @generated
	 */
	void setBase_InformationFlow(InformationFlow value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.sysml.portandflows.ItemFlow#getItemProperty <em>Item Property</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Item Property</em>' reference.
	 * @see #getItemProperty()
	 * @generated
	 */
	void setItemProperty(Property value);

} // ItemFlow
