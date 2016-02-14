package org.lompo.labs.java8.lambdas.pure.functional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
	
	@Test
	public void extractOperatorFrom_no_op_in_expression_Test() {
		String expression = "1234685";
		assertNull(ArithmeticExpressionProcessor.extractOperatorFrom(expression));
	}
	
	@Test
	public void extractOperatorFrom_good_op_in_expression_Test() {
		String expression = "5895*2145";
		String op = ArithmeticExpressionProcessor.extractOperatorFrom(expression);
		assertNotNull(op);
		assertEquals("*", op);
	}
	
	@Test
	public void extractOperatorFrom_all_operators_Test() {
		List<String> allExpressions = Arrays.asList("1*2","3-4","10.5/2.1","8.7+9","15%2","3^4");
		List<String> allOps = Arrays.asList("*","-","/","+","%","^");
		int index = 0;
		for (String expression: allExpressions) {
			String op = ArithmeticExpressionProcessor.extractOperatorFrom(expression);
			assertNotNull(op);
			assertEquals(allOps.get(index++), op);
		}	
	}
	
	@Test
	public void reduce_nominal_case_Test() {
		String key = "1";
		String initialExpression = "5*8";
		Tree<String> left = new Tree<String>("2L", "5", null, null);
		Tree<String> right = new Tree<String>("2R", "8", null, null);
		Tree<String> exprTree = new Tree<String>(key, initialExpression, left, right);
		Tree<String> reduced = ArithmeticExpressionProcessor.reduce(exprTree);
		assertNotNull(reduced);
		assertNull(reduced.getLeft());
		assertNull(reduced.getRight());
		assertEquals(key, reduced.getKey());
		assertEquals(Double.valueOf(40.0D), Double.valueOf(Double.parseDouble(reduced.getValue())));
	}
}
