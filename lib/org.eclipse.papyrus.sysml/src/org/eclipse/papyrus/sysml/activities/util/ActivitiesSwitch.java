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
package org.eclipse.papyrus.sysml.activities.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.papyrus.sysml.activities.ActivitiesPackage;
import org.eclipse.papyrus.sysml.activities.Continuous;
import org.eclipse.papyrus.sysml.activities.ControlOperator;
import org.eclipse.papyrus.sysml.activities.Discrete;
import org.eclipse.papyrus.sysml.activities.NoBuffer;
import org.eclipse.papyrus.sysml.activities.Optional;
import org.eclipse.papyrus.sysml.activities.Overwrite;
import org.eclipse.papyrus.sysml.activities.Probability;
import org.eclipse.papyrus.sysml.activities.Rate;

/**
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance
 * hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the
 * inheritance hierarchy until a non-null result is returned, which is the
 * result of the switch. <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.sysml.activities.ActivitiesPackage
 * @generated
 */
public class ActivitiesSwitch<T> extends Switch<T> {

	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected static ActivitiesPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public ActivitiesSwitch() {
		if(modelPackage == null) {
			modelPackage = ActivitiesPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Continuous</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Continuous</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContinuous(Continuous object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Control Operator</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Control Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseControlOperator(ControlOperator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Discrete</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Discrete</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDiscrete(Discrete object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>No Buffer</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>No Buffer</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNoBuffer(NoBuffer object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Overwrite</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Overwrite</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOverwrite(Overwrite object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Probability</em>'.
	 * <!-- begin-user-doc --> This implementation
	 * returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Probability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProbability(Probability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of ' <em>Rate</em>'. <!-- begin-user-doc --> This implementation returns null;
	 * returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of ' <em>Rate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRate(Rate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch, but this is
	 * the last case anyway. <!-- end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch(classifierID) {
		case ActivitiesPackage.OPTIONAL:
		{
			Optional optional = (Optional)theEObject;
			T result = caseOptional(optional);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ActivitiesPackage.RATE:
		{
			Rate rate = (Rate)theEObject;
			T result = caseRate(rate);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ActivitiesPackage.PROBABILITY:
		{
			Probability probability = (Probability)theEObject;
			T result = caseProbability(probability);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ActivitiesPackage.CONTINUOUS:
		{
			Continuous continuous = (Continuous)theEObject;
			T result = caseContinuous(continuous);
			if(result == null)
				result = caseRate(continuous);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ActivitiesPackage.DISCRETE:
		{
			Discrete discrete = (Discrete)theEObject;
			T result = caseDiscrete(discrete);
			if(result == null)
				result = caseRate(discrete);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ActivitiesPackage.CONTROL_OPERATOR:
		{
			ControlOperator controlOperator = (ControlOperator)theEObject;
			T result = caseControlOperator(controlOperator);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ActivitiesPackage.NO_BUFFER:
		{
			NoBuffer noBuffer = (NoBuffer)theEObject;
			T result = caseNoBuffer(noBuffer);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case ActivitiesPackage.OVERWRITE:
		{
			Overwrite overwrite = (Overwrite)theEObject;
			T result = caseOverwrite(overwrite);
			if(result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Optional</em>'.
	 * <!-- begin-user-doc --> This implementation returns
	 * null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object
	 *        the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Optional</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOptional(Optional object) {
		return null;
	}

} // ActivitiesSwitch
