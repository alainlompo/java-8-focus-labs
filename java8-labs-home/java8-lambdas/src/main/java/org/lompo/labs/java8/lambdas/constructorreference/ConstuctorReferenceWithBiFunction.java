package org.lompo.labs.java8.lambdas.constructorreference;

import java.util.function.BiFunction;

import org.lompo.labs.java8.lambdas.Peach;

public class ConstuctorReferenceWithBiFunction {
	
	// BiFunction with constructor reference
	public static final BiFunction<String, Integer, Peach> REFINED_FACTORY = Peach::new; 
	
	// Lambda expression with type inference
	public static final BiFunction<String, Integer, Peach> FINE_FACTORY = (color, weight) -> new Peach(color,weight);
	
	public static Peach getFinePeach(String color, int weight, BiFunction<String, Integer, Peach> factory) {
		return factory.apply(color, weight);
	}
	
	public static void main(String[] args) {
		Peach refinedPeach = getFinePeach("Green", 450, REFINED_FACTORY);
		Peach finePeach = getFinePeach("Green", 450, FINE_FACTORY);
		
		assert (finePeach.getColor().equals(refinedPeach.getColor())) && (finePeach.getWeight() == refinedPeach.getWeight());
		
	}

}
