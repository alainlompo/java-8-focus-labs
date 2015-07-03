package org.lompo.labs.java8.lambdas.methodreference;

import java.util.Collections;
import java.util.List;

import org.lompo.labs.java8.lambdas.Peach;
import org.lompo.labs.java8.lambdas.PeachManager;

public class MethodReference {
	
public static void main(String[] args) {
		
		System.out.println("Unsorted peach store...");
		
		PeachManager gardener = new PeachManager();
		gardener.add("Blue", 100)
		.add("Red", 50)
		.add("Green",75)
		.add("Yello", 60)
		.add("Red", 250)
		.add("White",320)
		.add("Cyan",320)
		.add("Magenta",320)
		.add("Gray",320)
		.printPeaches();
		
		List<Peach> peachStore = gardener.getPeaches();
	
		System.out.println();
		
		// Sorting by color
		// using method reference to sort the list
		
		Collections.sort(peachStore, 
				java.util.Comparator.comparing(Peach::getColor) 
				);
		System.out.println();
		System.out.println("Sorted store...");
		System.out.println(peachStore);
		
	}

}
