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

import static org.junit.Assert.fail;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.google.common.collect.Lists;

/**
 * Check if a service called from an interpreted expression exists.
 */
@RunWith(value = Parameterized.class)
public class ServiceExpressionSysmlViewpointTests {
	private InterpretedExpression underTest;

	private static Set<String> allServices = new HashSet<String>();

	public ServiceExpressionSysmlViewpointTests(InterpretedExpression expression) {
		this.underTest = expression;
	}

	@Parameters
	public static Collection<Object[]> data() {
		List<Object[]> parameters = Lists.newArrayList();

		// Get all services
		Set<Method> allMethods = new HashSet<Method>();
		ServiceTestsUtils.collectServicesFromSysmlDesignerViewpoint(allMethods,
				ServiceTestsUtils.VP_SYSML);
		for (Method method : allMethods) {
			allServices.add(method.getName());
		}

		// Get all services called from interpreted expressions
		Set<InterpretedExpression> allServiceExpressions = new HashSet<InterpretedExpression>();
		ServiceTestsUtils.collectServiceExpressionFromSysmlDesignerViewpoint(
				allServiceExpressions, ServiceTestsUtils.VP_SYSML);
		for (InterpretedExpression interpretedExpression : allServiceExpressions) {
			parameters.add(new Object[] { interpretedExpression });
		}
		return parameters;
	}

	@Test
	public void isValidService() {
		String expression = underTest.getExpression();
		String service = ServiceTestsUtils.getServiceCall(expression);

		if (service != null && !allServices.contains(service)) {
			fail("Expression : " + underTest.getExpression()
					+ " refers to an invalid service :" + service + ". See :"
					+ underTest.getFeature().getName() + " of object "
					+ EcoreUtil.getURI(underTest.getDeclaration()));
		}
	}
}
