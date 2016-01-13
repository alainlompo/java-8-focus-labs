package org.lompo.labs.java8.lambdas.constructorreference;

import java.util.List;

import org.lompo.labs.java8.lambdas.Peach;
import org.lompo.labs.java8.lambdas.PeachManager;
import static java.util.Comparator.comparing;

/**
 * Example illustrating chaining comparators
 * @author LOMPO
 *
 */
public class ChainedComparators {
	
	public static void main(String[] args) {
		PeachManager gardener = new PeachManager();
		gardener.add("Blue", 100)
		.add("Red", 50)
		.add("Green",75)
		.add("blackred", 260)
		.add("Red", 250)
		.add("Green",75)
		.add("blackred", 390)
		.add("Red", 250)
		.add("Green",320)
		.add("blackred",545)
		.add("Green", 60)
		.add("Red", 250)
		.add("blackred",75)
		.add("Green", 60)
		.add("Red", 250)
		.add("Green",75)
		.add("blackred", 160)
		.add("Red", 250)
		.add("blackred", 50)
		.printPeaches();
		System.out.println();
		
		List<Peach> peachStore = gardener.getPeaches();
		
		peachStore.sort(comparing(Peach::getColor)
				.reversed()
				.thenComparing(Peach::getWeight));
		System.out.println("And the peaches sorted by color then by weight is ....");
		System.out.println(peachStore);
				
		
	}

}
