package org.lompo.labs.java8.lambdas.streams.functionsbased;

import java.util.stream.Stream;

public class NthFirstNumbersSum {
	
	public static void streamIterateDemo(int n) {
		Stream.iterate(2, t -> t +2)
		.limit(n)
		.forEach(System.out::println);
	}
	
	public static void fibonacciWithStreamIterate(int n) {
		Stream.iterate(new int[] {0,1}, t -> new int[] {t[0]+t[1], t[0] + 2*t[1]})
		.limit(n)
		.forEach(t -> System.out.println("(" + t[0] + "," + t[1] + ")"));
	}
	public static void main(String[] args) {
		
		streamIterateDemo(10);
		
		System.out.println();
		System.out.println("Fibonnacci with Stream.iterate....");
		
		fibonacciWithStreamIterate(20);
	}

}
