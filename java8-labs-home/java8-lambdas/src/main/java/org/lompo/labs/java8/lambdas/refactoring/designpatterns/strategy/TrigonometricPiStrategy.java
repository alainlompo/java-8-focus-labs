package org.lompo.labs.java8.lambdas.refactoring.designpatterns.strategy;

import java.math.BigDecimal;

public class TrigonometricPiStrategy  implements PiComputingStrategy {

	@Override
	public BigDecimal execute() {
		// TODO sin (PI/2) = 1 => PI/2 = arcsin(1) => PI = 2 * arcsin(1)
		return BigDecimal.valueOf(Math.asin(1.0D) * 2);
		
	}
	
	public static void main(String[] args) {
		System.out.println( (new TrigonometricPiStrategy()).execute().toString());
	}

}
