package org.lompo.labs.java8.lambdas.refactoring.designpatterns.chainofresponsibility;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ProcessingDemoWithLambda {
	
	/**
	 * We can compose function using the andThen method over UnaryOperator<T> components
	 * @param args
	 */
	public static void main(String[] args) {
		UnaryOperator<String> tdProcessor = t -> "<TD>" + t + "</TD>";
		UnaryOperator<String> trProcessor = t -> "<TR>" + t + "</TR>";
		UnaryOperator<String> tableProcessor = t -> "<table border='1'>" + t + "</table>";
		
		Function<String, String> processingChain
		= tdProcessor.andThen(trProcessor).andThen(tableProcessor);
		
		System.out.println("Processing <h3>Hello world</h3>");
		System.out.println("Result : " + processingChain.apply("<h3>Hello world!</h3>"));
	}

}
