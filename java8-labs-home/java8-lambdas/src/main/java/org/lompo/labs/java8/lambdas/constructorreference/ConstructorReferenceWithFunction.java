package org.lompo.labs.java8.lambdas.constructorreference;

import java.util.function.Function;

import org.lompo.labs.java8.lambdas.Peach;

/**
 * Illustrating constructor reference along with its lambda equivalent
 * @author LOMPO
 *
 */
public class ConstructorReferenceWithFunction {
	
	// Using a constructor reference
	public static final Function<Integer, Peach> GOOD_PEACH_FACTORY =  Peach::new; 
	
	// Equivalent lambda expression
	public static final Function<Integer, Peach> PEACH_FACTORY = (w) -> new Peach(w);
	
	public static final Function<String, Peach> PEACH_SKIN_FACTORY = (color) -> new Peach(color,200);
	
	public static Peach getWeightyPeach(int desiredWeight) {
		return GOOD_PEACH_FACTORY.apply(desiredWeight);
	}
	
	public static Peach getWeightyPeach2(int desiredWeight) {
		return PEACH_FACTORY.apply(desiredWeight);
	}
	
	public static void main(String[] args) {
		Peach one = getWeightyPeach(350);
		Peach heaviest = getWeightyPeach2(350);
		
		assert one.getWeight() == heaviest.getWeight();
	}
	
	

}
