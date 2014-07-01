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
import org.eclipse.uml2.uml.NamedElement;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Requirement Related</b></em> '. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.RequirementRelated#getBase_NamedElement <em>Base Named Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.RequirementRelated#getTracedFrom <em>Traced From</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.RequirementRelated#getSatisfies <em>Satisfies</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.RequirementRelated#getRefines <em>Refines</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.RequirementRelated#getVerifies <em>Verifies</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.sysml.requirements.RequirementsPackage#getRequirementRelated()
 * @model
 * @generated
 */
public interface RequirementRelated extends EObject {

	/**
	 * Returns the value of the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Named Element</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Named Element</em>' reference.
	 * @see #setBase_NamedElement(NamedElement)
	 * @see org.eclipse.papyrus.sysml.requirements.RequirementsPackage#getRequirementRelated_Base_NamedElement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	NamedElement getBase_NamedElement();

	/**
	 * Returns the value of the '<em><b>Refines</b></em>' reference list. The
	 * list contents are of type {@link org.eclipse.papyrus.sysml.requirements.Requirement}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refines</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Refines</em>' reference list.
	 * @see org.eclipse.papyrus.sysml.requirements.RequirementsPackage#getRequirementRelated_Refines()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        ordered="false"
	 * @generated
	 */
	EList<Requirement> getRefines();

	/**
	 * Returns the value of the '<em><b>Satisfies</b></em>' reference list. The
	 * list contents are of type {@link org.eclipse.papyrus.sysml.requirements.Requirement}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Satisfies</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Satisfies</em>' reference list.
	 * @see org.eclipse.papyrus.sysml.requirements.RequirementsPackage#getRequirementRelated_Satisfies()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        ordered="false"
	 * @generated
	 */
	EList<Requirement> getSatisfies();

	/**
	 * Returns the value of the '<em><b>Traced From</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.sysml.requirements.Requirement}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Traced From</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Traced From</em>' reference list.
	 * @see org.eclipse.papyrus.sysml.requirements.RequirementsPackage#getRequirementRelated_TracedFrom()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        ordered="false"
	 * @generated
	 */
	EList<Requirement> getTracedFrom();

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
	 * @see org.eclipse.papyrus.sysml.requirements.RequirementsPackage#getRequirementRelated_Verifies()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        ordered="false"
	 * @generated
	 */
	EList<Requirement> getVerifies();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.sysml.requirements.RequirementRelated#getBase_NamedElement <em>Base Named Element</em>}'
	 * reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Named Element</em>' reference.
	 * @see #getBase_NamedElement()
	 * @generated
	 */
	void setBase_NamedElement(NamedElement value);

} // RequirementRelated
