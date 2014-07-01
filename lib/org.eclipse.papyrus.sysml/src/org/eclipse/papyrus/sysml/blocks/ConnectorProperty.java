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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Connector Property</b></em> '. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.blocks.ConnectorProperty#getBase_Property <em>Base Property</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.blocks.ConnectorProperty#getConnector <em>Connector</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.sysml.blocks.BlocksPackage#getConnectorProperty()
 * @model
 * @generated
 */
public interface ConnectorProperty extends EObject {

	/**
	 * Returns the value of the '<em><b>Base Property</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Property</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Property</em>' reference.
	 * @see #setBase_Property(Property)
	 * @see org.eclipse.papyrus.sysml.blocks.BlocksPackage#getConnectorProperty_Base_Property()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Property getBase_Property();

	/**
	 * Returns the value of the '<em><b>Connector</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Connector</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Connector</em>' reference.
	 * @see #setConnector(Connector)
	 * @see org.eclipse.papyrus.sysml.blocks.BlocksPackage#getConnectorProperty_Connector()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Connector getConnector();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.sysml.blocks.ConnectorProperty#getBase_Property <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Property</em>' reference.
	 * @see #getBase_Property()
	 * @generated
	 */
	void setBase_Property(Property value);

	/**
	 * Sets the value of the ' {@link org.eclipse.papyrus.sysml.blocks.ConnectorProperty#getConnector
	 * <em>Connector</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *        the new value of the '<em>Connector</em>' reference.
	 * @see #getConnector()
	 * @generated
	 */
	void setConnector(Connector value);

} // ConnectorProperty
