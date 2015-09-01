package org.lompo.labs.java8.lambdas.streams.reducing;

import java.util.Arrays;
import java.util.List;

public class MathIdentities {
	
	public static final List<Integer> TEN_FIRST_NUMBERS = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	
	public static void checkIntegerSumIdentity() {
		int sum = TEN_FIRST_NUMBERS
				.stream()
				.reduce(0, (a,b)-> a+b);
		int sum2 = 10 * (10 + 1)/2;
		System.out.println((sum == sum2)?"Identity verified":"false identity");
	}
	
	
	public static void main(String[] args) {
		checkIntegerSumIdentity();
	}

}
