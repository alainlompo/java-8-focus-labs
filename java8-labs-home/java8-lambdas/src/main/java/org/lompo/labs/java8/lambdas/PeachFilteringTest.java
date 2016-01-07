package org.lompo.labs.java8.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PeachFilteringTest {
	
	/**
	 * This method filters out any Peach from the inventory that does
	 * succeed to be validated by the PeachPredicate
	 * @param inventory
	 * @param predicate
	 * @return
	 */
	public static List<Peach> filter(List<Peach> inventory, PeachPredicate predicate) {
		List<Peach> result = new ArrayList<Peach>();
		for (Peach p: inventory) {
			if (predicate.test(p)) {
				result.add(p);
			}
		}
		return result;
	}
	
	
	public static List<Peach> filter(List<Peach> inventory, CompositePredicate<Peach> predicate) {
		List<Peach> result = new ArrayList<Peach>();
		for (Peach p: inventory) {
			if (predicate.test(p)) {
				result.add(p);
			}
		}
		return result;
	}
	
	
	
	
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
		
		
		System.out.println("Reddest peaches in the list...");
		System.out.println(filter(gardener.getPeaches(), new ReddestPeachPredicate()));
		System.out.println();
		
		Predicate<Peach> reddestPredicate = new Predicate<Peach>() {

			ReddestPeachPredicate rPP = new ReddestPeachPredicate();
			@Override
			public boolean test(Peach t) {
				// TODO Auto-generated method stub
				return rPP.test(t);
			}
			
		};
		
		Predicate<Peach> heavyWeightPeaches =
				new Predicate<Peach>() {

					@Override
					public boolean test(Peach t) {
						// TODO Auto-generated method stub
						return t.getWeight() > 300;
					}
			
		};
		
		CompositePredicate<Peach> reddestAndHeavy =
				CompositePredicate.getShell(Peach.class)
				.predicate(reddestPredicate)
				.and(new CompositePredicate<Peach>(heavyWeightPeaches, null));
		
		System.out.println("The reddest and heavy ones....");
		System.out.println(filter(gardener.getPeaches(), reddestAndHeavy));
		
		System.out.println();
		System.out.println("Let's get red and green peaches together...");
		
		
		Predicate<Peach> isRedPredicate = new Predicate<Peach>() {

			@Override
			public boolean test(Peach t) {
				// TODO Auto-generated method stub
				return "red".equalsIgnoreCase(t.getColor());
			}
			
		};
		
		Predicate<Peach> isGreenPredicate = new Predicate<Peach>() {

			@Override
			public boolean test(Peach t) {
				// TODO Auto-generated method stub
				return "green".equalsIgnoreCase(t.getColor());
			}
			
		};
		
		LogicalCompositePredicate<Peach>
		redAndGreenPredicate =
		new OrLogicalCompositePredicate<Peach>();
		
		redAndGreenPredicate
		.predicate(
				isRedPredicate
		)
		.and(new OrLogicalCompositePredicate<Peach>(isGreenPredicate, null) );
		
		System.out.println(filter(gardener.getPeaches(), redAndGreenPredicate));
		
		
		
	}

}
