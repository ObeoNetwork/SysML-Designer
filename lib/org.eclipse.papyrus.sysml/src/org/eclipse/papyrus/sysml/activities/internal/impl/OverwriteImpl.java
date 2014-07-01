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
import org.eclipse.papyrus.sysml.activities.Overwrite;
import org.eclipse.uml2.uml.ObjectNode;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Overwrite</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.activities.internal.impl.OverwriteImpl#getBase_ObjectNode <em>Base Object Node</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class OverwriteImpl extends MinimalEObjectImpl.Container implements Overwrite {

	/**
	 * The cached value of the '{@link #getBase_ObjectNode() <em>Base Object Node</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getBase_ObjectNode()
	 * @generated
	 * @ordered
	 */
	protected ObjectNode base_ObjectNode;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected OverwriteImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ObjectNode basicGetBase_ObjectNode() {
		return base_ObjectNode;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case ActivitiesPackage.OVERWRITE__BASE_OBJECT_NODE:
			if(resolve)
				return getBase_ObjectNode();
			return basicGetBase_ObjectNode();
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
		case ActivitiesPackage.OVERWRITE__BASE_OBJECT_NODE:
			return base_ObjectNode != null;
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
		case ActivitiesPackage.OVERWRITE__BASE_OBJECT_NODE:
			setBase_ObjectNode((ObjectNode)newValue);
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
		return ActivitiesPackage.Literals.OVERWRITE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case ActivitiesPackage.OVERWRITE__BASE_OBJECT_NODE:
			setBase_ObjectNode((ObjectNode)null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ObjectNode getBase_ObjectNode() {
		if(base_ObjectNode != null && base_ObjectNode.eIsProxy()) {
			InternalEObject oldBase_ObjectNode = (InternalEObject)base_ObjectNode;
			base_ObjectNode = (ObjectNode)eResolveProxy(oldBase_ObjectNode);
			if(base_ObjectNode != oldBase_ObjectNode) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ActivitiesPackage.OVERWRITE__BASE_OBJECT_NODE, oldBase_ObjectNode, base_ObjectNode));
			}
		}
		return base_ObjectNode;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_ObjectNode(ObjectNode newBase_ObjectNode) {
		ObjectNode oldBase_ObjectNode = base_ObjectNode;
		base_ObjectNode = newBase_ObjectNode;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ActivitiesPackage.OVERWRITE__BASE_OBJECT_NODE, oldBase_ObjectNode, base_ObjectNode));
	}

} // OverwriteImpl
