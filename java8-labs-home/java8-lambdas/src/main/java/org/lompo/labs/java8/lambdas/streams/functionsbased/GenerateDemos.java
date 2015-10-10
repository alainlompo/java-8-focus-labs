package org.lompo.labs.java8.lambdas.streams.functionsbased;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GenerateDemos {
	
	public static void randomGenerate() {
		Stream.generate(Math::random)
		.limit(5)
		.forEach(System.out::println);
	}
	
	public static void printTwentyOnes() {
		IntStream twentyOnes = IntStream.generate(() -> 1);
		twentyOnes
		.limit(20)
		.forEach( t -> {
			System.out.println(t);
		}
		);
				
	}
	public static void main(String[] args) {
		randomGenerate();
		System.out.println();
		System.out.println("About to print 20 ones...");
		printTwentyOnes();
	}

}
