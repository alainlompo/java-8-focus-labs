package org.lompo.labs.java8.lambdas.refactoring.designpatterns.factory;

import java.util.Map;
import java.util.HashMap;
import java.util.function.Supplier;

public class LambdaFactoryApproachDemo {
	
	
	public static final Map<LaptopStyle, Supplier<Laptop>> LAPTOP_SUPPLIER = new HashMap<LaptopStyle, Supplier<Laptop>>(); 
	static {
		LAPTOP_SUPPLIER.put(LaptopStyle.OFFICERUNNER, EyeBeAim::new);
		LAPTOP_SUPPLIER.put(LaptopStyle.POWERLAP, MacAndTouch::new);
		LAPTOP_SUPPLIER.put(LaptopStyle.UNDEFINED, PaySee::new);
	}
	
	
	public static Laptop getLaptop(LaptopStyle desiredLapStyle) {
		if (LAPTOP_SUPPLIER.containsKey(desiredLapStyle)) {
			return LAPTOP_SUPPLIER.get(desiredLapStyle).get();
		} else {
			throw new IllegalArgumentException("No such laptop style in factory's catalog....");
		}
	}
	
	/**
	 * We use constructor reference on the same way we used method references before
	 * @param args
	 */
	public static void main(String[] args) {
		Supplier<Laptop> macAndTouchSupplier = MacAndTouch::new;
		Supplier<Laptop> paySeeSupplier = PaySee::new;
		Supplier<Laptop> eyeBeAimSupplier = EyeBeAim::new;
		
		Laptop myMacAndTouch = macAndTouchSupplier.get();
		Laptop myEyeBeAim = eyeBeAimSupplier.get();
		
		System.out.println(myMacAndTouch);
		System.out.println(myEyeBeAim);
		System.out.println();
		System.out.println("Now using the getLaptop lambda-refactored method");
		
		// TODO: Using the refactored getLaptop method beneaf
		Laptop myPaySee = getLaptop(LaptopStyle.UNDEFINED);
		System.out.println("That's a paysee..." + myPaySee);
	}

}
