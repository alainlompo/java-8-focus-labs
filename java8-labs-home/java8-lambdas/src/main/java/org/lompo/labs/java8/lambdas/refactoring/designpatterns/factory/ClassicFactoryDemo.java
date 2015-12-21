package org.lompo.labs.java8.lambdas.refactoring.designpatterns.factory;

public class ClassicFactoryDemo {
	public static void main(String[] args) {
		Laptop myMckAndTouch = LaptopFactory.getLaptop(LaptopStyle.POWERLAP);
		Laptop myPeSee = LaptopFactory.getLaptop(LaptopStyle.UNDEFINED);
		System.out.println("my first laptop: " + myMckAndTouch);
		System.out.println("my second laptop: " +  myPeSee);
	}

}
