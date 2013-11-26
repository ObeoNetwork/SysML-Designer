/*******************************************************************************
 * Copyright (c) 2009, 2011 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.sysml.design.services.internal;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Interface;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Port;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.util.UMLSwitch;
import org.obeonetwork.dsl.sysml.design.services.SysMLServices;
import org.obeonetwork.dsl.uml2.design.services.internal.ILabelConstants;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * A switch that handle the label computation for each SysML types.
 * 
 * @author Melanie Bats <a href="mailto:melanie.bats@obeo.fr">melanie.bats@obeo.fr</a>
 */
public class ComputeLabelSwitch extends UMLSwitch<String> implements ILabelConstants {

	SysMLServices service = new SysMLServices();

	@Override
	public String caseClass(Class element) {
		Predicate<EObject> predicate = null;
		if (service.isConstraintBlock(element)) {
			predicate = new Predicate<EObject>() {
				public boolean apply(EObject input) {
					return input instanceof Class && service.isConstraintBlock((Classifier)input);
				}
			};
			return computeLabel(element, getSysmlTypeName(element), predicate);
		} else if (service.isBlock(element)) {
			predicate = new Predicate<EObject>() {
				public boolean apply(EObject input) {
					return input instanceof Class && service.isBlock((Classifier)input);
				}
			};
			return computeLabel(element, getSysmlTypeName(element), predicate);
		} else if (service.isRequirement(element)) {
			predicate = new Predicate<EObject>() {
				public boolean apply(EObject input) {
					return input instanceof Class && service.isRequirement((Class)input);
				}
			};
			return computeLabel(element, getSysmlTypeName(element), predicate);
		}
		predicate = new Predicate<EObject>() {
			public boolean apply(EObject input) {
				return input instanceof Class;
			}
		};
		return computeLabel(element, getUmlTypeName(element), predicate);
	}

	@Override
	public String caseInterface(Interface element) {
		Predicate<EObject> predicate = new Predicate<EObject>() {
			public boolean apply(EObject input) {
				return input instanceof Interface;
			}
		};
		return computeLabel(element, getUmlTypeName(element), predicate);
	}

	@Override
	public String casePackage(Package element) {
		Predicate<EObject> predicate = new Predicate<EObject>() {
			public boolean apply(EObject input) {
				return input instanceof Package;
			}
		};
		return computeLabel(element, getUmlTypeName(element), predicate);
	}

	@Override
	public String caseActivity(Activity element) {
		Predicate<EObject> predicate = new Predicate<EObject>() {
			public boolean apply(EObject input) {
				return input instanceof Activity;
			}
		};
		return computeLabel(element, "function", predicate);
	}

	@Override
	public String caseOperation(Operation element) {
		Predicate<EObject> predicate = null;
		if (service.isTestCase(element)) {
			predicate = new Predicate<EObject>() {
				public boolean apply(EObject input) {
					return input instanceof Operation && service.isTestCase((NamedElement)input);
				}
			};
			return computeLabel(element, getSysmlTypeName(element), predicate);
		}
		predicate = new Predicate<EObject>() {
			public boolean apply(EObject input) {
				return input instanceof Operation;
			}
		};
		return computeLabel(element, "function", predicate);
	}

	@Override
	public String caseProperty(Property element) {
		Predicate<EObject> predicate = null;
		if (service.isConstraintProperty(element)) {
			predicate = new Predicate<EObject>() {
				public boolean apply(EObject input) {
					return input instanceof Property && service.isConstraintProperty((NamedElement)input);
				}
			};
			return computeLabel(element, getSysmlTypeName(element), predicate);
		}
		predicate = new Predicate<EObject>() {
			public boolean apply(EObject input) {
				return input instanceof Property;
			}
		};
		return computeLabel(element, getUmlTypeName(element), predicate);
	}

	@Override
	public String casePort(Port element) {
		Predicate<EObject> predicate = null;
		if (service.isFlowPort(element)) {
			predicate = new Predicate<EObject>() {
				public boolean apply(EObject input) {
					return input instanceof Port && service.isFlowPort((NamedElement)input);
				}
			};
			return computeLabel(element, getSysmlTypeName(element), predicate);
		}
		predicate = new Predicate<EObject>() {
			public boolean apply(EObject input) {
				return input instanceof Port;
			}
		};
		return computeLabel(element, getUmlTypeName(element), predicate);
	}

	/**
	 * Get type name based on the UML type.
	 * 
	 * @param element
	 *            Element
	 * @return Name
	 */
	private String getUmlTypeName(NamedElement element) {
		return getTypeName(element);
	}

	/**
	 * Get type name based on the SysML stereotype.
	 * 
	 * @param element
	 *            Element
	 * @return Name
	 */
	private String getSysmlTypeName(NamedElement element) {
		if (element != null && element.getStereotypeApplications().size() > 0) {
			return getTypeName(element.getStereotypeApplications().get(0));
		}
		return "";
	}

	/**
	 * Get type name.
	 * 
	 * @param element
	 *            Element
	 * @return Name
	 */
	private String getTypeName(Object element) {
		if (element != null) {
			String name = element.getClass().getSimpleName().toLowerCase();
			return name.substring(0, name.indexOf("impl"));
		}
		return "";
	}

	/**
	 * Compute default label : name + number of existing element.
	 * 
	 * @param element
	 *            Element
	 * @param name
	 *            Name
	 * @param predicate
	 *            Predicate
	 * @return Default label
	 */
	@SuppressWarnings("unchecked")
	private String computeLabel(EObject element, String name, Predicate predicate) {
		List<EObject> existingElements = Lists.newArrayList(Iterables.filter(
				element.eContainer().eContents(), predicate));

		return name + existingElements.size();
	}
}
