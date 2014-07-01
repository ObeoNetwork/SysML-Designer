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
package org.eclipse.papyrus.sysml.modelelements;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>View Point</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.modelelements.ViewPoint#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.modelelements.ViewPoint#getStakeHolders <em>Stake Holders</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.modelelements.ViewPoint#getPurpose <em>Purpose</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.modelelements.ViewPoint#getConcerns <em>Concerns</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.modelelements.ViewPoint#getLanguages <em>Languages</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.modelelements.ViewPoint#getMethods <em>Methods</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.sysml.modelelements.ModelelementsPackage#getViewPoint()
 * @model
 * @generated
 */
public interface ViewPoint extends EObject {

	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.papyrus.sysml.modelelements.ModelelementsPackage#getViewPoint_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Returns the value of the '<em><b>Concerns</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Concerns</em>' attribute list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Concerns</em>' attribute list.
	 * @see org.eclipse.papyrus.sysml.modelelements.ModelelementsPackage#getViewPoint_Concerns()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	EList<String> getConcerns();

	/**
	 * Returns the value of the '<em><b>Languages</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Languages</em>' attribute list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Languages</em>' attribute list.
	 * @see org.eclipse.papyrus.sysml.modelelements.ModelelementsPackage#getViewPoint_Languages()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	EList<String> getLanguages();

	/**
	 * Returns the value of the '<em><b>Methods</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc
	 * -->
	 * <p>
	 * If the meaning of the '<em>Methods</em>' attribute list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Methods</em>' attribute list.
	 * @see org.eclipse.papyrus.sysml.modelelements.ModelelementsPackage#getViewPoint_Methods()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	EList<String> getMethods();

	/**
	 * Returns the value of the '<em><b>Purpose</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Purpose</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Purpose</em>' attribute.
	 * @see #setPurpose(String)
	 * @see org.eclipse.papyrus.sysml.modelelements.ModelelementsPackage#getViewPoint_Purpose()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	String getPurpose();

	/**
	 * Returns the value of the '<em><b>Stake Holders</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stake Holders</em>' attribute list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Stake Holders</em>' attribute list.
	 * @see org.eclipse.papyrus.sysml.modelelements.ModelelementsPackage#getViewPoint_StakeHolders()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	EList<String> getStakeHolders();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.sysml.modelelements.ViewPoint#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Sets the value of the ' {@link org.eclipse.papyrus.sysml.modelelements.ViewPoint#getPurpose
	 * <em>Purpose</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *        the new value of the '<em>Purpose</em>' attribute.
	 * @see #getPurpose()
	 * @generated
	 */
	void setPurpose(String value);

} // ViewPoint
