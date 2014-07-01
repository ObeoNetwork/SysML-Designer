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
package org.eclipse.papyrus.sysml.modelelements;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Comment;

/**
 * <!-- begin-user-doc --> A representation of the model object ' <em><b>Rationale</b></em>'. <!-- end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.sysml.modelelements.Rationale#getBase_Comment <em>Base Comment</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.sysml.modelelements.ModelelementsPackage#getRationale()
 * @model
 * @generated
 */
public interface Rationale extends EObject {

	/**
	 * Returns the value of the '<em><b>Base Comment</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Comment</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Comment</em>' reference.
	 * @see #setBase_Comment(Comment)
	 * @see org.eclipse.papyrus.sysml.modelelements.ModelelementsPackage#getRationale_Base_Comment()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Comment getBase_Comment();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.sysml.modelelements.Rationale#getBase_Comment <em>Base Comment</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Comment</em>' reference.
	 * @see #getBase_Comment()
	 * @generated
	 */
	void setBase_Comment(Comment value);

} // Rationale
