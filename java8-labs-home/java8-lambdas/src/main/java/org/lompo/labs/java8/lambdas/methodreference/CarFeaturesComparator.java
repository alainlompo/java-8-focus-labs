package org.lompo.labs.java8.lambdas.methodreference;

public class CarFeaturesComparator {
	
	public static final FeatureComparator<Car> GEAR_COMPARATOR = (Car c1, Car c2) -> Integer.valueOf(c1.getNumberOfGears()).compareTo(Integer.valueOf(c2.getNumberOfGears()));
	public static final FeatureComparator<Car> GEAR_COMPARATOR2  = (Car c1, Car c2) -> Car.compareByAirConditioner(c1, c2);
	
	public static int compareGears(Car c1, Car c2, FeatureComparator<Car> fComp) {
		return fComp.compare(c1, c2);
	}
	
	public static void main(String[] args) {
		Car velvo = new Car();
		velvo.setNumberOfGears(6);
		
		Car jetFarrari = new Car();
		jetFarrari.setNumberOfGears(18);
		
		int comparisonResult1 = compareGears(velvo, jetFarrari, GEAR_COMPARATOR);
		int comparisonResult2 = compareGears(velvo, jetFarrari, Car::compareByGears);
		
		assert comparisonResult1 ==  comparisonResult2: "The two methods are divergeant";
		
		// TODO: Lab 1 - Apply the same pattern as above to compare cars by air conditionner using
		// GEAR_COMPARATOR2 and a method reference Car :: compareByAirConditioner
		
		
	}

}
