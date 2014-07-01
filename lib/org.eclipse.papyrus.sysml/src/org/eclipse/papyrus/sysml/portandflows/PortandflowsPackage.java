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
package org.eclipse.papyrus.sysml.portandflows;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
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
 * @see org.eclipse.papyrus.sysml.portandflows.PortandflowsFactory
 * @model kind="package"
 * @generated
 */
public interface PortandflowsPackage extends EPackage {

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
		 * The meta object literal for the ' {@link org.eclipse.papyrus.sysml.portandflows.internal.impl.FlowPortImpl
		 * <em>Flow Port</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.eclipse.papyrus.sysml.portandflows.internal.impl.FlowPortImpl
		 * @see org.eclipse.papyrus.sysml.portandflows.internal.impl.PortandflowsPackageImpl#getFlowPort()
		 * @generated
		 */
		EClass FLOW_PORT = eINSTANCE.getFlowPort();

		/**
		 * The meta object literal for the '<em><b>Base Port</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FLOW_PORT__BASE_PORT = eINSTANCE.getFlowPort_Base_Port();

		/**
		 * The meta object literal for the '<em><b>Is Atomic</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute FLOW_PORT__IS_ATOMIC = eINSTANCE.getFlowPort_IsAtomic();

		/**
		 * The meta object literal for the '<em><b>Is Conjugated</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute FLOW_PORT__IS_CONJUGATED = eINSTANCE.getFlowPort_IsConjugated();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute FLOW_PORT__DIRECTION = eINSTANCE.getFlowPort_Direction();

		/**
		 * The meta object literal for the '<em><b>Get Icon</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EOperation FLOW_PORT___GET_ICON = eINSTANCE.getFlowPort__GetIcon();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.sysml.portandflows.internal.impl.FlowPropertyImpl <em>Flow Property</em>}'
		 * class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.sysml.portandflows.internal.impl.FlowPropertyImpl
		 * @see org.eclipse.papyrus.sysml.portandflows.internal.impl.PortandflowsPackageImpl#getFlowProperty()
		 * @generated
		 */
		EClass FLOW_PROPERTY = eINSTANCE.getFlowProperty();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FLOW_PROPERTY__BASE_PROPERTY = eINSTANCE.getFlowProperty_Base_Property();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute FLOW_PROPERTY__DIRECTION = eINSTANCE.getFlowProperty_Direction();

		/**
		 * The meta object literal for the '<em><b>Get Icon</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EOperation FLOW_PROPERTY___GET_ICON = eINSTANCE.getFlowProperty__GetIcon();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.sysml.portandflows.internal.impl.FlowSpecificationImpl
		 * <em>Flow Specification</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.sysml.portandflows.internal.impl.FlowSpecificationImpl
		 * @see org.eclipse.papyrus.sysml.portandflows.internal.impl.PortandflowsPackageImpl#getFlowSpecification()
		 * @generated
		 */
		EClass FLOW_SPECIFICATION = eINSTANCE.getFlowSpecification();

		/**
		 * The meta object literal for the '<em><b>Base Interface</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference FLOW_SPECIFICATION__BASE_INTERFACE = eINSTANCE.getFlowSpecification_Base_Interface();

		/**
		 * The meta object literal for the ' {@link org.eclipse.papyrus.sysml.portandflows.internal.impl.ItemFlowImpl
		 * <em>Item Flow</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.eclipse.papyrus.sysml.portandflows.internal.impl.ItemFlowImpl
		 * @see org.eclipse.papyrus.sysml.portandflows.internal.impl.PortandflowsPackageImpl#getItemFlow()
		 * @generated
		 */
		EClass ITEM_FLOW = eINSTANCE.getItemFlow();

		/**
		 * The meta object literal for the ' <em><b>Base Information Flow</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ITEM_FLOW__BASE_INFORMATION_FLOW = eINSTANCE.getItemFlow_Base_InformationFlow();

		/**
		 * The meta object literal for the '<em><b>Item Property</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ITEM_FLOW__ITEM_PROPERTY = eINSTANCE.getItemFlow_ItemProperty();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.sysml.portandflows.FlowDirection <em>Flow Direction</em>}' enum.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.sysml.portandflows.FlowDirection
		 * @see org.eclipse.papyrus.sysml.portandflows.internal.impl.PortandflowsPackageImpl#getFlowDirection()
		 * @generated
		 */
		EEnum FLOW_DIRECTION = eINSTANCE.getFlowDirection();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "portandflows";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/0.7.0/SysML/PortAndFlows";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "PortAndFlows";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	PortandflowsPackage eINSTANCE = org.eclipse.papyrus.sysml.portandflows.internal.impl.PortandflowsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.sysml.portandflows.internal.impl.FlowPortImpl <em>Flow Port</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.portandflows.internal.impl.FlowPortImpl
	 * @see org.eclipse.papyrus.sysml.portandflows.internal.impl.PortandflowsPackageImpl#getFlowPort()
	 * @generated
	 */
	int FLOW_PORT = 0;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FLOW_PORT__BASE_PORT = 0;

	/**
	 * The feature id for the '<em><b>Is Atomic</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FLOW_PORT__IS_ATOMIC = 1;

	/**
	 * The feature id for the '<em><b>Is Conjugated</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FLOW_PORT__IS_CONJUGATED = 2;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FLOW_PORT__DIRECTION = 3;

	/**
	 * The number of structural features of the '<em>Flow Port</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FLOW_PORT_FEATURE_COUNT = 4;

	/**
	 * The operation id for the '<em>Get Icon</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FLOW_PORT___GET_ICON = 0;

	/**
	 * The number of operations of the '<em>Flow Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FLOW_PORT_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the ' {@link org.eclipse.papyrus.sysml.portandflows.internal.impl.FlowPropertyImpl
	 * <em>Flow Property</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.papyrus.sysml.portandflows.internal.impl.FlowPropertyImpl
	 * @see org.eclipse.papyrus.sysml.portandflows.internal.impl.PortandflowsPackageImpl#getFlowProperty()
	 * @generated
	 */
	int FLOW_PROPERTY = 1;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FLOW_PROPERTY__BASE_PROPERTY = 0;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FLOW_PROPERTY__DIRECTION = 1;

	/**
	 * The number of structural features of the '<em>Flow Property</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FLOW_PROPERTY_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Get Icon</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FLOW_PROPERTY___GET_ICON = 0;

	/**
	 * The number of operations of the '<em>Flow Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FLOW_PROPERTY_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.sysml.portandflows.internal.impl.FlowSpecificationImpl <em>Flow Specification</em>}'
	 * class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.portandflows.internal.impl.FlowSpecificationImpl
	 * @see org.eclipse.papyrus.sysml.portandflows.internal.impl.PortandflowsPackageImpl#getFlowSpecification()
	 * @generated
	 */
	int FLOW_SPECIFICATION = 2;

	/**
	 * The feature id for the '<em><b>Base Interface</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FLOW_SPECIFICATION__BASE_INTERFACE = 0;

	/**
	 * The number of structural features of the '<em>Flow Specification</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FLOW_SPECIFICATION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Flow Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FLOW_SPECIFICATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.sysml.portandflows.internal.impl.ItemFlowImpl <em>Item Flow</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.portandflows.internal.impl.ItemFlowImpl
	 * @see org.eclipse.papyrus.sysml.portandflows.internal.impl.PortandflowsPackageImpl#getItemFlow()
	 * @generated
	 */
	int ITEM_FLOW = 3;

	/**
	 * The feature id for the '<em><b>Base Information Flow</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITEM_FLOW__BASE_INFORMATION_FLOW = 0;

	/**
	 * The feature id for the '<em><b>Item Property</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITEM_FLOW__ITEM_PROPERTY = 1;

	/**
	 * The number of structural features of the '<em>Item Flow</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITEM_FLOW_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Item Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ITEM_FLOW_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the ' {@link org.eclipse.papyrus.sysml.portandflows.FlowDirection
	 * <em>Flow Direction</em>}' enum. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.papyrus.sysml.portandflows.FlowDirection
	 * @see org.eclipse.papyrus.sysml.portandflows.internal.impl.PortandflowsPackageImpl#getFlowDirection()
	 * @generated
	 */
	int FLOW_DIRECTION = 4;

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.sysml.portandflows.FlowDirection <em>Flow Direction</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Flow Direction</em>'.
	 * @see org.eclipse.papyrus.sysml.portandflows.FlowDirection
	 * @generated
	 */
	EEnum getFlowDirection();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.sysml.portandflows.FlowPort <em>Flow Port</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Flow Port</em>'.
	 * @see org.eclipse.papyrus.sysml.portandflows.FlowPort
	 * @generated
	 */
	EClass getFlowPort();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.portandflows.FlowPort#getBase_Port <em>Base Port</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Port</em>'.
	 * @see org.eclipse.papyrus.sysml.portandflows.FlowPort#getBase_Port()
	 * @see #getFlowPort()
	 * @generated
	 */
	EReference getFlowPort_Base_Port();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.sysml.portandflows.FlowPort#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see org.eclipse.papyrus.sysml.portandflows.FlowPort#getDirection()
	 * @see #getFlowPort()
	 * @generated
	 */
	EAttribute getFlowPort_Direction();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.sysml.portandflows.FlowPort#getIcon() <em>Get Icon</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the '<em>Get Icon</em>' operation.
	 * @see org.eclipse.papyrus.sysml.portandflows.FlowPort#getIcon()
	 * @generated
	 */
	EOperation getFlowPort__GetIcon();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.sysml.portandflows.FlowPort#isAtomic <em>Is Atomic</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Is Atomic</em>'.
	 * @see org.eclipse.papyrus.sysml.portandflows.FlowPort#isAtomic()
	 * @see #getFlowPort()
	 * @generated
	 */
	EAttribute getFlowPort_IsAtomic();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.sysml.portandflows.FlowPort#isConjugated <em>Is Conjugated</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Is Conjugated</em>'.
	 * @see org.eclipse.papyrus.sysml.portandflows.FlowPort#isConjugated()
	 * @see #getFlowPort()
	 * @generated
	 */
	EAttribute getFlowPort_IsConjugated();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.sysml.portandflows.FlowProperty <em>Flow Property</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Flow Property</em>'.
	 * @see org.eclipse.papyrus.sysml.portandflows.FlowProperty
	 * @generated
	 */
	EClass getFlowProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.portandflows.FlowProperty#getBase_Property <em>Base Property</em>}
	 * '.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.sysml.portandflows.FlowProperty#getBase_Property()
	 * @see #getFlowProperty()
	 * @generated
	 */
	EReference getFlowProperty_Base_Property();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.sysml.portandflows.FlowProperty#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see org.eclipse.papyrus.sysml.portandflows.FlowProperty#getDirection()
	 * @see #getFlowProperty()
	 * @generated
	 */
	EAttribute getFlowProperty_Direction();

	/**
	 * Returns the meta object for the '{@link org.eclipse.papyrus.sysml.portandflows.FlowProperty#getIcon() <em>Get Icon</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the '<em>Get Icon</em>' operation.
	 * @see org.eclipse.papyrus.sysml.portandflows.FlowProperty#getIcon()
	 * @generated
	 */
	EOperation getFlowProperty__GetIcon();

	/**
	 * Returns the meta object for class ' {@link org.eclipse.papyrus.sysml.portandflows.FlowSpecification
	 * <em>Flow Specification</em>} '. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Flow Specification</em>'.
	 * @see org.eclipse.papyrus.sysml.portandflows.FlowSpecification
	 * @generated
	 */
	EClass getFlowSpecification();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.portandflows.FlowSpecification#getBase_Interface
	 * <em>Base Interface</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Interface</em>'.
	 * @see org.eclipse.papyrus.sysml.portandflows.FlowSpecification#getBase_Interface()
	 * @see #getFlowSpecification()
	 * @generated
	 */
	EReference getFlowSpecification_Base_Interface();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.sysml.portandflows.ItemFlow <em>Item Flow</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Item Flow</em>'.
	 * @see org.eclipse.papyrus.sysml.portandflows.ItemFlow
	 * @generated
	 */
	EClass getItemFlow();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.portandflows.ItemFlow#getBase_InformationFlow
	 * <em>Base Information Flow</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Information Flow</em>'.
	 * @see org.eclipse.papyrus.sysml.portandflows.ItemFlow#getBase_InformationFlow()
	 * @see #getItemFlow()
	 * @generated
	 */
	EReference getItemFlow_Base_InformationFlow();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.portandflows.ItemFlow#getItemProperty <em>Item Property</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Item Property</em>'.
	 * @see org.eclipse.papyrus.sysml.portandflows.ItemFlow#getItemProperty()
	 * @see #getItemFlow()
	 * @generated
	 */
	EReference getItemFlow_ItemProperty();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	PortandflowsFactory getPortandflowsFactory();

} // PortandflowsPackage
