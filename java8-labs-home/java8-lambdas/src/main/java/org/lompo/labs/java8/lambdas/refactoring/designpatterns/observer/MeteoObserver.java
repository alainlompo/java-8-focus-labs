package org.lompo.labs.java8.lambdas.refactoring.designpatterns.observer;

public class MeteoObserver implements ConsumableObserver<Integer> {

	@Override
	public void accept(Integer t) {
		System.out.println("The current temperature of the local zone is: " +t );
		
	}

	/**
	 * We relate the call to the consumer accept method
	 */
	@Override
	public void notify(Integer usefullEventInfo) {
		accept(usefullEventInfo);
		
	}
	

}
