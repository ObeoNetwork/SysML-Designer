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
 * @see org.eclipse.papyrus.sysml.activities.ActivitiesFactory
 * @model kind="package"
 * @generated
 */
public interface ActivitiesPackage extends EPackage {

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
		 * The meta object literal for the ' {@link org.eclipse.papyrus.sysml.activities.internal.impl.OptionalImpl
		 * <em>Optional</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.eclipse.papyrus.sysml.activities.internal.impl.OptionalImpl
		 * @see org.eclipse.papyrus.sysml.activities.internal.impl.ActivitiesPackageImpl#getOptional()
		 * @generated
		 */
		EClass OPTIONAL = eINSTANCE.getOptional();

		/**
		 * The meta object literal for the '<em><b>Base Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OPTIONAL__BASE_PARAMETER = eINSTANCE.getOptional_Base_Parameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.sysml.activities.internal.impl.RateImpl <em>Rate</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.sysml.activities.internal.impl.RateImpl
		 * @see org.eclipse.papyrus.sysml.activities.internal.impl.ActivitiesPackageImpl#getRate()
		 * @generated
		 */
		EClass RATE = eINSTANCE.getRate();

		/**
		 * The meta object literal for the '<em><b>Base Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference RATE__BASE_PARAMETER = eINSTANCE.getRate_Base_Parameter();

		/**
		 * The meta object literal for the '<em><b>Base Activity Edge</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference RATE__BASE_ACTIVITY_EDGE = eINSTANCE.getRate_Base_ActivityEdge();

		/**
		 * The meta object literal for the '<em><b>Rate</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference RATE__RATE = eINSTANCE.getRate_Rate();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.sysml.activities.internal.impl.ProbabilityImpl <em>Probability</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.sysml.activities.internal.impl.ProbabilityImpl
		 * @see org.eclipse.papyrus.sysml.activities.internal.impl.ActivitiesPackageImpl#getProbability()
		 * @generated
		 */
		EClass PROBABILITY = eINSTANCE.getProbability();

		/**
		 * The meta object literal for the '<em><b>Base Activity Edge</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROBABILITY__BASE_ACTIVITY_EDGE = eINSTANCE.getProbability_Base_ActivityEdge();

		/**
		 * The meta object literal for the '<em><b>Base Parameter Set</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROBABILITY__BASE_PARAMETER_SET = eINSTANCE.getProbability_Base_ParameterSet();

		/**
		 * The meta object literal for the '<em><b>Probability</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROBABILITY__PROBABILITY = eINSTANCE.getProbability_Probability();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.sysml.activities.internal.impl.ContinuousImpl <em>Continuous</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.sysml.activities.internal.impl.ContinuousImpl
		 * @see org.eclipse.papyrus.sysml.activities.internal.impl.ActivitiesPackageImpl#getContinuous()
		 * @generated
		 */
		EClass CONTINUOUS = eINSTANCE.getContinuous();

		/**
		 * The meta object literal for the ' {@link org.eclipse.papyrus.sysml.activities.internal.impl.DiscreteImpl
		 * <em>Discrete</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.eclipse.papyrus.sysml.activities.internal.impl.DiscreteImpl
		 * @see org.eclipse.papyrus.sysml.activities.internal.impl.ActivitiesPackageImpl#getDiscrete()
		 * @generated
		 */
		EClass DISCRETE = eINSTANCE.getDiscrete();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.sysml.activities.internal.impl.ControlOperatorImpl <em>Control Operator</em>}'
		 * class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.sysml.activities.internal.impl.ControlOperatorImpl
		 * @see org.eclipse.papyrus.sysml.activities.internal.impl.ActivitiesPackageImpl#getControlOperator()
		 * @generated
		 */
		EClass CONTROL_OPERATOR = eINSTANCE.getControlOperator();

		/**
		 * The meta object literal for the '<em><b>Base Operation</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONTROL_OPERATOR__BASE_OPERATION = eINSTANCE.getControlOperator_Base_Operation();

		/**
		 * The meta object literal for the '<em><b>Base Behavior</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONTROL_OPERATOR__BASE_BEHAVIOR = eINSTANCE.getControlOperator_Base_Behavior();

		/**
		 * The meta object literal for the ' {@link org.eclipse.papyrus.sysml.activities.internal.impl.NoBufferImpl
		 * <em>No Buffer</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.eclipse.papyrus.sysml.activities.internal.impl.NoBufferImpl
		 * @see org.eclipse.papyrus.sysml.activities.internal.impl.ActivitiesPackageImpl#getNoBuffer()
		 * @generated
		 */
		EClass NO_BUFFER = eINSTANCE.getNoBuffer();

		/**
		 * The meta object literal for the '<em><b>Base Object Node</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference NO_BUFFER__BASE_OBJECT_NODE = eINSTANCE.getNoBuffer_Base_ObjectNode();

		/**
		 * The meta object literal for the ' {@link org.eclipse.papyrus.sysml.activities.internal.impl.OverwriteImpl
		 * <em>Overwrite</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.eclipse.papyrus.sysml.activities.internal.impl.OverwriteImpl
		 * @see org.eclipse.papyrus.sysml.activities.internal.impl.ActivitiesPackageImpl#getOverwrite()
		 * @generated
		 */
		EClass OVERWRITE = eINSTANCE.getOverwrite();

		/**
		 * The meta object literal for the '<em><b>Base Object Node</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference OVERWRITE__BASE_OBJECT_NODE = eINSTANCE.getOverwrite_Base_ObjectNode();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "activities";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/0.7.0/SysML/Activities";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "Activities";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	ActivitiesPackage eINSTANCE = org.eclipse.papyrus.sysml.activities.internal.impl.ActivitiesPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.sysml.activities.internal.impl.OptionalImpl <em>Optional</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.activities.internal.impl.OptionalImpl
	 * @see org.eclipse.papyrus.sysml.activities.internal.impl.ActivitiesPackageImpl#getOptional()
	 * @generated
	 */
	int OPTIONAL = 0;

	/**
	 * The feature id for the '<em><b>Base Parameter</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPTIONAL__BASE_PARAMETER = 0;

	/**
	 * The number of structural features of the '<em>Optional</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Optional</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OPTIONAL_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.sysml.activities.internal.impl.RateImpl <em>Rate</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.activities.internal.impl.RateImpl
	 * @see org.eclipse.papyrus.sysml.activities.internal.impl.ActivitiesPackageImpl#getRate()
	 * @generated
	 */
	int RATE = 1;

	/**
	 * The feature id for the '<em><b>Base Parameter</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RATE__BASE_PARAMETER = 0;

	/**
	 * The feature id for the '<em><b>Base Activity Edge</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RATE__BASE_ACTIVITY_EDGE = 1;

	/**
	 * The feature id for the '<em><b>Rate</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RATE__RATE = 2;

	/**
	 * The number of structural features of the '<em>Rate</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RATE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Rate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the ' {@link org.eclipse.papyrus.sysml.activities.internal.impl.ProbabilityImpl
	 * <em>Probability</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.papyrus.sysml.activities.internal.impl.ProbabilityImpl
	 * @see org.eclipse.papyrus.sysml.activities.internal.impl.ActivitiesPackageImpl#getProbability()
	 * @generated
	 */
	int PROBABILITY = 2;

	/**
	 * The feature id for the '<em><b>Base Activity Edge</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROBABILITY__BASE_ACTIVITY_EDGE = 0;

	/**
	 * The feature id for the '<em><b>Base Parameter Set</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROBABILITY__BASE_PARAMETER_SET = 1;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROBABILITY__PROBABILITY = 2;

	/**
	 * The number of structural features of the '<em>Probability</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROBABILITY_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Probability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROBABILITY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the ' {@link org.eclipse.papyrus.sysml.activities.internal.impl.ContinuousImpl
	 * <em>Continuous</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.papyrus.sysml.activities.internal.impl.ContinuousImpl
	 * @see org.eclipse.papyrus.sysml.activities.internal.impl.ActivitiesPackageImpl#getContinuous()
	 * @generated
	 */
	int CONTINUOUS = 3;

	/**
	 * The feature id for the '<em><b>Base Parameter</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS__BASE_PARAMETER = RATE__BASE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Base Activity Edge</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS__BASE_ACTIVITY_EDGE = RATE__BASE_ACTIVITY_EDGE;

	/**
	 * The feature id for the '<em><b>Rate</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS__RATE = RATE__RATE;

	/**
	 * The number of structural features of the '<em>Continuous</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS_FEATURE_COUNT = RATE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Continuous</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTINUOUS_OPERATION_COUNT = RATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.sysml.activities.internal.impl.DiscreteImpl <em>Discrete</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.activities.internal.impl.DiscreteImpl
	 * @see org.eclipse.papyrus.sysml.activities.internal.impl.ActivitiesPackageImpl#getDiscrete()
	 * @generated
	 */
	int DISCRETE = 4;

	/**
	 * The feature id for the '<em><b>Base Parameter</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DISCRETE__BASE_PARAMETER = RATE__BASE_PARAMETER;

	/**
	 * The feature id for the '<em><b>Base Activity Edge</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DISCRETE__BASE_ACTIVITY_EDGE = RATE__BASE_ACTIVITY_EDGE;

	/**
	 * The feature id for the '<em><b>Rate</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DISCRETE__RATE = RATE__RATE;

	/**
	 * The number of structural features of the '<em>Discrete</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DISCRETE_FEATURE_COUNT = RATE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Discrete</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DISCRETE_OPERATION_COUNT = RATE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.sysml.activities.internal.impl.ControlOperatorImpl <em>Control Operator</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.activities.internal.impl.ControlOperatorImpl
	 * @see org.eclipse.papyrus.sysml.activities.internal.impl.ActivitiesPackageImpl#getControlOperator()
	 * @generated
	 */
	int CONTROL_OPERATOR = 5;

	/**
	 * The feature id for the '<em><b>Base Operation</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTROL_OPERATOR__BASE_OPERATION = 0;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTROL_OPERATOR__BASE_BEHAVIOR = 1;

	/**
	 * The number of structural features of the '<em>Control Operator</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTROL_OPERATOR_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Control Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONTROL_OPERATOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.sysml.activities.internal.impl.NoBufferImpl <em>No Buffer</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.activities.internal.impl.NoBufferImpl
	 * @see org.eclipse.papyrus.sysml.activities.internal.impl.ActivitiesPackageImpl#getNoBuffer()
	 * @generated
	 */
	int NO_BUFFER = 6;

	/**
	 * The feature id for the '<em><b>Base Object Node</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NO_BUFFER__BASE_OBJECT_NODE = 0;

	/**
	 * The number of structural features of the '<em>No Buffer</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NO_BUFFER_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>No Buffer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NO_BUFFER_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.sysml.activities.internal.impl.OverwriteImpl <em>Overwrite</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.activities.internal.impl.OverwriteImpl
	 * @see org.eclipse.papyrus.sysml.activities.internal.impl.ActivitiesPackageImpl#getOverwrite()
	 * @generated
	 */
	int OVERWRITE = 7;

	/**
	 * The feature id for the '<em><b>Base Object Node</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OVERWRITE__BASE_OBJECT_NODE = 0;

	/**
	 * The number of structural features of the '<em>Overwrite</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OVERWRITE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Overwrite</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OVERWRITE_OPERATION_COUNT = 0;

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ActivitiesFactory getActivitiesFactory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.sysml.activities.Continuous <em>Continuous</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Continuous</em>'.
	 * @see org.eclipse.papyrus.sysml.activities.Continuous
	 * @generated
	 */
	EClass getContinuous();

	/**
	 * Returns the meta object for class ' {@link org.eclipse.papyrus.sysml.activities.ControlOperator
	 * <em>Control Operator</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Control Operator</em>'.
	 * @see org.eclipse.papyrus.sysml.activities.ControlOperator
	 * @generated
	 */
	EClass getControlOperator();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.activities.ControlOperator#getBase_Behavior <em>Base Behavior</em>}
	 * '.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Behavior</em>'.
	 * @see org.eclipse.papyrus.sysml.activities.ControlOperator#getBase_Behavior()
	 * @see #getControlOperator()
	 * @generated
	 */
	EReference getControlOperator_Base_Behavior();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.activities.ControlOperator#getBase_Operation
	 * <em>Base Operation</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Operation</em>'.
	 * @see org.eclipse.papyrus.sysml.activities.ControlOperator#getBase_Operation()
	 * @see #getControlOperator()
	 * @generated
	 */
	EReference getControlOperator_Base_Operation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.sysml.activities.Discrete <em>Discrete</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Discrete</em>'.
	 * @see org.eclipse.papyrus.sysml.activities.Discrete
	 * @generated
	 */
	EClass getDiscrete();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.sysml.activities.NoBuffer <em>No Buffer</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for class '<em>No Buffer</em>'.
	 * @see org.eclipse.papyrus.sysml.activities.NoBuffer
	 * @generated
	 */
	EClass getNoBuffer();

	/**
	 * Returns the meta object for the reference ' {@link org.eclipse.papyrus.sysml.activities.NoBuffer#getBase_ObjectNode
	 * <em>Base Object Node</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the reference '<em>Base Object Node</em>'.
	 * @see org.eclipse.papyrus.sysml.activities.NoBuffer#getBase_ObjectNode()
	 * @see #getNoBuffer()
	 * @generated
	 */
	EReference getNoBuffer_Base_ObjectNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.sysml.activities.Optional <em>Optional</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Optional</em>'.
	 * @see org.eclipse.papyrus.sysml.activities.Optional
	 * @generated
	 */
	EClass getOptional();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.activities.Optional#getBase_Parameter <em>Base Parameter</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Parameter</em>'.
	 * @see org.eclipse.papyrus.sysml.activities.Optional#getBase_Parameter()
	 * @see #getOptional()
	 * @generated
	 */
	EReference getOptional_Base_Parameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.sysml.activities.Overwrite <em>Overwrite</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Overwrite</em>'.
	 * @see org.eclipse.papyrus.sysml.activities.Overwrite
	 * @generated
	 */
	EClass getOverwrite();

	/**
	 * Returns the meta object for the reference ' {@link org.eclipse.papyrus.sysml.activities.Overwrite#getBase_ObjectNode
	 * <em>Base Object Node</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the reference '<em>Base Object Node</em>'.
	 * @see org.eclipse.papyrus.sysml.activities.Overwrite#getBase_ObjectNode()
	 * @see #getOverwrite()
	 * @generated
	 */
	EReference getOverwrite_Base_ObjectNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.sysml.activities.Probability <em>Probability</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Probability</em>'.
	 * @see org.eclipse.papyrus.sysml.activities.Probability
	 * @generated
	 */
	EClass getProbability();

	/**
	 * Returns the meta object for the reference ' {@link org.eclipse.papyrus.sysml.activities.Probability#getBase_ActivityEdge
	 * <em>Base Activity Edge</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the reference '<em>Base Activity Edge</em>'.
	 * @see org.eclipse.papyrus.sysml.activities.Probability#getBase_ActivityEdge()
	 * @see #getProbability()
	 * @generated
	 */
	EReference getProbability_Base_ActivityEdge();

	/**
	 * Returns the meta object for the reference ' {@link org.eclipse.papyrus.sysml.activities.Probability#getBase_ParameterSet
	 * <em>Base Parameter Set</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the reference '<em>Base Parameter Set</em>'.
	 * @see org.eclipse.papyrus.sysml.activities.Probability#getBase_ParameterSet()
	 * @see #getProbability()
	 * @generated
	 */
	EReference getProbability_Base_ParameterSet();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.activities.Probability#getProbability <em>Probability</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Probability</em>'.
	 * @see org.eclipse.papyrus.sysml.activities.Probability#getProbability()
	 * @see #getProbability()
	 * @generated
	 */
	EReference getProbability_Probability();

	/**
	 * Returns the meta object for class ' {@link org.eclipse.papyrus.sysml.activities.Rate <em>Rate</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Rate</em>'.
	 * @see org.eclipse.papyrus.sysml.activities.Rate
	 * @generated
	 */
	EClass getRate();

	/**
	 * Returns the meta object for the reference ' {@link org.eclipse.papyrus.sysml.activities.Rate#getBase_ActivityEdge
	 * <em>Base Activity Edge</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the reference '<em>Base Activity Edge</em>'.
	 * @see org.eclipse.papyrus.sysml.activities.Rate#getBase_ActivityEdge()
	 * @see #getRate()
	 * @generated
	 */
	EReference getRate_Base_ActivityEdge();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.activities.Rate#getBase_Parameter <em>Base Parameter</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Parameter</em>'.
	 * @see org.eclipse.papyrus.sysml.activities.Rate#getBase_Parameter()
	 * @see #getRate()
	 * @generated
	 */
	EReference getRate_Base_Parameter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.activities.Rate#getRate <em>Rate</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Rate</em>'.
	 * @see org.eclipse.papyrus.sysml.activities.Rate#getRate()
	 * @see #getRate()
	 * @generated
	 */
	EReference getRate_Rate();

} // ActivitiesPackage
