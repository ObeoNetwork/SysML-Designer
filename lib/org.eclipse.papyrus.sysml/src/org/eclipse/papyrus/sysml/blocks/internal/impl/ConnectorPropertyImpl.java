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
import org.eclipse.papyrus.sysml.blocks.ConnectorProperty;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Property;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Connector Property</b></em> '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.blocks.internal.impl.ConnectorPropertyImpl#getBase_Property <em>Base Property</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.blocks.internal.impl.ConnectorPropertyImpl#getConnector <em>Connector</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ConnectorPropertyImpl extends MinimalEObjectImpl.Container implements ConnectorProperty {

	/**
	 * The cached value of the '{@link #getBase_Property() <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getBase_Property()
	 * @generated
	 * @ordered
	 */
	protected Property base_Property;

	/**
	 * The cached value of the '{@link #getConnector() <em>Connector</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getConnector()
	 * @generated
	 * @ordered
	 */
	protected Connector connector;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ConnectorPropertyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Property basicGetBase_Property() {
		return base_Property;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Connector basicGetConnector() {
		return connector;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case BlocksPackage.CONNECTOR_PROPERTY__BASE_PROPERTY:
			if(resolve)
				return getBase_Property();
			return basicGetBase_Property();
		case BlocksPackage.CONNECTOR_PROPERTY__CONNECTOR:
			if(resolve)
				return getConnector();
			return basicGetConnector();
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
		case BlocksPackage.CONNECTOR_PROPERTY__BASE_PROPERTY:
			return base_Property != null;
		case BlocksPackage.CONNECTOR_PROPERTY__CONNECTOR:
			return connector != null;
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
		case BlocksPackage.CONNECTOR_PROPERTY__BASE_PROPERTY:
			setBase_Property((Property)newValue);
			return;
		case BlocksPackage.CONNECTOR_PROPERTY__CONNECTOR:
			setConnector((Connector)newValue);
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
		return BlocksPackage.Literals.CONNECTOR_PROPERTY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case BlocksPackage.CONNECTOR_PROPERTY__BASE_PROPERTY:
			setBase_Property((Property)null);
			return;
		case BlocksPackage.CONNECTOR_PROPERTY__CONNECTOR:
			setConnector((Connector)null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Property getBase_Property() {
		if(base_Property != null && base_Property.eIsProxy()) {
			InternalEObject oldBase_Property = (InternalEObject)base_Property;
			base_Property = (Property)eResolveProxy(oldBase_Property);
			if(base_Property != oldBase_Property) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BlocksPackage.CONNECTOR_PROPERTY__BASE_PROPERTY, oldBase_Property, base_Property));
			}
		}
		return base_Property;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Connector getConnector() {
		if(connector != null && connector.eIsProxy()) {
			InternalEObject oldConnector = (InternalEObject)connector;
			connector = (Connector)eResolveProxy(oldConnector);
			if(connector != oldConnector) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, BlocksPackage.CONNECTOR_PROPERTY__CONNECTOR, oldConnector, connector));
			}
		}
		return connector;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_Property(Property newBase_Property) {
		Property oldBase_Property = base_Property;
		base_Property = newBase_Property;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BlocksPackage.CONNECTOR_PROPERTY__BASE_PROPERTY, oldBase_Property, base_Property));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setConnector(Connector newConnector) {
		Connector oldConnector = connector;
		connector = newConnector;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, BlocksPackage.CONNECTOR_PROPERTY__CONNECTOR, oldConnector, connector));
	}

} // ConnectorPropertyImpl
