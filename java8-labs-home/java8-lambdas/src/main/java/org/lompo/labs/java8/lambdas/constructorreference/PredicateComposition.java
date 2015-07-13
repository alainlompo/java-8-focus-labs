package org.lompo.labs.java8.lambdas.constructorreference;

import java.util.function.Predicate;

import org.lompo.labs.java8.lambdas.Peach;

/**
 * Using the and and or default method of the Predicate interface
 * to create new predicates by combinations
 * @author LOMPO
 *
 */
public class PredicateComposition {
	
	Predicate<Peach> greenPeach = (p) -> "green".equalsIgnoreCase(p.getColor());
	Predicate<Peach> greenAndHeavyPeach = greenPeach.and((p) -> 200 < p.getWeight());
	Predicate<Peach> greenAndHeavyPeachOrBluePeach = greenAndHeavyPeach.or((p) -> "blue".equalsIgnoreCase(p.getColor()));
	

}
