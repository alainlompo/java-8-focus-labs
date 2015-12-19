package org.lompo.labs.java8.lambdas.refactoring.designpatterns.observer;

public class SleepingVolcano extends Volcano<String> {

	@Override
	public String getActivityReport() {
		return "";
	}

	
	@Override
	public void registerObserver(VolcanicActivityObserver<String> observer) {
		this.observers.add(observer);
		
	}

	/**
	 * This is a standard way of implementing this method
	 */
	@Override
	public void notifyObservers() {
		for (VolcanicActivityObserver<String> observer: this.observers) {
			observer.notify(this);
		}
		
	}

}
