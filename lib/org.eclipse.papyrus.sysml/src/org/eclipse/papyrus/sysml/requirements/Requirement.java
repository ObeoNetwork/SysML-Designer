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
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.NamedElement;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Requirement</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.Requirement#getText <em>Text</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.Requirement#getId <em>Id</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.Requirement#getDerived <em>Derived</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.Requirement#getDerivedFrom <em>Derived From</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.Requirement#getSatisfiedBy <em>Satisfied By</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.Requirement#getRefinedBy <em>Refined By</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.Requirement#getTracedTo <em>Traced To</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.Requirement#getVerifiedBy <em>Verified By</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.Requirement#getMaster <em>Master</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.Requirement#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.sysml.requirements.RequirementsPackage#getRequirement()
 * @model
 * @generated
 */
public interface Requirement extends EObject {

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
	 * @see org.eclipse.papyrus.sysml.requirements.RequirementsPackage#getRequirement_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Returns the value of the '<em><b>Derived</b></em>' reference list. The
	 * list contents are of type {@link org.eclipse.papyrus.sysml.requirements.Requirement}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derived</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Derived</em>' reference list.
	 * @see org.eclipse.papyrus.sysml.requirements.RequirementsPackage#getRequirement_Derived()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        ordered="false"
	 * @generated
	 */
	EList<Requirement> getDerived();

	/**
	 * Returns the value of the '<em><b>Derived From</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.sysml.requirements.Requirement}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Derived From</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Derived From</em>' reference list.
	 * @see org.eclipse.papyrus.sysml.requirements.RequirementsPackage#getRequirement_DerivedFrom()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        ordered="false"
	 * @generated
	 */
	EList<Requirement> getDerivedFrom();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.eclipse.papyrus.sysml.requirements.RequirementsPackage#getRequirement_Id()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getId();

	/**
	 * Returns the value of the '<em><b>Master</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Master</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Master</em>' reference.
	 * @see org.eclipse.papyrus.sysml.requirements.RequirementsPackage#getRequirement_Master()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        ordered="false"
	 * @generated
	 */
	Requirement getMaster();

	/**
	 * Returns the value of the '<em><b>Refined By</b></em>' reference list. The
	 * list contents are of type {@link org.eclipse.uml2.uml.NamedElement}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Refined By</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Refined By</em>' reference list.
	 * @see org.eclipse.papyrus.sysml.requirements.RequirementsPackage#getRequirement_RefinedBy()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        ordered="false"
	 * @generated
	 */
	EList<NamedElement> getRefinedBy();

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.NamedElement} with the specified '<em><b>Name</b></em>' from the '<em><b>Refined By</b></em>'
	 * reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param name
	 *        The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.NamedElement} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.NamedElement} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getRefinedBy()
	 * @generated
	 */
	NamedElement getRefinedBy(String name);

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.NamedElement} with the specified '<em><b>Name</b></em>' from the '<em><b>Refined By</b></em>'
	 * reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param name
	 *        The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.NamedElement} to retrieve, or <code>null</code>.
	 * @param ignoreCase
	 *        Whether to ignore case in {@link java.lang.String} comparisons.
	 * @param eClass
	 *        The Ecore class of the {@link org.eclipse.uml2.uml.NamedElement} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.NamedElement} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getRefinedBy()
	 * @generated
	 */
	NamedElement getRefinedBy(String name, boolean ignoreCase, EClass eClass);

	/**
	 * Returns the value of the '<em><b>Satisfied By</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Satisfied By</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Satisfied By</em>' reference list.
	 * @see org.eclipse.papyrus.sysml.requirements.RequirementsPackage#getRequirement_SatisfiedBy()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<NamedElement> getSatisfiedBy();

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.NamedElement} with the specified '<em><b>Name</b></em>' from the '<em><b>Satisfied By</b></em>'
	 * reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param name
	 *        The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.NamedElement} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.NamedElement} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getSatisfiedBy()
	 * @generated
	 */
	NamedElement getSatisfiedBy(String name);

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.NamedElement} with the specified '<em><b>Name</b></em>' from the '<em><b>Satisfied By</b></em>'
	 * reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param name
	 *        The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.NamedElement} to retrieve, or <code>null</code>.
	 * @param ignoreCase
	 *        Whether to ignore case in {@link java.lang.String} comparisons.
	 * @param eClass
	 *        The Ecore class of the {@link org.eclipse.uml2.uml.NamedElement} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.NamedElement} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getSatisfiedBy()
	 * @generated
	 */
	NamedElement getSatisfiedBy(String name, boolean ignoreCase, EClass eClass);

	/**
	 * Returns the value of the '<em><b>Text</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Text</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Text</em>' attribute.
	 * @see #setText(String)
	 * @see org.eclipse.papyrus.sysml.requirements.RequirementsPackage#getRequirement_Text()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	String getText();

	/**
	 * Returns the value of the '<em><b>Traced To</b></em>' reference list. The
	 * list contents are of type {@link org.eclipse.uml2.uml.NamedElement}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Traced To</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Traced To</em>' reference list.
	 * @see org.eclipse.papyrus.sysml.requirements.RequirementsPackage#getRequirement_TracedTo()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 *        ordered="false"
	 * @generated
	 */
	EList<NamedElement> getTracedTo();

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.NamedElement} with the specified '<em><b>Name</b></em>' from the '<em><b>Traced To</b></em>'
	 * reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param name
	 *        The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.NamedElement} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.NamedElement} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getTracedTo()
	 * @generated
	 */
	NamedElement getTracedTo(String name);

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.NamedElement} with the specified '<em><b>Name</b></em>' from the '<em><b>Traced To</b></em>'
	 * reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param name
	 *        The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.NamedElement} to retrieve, or <code>null</code>.
	 * @param ignoreCase
	 *        Whether to ignore case in {@link java.lang.String} comparisons.
	 * @param eClass
	 *        The Ecore class of the {@link org.eclipse.uml2.uml.NamedElement} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.NamedElement} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getTracedTo()
	 * @generated
	 */
	NamedElement getTracedTo(String name, boolean ignoreCase, EClass eClass);

	/**
	 * Returns the value of the '<em><b>Verified By</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Verified By</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Verified By</em>' reference list.
	 * @see org.eclipse.papyrus.sysml.requirements.RequirementsPackage#getRequirement_VerifiedBy()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<NamedElement> getVerifiedBy();

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.NamedElement} with the specified '<em><b>Name</b></em>' from the '<em><b>Verified By</b></em>'
	 * reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param name
	 *        The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.NamedElement} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.NamedElement} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getVerifiedBy()
	 * @generated
	 */
	NamedElement getVerifiedBy(String name);

	/**
	 * Retrieves the first {@link org.eclipse.uml2.uml.NamedElement} with the specified '<em><b>Name</b></em>' from the '<em><b>Verified By</b></em>'
	 * reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param name
	 *        The '<em><b>Name</b></em>' of the {@link org.eclipse.uml2.uml.NamedElement} to retrieve, or <code>null</code>.
	 * @param ignoreCase
	 *        Whether to ignore case in {@link java.lang.String} comparisons.
	 * @param eClass
	 *        The Ecore class of the {@link org.eclipse.uml2.uml.NamedElement} to retrieve, or <code>null</code>.
	 * @return The first {@link org.eclipse.uml2.uml.NamedElement} with the specified '<em><b>Name</b></em>', or <code>null</code>.
	 * @see #getVerifiedBy()
	 * @generated
	 */
	NamedElement getVerifiedBy(String name, boolean ignoreCase, EClass eClass);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.sysml.requirements.Requirement#getBase_Class <em>Base Class</em>}' reference.
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
	 * Sets the value of the '{@link org.eclipse.papyrus.sysml.requirements.Requirement#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.sysml.requirements.Requirement#getText <em>Text</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Text</em>' attribute.
	 * @see #getText()
	 * @generated
	 */
	void setText(String value);

} // Requirement
