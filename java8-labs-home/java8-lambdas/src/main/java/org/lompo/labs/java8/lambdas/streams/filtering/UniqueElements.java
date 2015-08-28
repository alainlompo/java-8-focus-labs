package org.lompo.labs.java8.lambdas.streams.filtering;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UniqueElements {
	
	public static List<Integer> getBunchOfIntsLesserThan(int maxValue) {
		Random r = new Random();
		List<Integer> ints = new ArrayList<Integer>();
		int totalNumbers = r.nextInt(100);
		for (int i = 0; i <= totalNumbers; i++) {
			ints.add(r.nextInt(maxValue));
		}
		return ints;
	}
	
	public static void main(String[] args) {
		System.out.println("Filtering numbers that are greater than 10 and unique...");
		getBunchOfIntsLesserThan(1000)
		.stream()
		.filter(d -> d.compareTo(Integer.valueOf(10) )  > 0 )
		.distinct()
		.forEach(System.out::println);
		
		
	}

}
