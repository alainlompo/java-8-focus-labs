package org.lompo.labs.java8.lambdas;

import java.util.Comparator;


/**
 * The methods of this class are sample illustration of implementing
 * the Comparator interface using lambda. 
 * @author LOMPO
 *
 */
public class LambdaPeachComparators {
	
	public static Comparator<Peach> getWeightComparator() {
		return (Peach p1, Peach p2) -> Integer.valueOf( p1.getWeight()).compareTo(Integer.valueOf(p2.getWeight()));
		
	}
	
	public static Comparator<Peach> getColorComparator() {
		return (Peach p1, Peach p2) -> p1.getColor().compareTo(p2.getColor());
	}

}
