package org.lompo.labs.java8.lambdas.streams.filtering;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {
	
	public static void main(String[] args) {
		List<String> someWords = Arrays.asList ("Every", "Now", "And", "Then", "A", "Great", "Programmer", "Revolutionize", "IT", "With", "A", "Witty", "Invention");
		List<String> distincCharacters =
				someWords.stream()
				//.map(w -> w.toUpperCase())
				.map(w -> w.split(""))
				.flatMap(Arrays::stream)
				.distinct()
				.collect(Collectors.toList());
		
		System.out.println(distincCharacters);
		
		// Returning couples (A,1) (A,2) ...
		List<Character> chars = Arrays.asList('A','B','C','D','E');
		List<Integer> numbers = Arrays.asList(4,5,6,7);
		
		List<Object> couples =
				chars.stream()
				.flatMap(c -> numbers.stream()
						.map(n -> new Couple(c,n))
						)
						.collect(Collectors.toList())
						;
		for (Object o:couples) {
			System.out.print(o + " ");
		}
		
		
		
				
		
	}

}
