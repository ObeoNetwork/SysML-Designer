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

import org.eclipse.emf.ecore.EAttribute;
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
 * @see org.eclipse.papyrus.sysml.blocks.BlocksFactory
 * @model kind="package"
 * @generated
 */
public interface BlocksPackage extends EPackage {

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.sysml.blocks.internal.impl.BlockImpl <em>Block</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.BlockImpl
		 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.BlocksPackageImpl#getBlock()
		 * @generated
		 */
		EClass BLOCK = eINSTANCE.getBlock();

		/**
		 * The meta object literal for the '<em><b>Is Encapsulated</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BLOCK__IS_ENCAPSULATED = eINSTANCE.getBlock_IsEncapsulated();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference BLOCK__BASE_CLASS = eINSTANCE.getBlock_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.sysml.blocks.internal.impl.DistributedPropertyImpl
		 * <em>Distributed Property</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.DistributedPropertyImpl
		 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.BlocksPackageImpl#getDistributedProperty()
		 * @generated
		 */
		EClass DISTRIBUTED_PROPERTY = eINSTANCE.getDistributedProperty();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DISTRIBUTED_PROPERTY__BASE_PROPERTY = eINSTANCE.getDistributedProperty_Base_Property();

		/**
		 * The meta object literal for the ' {@link org.eclipse.papyrus.sysml.blocks.internal.impl.DimensionImpl
		 * <em>Dimension</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 * 
		 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.DimensionImpl
		 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.BlocksPackageImpl#getDimension()
		 * @generated
		 */
		EClass DIMENSION = eINSTANCE.getDimension();

		/**
		 * The meta object literal for the ' <em><b>Base Instance Specification</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DIMENSION__BASE_INSTANCE_SPECIFICATION = eINSTANCE.getDimension_Base_InstanceSpecification();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.sysml.blocks.internal.impl.UnitImpl <em>Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.UnitImpl
		 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.BlocksPackageImpl#getUnit()
		 * @generated
		 */
		EClass UNIT = eINSTANCE.getUnit();

		/**
		 * The meta object literal for the ' <em><b>Base Instance Specification</b></em>' reference feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference UNIT__BASE_INSTANCE_SPECIFICATION = eINSTANCE.getUnit_Base_InstanceSpecification();

		/**
		 * The meta object literal for the '<em><b>Dimension</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference UNIT__DIMENSION = eINSTANCE.getUnit_Dimension();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.sysml.blocks.internal.impl.ValueTypeImpl <em>Value Type</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.ValueTypeImpl
		 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.BlocksPackageImpl#getValueType()
		 * @generated
		 */
		EClass VALUE_TYPE = eINSTANCE.getValueType();

		/**
		 * The meta object literal for the '<em><b>Base Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VALUE_TYPE__BASE_DATA_TYPE = eINSTANCE.getValueType_Base_DataType();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VALUE_TYPE__UNIT = eINSTANCE.getValueType_Unit();

		/**
		 * The meta object literal for the '<em><b>Dimension</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference VALUE_TYPE__DIMENSION = eINSTANCE.getValueType_Dimension();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.sysml.blocks.internal.impl.NestedConnectorEndImpl
		 * <em>Nested Connector End</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.NestedConnectorEndImpl
		 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.BlocksPackageImpl#getNestedConnectorEnd()
		 * @generated
		 */
		EClass NESTED_CONNECTOR_END = eINSTANCE.getNestedConnectorEnd();

		/**
		 * The meta object literal for the '<em><b>Property Path</b></em>' reference list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference NESTED_CONNECTOR_END__PROPERTY_PATH = eINSTANCE.getNestedConnectorEnd_PropertyPath();

		/**
		 * The meta object literal for the '<em><b>Base Connector End</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference NESTED_CONNECTOR_END__BASE_CONNECTOR_END = eINSTANCE.getNestedConnectorEnd_Base_ConnectorEnd();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.sysml.blocks.internal.impl.ParticipantPropertyImpl
		 * <em>Participant Property</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.ParticipantPropertyImpl
		 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.BlocksPackageImpl#getParticipantProperty()
		 * @generated
		 */
		EClass PARTICIPANT_PROPERTY = eINSTANCE.getParticipantProperty();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PARTICIPANT_PROPERTY__BASE_PROPERTY = eINSTANCE.getParticipantProperty_Base_Property();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PARTICIPANT_PROPERTY__END = eINSTANCE.getParticipantProperty_End();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.sysml.blocks.internal.impl.ConnectorPropertyImpl <em>Connector Property</em>}'
		 * class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.ConnectorPropertyImpl
		 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.BlocksPackageImpl#getConnectorProperty()
		 * @generated
		 */
		EClass CONNECTOR_PROPERTY = eINSTANCE.getConnectorProperty();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONNECTOR_PROPERTY__BASE_PROPERTY = eINSTANCE.getConnectorProperty_Base_Property();

		/**
		 * The meta object literal for the '<em><b>Connector</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CONNECTOR_PROPERTY__CONNECTOR = eINSTANCE.getConnectorProperty_Connector();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.sysml.blocks.internal.impl.BindingConnectorImpl <em>Binding Connector</em>}'
		 * class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.BindingConnectorImpl
		 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.BlocksPackageImpl#getBindingConnector()
		 * @generated
		 */
		EClass BINDING_CONNECTOR = eINSTANCE.getBindingConnector();

		/**
		 * The meta object literal for the '<em><b>Base Connector</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference BINDING_CONNECTOR__BASE_CONNECTOR = eINSTANCE.getBindingConnector_Base_Connector();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.sysml.blocks.internal.impl.PropertySpecificTypeImpl
		 * <em>Property Specific Type</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.PropertySpecificTypeImpl
		 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.BlocksPackageImpl#getPropertySpecificType()
		 * @generated
		 */
		EClass PROPERTY_SPECIFIC_TYPE = eINSTANCE.getPropertySpecificType();

		/**
		 * The meta object literal for the '<em><b>Base Classifier</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PROPERTY_SPECIFIC_TYPE__BASE_CLASSIFIER = eINSTANCE.getPropertySpecificType_Base_Classifier();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "blocks";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/0.7.0/SysML/Blocks";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "Blocks";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	BlocksPackage eINSTANCE = org.eclipse.papyrus.sysml.blocks.internal.impl.BlocksPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.sysml.blocks.internal.impl.BlockImpl <em>Block</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.BlockImpl
	 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.BlocksPackageImpl#getBlock()
	 * @generated
	 */
	int BLOCK = 0;

	/**
	 * The feature id for the '<em><b>Is Encapsulated</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BLOCK__IS_ENCAPSULATED = 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BLOCK__BASE_CLASS = 1;

	/**
	 * The number of structural features of the '<em>Block</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BLOCK_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Block</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BLOCK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.sysml.blocks.internal.impl.DistributedPropertyImpl <em>Distributed Property</em>}'
	 * class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.DistributedPropertyImpl
	 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.BlocksPackageImpl#getDistributedProperty()
	 * @generated
	 */
	int DISTRIBUTED_PROPERTY = 1;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTED_PROPERTY__BASE_PROPERTY = 0;

	/**
	 * The number of structural features of the '<em>Distributed Property</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTED_PROPERTY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Distributed Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DISTRIBUTED_PROPERTY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.sysml.blocks.internal.impl.DimensionImpl <em>Dimension</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.DimensionImpl
	 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.BlocksPackageImpl#getDimension()
	 * @generated
	 */
	int DIMENSION = 2;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIMENSION__BASE_INSTANCE_SPECIFICATION = 0;

	/**
	 * The number of structural features of the '<em>Dimension</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIMENSION_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DIMENSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.sysml.blocks.internal.impl.UnitImpl <em>Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.UnitImpl
	 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.BlocksPackageImpl#getUnit()
	 * @generated
	 */
	int UNIT = 3;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIT__BASE_INSTANCE_SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Dimension</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIT__DIMENSION = 1;

	/**
	 * The number of structural features of the '<em>Unit</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int UNIT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the ' {@link org.eclipse.papyrus.sysml.blocks.internal.impl.ValueTypeImpl
	 * <em>Value Type</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.ValueTypeImpl
	 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.BlocksPackageImpl#getValueType()
	 * @generated
	 */
	int VALUE_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE__BASE_DATA_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE__UNIT = 1;

	/**
	 * The feature id for the '<em><b>Dimension</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE__DIMENSION = 2;

	/**
	 * The number of structural features of the '<em>Value Type</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Value Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int VALUE_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.sysml.blocks.internal.impl.NestedConnectorEndImpl <em>Nested Connector End</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.NestedConnectorEndImpl
	 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.BlocksPackageImpl#getNestedConnectorEnd()
	 * @generated
	 */
	int NESTED_CONNECTOR_END = 5;

	/**
	 * The feature id for the '<em><b>Property Path</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NESTED_CONNECTOR_END__PROPERTY_PATH = 0;

	/**
	 * The feature id for the '<em><b>Base Connector End</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NESTED_CONNECTOR_END__BASE_CONNECTOR_END = 1;

	/**
	 * The number of structural features of the '<em>Nested Connector End</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NESTED_CONNECTOR_END_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Nested Connector End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int NESTED_CONNECTOR_END_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.sysml.blocks.internal.impl.ParticipantPropertyImpl <em>Participant Property</em>}'
	 * class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.ParticipantPropertyImpl
	 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.BlocksPackageImpl#getParticipantProperty()
	 * @generated
	 */
	int PARTICIPANT_PROPERTY = 6;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_PROPERTY__BASE_PROPERTY = 0;

	/**
	 * The feature id for the '<em><b>End</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_PROPERTY__END = 1;

	/**
	 * The number of structural features of the '<em>Participant Property</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_PROPERTY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Participant Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PARTICIPANT_PROPERTY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.sysml.blocks.internal.impl.ConnectorPropertyImpl <em>Connector Property</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.ConnectorPropertyImpl
	 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.BlocksPackageImpl#getConnectorProperty()
	 * @generated
	 */
	int CONNECTOR_PROPERTY = 7;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_PROPERTY__BASE_PROPERTY = 0;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_PROPERTY__CONNECTOR = 1;

	/**
	 * The number of structural features of the '<em>Connector Property</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_PROPERTY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Connector Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_PROPERTY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.sysml.blocks.internal.impl.BindingConnectorImpl <em>Binding Connector</em>}' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.BindingConnectorImpl
	 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.BlocksPackageImpl#getBindingConnector()
	 * @generated
	 */
	int BINDING_CONNECTOR = 8;

	/**
	 * The feature id for the '<em><b>Base Connector</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_CONNECTOR__BASE_CONNECTOR = 0;

	/**
	 * The number of structural features of the '<em>Binding Connector</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_CONNECTOR_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Binding Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING_CONNECTOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.sysml.blocks.internal.impl.PropertySpecificTypeImpl <em>Property Specific Type</em>}'
	 * class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.PropertySpecificTypeImpl
	 * @see org.eclipse.papyrus.sysml.blocks.internal.impl.BlocksPackageImpl#getPropertySpecificType()
	 * @generated
	 */
	int PROPERTY_SPECIFIC_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SPECIFIC_TYPE__BASE_CLASSIFIER = 0;

	/**
	 * The number of structural features of the '<em>Property Specific Type</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SPECIFIC_TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Property Specific Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROPERTY_SPECIFIC_TYPE_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class ' {@link org.eclipse.papyrus.sysml.blocks.BindingConnector
	 * <em>Binding Connector</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Binding Connector</em>'.
	 * @see org.eclipse.papyrus.sysml.blocks.BindingConnector
	 * @generated
	 */
	EClass getBindingConnector();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.blocks.BindingConnector#getBase_Connector <em>Base Connector</em>}
	 * '.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Connector</em>'.
	 * @see org.eclipse.papyrus.sysml.blocks.BindingConnector#getBase_Connector()
	 * @see #getBindingConnector()
	 * @generated
	 */
	EReference getBindingConnector_Base_Connector();

	/**
	 * Returns the meta object for class ' {@link org.eclipse.papyrus.sysml.blocks.Block <em>Block</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Block</em>'.
	 * @see org.eclipse.papyrus.sysml.blocks.Block
	 * @generated
	 */
	EClass getBlock();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.blocks.Block#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.sysml.blocks.Block#getBase_Class()
	 * @see #getBlock()
	 * @generated
	 */
	EReference getBlock_Base_Class();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.sysml.blocks.Block#isEncapsulated <em>Is Encapsulated</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Is Encapsulated</em>'.
	 * @see org.eclipse.papyrus.sysml.blocks.Block#isEncapsulated()
	 * @see #getBlock()
	 * @generated
	 */
	EAttribute getBlock_IsEncapsulated();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	BlocksFactory getBlocksFactory();

	/**
	 * Returns the meta object for class ' {@link org.eclipse.papyrus.sysml.blocks.ConnectorProperty
	 * <em>Connector Property</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for class '<em>Connector Property</em>'.
	 * @see org.eclipse.papyrus.sysml.blocks.ConnectorProperty
	 * @generated
	 */
	EClass getConnectorProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.blocks.ConnectorProperty#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.sysml.blocks.ConnectorProperty#getBase_Property()
	 * @see #getConnectorProperty()
	 * @generated
	 */
	EReference getConnectorProperty_Base_Property();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.blocks.ConnectorProperty#getConnector <em>Connector</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Connector</em>'.
	 * @see org.eclipse.papyrus.sysml.blocks.ConnectorProperty#getConnector()
	 * @see #getConnectorProperty()
	 * @generated
	 */
	EReference getConnectorProperty_Connector();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.sysml.blocks.Dimension <em>Dimension</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Dimension</em>'.
	 * @see org.eclipse.papyrus.sysml.blocks.Dimension
	 * @generated
	 */
	EClass getDimension();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.blocks.Dimension#getBase_InstanceSpecification
	 * <em>Base Instance Specification</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Instance Specification</em>'.
	 * @see org.eclipse.papyrus.sysml.blocks.Dimension#getBase_InstanceSpecification()
	 * @see #getDimension()
	 * @generated
	 */
	EReference getDimension_Base_InstanceSpecification();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.sysml.blocks.DistributedProperty <em>Distributed Property</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Distributed Property</em>'.
	 * @see org.eclipse.papyrus.sysml.blocks.DistributedProperty
	 * @generated
	 */
	EClass getDistributedProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.blocks.DistributedProperty#getBase_Property <em>Base Property</em>}
	 * '.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.sysml.blocks.DistributedProperty#getBase_Property()
	 * @see #getDistributedProperty()
	 * @generated
	 */
	EReference getDistributedProperty_Base_Property();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.sysml.blocks.NestedConnectorEnd <em>Nested Connector End</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Nested Connector End</em>'.
	 * @see org.eclipse.papyrus.sysml.blocks.NestedConnectorEnd
	 * @generated
	 */
	EClass getNestedConnectorEnd();

	/**
	 * Returns the meta object for the reference ' {@link org.eclipse.papyrus.sysml.blocks.NestedConnectorEnd#getBase_ConnectorEnd
	 * <em>Base Connector End</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return the meta object for the reference '<em>Base Connector End</em>'.
	 * @see org.eclipse.papyrus.sysml.blocks.NestedConnectorEnd#getBase_ConnectorEnd()
	 * @see #getNestedConnectorEnd()
	 * @generated
	 */
	EReference getNestedConnectorEnd_Base_ConnectorEnd();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.sysml.blocks.NestedConnectorEnd#getPropertyPath
	 * <em>Property Path</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Property Path</em>'.
	 * @see org.eclipse.papyrus.sysml.blocks.NestedConnectorEnd#getPropertyPath()
	 * @see #getNestedConnectorEnd()
	 * @generated
	 */
	EReference getNestedConnectorEnd_PropertyPath();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.sysml.blocks.ParticipantProperty <em>Participant Property</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Participant Property</em>'.
	 * @see org.eclipse.papyrus.sysml.blocks.ParticipantProperty
	 * @generated
	 */
	EClass getParticipantProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.blocks.ParticipantProperty#getBase_Property <em>Base Property</em>}
	 * '.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.sysml.blocks.ParticipantProperty#getBase_Property()
	 * @see #getParticipantProperty()
	 * @generated
	 */
	EReference getParticipantProperty_Base_Property();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.blocks.ParticipantProperty#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>End</em>'.
	 * @see org.eclipse.papyrus.sysml.blocks.ParticipantProperty#getEnd()
	 * @see #getParticipantProperty()
	 * @generated
	 */
	EReference getParticipantProperty_End();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.sysml.blocks.PropertySpecificType <em>Property Specific Type</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Property Specific Type</em>'.
	 * @see org.eclipse.papyrus.sysml.blocks.PropertySpecificType
	 * @generated
	 */
	EClass getPropertySpecificType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.blocks.PropertySpecificType#getBase_Classifier
	 * <em>Base Classifier</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Classifier</em>'.
	 * @see org.eclipse.papyrus.sysml.blocks.PropertySpecificType#getBase_Classifier()
	 * @see #getPropertySpecificType()
	 * @generated
	 */
	EReference getPropertySpecificType_Base_Classifier();

	/**
	 * Returns the meta object for class ' {@link org.eclipse.papyrus.sysml.blocks.Unit <em>Unit</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Unit</em>'.
	 * @see org.eclipse.papyrus.sysml.blocks.Unit
	 * @generated
	 */
	EClass getUnit();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.blocks.Unit#getBase_InstanceSpecification
	 * <em>Base Instance Specification</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Instance Specification</em>'.
	 * @see org.eclipse.papyrus.sysml.blocks.Unit#getBase_InstanceSpecification()
	 * @see #getUnit()
	 * @generated
	 */
	EReference getUnit_Base_InstanceSpecification();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.blocks.Unit#getDimension <em>Dimension</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Dimension</em>'.
	 * @see org.eclipse.papyrus.sysml.blocks.Unit#getDimension()
	 * @see #getUnit()
	 * @generated
	 */
	EReference getUnit_Dimension();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.sysml.blocks.ValueType <em>Value Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Value Type</em>'.
	 * @see org.eclipse.papyrus.sysml.blocks.ValueType
	 * @generated
	 */
	EClass getValueType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.blocks.ValueType#getBase_DataType <em>Base Data Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Data Type</em>'.
	 * @see org.eclipse.papyrus.sysml.blocks.ValueType#getBase_DataType()
	 * @see #getValueType()
	 * @generated
	 */
	EReference getValueType_Base_DataType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.blocks.ValueType#getDimension <em>Dimension</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Dimension</em>'.
	 * @see org.eclipse.papyrus.sysml.blocks.ValueType#getDimension()
	 * @see #getValueType()
	 * @generated
	 */
	EReference getValueType_Dimension();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.sysml.blocks.ValueType#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Unit</em>'.
	 * @see org.eclipse.papyrus.sysml.blocks.ValueType#getUnit()
	 * @see #getValueType()
	 * @generated
	 */
	EReference getValueType_Unit();

} // BlocksPackage
