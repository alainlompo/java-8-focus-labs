package org.lompo.labs.java8.lambdas.streams.valuesbased;

import java.util.Arrays;
import java.util.stream.Stream;

public class ValuesBasedStreams {
	
	
	public static int sumNumbers(int[] datas) {
		return Arrays.stream(datas).sum();
	}
	
	public static void main(String[] args) {
		Stream<String> helloStream = Stream.of ("Hello", "world", "we", "are", "streaming");
		helloStream.map(String::toUpperCase)
		.map(s -> s+" ")
		.forEach(System.out::print);
		
		System.out.println();
		System.out.println();
		int[] oneToTen = {1,2,3,4,5,6,7,8,9,10};
		System.out.println("The sum of the ten first positive integers is: " + sumNumbers(oneToTen));
		
		
		
	}

}
