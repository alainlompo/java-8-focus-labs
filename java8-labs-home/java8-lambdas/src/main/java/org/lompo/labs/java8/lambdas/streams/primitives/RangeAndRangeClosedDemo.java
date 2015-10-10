package org.lompo.labs.java8.lambdas.streams.primitives;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RangeAndRangeClosedDemo {
	
	public static void demo1() {
		IntStream equStream =
				IntStream.rangeClosed(1,100)
				.filter(n -> n*n - 5*n -1 < 0);
		List<Integer> goodElemnts = equStream.boxed()
				.collect(Collectors.toList());
		System.out.println("The following elements satisfy n^2 < 5n -1 between 1 and 100 :" + goodElemnts);
		
		
	}
	
	public static void perfectSquaresBetween(int minValue, int maxValue) {
		
		System.out.println();
		System.out.println("Perfect squares via Phytagore's identity...");
		
		Stream<int[]>
		perfectSquares = IntStream.rangeClosed(minValue, maxValue)
		.boxed()
		.flatMap(a -> 
		IntStream.rangeClosed(a, maxValue)
		.filter(b -> Math.sqrt(a*a + b*b)% 1 == 0)
		
		.mapToObj(b -> new int[] {a,b, (int) Math.sqrt(a*a+b*b) }   )
				);
		
		perfectSquares.limit(10)
		.forEach(t-> System.out.println(t[0]+ "," + t[1] + "," + t[2]));
	}
	
	public static void perfectSquaresOptimized(int minValue, int maxValue) {
		Stream<double[]>
		perfectSquares = IntStream.rangeClosed(minValue, maxValue)
		.boxed()
		.flatMap(a -> 
		IntStream.rangeClosed(a, maxValue)
		.mapToObj(
				b -> new double[]{a,b, Math.sqrt(a*a+b*b)} 
				)
				.filter(t-> t[2] %1 == 0)
				);
		
		perfectSquares.limit(10)
		.forEach(t-> System.out.println(t[0]+ "," + t[1] + "," + t[2]));
		
	}
	
	
	public static void main(String[] args) {
		demo1();
		
		perfectSquaresBetween(10, 120);
		
		System.out.println("An optimized version of the same...");
		System.out.println();
		
		perfectSquaresOptimized(10, 120);
		
		
	}

}
