package org.lompo.labs.java8.lambdas.refactoring.designpatterns.strategy;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;


public class ApproximatingPiClientCode {
	
	public static void main(String[] args) {
		PiApproximator intApproximator = new PiApproximator(new IntegerFractionPiStrategy());
		PiApproximator poetryApproximator = new PiApproximator(new PoetryPiStrategy());
		PiApproximator trigoApproximator = new PiApproximator(new TrigonometricPiStrategy());
		
		// TODO: the above examples are nice but we can do it also using lambda expressions
		Supplier<BigDecimal> dummyStrategy = () -> BigDecimal.valueOf(3.14D);
		Supplier<BigDecimal> dummierStrategy = () -> BigDecimal.valueOf(29.0D/9.0D);
		PiApproximator dummyPiApproximator = new PiApproximator(() -> dummyStrategy.get());
		PiApproximator dummierPiApproximator = new PiApproximator(() -> dummierStrategy.get());
		
		List<PiApproximator> myApproximators = Arrays.asList(intApproximator, poetryApproximator, trigoApproximator,  
				dummyPiApproximator,
				dummierPiApproximator
				
				);
		
		for (PiApproximator approx: myApproximators) {
			System.out.println(approx.approximatePi().toString());
		}
		
	}

}
