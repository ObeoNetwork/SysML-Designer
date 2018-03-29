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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.google.common.collect.Lists;

/**
 * Check if a service declared in a java extension is referenced from an
 * interpreted expression.
 */
@RunWith(value = Parameterized.class)
public class DeclaredServiceTests {

	private Method underTest;

    private static Set<String> allServiceCalls = new HashSet<String>();

    /**
     * The plug-in ID.
     */
    private static final String SYSML_DESIGNER_PLUGIN_ID = "org.obeonetwork.dsl.sysml.design"; //$NON-NLS-1$

	public DeclaredServiceTests(Method method) {
		this.underTest = method;
	}

	@Parameters
	public static Collection<Object[]> data() {
		List<Object[]> parameters = Lists.newArrayList();

		// Get all declared services
		Set<Method> allDeclaredServices = new HashSet<Method>();
		ServiceTestsUtils
				.collectDeclaredServicesFromSysmlDesignerViewpoints(allDeclaredServices);

		// Get all services called from interpreted expressions
		Set<InterpretedExpression> allServiceExpressions = new HashSet<InterpretedExpression>();
		ServiceTestsUtils
				.collectServiceExpressionFromSysmlDesignerViewpoints(allServiceExpressions);
		for (InterpretedExpression serviceExpression : allServiceExpressions) {
			allServiceCalls.addAll(ServiceTestsUtils
					.getServiceCall(serviceExpression.getExpression()));
		}

		for (Method method : allDeclaredServices) {
			parameters.add(new Object[] { method });
		}
		return parameters;
	}

    @Test
    public void isUnusedDeclaredService() {
        if (isSysmlPluginService(underTest.getDeclaringClass().getName()) && !allServiceCalls.contains(underTest.getName())) {
            fail("Declared service " + underTest + " is not referenced by the odesign");
        }
    }

    private static boolean isSysmlPluginService(String qualifiedName) {
        if (qualifiedName != null && qualifiedName.startsWith(SYSML_DESIGNER_PLUGIN_ID)) {
            return true;
        }
        return false;
    }
}
