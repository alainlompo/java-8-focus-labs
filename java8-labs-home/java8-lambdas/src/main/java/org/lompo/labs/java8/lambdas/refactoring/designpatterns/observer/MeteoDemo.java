package org.lompo.labs.java8.lambdas.refactoring.designpatterns.observer;

public class MeteoDemo {
	
	public static void main(String[] args) {
		
		ClimateNewsHub newsHub = new ClimateNewsHub();
		newsHub.registerObserver(new MeteoObserver());
		newsHub.notifiyObservers(40);
		
		
	}

}
