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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.sysml.util;

import org.eclipse.papyrus.sysml.SysmlPackage;

/**
 * For all deprecated : use org.eclipse.uml2.uml.util.UMLUtil.getStereotypeApplication
 * Ex :
 * replace appliedStereotype =
 * connectorEnd.getAppliedStereotype("SysML::Blocks::NestedConnectorEnd");connectorEnd.getStereotypeApplication(appliedStereotype);
 * by org.eclipse.uml2.uml.util.UMLUtil.getStereotypeApplication(element, NestedConnectorEnd.class);
 */
public class SysmlResource {

	public static final String LIBRARIES_PATHMAP = "pathmap://SysML_LIBRARIES/"; //$NON-NLS-1$

	public static final String SYSML_PRIMITIVE_TYPES_LIBRARY_URI = LIBRARIES_PATHMAP + "SysMLPrimitiveTypes.uml"; //$NON-NLS-1$

	public static final String PROFILES_PATHMAP = "pathmap://SysML_PROFILES/"; //$NON-NLS-1$

	public static final String SYSML_PROFILE_NS_URI = SysmlPackage.eNS_URI;

	public static final String SYSML_PROFILE_URI = PROFILES_PATHMAP + "SysML.profile.uml"; //$NON-NLS-1$


	// Stereotypes ids
	@Deprecated
	public static String CONFORM_ID = "SysML::ModelElements::Conform";

	@Deprecated
	public static String VIEW_ID = "SysML::ModelElements::View";

	@Deprecated
	public static String VIEW_POINT_ID = "SysML::ModelElements::ViewPoint";

	/**
	 * @deprecated use VIEW_POINT_ID instead
	 */
	public static String VIEWPOINT_ID = VIEW_POINT_ID;

	@Deprecated
	public static String RATIONALE_ID = "SysML::ModelElements::Rationale";

	@Deprecated
	public static String PROBLEM_ID = "SysML::ModelElements::Problem";

	@Deprecated
	public static String BLOCK_ID = "SysML::Blocks::Block";

	@Deprecated
	public static String DISTRIBUTED_PROPERTY_ID = "SysML::Blocks::DistributedProperty";

	@Deprecated
	public static String DIMENSION_ID = "SysML::Blocks::Dimension";

	@Deprecated
	public static String UNIT_ID = "SysML::Blocks::Unit";

	@Deprecated
	public static String VALUE_TYPE_ID = "SysML::Blocks::ValueType";

	@Deprecated
	public static String NESTED_CONNECTOR_END_ID = "SysML::Blocks::NestedConnectorEnd";

	/** @deprecated use NESTED_CONNECTOR_END_ID instead */
	public static String NESTED_CONNECTOREND_ID = NESTED_CONNECTOR_END_ID;

	@Deprecated
	public static String PARTICIPANT_PROPERTY_ID = "SysML::Blocks::ParticipantProperty";

	@Deprecated
	public static String CONNECTOR_PROPERTY_ID = "SysML::Blocks::ConnectorProperty";

	@Deprecated
	public static String BINDING_CONNECTOR_ID = "SysML::Blocks::BindingConnector";

	@Deprecated
	public static String PROPERTY_SPECIFIC_TYPE_ID = "SysML::Blocks::PropertySpecificType";

	@Deprecated
	public static String FLOW_PORT_ID = "SysML::PortAndFlows::FlowPort";

	@Deprecated
	public static String FLOW_PROPERTY_ID = "SysML::PortAndFlows::FlowProperty";

	@Deprecated
	public static String FLOW_SPECIFICATION_ID = "SysML::PortAndFlows::FlowSpecification";

	@Deprecated
	public static String ITEM_FLOW_ID = "SysML::PortAndFlows::ItemFlow";

	@Deprecated
	public static String CONSTRAINT_BLOCK_ID = "SysML::Constraints::ConstraintBlock";

	@Deprecated
	public static String CONSTRAINT_PROPERTY_ID = "SysML::Constraints::ConstraintProperty";

	@Deprecated
	public static String OPTIONAL_ID = "SysML::Activities::Optional";

	@Deprecated
	public static String RATE_ID = "SysML::Activities::Rate";

	@Deprecated
	public static String PROBABILITY_ID = "SysML::Activities::Probability";

	@Deprecated
	public static String CONTINUOUS_ID = "SysML::Activities::Continuous";

	@Deprecated
	public static String DISCRETE_ID = "SysML::Activities::Discrete";

	@Deprecated
	public static String CONTROL_OPERATOR_ID = "SysML::Activities::ControlOperator";

	@Deprecated
	public static String NO_BUFFER_ID = "SysML::Activities::NoBuffer";

	@Deprecated
	public static String OVERWRITE_ID = "SysML::Activities::Overwrite";

	@Deprecated
	public static String ALLOCATE_ID = "SysML::Allocations::Allocate";

	@Deprecated
	public static String ALLOCATED_ID = "SysML::Allocations::Allocated";

	@Deprecated
	public static String ALLOCATE_ACTIVITY_PARTITION_ID = "SysML::Allocations::AllocateActivityPartition";

	@Deprecated
	public static String DERIVE_REQT_ID = "SysML::Requirements::DeriveReqt";

	@Deprecated
	public static String VERIFY_ID = "SysML::Requirements::Verify";

	@Deprecated
	public static String COPY_ID = "SysML::Requirements::Copy";

	@Deprecated
	public static String SATISFY_ID = "SysML::Requirements::Satisfy";

	@Deprecated
	public static String TEST_CASE_ID = "SysML::Requirements::TestCase";

	@Deprecated
	public static String REQUIREMENT_ID = "SysML::Requirements::Requirement";

	@Deprecated
	public static String REQUIREMENT_RELATED_ID = "SysML::Requirements::RequirementRelated";

	// SubProfiles ids
	@Deprecated
	public static String SYSML_ID = "SysML";

	@Deprecated
	public static String MODEL_ELEMENTS_ID = "SysML::ModelElements";

	@Deprecated
	public static String BLOCKS_ID = "SysML::Blocks";

	@Deprecated
	public static String PORT_AND_FLOWS_ID = "SysML::PortAndFlows";

	@Deprecated
	public static String CONSTRAINTS_ID = "SysML::Constraints";

	@Deprecated
	public static String ACTIVITIES_ID = "SysML::Activities";

	@Deprecated
	public static String ALLOCATIONS_ID = "SysML::Allocations";

	@Deprecated
	public static String REQUIREMENTS_ID = "SysML::Requirements";

	// stereotype properties ids
	// requirements properties
	@Deprecated
	public static String REQUIREMENT_BASE_CLASS_ID = "base_Class"; //$NON-NLS-1$

	@Deprecated
	public static String REQUIREMENT_DERIVED_ID = "derived"; //$NON-NLS-1$

	@Deprecated
	public static String REQUIREMENT_DERIVED_FROM_ID = "derivedFrom";//$NON-NLS-1$

	@Deprecated
	public static String REQUIREMENT_ID_ID = "id";//$NON-NLS-1$

	@Deprecated
	public static String REQUIREMENT_MASTER_ID = "master";//$NON-NLS-1$

	@Deprecated
	public static String REQUIREMENT_REFINED_BY_ID = "refinedBy";//$NON-NLS-1$

	@Deprecated
	public static String REQUIREMENT_SATISFIED_BY_ID = "satisfiedBy";//$NON-NLS-1$

	@Deprecated
	public static String REQUIREMENT_TEXT_ID = "text";//$NON-NLS-1$

	@Deprecated
	public static String REQUIREMENT_TRACED_TO_ID = "tracedTo";//$NON-NLS-1$

	@Deprecated
	public static String REQUIREMENT_VERIFIED_BY_ID = "verifiedBy";//$NON-NLS-1$

}
