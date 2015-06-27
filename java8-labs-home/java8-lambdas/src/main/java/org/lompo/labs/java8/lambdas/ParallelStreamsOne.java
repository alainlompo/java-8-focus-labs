package org.lompo.labs.java8.lambdas;

import java.util.List;
import java.util.stream.Collectors;

/**
 * This is a simple example of using ParallelStream. This syntax is far less verbose
 * than what a classic parallelization java code would do, and it takes advantage of the multicore
 * architecture of modern computers to handle real parallel processing
 * @author LOMPO
 *
 */
public class ParallelStreamsOne {
	
	public static void main(String[] args) {
		
		System.out.println("The spring peaches are...");
		PeachManager gardener = new PeachManager();
		gardener.add("Blue", 100)
		.add("Red", 50)
		.add("Green",75)
		.add("Green", 60)
		.add("Red", 250)
		.add("Green",320)
		.add("Blue",25)
		.add("Magenta", 75)
		.printPeaches();
		
		List<Peach> lightPeaches = gardener.getPeaches()
				.parallelStream()
				.filter((Peach p) -> p.getWeight() < 100)
				.collect(Collectors.toList());
		
		System.out.println();
		System.out.println("And the not heavy peaches are ...");
		System.out.println(lightPeaches);
		
	}

}
