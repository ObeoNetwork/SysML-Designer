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
package org.eclipse.papyrus.sysml.requirements.internal.impl;

import java.util.Iterator;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEList.UnmodifiableEList;
import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.eclipse.papyrus.sysml.requirements.RequirementsPackage;
import org.eclipse.papyrus.sysml.requirements.TestCase;
import org.eclipse.papyrus.sysml.requirements.Verify;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Test Case</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.internal.impl.TestCaseImpl#getBase_Behavior <em>Base Behavior</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.internal.impl.TestCaseImpl#getBase_Operation <em>Base Operation</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.internal.impl.TestCaseImpl#getVerifies <em>Verifies</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class TestCaseImpl extends MinimalEObjectImpl.Container implements TestCase {

	/**
	 * The cached value of the '{@link #getBase_Behavior() <em>Base Behavior</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getBase_Behavior()
	 * @generated
	 * @ordered
	 */
	protected Behavior base_Behavior;

	/**
	 * The cached value of the '{@link #getBase_Operation() <em>Base Operation</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getBase_Operation()
	 * @generated
	 * @ordered
	 */
	protected Operation base_Operation;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected TestCaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Behavior basicGetBase_Behavior() {
		return base_Behavior;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Operation basicGetBase_Operation() {
		return base_Operation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case RequirementsPackage.TEST_CASE__BASE_BEHAVIOR:
			if(resolve)
				return getBase_Behavior();
			return basicGetBase_Behavior();
		case RequirementsPackage.TEST_CASE__BASE_OPERATION:
			if(resolve)
				return getBase_Operation();
			return basicGetBase_Operation();
		case RequirementsPackage.TEST_CASE__VERIFIES:
			return getVerifies();
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
		case RequirementsPackage.TEST_CASE__BASE_BEHAVIOR:
			return base_Behavior != null;
		case RequirementsPackage.TEST_CASE__BASE_OPERATION:
			return base_Operation != null;
		case RequirementsPackage.TEST_CASE__VERIFIES:
			return !getVerifies().isEmpty();
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
		case RequirementsPackage.TEST_CASE__BASE_BEHAVIOR:
			setBase_Behavior((Behavior)newValue);
			return;
		case RequirementsPackage.TEST_CASE__BASE_OPERATION:
			setBase_Operation((Operation)newValue);
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
		return RequirementsPackage.Literals.TEST_CASE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case RequirementsPackage.TEST_CASE__BASE_BEHAVIOR:
			setBase_Behavior((Behavior)null);
			return;
		case RequirementsPackage.TEST_CASE__BASE_OPERATION:
			setBase_Operation((Operation)null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Behavior getBase_Behavior() {
		if(base_Behavior != null && base_Behavior.eIsProxy()) {
			InternalEObject oldBase_Behavior = (InternalEObject)base_Behavior;
			base_Behavior = (Behavior)eResolveProxy(oldBase_Behavior);
			if(base_Behavior != oldBase_Behavior) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RequirementsPackage.TEST_CASE__BASE_BEHAVIOR, oldBase_Behavior, base_Behavior));
			}
		}
		return base_Behavior;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Operation getBase_Operation() {
		if(base_Operation != null && base_Operation.eIsProxy()) {
			InternalEObject oldBase_Operation = (InternalEObject)base_Operation;
			base_Operation = (Operation)eResolveProxy(oldBase_Operation);
			if(base_Operation != oldBase_Operation) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RequirementsPackage.TEST_CASE__BASE_OPERATION, oldBase_Operation, base_Operation));
			}
		}
		return base_Operation;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Requirement> getVerifies() {
		// This should return the Requirements verified by current TestCase
		EList<Requirement> verifies = new BasicEList<Requirement>();
		Verify currentVerify = null;

		if((getBase_Behavior() != null) || (getBase_Operation() != null)) {
			// Find Verify link
			Iterator<Dependency> itDep;
			if(getBase_Behavior() != null) {
				itDep = getBase_Behavior().getClientDependencies().iterator();
			} else { // if (getBase_Operation() != null)
				itDep = getBase_Operation().getClientDependencies().iterator();
			}

			while(itDep.hasNext()) {
				Dependency currentDependency = itDep.next();
				currentVerify = UMLUtil.getStereotypeApplication(currentDependency, Verify.class);

				if(currentVerify != null) {
					EList<NamedElement> suppliers = currentVerify.getBase_Abstraction().getSuppliers();
					Iterator<NamedElement> it = suppliers.iterator();
					while(it.hasNext()) {
						Requirement currentRequirement = UMLUtil.getStereotypeApplication(it.next(), Requirement.class);
						if(currentRequirement != null) {
							verifies.add(currentRequirement);
						}
					}
				}
			}
		}

		UnmodifiableEList<Requirement> resultList = new UnmodifiableEList<Requirement>(this, RequirementsPackage.eINSTANCE.getTestCase_Verifies(), verifies.size(), verifies.toArray());
		return resultList;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Behavior(Behavior newBase_Behavior) {
		Behavior oldBase_Behavior = base_Behavior;
		base_Behavior = newBase_Behavior;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.TEST_CASE__BASE_BEHAVIOR, oldBase_Behavior, base_Behavior));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Operation(Operation newBase_Operation) {
		Operation oldBase_Operation = base_Operation;
		base_Operation = newBase_Operation;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.TEST_CASE__BASE_OPERATION, oldBase_Operation, base_Operation));
	}

} // TestCaseImpl
