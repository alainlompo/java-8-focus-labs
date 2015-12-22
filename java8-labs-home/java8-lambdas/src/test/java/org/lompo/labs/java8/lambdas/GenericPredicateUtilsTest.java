package org.lompo.labs.java8.lambdas;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GenericPredicateUtilsTest {
	@Test
	public void isNotNullTest() {
		GenericPredicatesUtils<String> utils = new GenericPredicatesUtils<String>();
		String helloStr = "Hello world!";
		assertTrue (utils.isNotNull(helloStr));
		String testStr = null;
		assertFalse(utils.isNotNull(testStr));
		
	}
	
	/**
	 * The following test fails which tells us that the unit function
	 * is incorrectly implemented
	 */
	@Test
	public void isInstanceOfTest() {
		GenericPredicatesUtils<B> utils = new GenericPredicatesUtils<B>();
		A a = new A();
		B b = new B();
		assertTrue(utils.isInstanceOf(b, a));
		
	}
	
	class A {
		
	}
	
	class B extends A {
		
	}

}
