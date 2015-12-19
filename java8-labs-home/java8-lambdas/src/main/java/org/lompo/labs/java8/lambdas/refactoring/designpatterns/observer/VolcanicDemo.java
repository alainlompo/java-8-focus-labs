package org.lompo.labs.java8.lambdas.refactoring.designpatterns.observer;

import java.math.BigInteger;

public class VolcanicDemo {
	
	public static void main(String[] args) {
		Volcano<BigInteger> kwiyoutoos = new JapaneseVolcano();
		VolcanicActivityObserver<BigInteger> heatObserver = new VolcanoHeatObserver();
		VolcanicActivityObserver<BigInteger> particlesObserver = new VolcanoEruptionObserver();
		kwiyoutoos.registerObserver(heatObserver);
		kwiyoutoos.registerObserver(particlesObserver);
		kwiyoutoos.notifyObservers();
		
		// Since the observer is based on a functional interface We can also use lambda to remove some boilerplate code
		//kwiyoutoos.registerObserver((Volcano<BigInteger> v) -> {
		//	
		// } );
		
		kwiyoutoos.registerObserver(v -> {System.out.println("The main parameter's value is " + v.getKeyParameter());});
		
		
		
		
	}

}
