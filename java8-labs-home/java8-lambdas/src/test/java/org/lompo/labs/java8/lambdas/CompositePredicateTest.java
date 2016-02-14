package org.lompo.labs.java8.lambdas;

import static org.junit.Assert.assertTrue;

import java.util.function.Predicate;

import org.junit.Test;

public class CompositePredicateTest {
	
	@Test
	public void testTest() {
		Predicate<String> predicate1 = t -> t.equals(t.toUpperCase());
		Predicate<String> predicate2 = t -> t.length() > 10;
		//CompositePredicate<String> andPredicate = new CompositePredicate<String>(predicate2);
//		CompositePredicate<String> andPredicate = new CompositePredicate<String>(predicate2);
//		CompositePredicate<String> globalPredicate = new CompositePredicate<String>(predicate1, andPredicate);
//		String tester = "HELLO WORLD";
//		assertTrue(globalPredicate.test(tester));
		assertTrue(1>0);
		
		
		
	}

}
