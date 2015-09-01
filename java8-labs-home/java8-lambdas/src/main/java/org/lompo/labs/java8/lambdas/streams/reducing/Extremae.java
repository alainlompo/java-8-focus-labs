package org.lompo.labs.java8.lambdas.streams.reducing;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * This is another illustration of the reduce method
 * The reduce method applies the operation to the current element and the previous operation result
 * Therefore for such operation as Integer::max it will apply it iteratively between the current element
 * and the last computed max result.
 * @author LOMPO
 *
 */
public class Extremae {
	private static final Integer[] NUMBERS ;
	private static final Random random = new Random();
	static {
		NUMBERS = new Integer[100];
		for (int i = 0; i < 100; i++) {
			NUMBERS[i]= i * random.nextInt(100);
			
		}
	}
	
	public static void doExtremaeDemo() {
		List<Integer> intsList = Arrays.asList(NUMBERS);
		intsList.stream()
		.reduce(Integer::max)
		.ifPresent(n -> System.out.println("The maximum value is :" + n + " which is at index " + intsList.indexOf(Integer.valueOf(n))));
		;
		
		intsList.stream()
		.reduce(Integer::min)
		.ifPresent(n -> System.out.println("The minimum value is :" + n + " which is found at index " + intsList.indexOf(Integer.valueOf(n))));
		
	}
	
	public static void main(String[] args) {
		doExtremaeDemo();
	}
}
