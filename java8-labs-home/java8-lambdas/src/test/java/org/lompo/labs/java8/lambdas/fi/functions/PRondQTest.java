package org.lompo.labs.java8.lambdas.fi.functions;

import static org.junit.Assert.assertEquals;

import java.util.function.Function;

import org.junit.Test;

/**
 * French mathematician use rond to describe the compositon relationship between two functions
 * For example if we have x -> f(x) and x -> g(x) the function defined by x - > f (g(x)) 
 * is called f rond g
 * @author LOMPO
 *
 */
public class PRondQTest {
	
	@Test
	public void F_nominal_case_Test() {
		Function<Integer, Integer> p = x -> x+1;
		Function<Integer, Integer> q = x -> x*x;
		Function<Integer, Integer> pRondQ = PRondQ.F(p, q);
		assertEquals(Integer.valueOf(26), pRondQ.apply (5));
		assertEquals(Integer.valueOf(5), pRondQ.apply(-2));
		
	}

}
