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
import org.eclipse.papyrus.sysml.activities.Optional;
import org.eclipse.uml2.uml.Parameter;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Optional</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.activities.internal.impl.OptionalImpl#getBase_Parameter <em>Base Parameter</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class OptionalImpl extends MinimalEObjectImpl.Container implements Optional {

	/**
	 * The cached value of the '{@link #getBase_Parameter() <em>Base Parameter</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getBase_Parameter()
	 * @generated
	 * @ordered
	 */
	protected Parameter base_Parameter;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected OptionalImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ActivitiesPackage.Literals.OPTIONAL;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Parameter getBase_Parameter() {
		if(base_Parameter != null && base_Parameter.eIsProxy()) {
			InternalEObject oldBase_Parameter = (InternalEObject)base_Parameter;
			base_Parameter = (Parameter)eResolveProxy(oldBase_Parameter);
			if(base_Parameter != oldBase_Parameter) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActivitiesPackage.OPTIONAL__BASE_PARAMETER, oldBase_Parameter, base_Parameter));
			}
		}
		return base_Parameter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Parameter basicGetBase_Parameter() {
		return base_Parameter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Parameter(Parameter newBase_Parameter) {
		Parameter oldBase_Parameter = base_Parameter;
		base_Parameter = newBase_Parameter;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivitiesPackage.OPTIONAL__BASE_PARAMETER, oldBase_Parameter, base_Parameter));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case ActivitiesPackage.OPTIONAL__BASE_PARAMETER:
			if(resolve)
				return getBase_Parameter();
			return basicGetBase_Parameter();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case ActivitiesPackage.OPTIONAL__BASE_PARAMETER:
			setBase_Parameter((Parameter)newValue);
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
	public void eUnset(int featureID) {
		switch(featureID) {
		case ActivitiesPackage.OPTIONAL__BASE_PARAMETER:
			setBase_Parameter((Parameter)null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case ActivitiesPackage.OPTIONAL__BASE_PARAMETER:
			return base_Parameter != null;
		}
		return super.eIsSet(featureID);
	}

} // OptionalImpl
