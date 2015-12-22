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

}
