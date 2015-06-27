package org.lompo.labs.java8.lambdas;

public class GoodLookingPeachPredicate implements PeachPredicate{

	@Override
	public boolean test(Peach peach) {
		// TODO Auto-generated method stub
		return "lightblue".equalsIgnoreCase(peach.getColor()) && 350 < peach.getWeight();
	}

}
