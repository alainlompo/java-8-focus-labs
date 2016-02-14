package org.lompo.labs.java8.lambdas.pure.functional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;
import java.util.List;

public class ArithmeticExpressionProcessorTest {
	
	@Test
	public void isOperator_wrong_operator_Test() {
		String testOp = "+*-/";
		assertFalse(ArithmeticExpressionProcessor.isOperator(testOp));
	}
	
	@Test
	public void isOperator_right_operator_Test() {
		String testOp ="*";
		assertTrue(ArithmeticExpressionProcessor.isOperator(testOp));
	}
	
	@Test
	public void is_Operator_ok_for_all_operators_Test() {
		List<String> allOps = Arrays.asList("*","-","/","+","%","^");
		for (String op: allOps) {
			assertTrue(ArithmeticExpressionProcessor.isOperator(op));
		}
	}

}
