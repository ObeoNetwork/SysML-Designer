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
package org.eclipse.papyrus.sysml.constraints;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.sysml.blocks.BlocksPackage;

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
 * @see org.eclipse.papyrus.sysml.constraints.ConstraintsFactory
 * @model kind="package"
 * @generated
 */
public interface ConstraintsPackage extends EPackage {

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.sysml.constraints.internal.impl.ConstraintBlockImpl <em>Constraint Block</em>}'
		 * class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.sysml.constraints.internal.impl.ConstraintBlockImpl
		 * @see org.eclipse.papyrus.sysml.constraints.internal.impl.ConstraintsPackageImpl#getConstraintBlock()
		 * @generated
		 */
		EClass CONSTRAINT_BLOCK = eINSTANCE.getConstraintBlock();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.sysml.constraints.internal.impl.ConstraintPropertyImpl
		 * <em>Constraint Property</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.sysml.constraints.internal.impl.ConstraintPropertyImpl
		 * @see org.eclipse.papyrus.sysml.constraints.internal.impl.ConstraintsPackageImpl#getConstraintProperty()
		 * @generated
		 */
		EClass CONSTRAINT_PROPERTY = eINSTANCE.getConstraintProperty();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONSTRAINT_PROPERTY__BASE_PROPERTY = eINSTANCE.getConstraintProperty_Base_Property();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "constraints";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/0.7.0/SysML/Constraints";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "Constraints";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	ConstraintsPackage eINSTANCE = org.eclipse.papyrus.sysml.constraints.internal.impl.ConstraintsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.sysml.constraints.internal.impl.ConstraintBlockImpl <em>Constraint Block</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.constraints.internal.impl.ConstraintBlockImpl
	 * @see org.eclipse.papyrus.sysml.constraints.internal.impl.ConstraintsPackageImpl#getConstraintBlock()
	 * @generated
	 */
	int CONSTRAINT_BLOCK = 0;

	/**
	 * The feature id for the '<em><b>Is Encapsulated</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_BLOCK__IS_ENCAPSULATED = BlocksPackage.BLOCK__IS_ENCAPSULATED;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_BLOCK__BASE_CLASS = BlocksPackage.BLOCK__BASE_CLASS;

	/**
	 * The number of structural features of the '<em>Constraint Block</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_BLOCK_FEATURE_COUNT = BlocksPackage.BLOCK_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Constraint Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_BLOCK_OPERATION_COUNT = BlocksPackage.BLOCK_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.sysml.constraints.internal.impl.ConstraintPropertyImpl <em>Constraint Property</em>}'
	 * class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.constraints.internal.impl.ConstraintPropertyImpl
	 * @see org.eclipse.papyrus.sysml.constraints.internal.impl.ConstraintsPackageImpl#getConstraintProperty()
	 * @generated
	 */
	int CONSTRAINT_PROPERTY = 1;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_PROPERTY__BASE_PROPERTY = 0;

	/**
	 * The number of structural features of the '<em>Constraint Property</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_PROPERTY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Constraint Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_PROPERTY_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class ' {@link org.eclipse.papyrus.sysml.constraints.ConstraintBlock
	 * <em>Constraint Block</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Constraint Block</em>'.
	 * @see org.eclipse.papyrus.sysml.constraints.ConstraintBlock
	 * @generated
	 */
	EClass getConstraintBlock();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.sysml.constraints.ConstraintProperty <em>Constraint Property</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Constraint Property</em>'.
	 * @see org.eclipse.papyrus.sysml.constraints.ConstraintProperty
	 * @generated
	 */
	EClass getConstraintProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.constraints.ConstraintProperty#getBase_Property
	 * <em>Base Property</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.sysml.constraints.ConstraintProperty#getBase_Property()
	 * @see #getConstraintProperty()
	 * @generated
	 */
	EReference getConstraintProperty_Base_Property();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ConstraintsFactory getConstraintsFactory();

} // ConstraintsPackage
