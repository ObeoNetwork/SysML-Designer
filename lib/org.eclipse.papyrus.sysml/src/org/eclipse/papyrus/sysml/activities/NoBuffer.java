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
import org.eclipse.uml2.uml.ObjectNode;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>No Buffer</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.activities.NoBuffer#getBase_ObjectNode <em>Base Object Node</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.sysml.activities.ActivitiesPackage#getNoBuffer()
 * @model
 * @generated
 */
public interface NoBuffer extends EObject {

	/**
	 * Returns the value of the '<em><b>Base Object Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Object Node</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Object Node</em>' reference.
	 * @see #setBase_ObjectNode(ObjectNode)
	 * @see org.eclipse.papyrus.sysml.activities.ActivitiesPackage#getNoBuffer_Base_ObjectNode()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ObjectNode getBase_ObjectNode();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.sysml.activities.NoBuffer#getBase_ObjectNode <em>Base Object Node</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Object Node</em>' reference.
	 * @see #getBase_ObjectNode()
	 * @generated
	 */
	void setBase_ObjectNode(ObjectNode value);

} // NoBuffer
