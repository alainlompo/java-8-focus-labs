package org.lompo.labs.java8.lambdas.refactoring.designpatterns.factory;

public class LaptopFactory {
	public static Laptop getLaptop(LaptopStyle desiredLapStyle) {
		switch (desiredLapStyle) {
			case OFFICERUNNER: {
				return new EyeBeAim();
				
			} case POWERLAP: {
				return new MacAndTouch();
				
			} case UNDEFINED: {
				return new PaySee();
			} default: {
				return new PaySee();
			}
			
		}
	}
}
