package org.lompo.labs.java8.lambdas;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.List;

public class PeachManager {
	
	private List<Peach> peaches;
	
	public PeachManager() {
		peaches = new ArrayList<Peach>();
		
	}
	
	public PeachManager add(Peach peach) {
		peaches.add(peach);
		return this;
	}
	
	public PeachManager add(String peachColor, int weight) {
		return add(new Peach(peachColor, weight));
	}
	
	public void sort() {
		
	}
	
	public void printPeaches() {
		System.out.println(peaches);
	}
	
	/**
	 * This method can be used as a reference to a predicate of type Predicate<Peach>
	 * @param peach
	 * @return
	 */
	public static boolean isGreenPeach(Peach peach) {
		return "green".equalsIgnoreCase(peach.getColor());
	}
	
	public static boolean isHeavyPeach(Peach peach) {
		return 150 < peach.getWeight();
	}
	
	/**
	 * 
	 * @param inventory
	 * @param p a reference to a Predicate<P> function. The two methods isHeavyPeach and
	 * isGreenPeach are good candidates
	 * @return
	 */
	public static List<Peach> filterPeaches(List<Peach> inventory, Predicate<Peach> p) {
		List<Peach> result = new ArrayList<Peach>();
		for (Peach peach: inventory) {
			if (p.test(peach)) {
				result.add(peach);
			}
		}
		return result;
	}
	
	/**
	 * A shorter version of the previous filter method using the internal List<Peach> as entry datas
	 * @param p
	 * @return
	 */
	public  List<Peach> filterPeaches( Predicate<Peach> p) {
		return filterPeaches(peaches, p);
	}
	
	public List<Peach> filterRedPeaches() {
		return filterPeaches((Peach p) -> "red".equalsIgnoreCase(p.getColor()));
	}
	
	
	
	

}
