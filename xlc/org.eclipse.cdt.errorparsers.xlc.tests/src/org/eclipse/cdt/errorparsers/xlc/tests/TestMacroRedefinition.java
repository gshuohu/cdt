/*******************************************************************************
 * Copyright (c) 2006, 2010 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.cdt.errorparsers.xlc.tests;

import junit.framework.TestCase;

import org.eclipse.cdt.core.IMarkerGenerator;

public class TestMacroRedefinition extends TestCase {
	/**
	 * This function tests parseLine function of the
	 * XlcErrorParser class. The second message generated by
	 * xlc compiler for macro redefinition problem is given as
	 * input for testing.
	 */
	public void testparseLine()
	{
		XlcErrorParserTester aix = new XlcErrorParserTester();
		// Macro redefinition warning generates 2 messages. First line is ignored.
		// Second line is re-parsed to 2 warnings to cross-reference both.
		String err_msg1 = "\"temp1.c\", line 5.9: 1506-236 (W) Macro name TEMP_1 has been redefined.";
		String err_msg2 = "\"temp1.c\", line 5.9: 1506-358 (I) \"TEMP_1\" is defined on line 3 of temp1.h.";
		aix.parseLine(err_msg1);
		aix.parseLine(err_msg2);
		assertEquals(2, aix.getNumberOfMarkers());
		
		assertEquals("Macro name TEMP_1 has been redefined on line 5 of temp1.c", aix.getMessage(0));
		assertEquals("temp1.h", aix.getFileName(0));
		assertEquals(3, aix.getLineNumber(0));
		assertEquals(IMarkerGenerator.SEVERITY_WARNING, aix.getSeverity(0));
		
		assertEquals("Macro name TEMP_1 redefines macro originally defined on line 3 of temp1.h", aix.getMessage(1));
		assertEquals("temp1.c", aix.getFileName(1));
		assertEquals(5, aix.getLineNumber(1));
		assertEquals(IMarkerGenerator.SEVERITY_WARNING, aix.getSeverity(1));
	}
	public TestMacroRedefinition( String name)
	{
		super(name);
	}
}