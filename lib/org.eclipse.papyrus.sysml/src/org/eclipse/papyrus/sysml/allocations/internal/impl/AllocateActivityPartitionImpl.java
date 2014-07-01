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
package org.eclipse.papyrus.sysml.allocations.internal.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.sysml.allocations.AllocateActivityPartition;
import org.eclipse.papyrus.sysml.allocations.AllocationsPackage;
import org.eclipse.uml2.uml.ActivityPartition;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Allocate Activity Partition</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.allocations.internal.impl.AllocateActivityPartitionImpl#getBase_ActivityPartition <em>Base Activity Partition
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class AllocateActivityPartitionImpl extends MinimalEObjectImpl.Container implements AllocateActivityPartition {

	/**
	 * The cached value of the '{@link #getBase_ActivityPartition() <em>Base Activity Partition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBase_ActivityPartition()
	 * @generated
	 * @ordered
	 */
	protected ActivityPartition base_ActivityPartition;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AllocateActivityPartitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ActivityPartition basicGetBase_ActivityPartition() {
		return base_ActivityPartition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case AllocationsPackage.ALLOCATE_ACTIVITY_PARTITION__BASE_ACTIVITY_PARTITION:
			if(resolve)
				return getBase_ActivityPartition();
			return basicGetBase_ActivityPartition();
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
		case AllocationsPackage.ALLOCATE_ACTIVITY_PARTITION__BASE_ACTIVITY_PARTITION:
			return base_ActivityPartition != null;
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
		case AllocationsPackage.ALLOCATE_ACTIVITY_PARTITION__BASE_ACTIVITY_PARTITION:
			setBase_ActivityPartition((ActivityPartition)newValue);
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
		return AllocationsPackage.Literals.ALLOCATE_ACTIVITY_PARTITION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case AllocationsPackage.ALLOCATE_ACTIVITY_PARTITION__BASE_ACTIVITY_PARTITION:
			setBase_ActivityPartition((ActivityPartition)null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ActivityPartition getBase_ActivityPartition() {
		if(base_ActivityPartition != null && base_ActivityPartition.eIsProxy()) {
			InternalEObject oldBase_ActivityPartition = (InternalEObject)base_ActivityPartition;
			base_ActivityPartition = (ActivityPartition)eResolveProxy(oldBase_ActivityPartition);
			if(base_ActivityPartition != oldBase_ActivityPartition) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocationsPackage.ALLOCATE_ACTIVITY_PARTITION__BASE_ACTIVITY_PARTITION, oldBase_ActivityPartition, base_ActivityPartition));
			}
		}
		return base_ActivityPartition;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_ActivityPartition(ActivityPartition newBase_ActivityPartition) {
		ActivityPartition oldBase_ActivityPartition = base_ActivityPartition;
		base_ActivityPartition = newBase_ActivityPartition;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocationsPackage.ALLOCATE_ACTIVITY_PARTITION__BASE_ACTIVITY_PARTITION, oldBase_ActivityPartition, base_ActivityPartition));
	}

} // AllocateActivityPartitionImpl
