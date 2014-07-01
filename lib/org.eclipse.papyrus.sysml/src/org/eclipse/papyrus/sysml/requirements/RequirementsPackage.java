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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.uml2.uml.profile.standard.StandardPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.sysml.requirements.RequirementsFactory
 * @model kind="package"
 * @generated
 */
public interface RequirementsPackage extends EPackage {

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that
	 * represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.sysml.requirements.internal.impl.DeriveReqtImpl <em>Derive Reqt</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.sysml.requirements.internal.impl.DeriveReqtImpl
		 * @see org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementsPackageImpl#getDeriveReqt()
		 * @generated
		 */
		EClass DERIVE_REQT = eINSTANCE.getDeriveReqt();

		/**
		 * The meta object literal for the ' {@link org.eclipse.papyrus.sysml.requirements.internal.impl.VerifyImpl
		 * <em>Verify</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.eclipse.papyrus.sysml.requirements.internal.impl.VerifyImpl
		 * @see org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementsPackageImpl#getVerify()
		 * @generated
		 */
		EClass VERIFY = eINSTANCE.getVerify();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.sysml.requirements.internal.impl.CopyImpl <em>Copy</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.sysml.requirements.internal.impl.CopyImpl
		 * @see org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementsPackageImpl#getCopy()
		 * @generated
		 */
		EClass COPY = eINSTANCE.getCopy();

		/**
		 * The meta object literal for the ' {@link org.eclipse.papyrus.sysml.requirements.internal.impl.SatisfyImpl
		 * <em>Satisfy</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.eclipse.papyrus.sysml.requirements.internal.impl.SatisfyImpl
		 * @see org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementsPackageImpl#getSatisfy()
		 * @generated
		 */
		EClass SATISFY = eINSTANCE.getSatisfy();

		/**
		 * The meta object literal for the ' {@link org.eclipse.papyrus.sysml.requirements.internal.impl.TestCaseImpl
		 * <em>Test Case</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.eclipse.papyrus.sysml.requirements.internal.impl.TestCaseImpl
		 * @see org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementsPackageImpl#getTestCase()
		 * @generated
		 */
		EClass TEST_CASE = eINSTANCE.getTestCase();

		/**
		 * The meta object literal for the '<em><b>Base Behavior</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TEST_CASE__BASE_BEHAVIOR = eINSTANCE.getTestCase_Base_Behavior();

		/**
		 * The meta object literal for the '<em><b>Base Operation</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TEST_CASE__BASE_OPERATION = eINSTANCE.getTestCase_Base_Operation();

		/**
		 * The meta object literal for the '<em><b>Verifies</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TEST_CASE__VERIFIES = eINSTANCE.getTestCase_Verifies();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementImpl <em>Requirement</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementImpl
		 * @see org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementsPackageImpl#getRequirement()
		 * @generated
		 */
		EClass REQUIREMENT = eINSTANCE.getRequirement();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REQUIREMENT__TEXT = eINSTANCE.getRequirement_Text();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute REQUIREMENT__ID = eINSTANCE.getRequirement_Id();

		/**
		 * The meta object literal for the '<em><b>Derived</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference REQUIREMENT__DERIVED = eINSTANCE.getRequirement_Derived();

		/**
		 * The meta object literal for the '<em><b>Derived From</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference REQUIREMENT__DERIVED_FROM = eINSTANCE.getRequirement_DerivedFrom();

		/**
		 * The meta object literal for the '<em><b>Satisfied By</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference REQUIREMENT__SATISFIED_BY = eINSTANCE.getRequirement_SatisfiedBy();

		/**
		 * The meta object literal for the '<em><b>Refined By</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference REQUIREMENT__REFINED_BY = eINSTANCE.getRequirement_RefinedBy();

		/**
		 * The meta object literal for the '<em><b>Traced To</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference REQUIREMENT__TRACED_TO = eINSTANCE.getRequirement_TracedTo();

		/**
		 * The meta object literal for the '<em><b>Verified By</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference REQUIREMENT__VERIFIED_BY = eINSTANCE.getRequirement_VerifiedBy();

		/**
		 * The meta object literal for the '<em><b>Master</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference REQUIREMENT__MASTER = eINSTANCE.getRequirement_Master();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference REQUIREMENT__BASE_CLASS = eINSTANCE.getRequirement_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementRelatedImpl
		 * <em>Requirement Related</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementRelatedImpl
		 * @see org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementsPackageImpl#getRequirementRelated()
		 * @generated
		 */
		EClass REQUIREMENT_RELATED = eINSTANCE.getRequirementRelated();

		/**
		 * The meta object literal for the '<em><b>Base Named Element</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference REQUIREMENT_RELATED__BASE_NAMED_ELEMENT = eINSTANCE.getRequirementRelated_Base_NamedElement();

		/**
		 * The meta object literal for the '<em><b>Traced From</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference REQUIREMENT_RELATED__TRACED_FROM = eINSTANCE.getRequirementRelated_TracedFrom();

		/**
		 * The meta object literal for the '<em><b>Satisfies</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference REQUIREMENT_RELATED__SATISFIES = eINSTANCE.getRequirementRelated_Satisfies();

		/**
		 * The meta object literal for the '<em><b>Refines</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference REQUIREMENT_RELATED__REFINES = eINSTANCE.getRequirementRelated_Refines();

		/**
		 * The meta object literal for the '<em><b>Verifies</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference REQUIREMENT_RELATED__VERIFIES = eINSTANCE.getRequirementRelated_Verifies();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "requirements";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/0.7.0/SysML/Requirements";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "Requirements";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	RequirementsPackage eINSTANCE = org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementsPackageImpl.init();

	/**
	 * The meta object id for the ' {@link org.eclipse.papyrus.sysml.requirements.internal.impl.DeriveReqtImpl
	 * <em>Derive Reqt</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.papyrus.sysml.requirements.internal.impl.DeriveReqtImpl
	 * @see org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementsPackageImpl#getDeriveReqt()
	 * @generated
	 */
	int DERIVE_REQT = 0;

	/**
	 * The feature id for the '<em><b>Base Abstraction</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERIVE_REQT__BASE_ABSTRACTION = StandardPackage.TRACE__BASE_ABSTRACTION;

	/**
	 * The number of structural features of the '<em>Derive Reqt</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERIVE_REQT_FEATURE_COUNT = StandardPackage.TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Derive Reqt</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DERIVE_REQT_OPERATION_COUNT = StandardPackage.TRACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.sysml.requirements.internal.impl.VerifyImpl <em>Verify</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.requirements.internal.impl.VerifyImpl
	 * @see org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementsPackageImpl#getVerify()
	 * @generated
	 */
	int VERIFY = 1;

	/**
	 * The feature id for the '<em><b>Base Abstraction</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERIFY__BASE_ABSTRACTION = StandardPackage.TRACE__BASE_ABSTRACTION;

	/**
	 * The number of structural features of the '<em>Verify</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERIFY_FEATURE_COUNT = StandardPackage.TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Verify</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VERIFY_OPERATION_COUNT = StandardPackage.TRACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.sysml.requirements.internal.impl.CopyImpl <em>Copy</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.requirements.internal.impl.CopyImpl
	 * @see org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementsPackageImpl#getCopy()
	 * @generated
	 */
	int COPY = 2;

	/**
	 * The feature id for the '<em><b>Base Abstraction</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COPY__BASE_ABSTRACTION = StandardPackage.TRACE__BASE_ABSTRACTION;

	/**
	 * The number of structural features of the '<em>Copy</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COPY_FEATURE_COUNT = StandardPackage.TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Copy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COPY_OPERATION_COUNT = StandardPackage.TRACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.sysml.requirements.internal.impl.SatisfyImpl <em>Satisfy</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.requirements.internal.impl.SatisfyImpl
	 * @see org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementsPackageImpl#getSatisfy()
	 * @generated
	 */
	int SATISFY = 3;

	/**
	 * The feature id for the '<em><b>Base Abstraction</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SATISFY__BASE_ABSTRACTION = StandardPackage.TRACE__BASE_ABSTRACTION;

	/**
	 * The number of structural features of the '<em>Satisfy</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SATISFY_FEATURE_COUNT = StandardPackage.TRACE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Satisfy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SATISFY_OPERATION_COUNT = StandardPackage.TRACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.sysml.requirements.internal.impl.TestCaseImpl <em>Test Case</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.requirements.internal.impl.TestCaseImpl
	 * @see org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementsPackageImpl#getTestCase()
	 * @generated
	 */
	int TEST_CASE = 4;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEST_CASE__BASE_BEHAVIOR = 0;

	/**
	 * The feature id for the '<em><b>Base Operation</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEST_CASE__BASE_OPERATION = 1;

	/**
	 * The feature id for the '<em><b>Verifies</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEST_CASE__VERIFIES = 2;

	/**
	 * The number of structural features of the '<em>Test Case</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Test Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the ' {@link org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementImpl
	 * <em>Requirement</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementImpl
	 * @see org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementsPackageImpl#getRequirement()
	 * @generated
	 */
	int REQUIREMENT = 5;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__TEXT = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__ID = 1;

	/**
	 * The feature id for the '<em><b>Derived</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__DERIVED = 2;

	/**
	 * The feature id for the '<em><b>Derived From</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__DERIVED_FROM = 3;

	/**
	 * The feature id for the '<em><b>Satisfied By</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__SATISFIED_BY = 4;

	/**
	 * The feature id for the '<em><b>Refined By</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__REFINED_BY = 5;

	/**
	 * The feature id for the '<em><b>Traced To</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__TRACED_TO = 6;

	/**
	 * The feature id for the '<em><b>Verified By</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__VERIFIED_BY = 7;

	/**
	 * The feature id for the '<em><b>Master</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__MASTER = 8;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT__BASE_CLASS = 9;

	/**
	 * The number of structural features of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_FEATURE_COUNT = 10;

	/**
	 * The number of operations of the '<em>Requirement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementRelatedImpl <em>Requirement Related</em>}'
	 * class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementRelatedImpl
	 * @see org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementsPackageImpl#getRequirementRelated()
	 * @generated
	 */
	int REQUIREMENT_RELATED = 6;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_RELATED__BASE_NAMED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Traced From</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_RELATED__TRACED_FROM = 1;

	/**
	 * The feature id for the '<em><b>Satisfies</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_RELATED__SATISFIES = 2;

	/**
	 * The feature id for the '<em><b>Refines</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_RELATED__REFINES = 3;

	/**
	 * The feature id for the '<em><b>Verifies</b></em>' reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_RELATED__VERIFIES = 4;

	/**
	 * The number of structural features of the '<em>Requirement Related</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_RELATED_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Requirement Related</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int REQUIREMENT_RELATED_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class ' {@link org.eclipse.papyrus.sysml.requirements.Copy <em>Copy</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Copy</em>'.
	 * @see org.eclipse.papyrus.sysml.requirements.Copy
	 * @generated
	 */
	EClass getCopy();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.sysml.requirements.DeriveReqt <em>Derive Reqt</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Derive Reqt</em>'.
	 * @see org.eclipse.papyrus.sysml.requirements.DeriveReqt
	 * @generated
	 */
	EClass getDeriveReqt();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.sysml.requirements.Requirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Requirement</em>'.
	 * @see org.eclipse.papyrus.sysml.requirements.Requirement
	 * @generated
	 */
	EClass getRequirement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.requirements.Requirement#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.sysml.requirements.Requirement#getBase_Class()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_Base_Class();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.sysml.requirements.Requirement#getDerived <em>Derived</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Derived</em>'.
	 * @see org.eclipse.papyrus.sysml.requirements.Requirement#getDerived()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_Derived();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.sysml.requirements.Requirement#getDerivedFrom <em>Derived From</em>}
	 * '.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Derived From</em>'.
	 * @see org.eclipse.papyrus.sysml.requirements.Requirement#getDerivedFrom()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_DerivedFrom();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.sysml.requirements.Requirement#getId <em>Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see org.eclipse.papyrus.sysml.requirements.Requirement#getId()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_Id();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.requirements.Requirement#getMaster <em>Master</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Master</em>'.
	 * @see org.eclipse.papyrus.sysml.requirements.Requirement#getMaster()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_Master();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.sysml.requirements.Requirement#getRefinedBy <em>Refined By</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Refined By</em>'.
	 * @see org.eclipse.papyrus.sysml.requirements.Requirement#getRefinedBy()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_RefinedBy();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.sysml.requirements.Requirement#getSatisfiedBy <em>Satisfied By</em>}
	 * '.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Satisfied By</em>'.
	 * @see org.eclipse.papyrus.sysml.requirements.Requirement#getSatisfiedBy()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_SatisfiedBy();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.sysml.requirements.Requirement#getText <em>Text</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see org.eclipse.papyrus.sysml.requirements.Requirement#getText()
	 * @see #getRequirement()
	 * @generated
	 */
	EAttribute getRequirement_Text();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.sysml.requirements.Requirement#getTracedTo <em>Traced To</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Traced To</em>'.
	 * @see org.eclipse.papyrus.sysml.requirements.Requirement#getTracedTo()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_TracedTo();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.sysml.requirements.Requirement#getVerifiedBy <em>Verified By</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Verified By</em>'.
	 * @see org.eclipse.papyrus.sysml.requirements.Requirement#getVerifiedBy()
	 * @see #getRequirement()
	 * @generated
	 */
	EReference getRequirement_VerifiedBy();

	/**
	 * Returns the meta object for class ' {@link org.eclipse.papyrus.sysml.requirements.RequirementRelated
	 * <em>Requirement Related</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Requirement Related</em>'.
	 * @see org.eclipse.papyrus.sysml.requirements.RequirementRelated
	 * @generated
	 */
	EClass getRequirementRelated();

	/**
	 * Returns the meta object for the reference ' {@link org.eclipse.papyrus.sysml.requirements.RequirementRelated#getBase_NamedElement
	 * <em>Base Named Element</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the reference '<em>Base Named Element</em>'.
	 * @see org.eclipse.papyrus.sysml.requirements.RequirementRelated#getBase_NamedElement()
	 * @see #getRequirementRelated()
	 * @generated
	 */
	EReference getRequirementRelated_Base_NamedElement();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.sysml.requirements.RequirementRelated#getRefines <em>Refines</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Refines</em>'.
	 * @see org.eclipse.papyrus.sysml.requirements.RequirementRelated#getRefines()
	 * @see #getRequirementRelated()
	 * @generated
	 */
	EReference getRequirementRelated_Refines();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.sysml.requirements.RequirementRelated#getSatisfies
	 * <em>Satisfies</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Satisfies</em>'.
	 * @see org.eclipse.papyrus.sysml.requirements.RequirementRelated#getSatisfies()
	 * @see #getRequirementRelated()
	 * @generated
	 */
	EReference getRequirementRelated_Satisfies();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.sysml.requirements.RequirementRelated#getTracedFrom
	 * <em>Traced From</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Traced From</em>'.
	 * @see org.eclipse.papyrus.sysml.requirements.RequirementRelated#getTracedFrom()
	 * @see #getRequirementRelated()
	 * @generated
	 */
	EReference getRequirementRelated_TracedFrom();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.sysml.requirements.RequirementRelated#getVerifies <em>Verifies</em>}
	 * '.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Verifies</em>'.
	 * @see org.eclipse.papyrus.sysml.requirements.RequirementRelated#getVerifies()
	 * @see #getRequirementRelated()
	 * @generated
	 */
	EReference getRequirementRelated_Verifies();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RequirementsFactory getRequirementsFactory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.sysml.requirements.Satisfy <em>Satisfy</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Satisfy</em>'.
	 * @see org.eclipse.papyrus.sysml.requirements.Satisfy
	 * @generated
	 */
	EClass getSatisfy();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.sysml.requirements.TestCase <em>Test Case</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Test Case</em>'.
	 * @see org.eclipse.papyrus.sysml.requirements.TestCase
	 * @generated
	 */
	EClass getTestCase();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.requirements.TestCase#getBase_Behavior <em>Base Behavior</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Behavior</em>'.
	 * @see org.eclipse.papyrus.sysml.requirements.TestCase#getBase_Behavior()
	 * @see #getTestCase()
	 * @generated
	 */
	EReference getTestCase_Base_Behavior();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.requirements.TestCase#getBase_Operation <em>Base Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Operation</em>'.
	 * @see org.eclipse.papyrus.sysml.requirements.TestCase#getBase_Operation()
	 * @see #getTestCase()
	 * @generated
	 */
	EReference getTestCase_Base_Operation();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.sysml.requirements.TestCase#getVerifies <em>Verifies</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Verifies</em>'.
	 * @see org.eclipse.papyrus.sysml.requirements.TestCase#getVerifies()
	 * @see #getTestCase()
	 * @generated
	 */
	EReference getTestCase_Verifies();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.sysml.requirements.Verify <em>Verify</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Verify</em>'.
	 * @see org.eclipse.papyrus.sysml.requirements.Verify
	 * @generated
	 */
	EClass getVerify();

} // RequirementsPackage
