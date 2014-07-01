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
import org.eclipse.papyrus.sysml.blocks.Unit;
import org.eclipse.uml2.uml.InstanceSpecification;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Unit</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.blocks.internal.impl.UnitImpl#getBase_InstanceSpecification <em>Base Instance Specification</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.blocks.internal.impl.UnitImpl#getDimension <em>Dimension</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class UnitImpl extends MinimalEObjectImpl.Container implements Unit {

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
	 * The cached value of the '{@link #getDimension() <em>Dimension</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDimension()
	 * @generated
	 * @ordered
	 */
	protected Dimension dimension;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected UnitImpl() {
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
	public Dimension basicGetDimension() {
		return dimension;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case BlocksPackage.UNIT__BASE_INSTANCE_SPECIFICATION:
			if(resolve)
				return getBase_InstanceSpecification();
			return basicGetBase_InstanceSpecification();
		case BlocksPackage.UNIT__DIMENSION:
			if(resolve)
				return getDimension();
			return basicGetDimension();
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
		case BlocksPackage.UNIT__BASE_INSTANCE_SPECIFICATION:
			return base_InstanceSpecification != null;
		case BlocksPackage.UNIT__DIMENSION:
			return dimension != null;
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
		case BlocksPackage.UNIT__BASE_INSTANCE_SPECIFICATION:
			setBase_InstanceSpecification((InstanceSpecification)newValue);
			return;
		case BlocksPackage.UNIT__DIMENSION:
			setDimension((Dimension)newValue);
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
		return BlocksPackage.Literals.UNIT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case BlocksPackage.UNIT__BASE_INSTANCE_SPECIFICATION:
			setBase_InstanceSpecification((InstanceSpecification)null);
			return;
		case BlocksPackage.UNIT__DIMENSION:
			setDimension((Dimension)null);
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BlocksPackage.UNIT__BASE_INSTANCE_SPECIFICATION, oldBase_InstanceSpecification, base_InstanceSpecification));
			}
		}
		return base_InstanceSpecification;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Dimension getDimension() {
		if(dimension != null && dimension.eIsProxy()) {
			InternalEObject oldDimension = (InternalEObject)dimension;
			dimension = (Dimension)eResolveProxy(oldDimension);
			if(dimension != oldDimension) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BlocksPackage.UNIT__DIMENSION, oldDimension, dimension));
			}
		}
		return dimension;
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
			eNotify(new ENotificationImpl(this, Notification.SET, BlocksPackage.UNIT__BASE_INSTANCE_SPECIFICATION, oldBase_InstanceSpecification, base_InstanceSpecification));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDimension(Dimension newDimension) {
		Dimension oldDimension = dimension;
		dimension = newDimension;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BlocksPackage.UNIT__DIMENSION, oldDimension, dimension));
	}

} // UnitImpl
