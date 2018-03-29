/*******************************************************************************
 * Copyright (c) 2014 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.obeonetwork.dsl.sysml.design.tests.plugin.manual;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.sirius.business.api.componentization.ViewpointRegistry;
import org.eclipse.sirius.viewpoint.description.DescriptionPackage;
import org.eclipse.sirius.viewpoint.description.JavaExtension;
import org.eclipse.sirius.viewpoint.description.Viewpoint;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class ServiceTestsUtils {
	static final String VP_SYSML = "SysML";
	static final String SYSML_VP_URI = "viewpoint:/org.obeonetwork.dsl.sysml.design/";

	public static void collectJavaExtensionsFromSysmlDesignerViewpoints(
			Set<JavaExtension> allExtensions) {
		collectJavaExtensionsFromDesignerViewpoints(SYSML_VP_URI, VP_SYSML,
				allExtensions);
	}

	public static void collectDeclaredServicesFromSysmlDesignerViewpoints(
			Set<Method> allDeclaredServices) {
		collectDeclaredServicesFromDesignerViewpoints(allDeclaredServices,
				SYSML_VP_URI, VP_SYSML);
	}

	public static void collectServiceExpressionFromSysmlDesignerViewpoints(
			Set<InterpretedExpression> allServiceExpressions) {
		collectServiceExpressionFromSysmlDesignerViewpoints(
				allServiceExpressions, VP_SYSML);
	}

	public static void collectServiceExpressionFromSysmlDesignerViewpoints(
			Set<InterpretedExpression> allExpressions, String vpName) {
		collectServiceExpressionFromDesignerViewpoints(allExpressions,
				SYSML_VP_URI, vpName);
	}

	public static void collectServicesFromSysmlDesignerViewpoint(
			Set<Method> allServices, String viewpointName) {
		collectServicesFromDesignerViewpoint(allServices, VP_SYSML,
				SYSML_VP_URI);
	}

	public static void collectServiceExpressionFromSysmlDesignerViewpoint(
			Set<InterpretedExpression> allServiceExpressions,
			String viewpointName) {
		collectServiceExpressionFromSysmlDesignerViewpoints(
				allServiceExpressions, viewpointName);
	}

	private static Set<String> acceleoWhiteList = Sets.newHashSet("->",
			"eContainer", "toLowerFirst", "toUpperFirst", "not ", "eClass",
			"eAllContents", "eContents", "equalsIgnoreCase");

    private static Set<String> aqlWhiteList = Sets.newHashSet("<>", "null");

    private static Set<String> umlWhiteList = Sets
            .newHashSet(getAllUmlOperations());
    private static Set<String> sysmlWhiteList = Sets
            .newHashSet(getAllSysmlOperations());

    private static Set<String> siriusWhiteList = Sets.newHashSet("getTarget");

    public static void collectDeclaredServicesFromDesignerViewpoints(
            Set<Method> allDeclaredServices, String vpUri, String vpName) {
        Set<JavaExtension> allExtensions = new HashSet<JavaExtension>();
        collectJavaExtensionsFromDesignerViewpoints(vpUri, vpName,
                allExtensions);
        for (JavaExtension extension : allExtensions) {
            try {
                @SuppressWarnings("rawtypes")
                Class clazz = Class.forName(extension.getQualifiedClassName());
                for (Method method : clazz.getDeclaredMethods()) {
                    if (method.getModifiers() == Modifier.PUBLIC) {
                        allDeclaredServices.add(method);
                    }

                }
            } catch (ClassNotFoundException e) {
                // Nothing to do, this is checked by the {@link
                // JavaExtensionTests}
            }
        }
    }
    public static void collectServicesFromDesignerViewpoint(Set<Method> allServices, String vpName, String vpUri) {
        Set<JavaExtension> allExtensions = new HashSet<JavaExtension>();
        collectJavaExtensionsFromDesignerViewpoints(vpUri, vpName, allExtensions);
        for (JavaExtension extension : allExtensions) {
            try {
                @SuppressWarnings("rawtypes")
                Class clazz = Class.forName(extension.getQualifiedClassName());
                for (Method method : clazz.getMethods()) {
                    if (method.getModifiers() == Modifier.PUBLIC) {
                        allServices.add(method);
                    }
                }
            } catch (ClassNotFoundException e) {
                // Nothing to do, this is checked by the {@link
                // JavaExtensionTests}
            }
        }
    }

    protected static void collectServiceExpressionFromDesignerViewpoints(
            Set<InterpretedExpression> allExpressions, String vpUri,
            String vpName) {
        Viewpoint structural = ViewpointRegistry.getInstance().getViewpoint(
                URI.createURI(vpUri + vpName));
        collectServiceExpressionsFromViewpoint(structural, allExpressions);
    }

	private static void collectServiceExpressionsFromViewpoint(
			Viewpoint structural, Set<InterpretedExpression> allExpressions) {
		Iterator<EObject> it = structural.eAllContents();
		while (it.hasNext()) {
			EObject underTest = it.next();
			for (EAttribute attr : underTest.eClass().getEAllAttributes()) {
				if (attr.getEType() == DescriptionPackage.eINSTANCE
						.getInterpretedExpression()) {
					Object expr = underTest.eGet(attr);

					if (expr instanceof String && ((String) expr).length() > 0) {
						System.out.println(expr + " : "
								+ isService(((String) expr)));
						if (isService(((String) expr)))
							allExpressions.add(new InterpretedExpression(
									(String) expr, underTest, attr));
					}
				}
			}
		}
	}

	private static boolean isService(String expr) {
		if (isServiceInterpreterCall(expr) || isAcceleoServiceCall(expr) || isAqlServiceCall(expr)) {
			return true;
		}
		return false;
	}

	private static List<String> getAcceleoServiceCall(String expr) {
		if (expr.startsWith("[") && expr.endsWith("/]")) {
		    List<String> result = new ArrayList<String>();
		    String[] splitExpr = expr.split("\\.");
			for (String exprPart : splitExpr) {
				if (exprPart.matches("\\w+ *\\(.*")
						&& !exprPart.startsWith("ocl")
						&& !containsAcceleoKeywords(exprPart)
						&& !containsUmlOperations(getServiceName(exprPart))
						&& !containsSysmlOperations(getServiceName(exprPart))
						&& !containsSiriusOperations(exprPart)) {
				    result.add(getServiceName(exprPart));
				}
				return result;
			}
		}
		return null;
	}

	private static boolean containsAcceleoKeywords(String expression) {
		for (String keywords : acceleoWhiteList) {
			if (expression.contains(keywords))
				return true;
		}
		return false;
	}

	private static boolean containsUmlOperations(String expression) {
		for (String keywords : umlWhiteList) {
			if (expression.equals(keywords))
				return true;
		}
		return false;
	}

	private static boolean containsSysmlOperations(String expression) {
		for (String keywords : sysmlWhiteList) {
			if (expression.equals(keywords))
				return true;
		}
		return false;
	}

	private static boolean containsSiriusOperations(String expression) {
		for (String keywords : siriusWhiteList) {
			if (expression.equals(keywords))
				return true;
		}
		return false;
	}

	private static boolean isAcceleoServiceCall(String expr) {
		return getAcceleoServiceCall(expr) != null;
	}

	private static boolean isServiceInterpreterCall(String expr) {
		return getServiceInterpreterCall(expr) != null;
	}

	public static List<String> getServiceCall(String expression) {
	    if (isAqlServiceCall(expression)) {
            return getAqlServiceCall(expression);
        }
        if (isServiceInterpreterCall(expression)) {
			return getServiceInterpreterCall(expression);
		}
		if (isAcceleoServiceCall(expression)) {
			return getAcceleoServiceCall(expression);
		}
		return null;
	}

	private static List<String> getServiceInterpreterCall(String expression) {
		if (expression.startsWith("service:")) {
			String expr = expression.substring("service:".length());
			if (expression.contains(".")) {
				String[] splitExpr = expr.split("\\.");
				for (String exprPart : splitExpr) {
					String service = getServiceName(exprPart);
					if (!service.equals(exprPart)
							&& !containsUmlOperations(service)
							&& !containsSysmlOperations(service)
							&& !containsSiriusOperations(service)) {
						return  Arrays.asList(service);
					}
				}

				String service = splitExpr[splitExpr.length - 1];
				if (!containsUmlOperations(service)
						&& !containsSysmlOperations(service)
						&& !containsSiriusOperations(service)) {
					return  Arrays.asList(getServiceName(service));
				}
			} else if (!containsUmlOperations(expr)
					&& !containsSysmlOperations(expr)
					&& !containsSiriusOperations(expr)) {
				return  Arrays.asList(getServiceName(expr));
			}
		}
		return null;
	}

	private static String getServiceName(String expr) {
		if (expr.contains("(")) {
			return expr.substring(0, expr.indexOf("("));
		}
		return expr;
	}

	protected static void collectJavaExtensionsFromDesignerViewpoints(
			String vpUri, String vpName, Set<JavaExtension> allExtensions) {
		Viewpoint structural = ViewpointRegistry.getInstance().getViewpoint(
				URI.createURI(vpUri + vpName));
		collectJavaExtensionsFromViewpoint(structural, allExtensions);
	}

	private static void collectJavaExtensionsFromViewpoint(
			Viewpoint structural, Set<JavaExtension> allExtensions) {
		allExtensions.addAll(structural.getOwnedJavaExtensions());
	}

	private static List<String> getAllUmlOperations() {
		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();

        // Create a resource
        Resource res = resSet.getResource(
                URI.createURI("http://www.eclipse.org/uml2/5.0.0/UML"),
                true);
        EObject root = res.getContents().get(0);

		// Get all eOperations
		List<EObject> umlOperations = Lists.newArrayList();
		Iterators.addAll(
				umlOperations,
				Iterators.filter(root.eAllContents(),
						Predicates.instanceOf(EOperation.class)));

		// Get eOperation names
		List<String> result = Lists.newArrayList();
		for (EObject umlOperation : umlOperations) {
			result.add(((EOperation) umlOperation).getName());
		}
		return result;
	}

	private static List<String> getAllSysmlOperations() {
		// Obtain a new resource set
		ResourceSet resSet = new ResourceSetImpl();

        // Create a resource
        Resource res = resSet.getResource(
                URI.createURI("http://www.eclipse.org/papyrus/sysml/1.4/SysML"),
                true);
        EObject root = res.getContents().get(0);

		// Get all eOperations
		List<EObject> sysmlOperations = Lists.newArrayList();
		Iterators.addAll(
				sysmlOperations,
				Iterators.filter(root.eAllContents(),
						Predicates.instanceOf(EOperation.class)));

        // Get eOperation names
        List<String> result = Lists.newArrayList();
        for (EObject sysmlOperation : sysmlOperations) {
            result.add(((EOperation) sysmlOperation).getName());
        }
        return result;
    }

    private static List<String> getAqlServiceCall(String expr) {
        if (expr.startsWith("aql:")) {
            List<String> result = new ArrayList<String>();

            // several call to a service can be done in an expression (for
            // example if/then/else)
            String[] splitExpr = expr.split("\\.");
            for (String exprPart : splitExpr) {
                if (exprPart.matches("\\w+ *\\(.*") && !exprPart.startsWith("ocl") && !containsAcceleoKeywords(exprPart) && !containsAqlKeywords(exprPart)
                        && !containsUmlOperations(getServiceName(exprPart)) && !containsSysmlOperations(getServiceName(exprPart)) && !containsSiriusOperations(exprPart)) {
                    result.add(getServiceName(exprPart));
                }
            }
            return result;
        }
        return null;
    }

    private static boolean containsAqlKeywords(String expression) {
        for (String keywords : aqlWhiteList) {
            if (expression.contains(keywords))
                return true;
        }
        return false;
    }

    private static boolean isAqlServiceCall(String expr) {
        return expr.startsWith("aql:");
    }
}
