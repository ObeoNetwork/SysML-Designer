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
import org.eclipse.papyrus.sysml.blocks.Block;
import org.eclipse.papyrus.sysml.blocks.BlocksPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Block</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.blocks.internal.impl.BlockImpl#isEncapsulated <em>Is Encapsulated</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.blocks.internal.impl.BlockImpl#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class BlockImpl extends MinimalEObjectImpl.Container implements Block {

	/**
	 * The default value of the '{@link #isEncapsulated() <em>Is Encapsulated</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isEncapsulated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ENCAPSULATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEncapsulated() <em>Is Encapsulated</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isEncapsulated()
	 * @generated
	 * @ordered
	 */
	protected boolean isEncapsulated = IS_ENCAPSULATED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBase_Class() <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBase_Class()
	 * @generated
	 * @ordered
	 */
	protected org.eclipse.uml2.uml.Class base_Class;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected BlockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class basicGetBase_Class() {
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case BlocksPackage.BLOCK__IS_ENCAPSULATED:
			return isEncapsulated();
		case BlocksPackage.BLOCK__BASE_CLASS:
			if(resolve)
				return getBase_Class();
			return basicGetBase_Class();
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
		case BlocksPackage.BLOCK__IS_ENCAPSULATED:
			return isEncapsulated != IS_ENCAPSULATED_EDEFAULT;
		case BlocksPackage.BLOCK__BASE_CLASS:
			return base_Class != null;
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
		case BlocksPackage.BLOCK__IS_ENCAPSULATED:
			setIsEncapsulated((Boolean)newValue);
			return;
		case BlocksPackage.BLOCK__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)newValue);
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
		return BlocksPackage.Literals.BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isEncapsulated() {
		return isEncapsulated;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case BlocksPackage.BLOCK__IS_ENCAPSULATED:
			setIsEncapsulated(IS_ENCAPSULATED_EDEFAULT);
			return;
		case BlocksPackage.BLOCK__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public org.eclipse.uml2.uml.Class getBase_Class() {
		if(base_Class != null && base_Class.eIsProxy()) {
			InternalEObject oldBase_Class = (InternalEObject)base_Class;
			base_Class = (org.eclipse.uml2.uml.Class)eResolveProxy(oldBase_Class);
			if(base_Class != oldBase_Class) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BlocksPackage.BLOCK__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Class(org.eclipse.uml2.uml.Class newBase_Class) {
		org.eclipse.uml2.uml.Class oldBase_Class = base_Class;
		base_Class = newBase_Class;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BlocksPackage.BLOCK__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setIsEncapsulated(boolean newIsEncapsulated) {
		boolean oldIsEncapsulated = isEncapsulated;
		isEncapsulated = newIsEncapsulated;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BlocksPackage.BLOCK__IS_ENCAPSULATED, oldIsEncapsulated, isEncapsulated));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if(eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (isEncapsulated: ");
		result.append(isEncapsulated);
		result.append(')');
		return result.toString();
	}

} // BlockImpl
