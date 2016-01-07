package org.lompo.labs.java8.lambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;


/**
 * These examples are demonstrating type inference with java 8 lambdas
 * In some cases java is able to infer the lambdas parameters types
 * and thus we do not need to mention them. This somehow reminds about
 * the diamond operator with generics, prior to java 8
 * @author LOMPO
 *
 */
public class TypeInference {
	
	/**
	 * Filter the List<T> by the use of the Predicate<T> criteria
	 * @param peachStore
	 * @param criteria
	 * @return
	 */
	public static List<Peach> filter(List<Peach> peachStore, Predicate<Peach> criteria) {
		 
		// Diamond operator, before java 8 allows some kind of type inference 
		List<Peach> result = new ArrayList<>();
		
		for (Peach p: peachStore) {
			if (criteria.test(p)) {
				result.add(p);
			}
		}
		return result;
		
		
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Unsorted peach store...");
		
		PeachManager gardener = new PeachManager();
		gardener.add("Blue", 100)
		.add("Red", 50)
		.add("Green",75)
		.add("Green", 60)
		.add("Red", 250)
		.add("Green",320)
		.printPeaches();
		
		List<Peach> peachStore = gardener.getPeaches();
		
		// Type inference here:
		List<Peach> choosenPeaches = filter(peachStore, p -> p.getWeight() > 100);
		
		System.out.println();
		System.out.println(choosenPeaches);
		
		// Sorting by weight
		// using type inference on the Comparator<Peach> lambda
		
		Collections.sort(peachStore, (p1,p2) -> Integer.valueOf(p1.getWeight()).compareTo(Integer.valueOf(p2.getWeight())) );
		System.out.println();
		System.out.println("Sorted store...");
		System.out.println(peachStore);
		
	}

	
}
