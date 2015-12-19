package org.lompo.labs.java8.lambdas.refactoring.designpatterns.observer;

import java.math.BigInteger;

public class VolcanoEruptionObserver implements VolcanicActivityObserver<BigInteger> {

	@Override
	public void notify(Volcano<BigInteger> volcano) {
		if (volcano.getKeyParameter().compareTo(BigInteger.valueOf(10000)) > 0) {
			System.out.println("At this temperature the volcano emits raw diamonds...");
		} else {
			if (volcano.getKeyParameter().compareTo(BigInteger.valueOf(5000))> 0) {
				System.out.println("At this temperature the volcano emits rubis and pearls");
			} else {
				System.out.println("At this temperature we only have carbone and sometimes bdelum and onyx");
			}
			 
		}
		
	}

}
