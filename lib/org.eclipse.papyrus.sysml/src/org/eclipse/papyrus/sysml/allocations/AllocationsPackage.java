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
package org.eclipse.papyrus.sysml.allocations;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.papyrus.sysml.allocations.AllocationsFactory
 * @model kind="package"
 * @generated
 */
public interface AllocationsPackage extends EPackage {

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
		 * The meta object literal for the ' {@link org.eclipse.papyrus.sysml.allocations.internal.impl.AllocateImpl
		 * <em>Allocate</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.eclipse.papyrus.sysml.allocations.internal.impl.AllocateImpl
		 * @see org.eclipse.papyrus.sysml.allocations.internal.impl.AllocationsPackageImpl#getAllocate()
		 * @generated
		 */
		EClass ALLOCATE = eINSTANCE.getAllocate();

		/**
		 * The meta object literal for the '<em><b>Base Abstraction</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ALLOCATE__BASE_ABSTRACTION = eINSTANCE.getAllocate_Base_Abstraction();

		/**
		 * The meta object literal for the ' {@link org.eclipse.papyrus.sysml.allocations.internal.impl.AllocatedImpl
		 * <em>Allocated</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.eclipse.papyrus.sysml.allocations.internal.impl.AllocatedImpl
		 * @see org.eclipse.papyrus.sysml.allocations.internal.impl.AllocationsPackageImpl#getAllocated()
		 * @generated
		 */
		EClass ALLOCATED = eINSTANCE.getAllocated();

		/**
		 * The meta object literal for the '<em><b>Base Named Element</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ALLOCATED__BASE_NAMED_ELEMENT = eINSTANCE.getAllocated_Base_NamedElement();

		/**
		 * The meta object literal for the '<em><b>Allocated From</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ALLOCATED__ALLOCATED_FROM = eINSTANCE.getAllocated_AllocatedFrom();

		/**
		 * The meta object literal for the '<em><b>Allocated To</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ALLOCATED__ALLOCATED_TO = eINSTANCE.getAllocated_AllocatedTo();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.sysml.allocations.internal.impl.AllocateActivityPartitionImpl
		 * <em>Allocate Activity Partition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.sysml.allocations.internal.impl.AllocateActivityPartitionImpl
		 * @see org.eclipse.papyrus.sysml.allocations.internal.impl.AllocationsPackageImpl#getAllocateActivityPartition()
		 * @generated
		 */
		EClass ALLOCATE_ACTIVITY_PARTITION = eINSTANCE.getAllocateActivityPartition();

		/**
		 * The meta object literal for the ' <em><b>Base Activity Partition</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ALLOCATE_ACTIVITY_PARTITION__BASE_ACTIVITY_PARTITION = eINSTANCE.getAllocateActivityPartition_Base_ActivityPartition();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "allocations";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/0.7.0/SysML/Allocations";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "Allocations";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	AllocationsPackage eINSTANCE = org.eclipse.papyrus.sysml.allocations.internal.impl.AllocationsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.sysml.allocations.internal.impl.AllocateImpl <em>Allocate</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.allocations.internal.impl.AllocateImpl
	 * @see org.eclipse.papyrus.sysml.allocations.internal.impl.AllocationsPackageImpl#getAllocate()
	 * @generated
	 */
	int ALLOCATE = 0;

	/**
	 * The feature id for the '<em><b>Base Abstraction</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALLOCATE__BASE_ABSTRACTION = 0;

	/**
	 * The number of structural features of the '<em>Allocate</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALLOCATE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Allocate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALLOCATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.sysml.allocations.internal.impl.AllocatedImpl <em>Allocated</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.allocations.internal.impl.AllocatedImpl
	 * @see org.eclipse.papyrus.sysml.allocations.internal.impl.AllocationsPackageImpl#getAllocated()
	 * @generated
	 */
	int ALLOCATED = 1;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALLOCATED__BASE_NAMED_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Allocated From</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALLOCATED__ALLOCATED_FROM = 1;

	/**
	 * The feature id for the '<em><b>Allocated To</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALLOCATED__ALLOCATED_TO = 2;

	/**
	 * The number of structural features of the '<em>Allocated</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALLOCATED_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Allocated</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALLOCATED_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.sysml.allocations.internal.impl.AllocateActivityPartitionImpl
	 * <em>Allocate Activity Partition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.allocations.internal.impl.AllocateActivityPartitionImpl
	 * @see org.eclipse.papyrus.sysml.allocations.internal.impl.AllocationsPackageImpl#getAllocateActivityPartition()
	 * @generated
	 */
	int ALLOCATE_ACTIVITY_PARTITION = 2;

	/**
	 * The feature id for the '<em><b>Base Activity Partition</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALLOCATE_ACTIVITY_PARTITION__BASE_ACTIVITY_PARTITION = 0;

	/**
	 * The number of structural features of the '<em>Allocate Activity Partition</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALLOCATE_ACTIVITY_PARTITION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Allocate Activity Partition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALLOCATE_ACTIVITY_PARTITION_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.sysml.allocations.Allocate <em>Allocate</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Allocate</em>'.
	 * @see org.eclipse.papyrus.sysml.allocations.Allocate
	 * @generated
	 */
	EClass getAllocate();

	/**
	 * Returns the meta object for the reference ' {@link org.eclipse.papyrus.sysml.allocations.Allocate#getBase_Abstraction
	 * <em>Base Abstraction</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the reference '<em>Base Abstraction</em>'.
	 * @see org.eclipse.papyrus.sysml.allocations.Allocate#getBase_Abstraction()
	 * @see #getAllocate()
	 * @generated
	 */
	EReference getAllocate_Base_Abstraction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.sysml.allocations.AllocateActivityPartition <em>Allocate Activity Partition</em>}
	 * '.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Allocate Activity Partition</em>'.
	 * @see org.eclipse.papyrus.sysml.allocations.AllocateActivityPartition
	 * @generated
	 */
	EClass getAllocateActivityPartition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.allocations.AllocateActivityPartition#getBase_ActivityPartition
	 * <em>Base Activity Partition</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Activity Partition</em>'.
	 * @see org.eclipse.papyrus.sysml.allocations.AllocateActivityPartition#getBase_ActivityPartition()
	 * @see #getAllocateActivityPartition()
	 * @generated
	 */
	EReference getAllocateActivityPartition_Base_ActivityPartition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.sysml.allocations.Allocated <em>Allocated</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Allocated</em>'.
	 * @see org.eclipse.papyrus.sysml.allocations.Allocated
	 * @generated
	 */
	EClass getAllocated();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.sysml.allocations.Allocated#getAllocatedFrom
	 * <em>Allocated From</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Allocated From</em>'.
	 * @see org.eclipse.papyrus.sysml.allocations.Allocated#getAllocatedFrom()
	 * @see #getAllocated()
	 * @generated
	 */
	EReference getAllocated_AllocatedFrom();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.sysml.allocations.Allocated#getAllocatedTo <em>Allocated To</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Allocated To</em>'.
	 * @see org.eclipse.papyrus.sysml.allocations.Allocated#getAllocatedTo()
	 * @see #getAllocated()
	 * @generated
	 */
	EReference getAllocated_AllocatedTo();

	/**
	 * Returns the meta object for the reference ' {@link org.eclipse.papyrus.sysml.allocations.Allocated#getBase_NamedElement
	 * <em>Base Named Element</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the reference '<em>Base Named Element</em>'.
	 * @see org.eclipse.papyrus.sysml.allocations.Allocated#getBase_NamedElement()
	 * @see #getAllocated()
	 * @generated
	 */
	EReference getAllocated_Base_NamedElement();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AllocationsFactory getAllocationsFactory();

} // AllocationsPackage
