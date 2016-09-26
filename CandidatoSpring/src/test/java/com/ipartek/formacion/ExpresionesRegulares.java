package com.ipartek.formacion;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExpresionesRegulares {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testReemplazar() {
		Pattern patron = Pattern.compile("a*b");
		Pattern patron2 = Pattern.compile("123 a");
		Matcher matcher = patron.matcher("ab");
		assertTrue(matcher.find());

		matcher = patron.matcher("aaabbb");
		assertTrue(matcher.find());

		matcher = patron.matcher("adhs34573b");
		assertTrue(matcher.find());

		matcher = patron.matcher("ac");
		assertFalse(matcher.find());

		matcher = patron2.matcher("123");
		assertFalse(matcher.matches());

		matcher = patron2.matcher("123a");
		assertFalse(matcher.find());

	}

}
