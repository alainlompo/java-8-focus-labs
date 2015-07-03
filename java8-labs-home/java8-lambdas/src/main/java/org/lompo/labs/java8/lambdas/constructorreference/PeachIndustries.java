package org.lompo.labs.java8.lambdas.constructorreference;

import org.lompo.labs.java8.lambdas.Peach;

public class PeachIndustries {
	
	public static final FruitFactory<Peach> LOCAL_PEACH_PRODUCER = () -> new Peach("green", 250);
	
	public static Peach getLocalPeach(FruitFactory<Peach> factory) {
		
		return factory.get();
	}
	
	public static void main(String[] args) {
		// Get a peach from the local peach produced
		Peach theGreenOne = getLocalPeach(LOCAL_PEACH_PRODUCER);
		assert "green".equalsIgnoreCase(theGreenOne.getColor());
		assert 250 == theGreenOne.getWeight();
		
		// Now get another peach using a constructor reference
		
		Peach theBluePeach = getLocalPeach(Peach::new);
		assert theBluePeach.getColor().equalsIgnoreCase("blue");
		
		// Or we could do
		FruitFactory<Peach> yAFactory = Peach::new;
		
		// Blue also because invoking the default constructor for which default color = blue
		Peach anotherBlue = getLocalPeach(yAFactory);
		
		assert "blue".equalsIgnoreCase(anotherBlue.getColor());
	}

}
