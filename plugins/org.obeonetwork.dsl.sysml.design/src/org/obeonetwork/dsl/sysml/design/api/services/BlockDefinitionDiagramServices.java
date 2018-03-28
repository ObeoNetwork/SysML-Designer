/*******************************************************************************
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.sysml.design.api.services;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.papyrus.sysml14.blocks.ValueType;
import org.eclipse.papyrus.sysml14.requirements.Requirement;
import org.eclipse.papyrus.sysml14.util.QUDVUtil;
import org.eclipse.sirius.business.api.session.SessionManager;
import org.eclipse.sirius.diagram.DDiagram;
import org.eclipse.uml2.uml.Abstraction;
import org.eclipse.uml2.uml.Actor;
import org.eclipse.uml2.uml.Association;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Classifier;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.obeonetwork.dsl.sysml.design.internal.services.SysmlElementServices;
import org.obeonetwork.dsl.uml2.core.api.utils.UmlUtils;
import org.obeonetwork.dsl.uml2.core.internal.services.LabelServices;
import org.obeonetwork.dsl.uml2.core.internal.services.NodeInverseRefsServices;

import com.google.common.collect.Lists;

/**
 * A set of services to handle the Block Definition diagram.
 *
 * @author Melanie Bats <a href="mailto:melanie.bats@obeo.fr">melanie.bats@obeo.fr</a>
 */
public class BlockDefinitionDiagramServices extends SysmlAbstractDiagramServices {

	private static final Classifier UNIT_CLASS = QUDVUtil
			.getClassifierByNameSpaceFromQUDV(QUDVUtil.UNIT_AND_QUANTITY_KIND, QUDVUtil.UNIT);

	private static final Classifier QUANTITY_KIND__CLASS = QUDVUtil
			.getClassifierByNameSpaceFromQUDV(QUDVUtil.UNIT_AND_QUANTITY_KIND, QUDVUtil.QUANTITY_KIND);

	/**
	 * Compute the label of the given association.
	 *
	 * @param association
	 *            the {@link Association} for which to retrieve a label.
	 * @return the computed label.
	 */
	public String computeAssociationBeginLabel(Association association) {
		return LabelServices.INSTANCE.computeAssociationBeginLabel(association);
	}

	/**
	 * Compute the label of the given association.
	 *
	 * @param association
	 *            the {@link Association} for which to retrieve a label.
	 * @return the computed label.
	 */
	public String computeAssociationEndLabel(Association association) {
		return LabelServices.INSTANCE.computeAssociationEndLabel(association);
	}

	/**
	 * Get all actors.
	 *
	 * @param element
	 *            element
	 * @return All actors.
	 */
	public List<Element> getAllActorsAndContainers(Element element) {
		final List<Element> results = Lists.newArrayList();
		final List<Package> models = getAllAvailableRootPackages(element);
		results.addAll(models);
		for (final Package pkg : models) {
			for (final Iterator<EObject> iterator = pkg.eAllContents(); iterator.hasNext();) {
				final EObject iter = iterator.next();
				if (iter instanceof Actor || iter instanceof Package) {
					results.add((Element)iter);
				}
			}
		}

		return results;
	}

	/**
	 * Get all dimensions.
	 *
	 * @param container
	 *            Package
	 * @return All dimensions.
	 */
	public List<InstanceSpecification> getAllDimensions(Element valueType) {
		final List<InstanceSpecification> results = Lists.newArrayList();
		for (final Iterator<EObject> iterator = valueType.getModel().eAllContents(); iterator.hasNext();) {
			final EObject element = iterator.next();
			if (element instanceof InstanceSpecification && isDimension((InstanceSpecification)element)) {
				results.add((InstanceSpecification)element);
			}
		}
		return results;
	}

	/**
	 * Get all the stereotype applications according to the selected diagram.
	 *
	 * @param diagram
	 *            Current diagram
	 * @return Stereotype applications
	 */
	public Collection<Object> getAllStereotypeApplications(DDiagram diagram) {
		return org.obeonetwork.dsl.uml2.core.internal.services.StereotypeServices.INSTANCE
				.getAllStereotypeApplications(diagram);
	}

	/**
	 * Get all units.
	 *
	 * @param container
	 *            Package
	 * @return All units.
	 */
	public List<InstanceSpecification> getAllUnits(Element valueType) {
		final List<InstanceSpecification> results = Lists.newArrayList();
		for (final Iterator<EObject> iterator = valueType.getModel().eAllContents(); iterator.hasNext();) {
			final EObject element = iterator.next();
			if (element instanceof InstanceSpecification && isUnit((InstanceSpecification)element)) {
				results.add((InstanceSpecification)element);
			}
		}
		return results;
	}

	/**
	 * @see NodeInverseRefsServices#getAssociationInverseRefs(DDiagram)
	 */
	public Collection<EObject> getAssociationInverseRefs(DDiagram diagram) {
		return NodeInverseRefsServices.INSTANCE.getAssociationInverseRefs(diagram);
	}

	/**
	 * Get base class associated to a stereotype application.
	 *
	 * @param stereotypeApplication
	 *            Stereotype application
	 * @return Base class
	 */
	public Element getBaseClass(EObject stereotypeApplication) {
		return org.obeonetwork.dsl.uml2.core.internal.services.StereotypeServices.INSTANCE
				.getBaseClass(stereotypeApplication);
	}

	/**
	 * @see NodeInverseRefsServices#getDependencyInverseRefs(DDiagram)
	 */
	public Collection<EObject> getDependencyInverseRefs(DDiagram diagram) {
		return NodeInverseRefsServices.INSTANCE.getDependencyInverseRefs(diagram);
	}

	/**
	 * Get dimension.
	 *
	 * @param container
	 *            Package
	 * @return Dimension.
	 */
	public InstanceSpecification getDimension(Element valueType) {
		for (final EObject stereotype : valueType.getStereotypeApplications()) {
			if (stereotype instanceof ValueType) {
				return ((ValueType)stereotype).getQuantityKind();
			}
		}
		return null;
	}

	/**
	 * @see NodeInverseRefsServices#getGeneralizationInverseRefs(DDiagram)
	 */
	public Collection<EObject> getGeneralizationInverseRefs(DDiagram diagram) {
		return NodeInverseRefsServices.INSTANCE.getGeneralizationInverseRefs(diagram);
	}

	/**
	 * Retrieve the cross references of the interface realization of all the UML elements displayed as node in
	 * a Diagram. Note that a Property cross reference will lead to retrieve the cross references of this
	 * property.
	 *
	 * @param diagram
	 *            a diagram.
	 * @return the list of cross reference of the given
	 */
	public Collection<EObject> getInterfaceRealizationInverseRefs(DDiagram diagram) {
		return NodeInverseRefsServices.INSTANCE.getInterfaceRealizationInverseRefs(diagram);
	}

	/**
	 * Get satisfied requirements.
	 *
	 * @param element
	 *            Block
	 * @return Requirements satisfied by the given block
	 */
	public List<Class> getSatisfiedRequirements(Class element) {
		final List<Class> results = Lists.newArrayList();
		final Collection<Setting> xRefs = SessionManager.INSTANCE.getSession(element)
				.getSemanticCrossReferencer().getInverseReferences(element);
		for (final Setting xRef : xRefs) {
			final EObject eObject = xRef.getEObject();
			if (eObject instanceof Abstraction) {
				for (final Element supplier : ((Abstraction)eObject).getSuppliers()) {
					if (supplier instanceof Class) {
						for (final EObject stereotype : supplier.getStereotypeApplications()) {
							if (stereotype instanceof Requirement) {
								results.add((Class)supplier);
							}
						}
					}
				}
			}
		}
		return results;
	}

	/**
	 * Return the source of an association.
	 *
	 * @param association
	 *            the {@link Association} context
	 * @return first end of the association
	 */
	public Property getSource(Association association) {
		return org.obeonetwork.dsl.uml2.core.internal.services.AssociationServices.INSTANCE
				.getSource(association);
	}

	/**
	 * Get stereotype application label.
	 *
	 * @param stereotypeApplication
	 *            Stereotype application
	 * @return The stereotype name.
	 */
	public String getStereotypeApplicationLabel(EObject stereotypeApplication) {
		return org.obeonetwork.dsl.uml2.core.internal.services.StereotypeServices.INSTANCE
				.getStereotypeApplicationLabel(stereotypeApplication);
	}

	/**
	 * Return the target of an association.
	 *
	 * @param association
	 *            the {@link Association} context
	 * @return second end of the association
	 */
	public Property getTarget(Association association) {
		return org.obeonetwork.dsl.uml2.core.internal.services.AssociationServices.INSTANCE
				.getTarget(association);
	}

	/**
	 * Get UML String type.
	 *
	 * @param object
	 *            the object for which to find the corresponding String type
	 * @return the found String element or null
	 */
	public Type getUmlStringType(EObject object) {
		return UmlUtils.INSTANCE.findTypeByName(object, "String"); //$NON-NLS-1$
	}

	/**
	 * Get unit.
	 *
	 * @param container
	 *            Package
	 * @return Unit.
	 */
	public InstanceSpecification getUnit(Element valueType) {
		for (final EObject stereotype : valueType.getStereotypeApplications()) {
			if (stereotype instanceof ValueType) {
				return ((ValueType)stereotype).getUnit();
			}
		}
		return null;
	}

	/**
	 * @see SysmlElementServices#isBlock(Element)
	 */
	public boolean isBlock(Element element) {
		return SysmlElementServices.INSTANCE.isBlock(element);
	}

	/**
	 * @see SysmlElementServices#isConstraintBlock(Classifier)
	 */
	public boolean isConstraintBlock(Classifier element) {
		return SysmlElementServices.INSTANCE.isConstraintBlock(element);
	}

	/**
	 * Checks if element specifies a QUDV Quantity Kind
	 *
	 * @param element
	 *            the specification to check.
	 * @return True if element specifies a QUDV Quantity Kind otherwise false
	 */
	public boolean isDimension(InstanceSpecification element) {
		// all classifiers must be a Quantity Kind (see ValueType SysML Specifications).
		for (final Classifier specifiedClassifier : element.getClassifiers()) {
			if (!specifiedClassifier.isSubstitutableFor(QUANTITY_KIND__CLASS)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @see SysmlElementServices#isRequirement(Element)
	 */
	public boolean isRequirement(Element element) {
		return SysmlElementServices.INSTANCE.isRequirement(element);
	}

	/**
	 * Checks if the given element is an unit. It returns <code>true</code> if the given classifier is the
	 * Unit classifier or a subtype of the Unit classifier.
	 *
	 * @param classifierToCheck
	 *            the classifier to check.
	 * @return returns <code>true</code> if the given classifier is the Unit classifier or a subtype of the
	 *         Unit classifier.
	 */
	private boolean isUnit(final Classifier classifierToCheck) {
		return classifierToCheck.isSubstitutableFor(UNIT_CLASS);
	}

	/**
	 * Checks if element specifies a QUDV Unit.
	 *
	 * @param element
	 *            the specification to check.
	 * @return True if element specifies an unit otherwise false.
	 */
	public boolean isUnit(InstanceSpecification element) {
		// all classifiers must be an Unit (see ValueType SysML Specifications).
		for (final Classifier specifiedClassifier : element.getClassifiers()) {
			if (!isUnit(specifiedClassifier)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if an element is a valid root of a block definition diagram.
	 *
	 * @param element
	 *            Named element
	 * @return True if element could be a root of a block definition diagram otherwise false
	 */
	public boolean isValidBlockDefinitionDiagramRoot(NamedElement element) {
		// Replace the acceleo expression : [self.oclIsKindOf(uml::Package) or
		// self->filter(uml::Class).getStereotypeApplications()->filter(sysml::blocks::Block)->size() > 0/]
		if (element instanceof Package) {
			return true;
		} else if (element instanceof Class) {
			return SysmlElementServices.INSTANCE.isBlock(element);
		}
		return false;
	}

	/**
	 * Checks if element has the stereotype value type.
	 *
	 * @param element
	 *            Named element
	 * @return True if element is a value type otherwise false
	 */
	public boolean isValueType(NamedElement element) {
		for (final EObject stereotype : element.getStereotypeApplications()) {
			if (stereotype instanceof ValueType) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Set dimension.
	 *
	 * @param dataType
	 *            Datatype
	 * @param instanceSpecification
	 *            Dimension
	 */
	public void setDimension(Element dataType, InstanceSpecification instanceSpecification) {
		if (dataType.getStereotypeApplications() != null) {
			final EObject stereotype = dataType.getStereotypeApplications().get(0);
			if (stereotype instanceof ValueType) {
				final ValueType valueType = (ValueType)stereotype;
				valueType.setQuantityKind(instanceSpecification);
			}
		}
	}

	/**
	 * Set unit.
	 *
	 * @param dataType
	 *            Datatype
	 * @param instanceSpecification
	 *            unit
	 */
	public void setUnit(Element dataType, InstanceSpecification instanceSpecification) {
		if (dataType.getStereotypeApplications() != null) {
			final EObject stereotype = dataType.getStereotypeApplications().get(0);
			if (stereotype instanceof ValueType) {
				final ValueType valueType = (ValueType)stereotype;
				valueType.setUnit(instanceSpecification);
			}
		}
	}

	public void unsetDimension(EObject valueType) {
		((ValueType)((Element)valueType).getStereotypeApplications()).setQuantityKind(null);
	}

	/**
	 * Update stereotype of element if needed.
	 *
	 * @param element
	 *            the given Element.
	 * @return the element updated.
	 */
	public Element updateStereotype(Element element) {
		// nothing to do anymore.
		return element;
	}
}
