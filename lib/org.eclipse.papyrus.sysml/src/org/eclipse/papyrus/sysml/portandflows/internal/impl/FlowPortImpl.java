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
package org.eclipse.papyrus.sysml.portandflows.internal.impl;

import java.lang.reflect.InvocationTargetException;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.papyrus.sysml.portandflows.FlowDirection;
import org.eclipse.papyrus.sysml.portandflows.FlowPort;
import org.eclipse.papyrus.sysml.portandflows.FlowSpecification;
import org.eclipse.papyrus.sysml.portandflows.PortandflowsPackage;
import org.eclipse.uml2.uml.Image;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.Type;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Flow Port</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.portandflows.internal.impl.FlowPortImpl#getBase_Port <em>Base Port</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.portandflows.internal.impl.FlowPortImpl#isAtomic <em>Is Atomic</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.portandflows.internal.impl.FlowPortImpl#isConjugated <em>Is Conjugated</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.portandflows.internal.impl.FlowPortImpl#getDirection <em>Direction</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class FlowPortImpl extends MinimalEObjectImpl.Container implements FlowPort {

	/**
	 * The cached value of the '{@link #getBase_Port() <em>Base Port</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBase_Port()
	 * @generated
	 * @ordered
	 */
	protected Port base_Port;

	/**
	 * The default value of the '{@link #isAtomic() <em>Is Atomic</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isAtomic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_ATOMIC_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isConjugated() <em>Is Conjugated</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #isConjugated()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_CONJUGATED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isConjugated() <em>Is Conjugated</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isConjugated()
	 * @generated
	 * @ordered
	 */
	protected boolean isConjugated = IS_CONJUGATED_EDEFAULT;

	/**
	 * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected static final FlowDirection DIRECTION_EDEFAULT = FlowDirection.INOUT;

	/**
	 * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected FlowDirection direction = DIRECTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected FlowPortImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Port basicGetBase_Port() {
		return base_Port;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case PortandflowsPackage.FLOW_PORT__BASE_PORT:
			if(resolve)
				return getBase_Port();
			return basicGetBase_Port();
		case PortandflowsPackage.FLOW_PORT__IS_ATOMIC:
			return isAtomic();
		case PortandflowsPackage.FLOW_PORT__IS_CONJUGATED:
			return isConjugated();
		case PortandflowsPackage.FLOW_PORT__DIRECTION:
			return getDirection();
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
		case PortandflowsPackage.FLOW_PORT__BASE_PORT:
			return base_Port != null;
		case PortandflowsPackage.FLOW_PORT__IS_ATOMIC:
			return isAtomic() != IS_ATOMIC_EDEFAULT;
		case PortandflowsPackage.FLOW_PORT__IS_CONJUGATED:
			return isConjugated != IS_CONJUGATED_EDEFAULT;
		case PortandflowsPackage.FLOW_PORT__DIRECTION:
			return direction != DIRECTION_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch(operationID) {
		case PortandflowsPackage.FLOW_PORT___GET_ICON:
			return getIcon();
		}
		return super.eInvoke(operationID, arguments);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case PortandflowsPackage.FLOW_PORT__BASE_PORT:
			setBase_Port((Port)newValue);
			return;
		case PortandflowsPackage.FLOW_PORT__IS_CONJUGATED:
			setIsConjugated((Boolean)newValue);
			return;
		case PortandflowsPackage.FLOW_PORT__DIRECTION:
			setDirection((FlowDirection)newValue);
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
		return PortandflowsPackage.Literals.FLOW_PORT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case PortandflowsPackage.FLOW_PORT__BASE_PORT:
			setBase_Port((Port)null);
			return;
		case PortandflowsPackage.FLOW_PORT__IS_CONJUGATED:
			setIsConjugated(IS_CONJUGATED_EDEFAULT);
			return;
		case PortandflowsPackage.FLOW_PORT__DIRECTION:
			setDirection(DIRECTION_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Port getBase_Port() {
		if(base_Port != null && base_Port.eIsProxy()) {
			InternalEObject oldBase_Port = (InternalEObject)base_Port;
			base_Port = (Port)eResolveProxy(oldBase_Port);
			if(base_Port != oldBase_Port) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PortandflowsPackage.FLOW_PORT__BASE_PORT, oldBase_Port, base_Port));
			}
		}
		return base_Port;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public FlowDirection getDirection() {
		return direction;
	}

	/**
	 * <!-- begin-user-doc --> Images registered in Profile are : 0 - FlowPort
	 * (default, similar to INOUT) 1 - FlowPort IN 2 - FlowPort OUT 3 - FlowPort
	 * INOUT 4 - FlowPort NA (Non Atomic) <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Image getIcon() {

		Image ImageNotFound = null;

		if(getBase_Port() != null) {

			Stereotype st = UMLUtil.getStereotype(this);

			Image image = st.getIcons().get(0);

			if(isAtomic()) {
				if(getDirection() == FlowDirection.IN) {
					image = st.getIcons().get(1);
				} else if(getDirection() == FlowDirection.OUT) {
					image = st.getIcons().get(2);
				} else if(getDirection() == FlowDirection.INOUT) {
					image = st.getIcons().get(3);
				}

			} else {
				image = st.getIcons().get(4);
			}

			return image;

		} else {
			return ImageNotFound;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Port(Port newBase_Port) {
		Port oldBase_Port = base_Port;
		base_Port = newBase_Port;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PortandflowsPackage.FLOW_PORT__BASE_PORT, oldBase_Port, base_Port));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isAtomic() {
		// The FlowPort is Atomic if it is not typed by a FlowSpecification
		Boolean isAtomic = true;
		FlowSpecification flowSpec = null;

		if(getBase_Port() != null) {
			// Find FlowPort type
			Type type = getBase_Port().getType();
			if((type != null) && (type instanceof Interface)) {
				flowSpec = UMLUtil.getStereotypeApplication(type, FlowSpecification.class);
			}

			if(flowSpec != null) {
				isAtomic = false;
			}
		}
		return isAtomic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isConjugated() {
		return isConjugated;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDirection(FlowDirection newDirection) {
		FlowDirection oldDirection = direction;
		direction = newDirection == null ? DIRECTION_EDEFAULT : newDirection;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PortandflowsPackage.FLOW_PORT__DIRECTION, oldDirection, direction));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setIsAtomic(boolean newIsAtomic) {
		// TODO: implement this method to set the 'Is Atomic' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		// throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setIsConjugated(boolean newIsConjugated) {
		boolean oldIsConjugated = isConjugated;
		isConjugated = newIsConjugated;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PortandflowsPackage.FLOW_PORT__IS_CONJUGATED, oldIsConjugated, isConjugated));
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
		result.append(" (isConjugated: ");
		result.append(isConjugated);
		result.append(", direction: ");
		result.append(direction);
		result.append(')');
		return result.toString();
	}

} // FlowPortImpl
