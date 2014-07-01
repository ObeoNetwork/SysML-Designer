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
package org.eclipse.papyrus.sysml.blocks;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.ConnectorEnd;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Nested Connector End</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.blocks.NestedConnectorEnd#getPropertyPath <em>Property Path</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.blocks.NestedConnectorEnd#getBase_ConnectorEnd <em>Base Connector End</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.sysml.blocks.BlocksPackage#getNestedConnectorEnd()
 * @model
 * @generated
 */
public interface NestedConnectorEnd extends EObject {

	/**
	 * Returns the value of the '<em><b>Base Connector End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Connector End</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Connector End</em>' reference.
	 * @see #setBase_ConnectorEnd(ConnectorEnd)
	 * @see org.eclipse.papyrus.sysml.blocks.BlocksPackage#getNestedConnectorEnd_Base_ConnectorEnd()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ConnectorEnd getBase_ConnectorEnd();

	/**
	 * Returns the value of the '<em><b>Property Path</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Property}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Path</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Property Path</em>' reference list.
	 * @see org.eclipse.papyrus.sysml.blocks.BlocksPackage#getNestedConnectorEnd_PropertyPath()
	 * @model required="true"
	 * @generated
	 */
	EList<Property> getPropertyPath();

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.Property} with the specified '<em><b>Name</b></em>', and '<em><b>Type</b></em>' from the '
	 * <em><b>Property Path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param name
	 *        The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Property} to retrieve, or <code>null</code>.
	 * @param type
	 *        The '<em><b>Type</b></em>' of the {@link org.eclipse.uml2.uml.Property} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.Property} with the specified '<em><b>Name</b></em>', and '<em><b>Type</b></em>', or
	 *         <code>null</code>.
	 * @see #getPropertyPath()
	 * @generated
	 */
	Property getPropertyPath(String name, Type type);

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.Property} with the specified '<em><b>Name</b></em>', and '<em><b>Type</b></em>' from the '
	 * <em><b>Property Path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param name
	 *        The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.Property} to retrieve, or <code>null</code>.
	 * @param type
	 *        The '<em><b>Type</b></em>' of the {@link org.eclipse.uml2.uml.Property} to retrieve, or <code>null</code>.
	 * @param ignoreCase
	 *        Whether to ignore case in {@link java.lang.String} comparisons.
	 * @param eClass
	 *        The Ecore class of the {@link org.eclipse.uml2.uml.Property} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.Property} with the specified '<em><b>Name</b></em>', and '<em><b>Type</b></em>', or
	 *         <code>null</code>.
	 * @see #getPropertyPath()
	 * @generated
	 */
	Property getPropertyPath(String name, Type type, boolean ignoreCase, EClass eClass);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.sysml.blocks.NestedConnectorEnd#getBase_ConnectorEnd <em>Base Connector End</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Connector End</em>' reference.
	 * @see #getBase_ConnectorEnd()
	 * @generated
	 */
	void setBase_ConnectorEnd(ConnectorEnd value);

} // NestedConnectorEnd
