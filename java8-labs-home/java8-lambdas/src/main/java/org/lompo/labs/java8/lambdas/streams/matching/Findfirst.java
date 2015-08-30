package org.lompo.labs.java8.lambdas.streams.matching;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Findfirst {
	
	public static void main(String[] args) {
		Integer[] ints = new Integer[100];
		for (int i = 0; i < 100; i++) {
			ints[i] = 2*i+11;
		}
		
		List<Integer> intsList = Arrays.asList(ints);
		Optional<Integer> firstSquareThreeTimeTheValue
		= intsList.stream()
		.map( x -> x*x)
		.filter(x -> x > 3 * Math.sqrt(x))
		.findFirst();
		
		firstSquareThreeTimeTheValue.ifPresent(x -> {
			System.out.println("We found one match....");
			System.out.println(x + " > 3*"+Math.sqrt(x));
		});
		
		
	}

}
