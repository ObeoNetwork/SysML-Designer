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
package org.eclipse.papyrus.sysml.blocks.internal.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.sysml.blocks.BlocksPackage;
import org.eclipse.papyrus.sysml.blocks.Dimension;
import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Dimension</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.blocks.internal.impl.DimensionImpl#getBase_InstanceSpecification <em>Base Instance Specification</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class DimensionImpl extends MinimalEObjectImpl.Container implements Dimension {

	/**
	 * The cached value of the '{@link #getBase_InstanceSpecification() <em>Base Instance Specification</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBase_InstanceSpecification()
	 * @generated
	 * @ordered
	 */
	protected InstanceSpecification base_InstanceSpecification;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected DimensionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InstanceSpecification basicGetBase_InstanceSpecification() {
		return base_InstanceSpecification;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case BlocksPackage.DIMENSION__BASE_INSTANCE_SPECIFICATION:
			if(resolve)
				return getBase_InstanceSpecification();
			return basicGetBase_InstanceSpecification();
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
		case BlocksPackage.DIMENSION__BASE_INSTANCE_SPECIFICATION:
			return base_InstanceSpecification != null;
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
		case BlocksPackage.DIMENSION__BASE_INSTANCE_SPECIFICATION:
			setBase_InstanceSpecification((InstanceSpecification)newValue);
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
		return BlocksPackage.Literals.DIMENSION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case BlocksPackage.DIMENSION__BASE_INSTANCE_SPECIFICATION:
			setBase_InstanceSpecification((InstanceSpecification)null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InstanceSpecification getBase_InstanceSpecification() {
		if(base_InstanceSpecification != null && base_InstanceSpecification.eIsProxy()) {
			InternalEObject oldBase_InstanceSpecification = (InternalEObject)base_InstanceSpecification;
			base_InstanceSpecification = (InstanceSpecification)eResolveProxy(oldBase_InstanceSpecification);
			if(base_InstanceSpecification != oldBase_InstanceSpecification) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BlocksPackage.DIMENSION__BASE_INSTANCE_SPECIFICATION, oldBase_InstanceSpecification, base_InstanceSpecification));
			}
		}
		return base_InstanceSpecification;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_InstanceSpecification(InstanceSpecification newBase_InstanceSpecification) {
		InstanceSpecification oldBase_InstanceSpecification = base_InstanceSpecification;
		base_InstanceSpecification = newBase_InstanceSpecification;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BlocksPackage.DIMENSION__BASE_INSTANCE_SPECIFICATION, oldBase_InstanceSpecification, base_InstanceSpecification));
	}

} // DimensionImpl
