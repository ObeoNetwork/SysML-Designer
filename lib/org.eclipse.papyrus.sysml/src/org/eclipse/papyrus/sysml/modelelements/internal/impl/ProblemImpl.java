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
package org.eclipse.papyrus.sysml.modelelements.internal.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.sysml.modelelements.ModelelementsPackage;
import org.eclipse.papyrus.sysml.modelelements.Problem;
import org.eclipse.uml2.uml.Comment;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Problem</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.modelelements.internal.impl.ProblemImpl#getBase_Comment <em>Base Comment</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ProblemImpl extends MinimalEObjectImpl.Container implements Problem {

	/**
	 * The cached value of the '{@link #getBase_Comment() <em>Base Comment</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBase_Comment()
	 * @generated
	 * @ordered
	 */
	protected Comment base_Comment;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ProblemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Comment basicGetBase_Comment() {
		return base_Comment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case ModelelementsPackage.PROBLEM__BASE_COMMENT:
			if(resolve)
				return getBase_Comment();
			return basicGetBase_Comment();
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
		case ModelelementsPackage.PROBLEM__BASE_COMMENT:
			return base_Comment != null;
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
		case ModelelementsPackage.PROBLEM__BASE_COMMENT:
			setBase_Comment((Comment)newValue);
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
		return ModelelementsPackage.Literals.PROBLEM;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case ModelelementsPackage.PROBLEM__BASE_COMMENT:
			setBase_Comment((Comment)null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Comment getBase_Comment() {
		if(base_Comment != null && base_Comment.eIsProxy()) {
			InternalEObject oldBase_Comment = (InternalEObject)base_Comment;
			base_Comment = (Comment)eResolveProxy(oldBase_Comment);
			if(base_Comment != oldBase_Comment) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelelementsPackage.PROBLEM__BASE_COMMENT, oldBase_Comment, base_Comment));
			}
		}
		return base_Comment;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Comment(Comment newBase_Comment) {
		Comment oldBase_Comment = base_Comment;
		base_Comment = newBase_Comment;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelelementsPackage.PROBLEM__BASE_COMMENT, oldBase_Comment, base_Comment));
	}

} // ProblemImpl
