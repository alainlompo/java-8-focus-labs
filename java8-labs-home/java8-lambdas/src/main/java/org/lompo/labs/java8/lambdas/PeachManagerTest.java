package org.lompo.labs.java8.lambdas;

import java.util.List;
public class PeachManagerTest {
	
	public static void main(String[] args) {
		PeachManager gardener = new PeachManager();
		gardener.add("Blue", 100)
		.add("Red", 50)
		.add("Green",75)
		.add("Green", 60)
		.add("Red", 250)
		.add("Green",320)
		.printPeaches();
		
		List<Peach> heavyPeaches = gardener.filterPeaches(PeachManager::isHeavyPeach);
		
		System.out.println();
		System.out.println("And the heavy peaches are:...");
		System.out.println(heavyPeaches);
		
		System.out.println();
		System.out.println("And the red ones are...");
		System.out.println(gardener.filterRedPeaches());
	}
	
	
	
	

}
