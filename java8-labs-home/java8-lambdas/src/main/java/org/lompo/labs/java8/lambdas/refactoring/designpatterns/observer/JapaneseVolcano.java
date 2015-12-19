package org.lompo.labs.java8.lambdas.refactoring.designpatterns.observer;

import java.math.BigInteger;

public class JapaneseVolcano extends Volcano<BigInteger> {

	@Override
	public String getActivityReport() {
		// TODO Auto-generated method stub
		return "Produces very hot lava: current temperature: " + this.keyParameter + " °C";
	}
	
	public JapaneseVolcano() {
		super();
		this.keyParameter = BigInteger.valueOf(545000);
	}

	@Override
	public void registerObserver(VolcanicActivityObserver<BigInteger> observer) {
		this.observers.add(observer);
		
	}

	/**
	 * Let's use a lambda based implementation with the forEach method
	 */
	@Override
	public void notifyObservers() {

		this.observers.forEach(observer -> observer.notify(this));
		
	}

}
