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
package org.eclipse.papyrus.sysml.activities.internal.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.sysml.activities.ActivitiesFactory;
import org.eclipse.papyrus.sysml.activities.ActivitiesPackage;
import org.eclipse.papyrus.sysml.activities.Continuous;
import org.eclipse.papyrus.sysml.activities.ControlOperator;
import org.eclipse.papyrus.sysml.activities.Discrete;
import org.eclipse.papyrus.sysml.activities.NoBuffer;
import org.eclipse.papyrus.sysml.activities.Optional;
import org.eclipse.papyrus.sysml.activities.Overwrite;
import org.eclipse.papyrus.sysml.activities.Probability;
import org.eclipse.papyrus.sysml.activities.Rate;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class ActivitiesFactoryImpl extends EFactoryImpl implements ActivitiesFactory {

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ActivitiesPackage getPackage() {
		return ActivitiesPackage.eINSTANCE;
	}

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static ActivitiesFactory init() {
		try {
			ActivitiesFactory theActivitiesFactory = (ActivitiesFactory)EPackage.Registry.INSTANCE.getEFactory(ActivitiesPackage.eNS_URI);
			if(theActivitiesFactory != null) {
				return theActivitiesFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ActivitiesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public ActivitiesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch(eClass.getClassifierID()) {
		case ActivitiesPackage.OPTIONAL:
			return createOptional();
		case ActivitiesPackage.RATE:
			return createRate();
		case ActivitiesPackage.PROBABILITY:
			return createProbability();
		case ActivitiesPackage.CONTINUOUS:
			return createContinuous();
		case ActivitiesPackage.DISCRETE:
			return createDiscrete();
		case ActivitiesPackage.CONTROL_OPERATOR:
			return createControlOperator();
		case ActivitiesPackage.NO_BUFFER:
			return createNoBuffer();
		case ActivitiesPackage.OVERWRITE:
			return createOverwrite();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Optional createOptional() {
		OptionalImpl optional = new OptionalImpl();
		return optional;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Continuous createContinuous() {
		ContinuousImpl continuous = new ContinuousImpl();
		return continuous;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ControlOperator createControlOperator() {
		ControlOperatorImpl controlOperator = new ControlOperatorImpl();
		return controlOperator;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Discrete createDiscrete() {
		DiscreteImpl discrete = new DiscreteImpl();
		return discrete;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NoBuffer createNoBuffer() {
		NoBufferImpl noBuffer = new NoBufferImpl();
		return noBuffer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Overwrite createOverwrite() {
		OverwriteImpl overwrite = new OverwriteImpl();
		return overwrite;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Probability createProbability() {
		ProbabilityImpl probability = new ProbabilityImpl();
		return probability;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Rate createRate() {
		RateImpl rate = new RateImpl();
		return rate;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ActivitiesPackage getActivitiesPackage() {
		return (ActivitiesPackage)getEPackage();
	}

} // ActivitiesFactoryImpl
