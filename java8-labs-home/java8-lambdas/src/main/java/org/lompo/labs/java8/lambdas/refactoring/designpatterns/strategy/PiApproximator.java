package org.lompo.labs.java8.lambdas.refactoring.designpatterns.strategy;

import java.math.BigDecimal;

public class PiApproximator {
	private PiComputingStrategy strategy;
	public PiApproximator(PiComputingStrategy strategy) {
		this.strategy = strategy;
	}
	
	public BigDecimal computePiUsing(PiComputingStrategy strategy) {
		return strategy.execute();
	}
	
	public BigDecimal approximatePi() {
		return strategy.execute();
	}

}
