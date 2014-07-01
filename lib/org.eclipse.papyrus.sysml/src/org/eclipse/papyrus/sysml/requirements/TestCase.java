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
package org.eclipse.papyrus.sysml.requirements;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Operation;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Test Case</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.TestCase#getBase_Behavior <em>Base Behavior</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.TestCase#getBase_Operation <em>Base Operation</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.TestCase#getVerifies <em>Verifies</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.sysml.requirements.RequirementsPackage#getTestCase()
 * @model
 * @generated
 */
public interface TestCase extends EObject {

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
	 * @see org.eclipse.papyrus.sysml.requirements.RequirementsPackage#getTestCase_Base_Behavior()
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
	 * @see org.eclipse.papyrus.sysml.requirements.RequirementsPackage#getTestCase_Base_Operation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Operation getBase_Operation();

	/**
	 * Returns the value of the '<em><b>Verifies</b></em>' reference list. The
	 * list contents are of type {@link org.eclipse.papyrus.sysml.requirements.Requirement}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Verifies</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Verifies</em>' reference list.
	 * @see org.eclipse.papyrus.sysml.requirements.RequirementsPackage#getTestCase_Verifies()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        ordered="false"
	 * @generated
	 */
	EList<Requirement> getVerifies();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.sysml.requirements.TestCase#getBase_Behavior <em>Base Behavior</em>}' reference.
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
	 * Sets the value of the '{@link org.eclipse.papyrus.sysml.requirements.TestCase#getBase_Operation <em>Base Operation</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Operation</em>' reference.
	 * @see #getBase_Operation()
	 * @generated
	 */
	void setBase_Operation(Operation value);

} // TestCase
