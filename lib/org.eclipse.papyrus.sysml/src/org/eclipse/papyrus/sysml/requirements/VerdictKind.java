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
package org.eclipse.papyrus.sysml.requirements;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration ' <em><b>Verdict Kind</b></em>', and utility methods for working with
 * them.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.sysml.requirements.RequirementsPackage#getVerdictKind()
 * @model
 * @generated
 */
public enum VerdictKind implements Enumerator {
	/**
	 * The '<em><b>Pass</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #PASS_VALUE
	 * @generated
	 * @ordered
	 */
	PASS(0, "pass", "pass"),

	/**
	 * The '<em><b>Fail</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #FAIL_VALUE
	 * @generated
	 * @ordered
	 */
	FAIL(1, "fail", "fail"),

	/**
	 * The '<em><b>Inconclusive</b></em>' literal object. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #INCONCLUSIVE_VALUE
	 * @generated
	 * @ordered
	 */
	INCONCLUSIVE(2, "inconclusive", "inconclusive"),

	/**
	 * The '<em><b>Error</b></em>' literal object. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #ERROR_VALUE
	 * @generated
	 * @ordered
	 */
	ERROR(3, "error", "error");

	/**
	 * The '<em><b>Pass</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Pass</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #PASS
	 * @model name="pass"
	 * @generated
	 * @ordered
	 */
	public static final int PASS_VALUE = 0;

	/**
	 * The '<em><b>Fail</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Fail</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #FAIL
	 * @model name="fail"
	 * @generated
	 * @ordered
	 */
	public static final int FAIL_VALUE = 1;

	/**
	 * The '<em><b>Inconclusive</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Inconclusive</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #INCONCLUSIVE
	 * @model name="inconclusive"
	 * @generated
	 * @ordered
	 */
	public static final int INCONCLUSIVE_VALUE = 2;

	/**
	 * The '<em><b>Error</b></em>' literal value. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Error</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #ERROR
	 * @model name="error"
	 * @generated
	 * @ordered
	 */
	public static final int ERROR_VALUE = 3;

	/**
	 * An array of all the '<em><b>Verdict Kind</b></em>' enumerators. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final VerdictKind[] VALUES_ARRAY = new VerdictKind[]{ PASS, FAIL, INCONCLUSIVE, ERROR, };

	/**
	 * A public read-only list of all the '<em><b>Verdict Kind</b></em>'
	 * enumerators. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<VerdictKind> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Verdict Kind</b></em>' literal with the specified
	 * integer value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static VerdictKind get(int value) {
		switch(value) {
		case PASS_VALUE:
			return PASS;
		case FAIL_VALUE:
			return FAIL;
		case INCONCLUSIVE_VALUE:
			return INCONCLUSIVE;
		case ERROR_VALUE:
			return ERROR;
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Verdict Kind</b></em>' literal with the specified
	 * literal value. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static VerdictKind get(String literal) {
		for(int i = 0; i < VALUES_ARRAY.length; ++i) {
			VerdictKind result = VALUES_ARRAY[i];
			if(result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Verdict Kind</b></em>' literal with the specified
	 * name. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static VerdictKind getByName(String name) {
		for(int i = 0; i < VALUES_ARRAY.length; ++i) {
			VerdictKind result = VALUES_ARRAY[i];
			if(result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	private VerdictKind(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string
	 * representation. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} // VerdictKind
