package org.lompo.labs.java8.lambdas.refactoring.designpatterns.observer;

import java.math.BigInteger;

public class VolcanoHeatObserver implements VolcanicActivityObserver<BigInteger> {

	@Override
	public void notify(Volcano<BigInteger> volcano) {
		
		System.out.println("Here is the report about the volcano's temperature: " + volcano.getActivityReport());
	}

}
