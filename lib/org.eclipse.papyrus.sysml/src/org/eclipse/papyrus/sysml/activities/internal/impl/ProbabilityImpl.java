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

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.sysml.activities.ActivitiesPackage;
import org.eclipse.papyrus.sysml.activities.Probability;
import org.eclipse.uml2.uml.ActivityEdge;
import org.eclipse.uml2.uml.ParameterSet;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Probability</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.activities.internal.impl.ProbabilityImpl#getBase_ActivityEdge <em>Base Activity Edge</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.activities.internal.impl.ProbabilityImpl#getBase_ParameterSet <em>Base Parameter Set</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.activities.internal.impl.ProbabilityImpl#getProbability <em>Probability</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ProbabilityImpl extends MinimalEObjectImpl.Container implements Probability {

	/**
	 * The cached value of the '{@link #getBase_ActivityEdge() <em>Base Activity Edge</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getBase_ActivityEdge()
	 * @generated
	 * @ordered
	 */
	protected ActivityEdge base_ActivityEdge;

	/**
	 * The cached value of the '{@link #getBase_ParameterSet() <em>Base Parameter Set</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getBase_ParameterSet()
	 * @generated
	 * @ordered
	 */
	protected ParameterSet base_ParameterSet;

	/**
	 * The cached value of the '{@link #getProbability() <em>Probability</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProbability()
	 * @generated
	 * @ordered
	 */
	protected ValueSpecification probability;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ProbabilityImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ActivityEdge basicGetBase_ActivityEdge() {
		return base_ActivityEdge;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ParameterSet basicGetBase_ParameterSet() {
		return base_ParameterSet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ValueSpecification basicGetProbability() {
		return probability;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case ActivitiesPackage.PROBABILITY__BASE_ACTIVITY_EDGE:
			if(resolve)
				return getBase_ActivityEdge();
			return basicGetBase_ActivityEdge();
		case ActivitiesPackage.PROBABILITY__BASE_PARAMETER_SET:
			if(resolve)
				return getBase_ParameterSet();
			return basicGetBase_ParameterSet();
		case ActivitiesPackage.PROBABILITY__PROBABILITY:
			if(resolve)
				return getProbability();
			return basicGetProbability();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case ActivitiesPackage.PROBABILITY__BASE_ACTIVITY_EDGE:
			return base_ActivityEdge != null;
		case ActivitiesPackage.PROBABILITY__BASE_PARAMETER_SET:
			return base_ParameterSet != null;
		case ActivitiesPackage.PROBABILITY__PROBABILITY:
			return probability != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case ActivitiesPackage.PROBABILITY__BASE_ACTIVITY_EDGE:
			setBase_ActivityEdge((ActivityEdge)newValue);
			return;
		case ActivitiesPackage.PROBABILITY__BASE_PARAMETER_SET:
			setBase_ParameterSet((ParameterSet)newValue);
			return;
		case ActivitiesPackage.PROBABILITY__PROBABILITY:
			setProbability((ValueSpecification)newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActivitiesPackage.Literals.PROBABILITY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case ActivitiesPackage.PROBABILITY__BASE_ACTIVITY_EDGE:
			setBase_ActivityEdge((ActivityEdge)null);
			return;
		case ActivitiesPackage.PROBABILITY__BASE_PARAMETER_SET:
			setBase_ParameterSet((ParameterSet)null);
			return;
		case ActivitiesPackage.PROBABILITY__PROBABILITY:
			setProbability((ValueSpecification)null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ActivityEdge getBase_ActivityEdge() {
		if(base_ActivityEdge != null && base_ActivityEdge.eIsProxy()) {
			InternalEObject oldBase_ActivityEdge = (InternalEObject)base_ActivityEdge;
			base_ActivityEdge = (ActivityEdge)eResolveProxy(oldBase_ActivityEdge);
			if(base_ActivityEdge != oldBase_ActivityEdge) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActivitiesPackage.PROBABILITY__BASE_ACTIVITY_EDGE, oldBase_ActivityEdge, base_ActivityEdge));
			}
		}
		return base_ActivityEdge;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ParameterSet getBase_ParameterSet() {
		if(base_ParameterSet != null && base_ParameterSet.eIsProxy()) {
			InternalEObject oldBase_ParameterSet = (InternalEObject)base_ParameterSet;
			base_ParameterSet = (ParameterSet)eResolveProxy(oldBase_ParameterSet);
			if(base_ParameterSet != oldBase_ParameterSet) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActivitiesPackage.PROBABILITY__BASE_PARAMETER_SET, oldBase_ParameterSet, base_ParameterSet));
			}
		}
		return base_ParameterSet;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ValueSpecification getProbability() {
		if(probability != null && probability.eIsProxy()) {
			InternalEObject oldProbability = (InternalEObject)probability;
			probability = (ValueSpecification)eResolveProxy(oldProbability);
			if(probability != oldProbability) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActivitiesPackage.PROBABILITY__PROBABILITY, oldProbability, probability));
			}
		}
		return probability;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_ActivityEdge(ActivityEdge newBase_ActivityEdge) {
		ActivityEdge oldBase_ActivityEdge = base_ActivityEdge;
		base_ActivityEdge = newBase_ActivityEdge;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivitiesPackage.PROBABILITY__BASE_ACTIVITY_EDGE, oldBase_ActivityEdge, base_ActivityEdge));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_ParameterSet(ParameterSet newBase_ParameterSet) {
		ParameterSet oldBase_ParameterSet = base_ParameterSet;
		base_ParameterSet = newBase_ParameterSet;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivitiesPackage.PROBABILITY__BASE_PARAMETER_SET, oldBase_ParameterSet, base_ParameterSet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setProbability(ValueSpecification newProbability) {
		ValueSpecification oldProbability = probability;
		probability = newProbability;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivitiesPackage.PROBABILITY__PROBABILITY, oldProbability, probability));
	}

} // ProbabilityImpl
