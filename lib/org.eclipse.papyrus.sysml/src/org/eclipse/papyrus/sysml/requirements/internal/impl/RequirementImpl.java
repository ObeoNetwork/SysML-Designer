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
import org.eclipse.papyrus.sysml.requirements.Copy;
import org.eclipse.papyrus.sysml.requirements.DeriveReqt;
import org.eclipse.papyrus.sysml.requirements.Requirement;
import org.eclipse.papyrus.sysml.requirements.RequirementsPackage;
import org.eclipse.papyrus.sysml.requirements.Satisfy;
import org.eclipse.papyrus.sysml.requirements.Verify;
import org.eclipse.uml2.uml.Dependency;
import org.eclipse.uml2.uml.DirectedRelationship;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.profile.standard.Refine;
import org.eclipse.uml2.uml.profile.standard.StandardPackage;
import org.eclipse.uml2.uml.profile.standard.Trace;
import org.eclipse.uml2.uml.util.UMLUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Requirement</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementImpl#getText <em>Text</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementImpl#getId <em>Id</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementImpl#getDerived <em>Derived</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementImpl#getDerivedFrom <em>Derived From</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementImpl#getSatisfiedBy <em>Satisfied By</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementImpl#getRefinedBy <em>Refined By</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementImpl#getTracedTo <em>Traced To</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementImpl#getVerifiedBy <em>Verified By</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementImpl#getMaster <em>Master</em>}</li>
 * <li>{@link org.eclipse.papyrus.sysml.requirements.internal.impl.RequirementImpl#getBase_Class <em>Base Class</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class RequirementImpl extends MinimalEObjectImpl.Container implements Requirement {

	/**
	 * The default value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected static final String TEXT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getText() <em>Text</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getText()
	 * @generated
	 * @ordered
	 */
	protected String text = TEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

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
	protected RequirementImpl() {
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
	 * @generated NOT
	 */
	public Requirement basicGetMaster() {
		// The Requirement is the supplier of the Copy link between the master
		// Requirement and
		// current
		// This should return the TestCase verifying current Requirement
		Requirement master = null;
		Copy currentCopy = null;

		if(getBase_Class() != null) {
			Iterator<Dependency> itDep = getBase_Class().getClientDependencies().iterator();

			// Find Copy link
			while(itDep.hasNext()) {
				Dependency currentDep = itDep.next();
				currentCopy = UMLUtil.getStereotypeApplication(currentDep, Copy.class);

				if(currentCopy != null) {
					EList<NamedElement> suppliers = currentCopy.getBase_Abstraction().getSuppliers();
					Iterator<NamedElement> it = suppliers.iterator();
					while(it.hasNext() && (master == null)) {
						Requirement currentRequirement = UMLUtil.getStereotypeApplication(it.next(), Requirement.class);
						if(currentRequirement != null) {
							master = currentRequirement;
						}
					}
				}
			}
		}
		return master;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case RequirementsPackage.REQUIREMENT__TEXT:
			return getText();
		case RequirementsPackage.REQUIREMENT__ID:
			return getId();
		case RequirementsPackage.REQUIREMENT__DERIVED:
			return getDerived();
		case RequirementsPackage.REQUIREMENT__DERIVED_FROM:
			return getDerivedFrom();
		case RequirementsPackage.REQUIREMENT__SATISFIED_BY:
			return getSatisfiedBy();
		case RequirementsPackage.REQUIREMENT__REFINED_BY:
			return getRefinedBy();
		case RequirementsPackage.REQUIREMENT__TRACED_TO:
			return getTracedTo();
		case RequirementsPackage.REQUIREMENT__VERIFIED_BY:
			return getVerifiedBy();
		case RequirementsPackage.REQUIREMENT__MASTER:
			if(resolve)
				return getMaster();
			return basicGetMaster();
		case RequirementsPackage.REQUIREMENT__BASE_CLASS:
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
		case RequirementsPackage.REQUIREMENT__TEXT:
			return TEXT_EDEFAULT == null ? text != null : !TEXT_EDEFAULT.equals(text);
		case RequirementsPackage.REQUIREMENT__ID:
			return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
		case RequirementsPackage.REQUIREMENT__DERIVED:
			return !getDerived().isEmpty();
		case RequirementsPackage.REQUIREMENT__DERIVED_FROM:
			return !getDerivedFrom().isEmpty();
		case RequirementsPackage.REQUIREMENT__SATISFIED_BY:
			return !getSatisfiedBy().isEmpty();
		case RequirementsPackage.REQUIREMENT__REFINED_BY:
			return !getRefinedBy().isEmpty();
		case RequirementsPackage.REQUIREMENT__TRACED_TO:
			return !getTracedTo().isEmpty();
		case RequirementsPackage.REQUIREMENT__VERIFIED_BY:
			return !getVerifiedBy().isEmpty();
		case RequirementsPackage.REQUIREMENT__MASTER:
			return basicGetMaster() != null;
		case RequirementsPackage.REQUIREMENT__BASE_CLASS:
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
		case RequirementsPackage.REQUIREMENT__TEXT:
			setText((String)newValue);
			return;
		case RequirementsPackage.REQUIREMENT__ID:
			setId((String)newValue);
			return;
		case RequirementsPackage.REQUIREMENT__BASE_CLASS:
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
		return RequirementsPackage.Literals.REQUIREMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case RequirementsPackage.REQUIREMENT__TEXT:
			setText(TEXT_EDEFAULT);
			return;
		case RequirementsPackage.REQUIREMENT__ID:
			setId(ID_EDEFAULT);
			return;
		case RequirementsPackage.REQUIREMENT__BASE_CLASS:
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, RequirementsPackage.REQUIREMENT__BASE_CLASS, oldBase_Class, base_Class));
			}
		}
		return base_Class;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Requirement> getDerived() {
		// This should return the Requirement(s) derived from current
		EList<Requirement> derived = new BasicEList<Requirement>();
		DeriveReqt currentDeriveReqt = null;

		if(getBase_Class() != null) {
			Iterator<DirectedRelationship> itDep = getBase_Class().getTargetDirectedRelationships().iterator();

			// Find DeriveReqt link
			while(itDep.hasNext()) {
				DirectedRelationship currentDirectedRelationship = itDep.next();
				currentDeriveReqt = UMLUtil.getStereotypeApplication(currentDirectedRelationship, DeriveReqt.class);

				if(currentDeriveReqt != null) {
					EList<NamedElement> clients = currentDeriveReqt.getBase_Abstraction().getClients();
					Iterator<NamedElement> it = clients.iterator();
					while(it.hasNext()) {
						Requirement currentRequirement = UMLUtil.getStereotypeApplication(it.next(), Requirement.class);
						if(currentRequirement != null) {
							derived.add(currentRequirement);
						}
					}
				}
			}
		}

		UnmodifiableEList<Requirement> resultList = new UnmodifiableEList<Requirement>(this, RequirementsPackage.eINSTANCE.getRequirement_Derived(), derived.size(), derived.toArray());
		return resultList;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Requirement> getDerivedFrom() {
		// This should return the Requirement(s) this Requirement is derived
		// from
		EList<Requirement> derivedFrom = new BasicEList<Requirement>();
		DeriveReqt currentDeriveReqt = null;
		if(getBase_Class() != null) {
			Iterator<DirectedRelationship> itDep = getBase_Class().getSourceDirectedRelationships().iterator();

			// Find DeriveReqt link
			while(itDep.hasNext()) {
				DirectedRelationship currentDRelationship = itDep.next();
				currentDeriveReqt = UMLUtil.getStereotypeApplication(currentDRelationship, DeriveReqt.class);

				if(currentDeriveReqt != null) {
					EList<NamedElement> suppliers = currentDeriveReqt.getBase_Abstraction().getSuppliers();
					Iterator<NamedElement> it = suppliers.iterator();
					while(it.hasNext()) {
						Requirement currentRequirement = UMLUtil.getStereotypeApplication(it.next(), Requirement.class);
						if(currentRequirement != null) {
							derivedFrom.add(currentRequirement);
						}
					}
				}
			}
		}

		UnmodifiableEList<Requirement> resultList = new UnmodifiableEList<Requirement>(this, RequirementsPackage.eINSTANCE.getRequirement_DerivedFrom(), derivedFrom.size(), derivedFrom.toArray());
		return resultList;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public Requirement getMaster() {
		Requirement master = basicGetMaster();
		return master != null && master.eIsProxy() ? (Requirement)eResolveProxy((InternalEObject)master) : master;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<NamedElement> getRefinedBy() {
		// This should return the NamedElement(s) that refine current
		// Requirement
		EList<NamedElement> refinedBy = new BasicEList<NamedElement>();
		Refine currentRefine = null;

		if(getBase_Class() != null) {
			Iterator<DirectedRelationship> itDep = getBase_Class().getTargetDirectedRelationships().iterator();

			// Find Refine link
			while(itDep.hasNext()) {
				DirectedRelationship currentDRelationship = itDep.next();
				currentRefine = UMLUtil.getStereotypeApplication(currentDRelationship, Refine.class);

				if(currentRefine != null) {
					refinedBy.addAll(currentRefine.getBase_Abstraction().getClients());
				}
			}
		}

		UnmodifiableEList<NamedElement> resultList = new UnmodifiableEList<NamedElement>(this, RequirementsPackage.eINSTANCE.getRequirement_RefinedBy(), refinedBy.size(), refinedBy.toArray());
		return resultList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NamedElement getRefinedBy(String name) {
		return getRefinedBy(name, false, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NamedElement getRefinedBy(String name, boolean ignoreCase, EClass eClass) {
		refinedByLoop: for(NamedElement refinedBy : getRefinedBy()) {
			if(eClass != null && !eClass.isInstance(refinedBy))
				continue refinedByLoop;
			if(name != null && !(ignoreCase ? name.equalsIgnoreCase(refinedBy.getName()) : name.equals(refinedBy.getName())))
				continue refinedByLoop;
			return refinedBy;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<NamedElement> getSatisfiedBy() {
		// This should return the NamedElement(s) that satisfy current
		// Requirement
		EList<NamedElement> satisfyBy = new BasicEList<NamedElement>();
		Satisfy currentSatisfy = null;

		if(getBase_Class() != null) {
			Iterator<DirectedRelationship> itDep = getBase_Class().getTargetDirectedRelationships().iterator();

			// Find Satisfy link
			while(itDep.hasNext()) {
				DirectedRelationship currentDRelationship = itDep.next();
				currentSatisfy = UMLUtil.getStereotypeApplication(currentDRelationship, Satisfy.class);

				if(currentSatisfy != null) {
					satisfyBy.addAll(currentSatisfy.getBase_Abstraction().getClients());
				}
			}
		}

		UnmodifiableEList<NamedElement> resultList = new UnmodifiableEList<NamedElement>(this, RequirementsPackage.eINSTANCE.getRequirement_SatisfiedBy(), satisfyBy.size(), satisfyBy.toArray());
		return resultList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NamedElement getSatisfiedBy(String name) {
		return getSatisfiedBy(name, false, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NamedElement getSatisfiedBy(String name, boolean ignoreCase, EClass eClass) {
		satisfiedByLoop: for(NamedElement satisfiedBy : getSatisfiedBy()) {
			if(eClass != null && !eClass.isInstance(satisfiedBy))
				continue satisfiedByLoop;
			if(name != null && !(ignoreCase ? name.equalsIgnoreCase(satisfiedBy.getName()) : name.equals(satisfiedBy.getName())))
				continue satisfiedByLoop;
			return satisfiedBy;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getText() {
		return text;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<NamedElement> getTracedTo() {
		// This should return the NamedElement(s) traced by current Requirement
		// SysML spec. : Derived from all elements that are the client of a
		// «trace» relationship
		// for which this requirement is a supplier.
		EList<NamedElement> tracedTo = new BasicEList<NamedElement>();
		Trace currentTrace = null;

		if(getBase_Class() != null) {
			Iterator<DirectedRelationship> itDep = getBase_Class().getTargetDirectedRelationships().iterator();

			// Find Trace link
			while(itDep.hasNext()) {
				DirectedRelationship currentDR = itDep.next();
				currentTrace = UMLUtil.getStereotypeApplication(currentDR, Trace.class);

				// Must be a Trace not a subtype (see bug #352563).
				if((currentTrace != null) && (currentTrace.eClass() == StandardPackage.eINSTANCE.getTrace())) {
					EList<NamedElement> suppliers = currentTrace.getBase_Abstraction().getClients();
					tracedTo.addAll(suppliers);
				}
			}
		}

		UnmodifiableEList<NamedElement> resultList = new UnmodifiableEList<NamedElement>(this, RequirementsPackage.eINSTANCE.getRequirement_TracedTo(), tracedTo.size(), tracedTo.toArray());
		return resultList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NamedElement getTracedTo(String name) {
		return getTracedTo(name, false, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NamedElement getTracedTo(String name, boolean ignoreCase, EClass eClass) {
		tracedToLoop: for(NamedElement tracedTo : getTracedTo()) {
			if(eClass != null && !eClass.isInstance(tracedTo))
				continue tracedToLoop;
			if(name != null && !(ignoreCase ? name.equalsIgnoreCase(tracedTo.getName()) : name.equals(tracedTo.getName())))
				continue tracedToLoop;
			return tracedTo;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<NamedElement> getVerifiedBy() {
		// This should return the list of NamedElement verifying current
		// Requirement
		EList<NamedElement> verifiedBy = new BasicEList<NamedElement>();
		Verify currentVerify = null;

		if(getBase_Class() != null) {
			Iterator<DirectedRelationship> itDep = getBase_Class().getTargetDirectedRelationships().iterator();

			// Find Verify link
			while(itDep.hasNext()) {
				DirectedRelationship currentDRelationship = itDep.next();
				currentVerify = UMLUtil.getStereotypeApplication(currentDRelationship, Verify.class);

				if(currentVerify != null) {
					verifiedBy.addAll(currentVerify.getBase_Abstraction().getClients());
				}
			}
		}

		UnmodifiableEList<NamedElement> resultList = new UnmodifiableEList<NamedElement>(this, RequirementsPackage.eINSTANCE.getRequirement_VerifiedBy(), verifiedBy.size(), verifiedBy.toArray());
		return resultList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NamedElement getVerifiedBy(String name) {
		return getVerifiedBy(name, false, null);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NamedElement getVerifiedBy(String name, boolean ignoreCase, EClass eClass) {
		verifiedByLoop: for(NamedElement verifiedBy : getVerifiedBy()) {
			if(eClass != null && !eClass.isInstance(verifiedBy))
				continue verifiedByLoop;
			if(name != null && !(ignoreCase ? name.equalsIgnoreCase(verifiedBy.getName()) : name.equals(verifiedBy.getName())))
				continue verifiedByLoop;
			return verifiedBy;
		}
		return null;
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
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.REQUIREMENT__BASE_CLASS, oldBase_Class, base_Class));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.REQUIREMENT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public void setMaster(Requirement newMaster) {

	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setText(String newText) {
		String oldText = text;
		text = newText;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RequirementsPackage.REQUIREMENT__TEXT, oldText, text));
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
		result.append(" (text: ");
		result.append(text);
		result.append(", id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

} // RequirementImpl
