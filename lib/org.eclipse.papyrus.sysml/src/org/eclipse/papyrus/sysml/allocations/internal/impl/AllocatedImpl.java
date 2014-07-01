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

import java.util.Iterator;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEList.UnmodifiableEList;
import org.eclipse.papyrus.sysml.allocations.Allocate;
import org.eclipse.papyrus.sysml.allocations.Allocated;
import org.eclipse.papyrus.sysml.allocations.AllocationsPackage;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Allocated</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.allocations.internal.impl.AllocatedImpl#getBase_NamedElement <em>Base Named Element</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.allocations.internal.impl.AllocatedImpl#getAllocatedFrom <em>Allocated From</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.allocations.internal.impl.AllocatedImpl#getAllocatedTo <em>Allocated To</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class AllocatedImpl extends MinimalEObjectImpl.Container implements Allocated {

	/**
	 * The cached value of the '{@link #getBase_NamedElement() <em>Base Named Element</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getBase_NamedElement()
	 * @generated
	 * @ordered
	 */
	protected NamedElement base_NamedElement;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected AllocatedImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NamedElement basicGetBase_NamedElement() {
		return base_NamedElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case AllocationsPackage.ALLOCATED__BASE_NAMED_ELEMENT:
			if(resolve)
				return getBase_NamedElement();
			return basicGetBase_NamedElement();
		case AllocationsPackage.ALLOCATED__ALLOCATED_FROM:
			return getAllocatedFrom();
		case AllocationsPackage.ALLOCATED__ALLOCATED_TO:
			return getAllocatedTo();
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
		case AllocationsPackage.ALLOCATED__BASE_NAMED_ELEMENT:
			return base_NamedElement != null;
		case AllocationsPackage.ALLOCATED__ALLOCATED_FROM:
			return !getAllocatedFrom().isEmpty();
		case AllocationsPackage.ALLOCATED__ALLOCATED_TO:
			return !getAllocatedTo().isEmpty();
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
		case AllocationsPackage.ALLOCATED__BASE_NAMED_ELEMENT:
			setBase_NamedElement((NamedElement)newValue);
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
		return AllocationsPackage.Literals.ALLOCATED;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case AllocationsPackage.ALLOCATED__BASE_NAMED_ELEMENT:
			setBase_NamedElement((NamedElement)null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<NamedElement> getAllocatedFrom() {
		// AllocatedFrom property lists all the named elements linked to current
		// by an Allocate link.
		// Current element is the target of the Allocate link.
		EList<NamedElement> allocatedFrom = new BasicEList<NamedElement>();
		Allocate currentAllocate = null;

		if(getBase_NamedElement() != null) {
			// Find Allocate link
			Iterator<DirectedRelationship> itDep = getBase_NamedElement().getTargetDirectedRelationships().iterator();
			while(itDep.hasNext()) {
				DirectedRelationship currentDRelationship = itDep.next();
				currentAllocate = UMLUtil.getStereotypeApplication(currentDRelationship, Allocate.class);

				if(currentAllocate != null) {
					EList<Element> targets = currentAllocate.getBase_Abstraction().getSources();
					Iterator<Element> it = targets.iterator();
					while(it.hasNext()) {
						Element currentElt = it.next();
						if(currentElt instanceof NamedElement) {
							allocatedFrom.add((NamedElement)currentElt);
						}
					}
				}
			}
		}

		UnmodifiableEList<NamedElement> resultList = new UnmodifiableEList<NamedElement>(this, AllocationsPackage.eINSTANCE.getAllocated_AllocatedFrom(), allocatedFrom.size(), allocatedFrom.toArray());
		return resultList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NamedElement getAllocatedFrom(String name) {
		return getAllocatedFrom(name, false, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NamedElement getAllocatedFrom(String name, boolean ignoreCase, EClass eClass) {
		allocatedFromLoop: for(NamedElement allocatedFrom : getAllocatedFrom()) {
			if(eClass != null && !eClass.isInstance(allocatedFrom))
				continue allocatedFromLoop;
			if(name != null && !(ignoreCase ? name.equalsIgnoreCase(allocatedFrom.getName()) : name.equals(allocatedFrom.getName())))
				continue allocatedFromLoop;
			return allocatedFrom;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<NamedElement> getAllocatedTo() {
		// AllocatedFrom property lists all the named elements linked to current
		// by an Allocate link.
		// Current element is the target of the Allocate link.
		EList<NamedElement> allocatedTo = new BasicEList<NamedElement>();
		Allocate currentAllocate = null;

		if(getBase_NamedElement() != null) {
			// Find Allocate link
			Iterator<Dependency> itDep = getBase_NamedElement().getClientDependencies().iterator();
			while(itDep.hasNext()) {
				Dependency currentDependency = itDep.next();
				currentAllocate = UMLUtil.getStereotypeApplication(currentDependency, Allocate.class);

				if(currentAllocate != null) {
					allocatedTo.addAll(currentAllocate.getBase_Abstraction().getSuppliers());
				}
			}
		}
		UnmodifiableEList<NamedElement> resultList = new UnmodifiableEList<NamedElement>(this, AllocationsPackage.eINSTANCE.getAllocated_AllocatedTo(), allocatedTo.size(), allocatedTo.toArray());
		return resultList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NamedElement getAllocatedTo(String name) {
		return getAllocatedTo(name, false, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NamedElement getAllocatedTo(String name, boolean ignoreCase, EClass eClass) {
		allocatedToLoop: for(NamedElement allocatedTo : getAllocatedTo()) {
			if(eClass != null && !eClass.isInstance(allocatedTo))
				continue allocatedToLoop;
			if(name != null && !(ignoreCase ? name.equalsIgnoreCase(allocatedTo.getName()) : name.equals(allocatedTo.getName())))
				continue allocatedToLoop;
			return allocatedTo;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NamedElement getBase_NamedElement() {
		if(base_NamedElement != null && base_NamedElement.eIsProxy()) {
			InternalEObject oldBase_NamedElement = (InternalEObject)base_NamedElement;
			base_NamedElement = (NamedElement)eResolveProxy(oldBase_NamedElement);
			if(base_NamedElement != oldBase_NamedElement) {
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AllocationsPackage.ALLOCATED__BASE_NAMED_ELEMENT, oldBase_NamedElement, base_NamedElement));
			}
		}
		return base_NamedElement;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setBase_NamedElement(NamedElement newBase_NamedElement) {
		NamedElement oldBase_NamedElement = base_NamedElement;
		base_NamedElement = newBase_NamedElement;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AllocationsPackage.ALLOCATED__BASE_NAMED_ELEMENT, oldBase_NamedElement, base_NamedElement));
	}

} // AllocatedImpl
