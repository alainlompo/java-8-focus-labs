package org.lompo.labs.java8.lambdas.refactoring.designpatterns.strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class IntegerFractionPiStrategy implements PiComputingStrategy {

	@Override
	public BigDecimal execute() {
		BigDecimal divided = BigDecimal.valueOf(22.0D);
		BigDecimal diviser = BigDecimal.valueOf(7.0D);
		//MathContext mC = new MathContext();
		return divided.divide(diviser,15, RoundingMode.CEILING);
	}
	
	public static void main(String[] args) {
		IntegerFractionPiStrategy pIS = new IntegerFractionPiStrategy();
		System.out.println(pIS.execute().toString());
	}

}
