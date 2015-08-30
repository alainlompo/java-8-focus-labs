package org.lompo.labs.java8.lambdas.streams.filtering;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap2 {
	
	public static void main(String[] args) {
		
		
		// Returning couples (A,1) (A,2) ... where the number is even
		List<Character> chars = Arrays.asList('A','B','C','D','E');
		List<Integer> numbers = Arrays.asList(4,5,6,7);
		
		List<Object> couples =
				chars.stream()
				.flatMap(c -> numbers.stream()
						.map(n -> new Couple(c,n))
						)
						.filter(o -> {
							if (! (o instanceof Couple)) {
								return false;
							}
							Couple c = (Couple)o;
							return (c.getNumber() % 2 == 1);
							
						})
						.collect(Collectors.toList())
						
						;
		for (Object o:couples) {
			System.out.print(o + " ");
		}
		
		
	}

}
