package org.lompo.labs.java8.lambdas.pure.functional;

import java.util.Arrays;
import java.util.List;

public class ArithmeticExpressionProcessor  {
	
	public static final List<String> OPERATORS =Arrays.asList("-", "+","*", "/", "^", "%");
	/**
	 * This method assumes that the current node contains
	 * the simplest arithmetic expression (example: 2*8, 6+9, ....)
	 * and that the left node contains the left operand (example: 2, 6) while
	 * the right node contains the right operand (example: 8,9)
	 * It will compute the resulting expression and put it in a  new Tree<String> instance
	 * with  null left and right nodes.
	 * @param tree
	 * @return
	 */
	public static Tree<String> reduce(Tree<String> tree) {
		
		// It contains a basic arithmetic expression
		String value = tree.getValue();
		String operator= extractOperatorFrom(value);
		if (operator == null) {
			return null;
		}
		double leftOperande = 0.0D;
		double rightOperande = 0.0D;
		try {
			leftOperande = Double.parseDouble(tree.getLeft().getValue());
			rightOperande = Double.parseDouble(tree.getRight().getValue());
		} catch (Exception ex) {
			// Any problem here, lets return null
			return null;
		}
		
		
		double operationResult = 0.0D;
		switch (operator) {
		case "-": 
			operationResult = leftOperande - rightOperande;
			break;
		case "+":
			operationResult = leftOperande + rightOperande;
			break;
		case "*":
			operationResult = leftOperande * rightOperande;
		case "/":
			if (rightOperande == 0.0D) {
				operationResult = (leftOperande < 0)? Double.NEGATIVE_INFINITY: Double.POSITIVE_INFINITY;
			} else {
				operationResult = leftOperande / rightOperande;
			}
			break;
		case "^":
			operationResult = Math.pow(leftOperande, rightOperande);
			break;
		case "%":
			operationResult = leftOperande % rightOperande;
			break;
		default: 
			operationResult = Double.NaN;
		}
		
		return new Tree<String> (tree.getKey(), operationResult+"", null, null);
		
	}
	
	/**
	 * Will return the first found operator (starting from left to right)
	 * We don't consider operators priorities, .... 
	 * @param expression
	 * @return
	 */
	public static String extractOperatorFrom(String expression) {
		String result = null;
		for (int index = 0; index < expression.length(); index++) {
			String candidate = expression.substring(index, index+1);
			if (isOperator(candidate)) {
				result = candidate;
				break;
			}
		}
		return result;
		
	}
	public static boolean isOperator(String op) {
		return OPERATORS.contains(op);
	}
}
