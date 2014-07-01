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

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.papyrus.sysml.modelelements.ModelelementsPackage;
import org.eclipse.papyrus.sysml.modelelements.ViewPoint;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>View Point</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.modelelements.internal.impl.ViewPointImpl#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.modelelements.internal.impl.ViewPointImpl#getStakeHolders <em>Stake Holders</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.modelelements.internal.impl.ViewPointImpl#getPurpose <em>Purpose</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.modelelements.internal.impl.ViewPointImpl#getConcerns <em>Concerns</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.modelelements.internal.impl.ViewPointImpl#getLanguages <em>Languages</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.modelelements.internal.impl.ViewPointImpl#getMethods <em>Methods</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ViewPointImpl extends MinimalEObjectImpl.Container implements ViewPoint {

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
	 * The cached value of the '{@link #getStakeHolders() <em>Stake Holders</em>}' attribute list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getStakeHolders()
	 * @generated
	 * @ordered
	 */
	protected EList<String> stakeHolders;

	/**
	 * The default value of the '{@link #getPurpose() <em>Purpose</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPurpose()
	 * @generated
	 * @ordered
	 */
	protected static final String PURPOSE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPurpose() <em>Purpose</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getPurpose()
	 * @generated
	 * @ordered
	 */
	protected String purpose = PURPOSE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getConcerns() <em>Concerns</em>}' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConcerns()
	 * @generated
	 * @ordered
	 */
	protected EList<String> concerns;

	/**
	 * The cached value of the '{@link #getLanguages() <em>Languages</em>}' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getLanguages()
	 * @generated
	 * @ordered
	 */
	protected EList<String> languages;

	/**
	 * The cached value of the '{@link #getMethods() <em>Methods</em>}' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMethods()
	 * @generated
	 * @ordered
	 */
	protected EList<String> methods;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ViewPointImpl() {
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
		case ModelelementsPackage.VIEW_POINT__BASE_CLASS:
			if(resolve)
				return getBase_Class();
			return basicGetBase_Class();
		case ModelelementsPackage.VIEW_POINT__STAKE_HOLDERS:
			return getStakeHolders();
		case ModelelementsPackage.VIEW_POINT__PURPOSE:
			return getPurpose();
		case ModelelementsPackage.VIEW_POINT__CONCERNS:
			return getConcerns();
		case ModelelementsPackage.VIEW_POINT__LANGUAGES:
			return getLanguages();
		case ModelelementsPackage.VIEW_POINT__METHODS:
			return getMethods();
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
		case ModelelementsPackage.VIEW_POINT__BASE_CLASS:
			return base_Class != null;
		case ModelelementsPackage.VIEW_POINT__STAKE_HOLDERS:
			return stakeHolders != null && !stakeHolders.isEmpty();
		case ModelelementsPackage.VIEW_POINT__PURPOSE:
			return PURPOSE_EDEFAULT == null ? purpose != null : !PURPOSE_EDEFAULT.equals(purpose);
		case ModelelementsPackage.VIEW_POINT__CONCERNS:
			return concerns != null && !concerns.isEmpty();
		case ModelelementsPackage.VIEW_POINT__LANGUAGES:
			return languages != null && !languages.isEmpty();
		case ModelelementsPackage.VIEW_POINT__METHODS:
			return methods != null && !methods.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case ModelelementsPackage.VIEW_POINT__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)newValue);
			return;
		case ModelelementsPackage.VIEW_POINT__STAKE_HOLDERS:
			getStakeHolders().clear();
			getStakeHolders().addAll((Collection<? extends String>)newValue);
			return;
		case ModelelementsPackage.VIEW_POINT__PURPOSE:
			setPurpose((String)newValue);
			return;
		case ModelelementsPackage.VIEW_POINT__CONCERNS:
			getConcerns().clear();
			getConcerns().addAll((Collection<? extends String>)newValue);
			return;
		case ModelelementsPackage.VIEW_POINT__LANGUAGES:
			getLanguages().clear();
			getLanguages().addAll((Collection<? extends String>)newValue);
			return;
		case ModelelementsPackage.VIEW_POINT__METHODS:
			getMethods().clear();
			getMethods().addAll((Collection<? extends String>)newValue);
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
		return ModelelementsPackage.Literals.VIEW_POINT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case ModelelementsPackage.VIEW_POINT__BASE_CLASS:
			setBase_Class((org.eclipse.uml2.uml.Class)null);
			return;
		case ModelelementsPackage.VIEW_POINT__STAKE_HOLDERS:
			getStakeHolders().clear();
			return;
		case ModelelementsPackage.VIEW_POINT__PURPOSE:
			setPurpose(PURPOSE_EDEFAULT);
			return;
		case ModelelementsPackage.VIEW_POINT__CONCERNS:
			getConcerns().clear();
			return;
		case ModelelementsPackage.VIEW_POINT__LANGUAGES:
			getLanguages().clear();
			return;
		case ModelelementsPackage.VIEW_POINT__METHODS:
			getMethods().clear();
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelelementsPackage.VIEW_POINT__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<String> getConcerns() {
		if(concerns == null) {
			concerns = new EDataTypeEList<String>(String.class, this, ModelelementsPackage.VIEW_POINT__CONCERNS);
		}
		return concerns;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<String> getLanguages() {
		if(languages == null) {
			languages = new EDataTypeEList<String>(String.class, this, ModelelementsPackage.VIEW_POINT__LANGUAGES);
		}
		return languages;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<String> getMethods() {
		if(methods == null) {
			methods = new EDataTypeEList<String>(String.class, this, ModelelementsPackage.VIEW_POINT__METHODS);
		}
		return methods;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getPurpose() {
		return purpose;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<String> getStakeHolders() {
		if(stakeHolders == null) {
			stakeHolders = new EDataTypeEList<String>(String.class, this, ModelelementsPackage.VIEW_POINT__STAKE_HOLDERS);
		}
		return stakeHolders;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelelementsPackage.VIEW_POINT__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setPurpose(String newPurpose) {
		String oldPurpose = purpose;
		purpose = newPurpose;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelelementsPackage.VIEW_POINT__PURPOSE, oldPurpose, purpose));
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
		result.append(" (stakeHolders: ");
		result.append(stakeHolders);
		result.append(", purpose: ");
		result.append(purpose);
		result.append(", concerns: ");
		result.append(concerns);
		result.append(", languages: ");
		result.append(languages);
		result.append(", methods: ");
		result.append(methods);
		result.append(')');
		return result.toString();
	}

} // ViewPointImpl
