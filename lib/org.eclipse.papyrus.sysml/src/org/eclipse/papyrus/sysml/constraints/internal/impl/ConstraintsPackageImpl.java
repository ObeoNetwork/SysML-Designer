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
package org.eclipse.papyrus.sysml.constraints.internal.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.sysml.SysmlPackage;
import org.eclipse.papyrus.sysml.activities.ActivitiesPackage;
import org.eclipse.papyrus.sysml.activities.internal.impl.ActivitiesPackageImpl;
import org.eclipse.papyrus.sysml.allocations.AllocationsPackage;
import org.eclipse.papyrus.sysml.allocations.internal.impl.AllocationsPackageImpl;
import org.eclipse.papyrus.sysml.blocks.BlocksPackage;
import org.eclipse.papyrus.sysml.blocks.internal.impl.BlocksPackageImpl;
import org.eclipse.papyrus.sysml.constraints.ConstraintBlock;
import org.eclipse.papyrus.sysml.constraints.ConstraintProperty;
import org.eclipse.papyrus.sysml.constraints.ConstraintsFactory;
import org.eclipse.papyrus.sysml.constraints.ConstraintsPackage;
import org.eclipse.papyrus.sysml.interactions.InteractionsPackage;
import org.eclipse.papyrus.sysml.interactions.internal.impl.InteractionsPackageImpl;
import org.eclipse.papyrus.sysml.internal.impl.SysmlPackageImpl;
import org.eclipse.papyrus.sysml.modelelements.ModelelementsPackage;
import org.eclipse.papyrus.sysml.modelelements.internal.impl.ModelelementsPackageImpl;
import org.eclipse.papyrus.sysml.portandflows.PortandflowsPackage;
import org.eclipse.papyrus.sysml.portandflows.internal.impl.PortandflowsPackageImpl;
import org.eclipse.papyrus.sysml.requirements.RequirementsPackage;
import org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementsPackageImpl;
import org.eclipse.papyrus.sysml.statemachines.StatemachinesPackage;
import org.eclipse.papyrus.sysml.statemachines.internal.impl.StatemachinesPackageImpl;
import org.eclipse.papyrus.sysml.usecases.UsecasesPackage;
import org.eclipse.papyrus.sysml.usecases.internal.impl.UsecasesPackageImpl;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.profile.standard.StandardPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class ConstraintsPackageImpl extends EPackageImpl implements ConstraintsPackage {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>
	 * This method is used to initialize {@link ConstraintsPackage#eINSTANCE} when that field is accessed. Clients should not invoke it directly.
	 * Instead, they should simply access that field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ConstraintsPackage init() {
		if(isInited)
			return (ConstraintsPackage)EPackage.Registry.INSTANCE.getEPackage(ConstraintsPackage.eNS_URI);

		// Obtain or create and register package
		ConstraintsPackageImpl theConstraintsPackage = (ConstraintsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ConstraintsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ConstraintsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		StandardPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		SysmlPackageImpl theSysmlPackage = (SysmlPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SysmlPackage.eNS_URI) instanceof SysmlPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SysmlPackage.eNS_URI) : SysmlPackage.eINSTANCE);
		ModelelementsPackageImpl theModelelementsPackage = (ModelelementsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelelementsPackage.eNS_URI) instanceof ModelelementsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelelementsPackage.eNS_URI) : ModelelementsPackage.eINSTANCE);
		BlocksPackageImpl theBlocksPackage = (BlocksPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BlocksPackage.eNS_URI) instanceof BlocksPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BlocksPackage.eNS_URI) : BlocksPackage.eINSTANCE);
		PortandflowsPackageImpl thePortandflowsPackage = (PortandflowsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PortandflowsPackage.eNS_URI) instanceof PortandflowsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PortandflowsPackage.eNS_URI) : PortandflowsPackage.eINSTANCE);
		ActivitiesPackageImpl theActivitiesPackage = (ActivitiesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ActivitiesPackage.eNS_URI) instanceof ActivitiesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ActivitiesPackage.eNS_URI) : ActivitiesPackage.eINSTANCE);
		AllocationsPackageImpl theAllocationsPackage = (AllocationsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AllocationsPackage.eNS_URI) instanceof AllocationsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AllocationsPackage.eNS_URI) : AllocationsPackage.eINSTANCE);
		RequirementsPackageImpl theRequirementsPackage = (RequirementsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RequirementsPackage.eNS_URI) instanceof RequirementsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RequirementsPackage.eNS_URI) : RequirementsPackage.eINSTANCE);
		InteractionsPackageImpl theInteractionsPackage = (InteractionsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(InteractionsPackage.eNS_URI) instanceof InteractionsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(InteractionsPackage.eNS_URI) : InteractionsPackage.eINSTANCE);
		StatemachinesPackageImpl theStatemachinesPackage = (StatemachinesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StatemachinesPackage.eNS_URI) instanceof StatemachinesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StatemachinesPackage.eNS_URI) : StatemachinesPackage.eINSTANCE);
		UsecasesPackageImpl theUsecasesPackage = (UsecasesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UsecasesPackage.eNS_URI) instanceof UsecasesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UsecasesPackage.eNS_URI) : UsecasesPackage.eINSTANCE);

		// Create package meta-data objects
		theConstraintsPackage.createPackageContents();
		theSysmlPackage.createPackageContents();
		theModelelementsPackage.createPackageContents();
		theBlocksPackage.createPackageContents();
		thePortandflowsPackage.createPackageContents();
		theActivitiesPackage.createPackageContents();
		theAllocationsPackage.createPackageContents();
		theRequirementsPackage.createPackageContents();
		theInteractionsPackage.createPackageContents();
		theStatemachinesPackage.createPackageContents();
		theUsecasesPackage.createPackageContents();

		// Initialize created meta-data
		theConstraintsPackage.initializePackageContents();
		theSysmlPackage.initializePackageContents();
		theModelelementsPackage.initializePackageContents();
		theBlocksPackage.initializePackageContents();
		thePortandflowsPackage.initializePackageContents();
		theActivitiesPackage.initializePackageContents();
		theAllocationsPackage.initializePackageContents();
		theRequirementsPackage.initializePackageContents();
		theInteractionsPackage.initializePackageContents();
		theStatemachinesPackage.initializePackageContents();
		theUsecasesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theConstraintsPackage.freeze();


		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ConstraintsPackage.eNS_URI, theConstraintsPackage);
		return theConstraintsPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass constraintBlockEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private EClass constraintPropertyEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package
	 * package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.sysml.constraints.ConstraintsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ConstraintsPackageImpl() {
		super(eNS_URI, ConstraintsFactory.eINSTANCE);
	}

	/**
	 * Creates the meta-model objects for the package. This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void createPackageContents() {
		if(isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		constraintBlockEClass = createEClass(CONSTRAINT_BLOCK);

		constraintPropertyEClass = createEClass(CONSTRAINT_PROPERTY);
		createEReference(constraintPropertyEClass, CONSTRAINT_PROPERTY__BASE_PROPERTY);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getConstraintBlock() {
		return constraintBlockEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EClass getConstraintProperty() {
		return constraintPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EReference getConstraintProperty_Base_Property() {
		return (EReference)constraintPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ConstraintsFactory getConstraintsFactory() {
		return (ConstraintsFactory)getEFactoryInstance();
	}

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void initializePackageContents() {
		if(isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		BlocksPackage theBlocksPackage = (BlocksPackage)EPackage.Registry.INSTANCE.getEPackage(BlocksPackage.eNS_URI);
		UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		constraintBlockEClass.getESuperTypes().add(theBlocksPackage.getBlock());

		// Initialize classes, features, and operations; add parameters
		initEClass(constraintBlockEClass, ConstraintBlock.class, "ConstraintBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(constraintPropertyEClass, ConstraintProperty.class, "ConstraintProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConstraintProperty_Base_Property(), theUMLPackage.getProperty(), null, "base_Property", null, 1, 1, ConstraintProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
	}

} // ConstraintsPackageImpl
