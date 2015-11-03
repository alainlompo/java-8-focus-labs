package org.lompo.labs.java8.lambdas;

import java.util.List;
import java.util.Random;

public class BunchOfDatasForTestUtils {

	private BunchOfDatasForTestUtils() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private static Random random;
	static {
		random = new Random();
	}
	
	@SafeVarargs
	/**
	 * Simple generic method that randomly returns one element from an array
	 * The index of the target element is randomly picked up
	 * @param elements
	 * @return
	 */
	public static <T> T oneOf(T...elements) {
		if (null == elements) {
			return null;
		}
		
		return elements[random.nextInt(elements.length)];
	}
	
	public static <T> T oneOf(List<T> elements) {
		if (null == elements) {
			return null;
		}
		
		return elements.get(random.nextInt(elements.size()));
		
		
	}
	
	

}
