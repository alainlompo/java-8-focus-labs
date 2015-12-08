package org.lompo.labs.java8.lambdas.streams.parallel;

import java.util.Random;

public class IterativeProductParralelDemo {
	
	public static void main(String[] args) {
		Random r= new Random();
		long max = r.nextInt(15)* 1L;
		System.out.println("The product from 1 to " + max +" is: " + ApproachingParallelStreams.parallelProductFromOnteTo(max));
	}

}
