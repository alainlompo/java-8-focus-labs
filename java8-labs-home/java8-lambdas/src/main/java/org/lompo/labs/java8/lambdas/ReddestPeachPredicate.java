package org.lompo.labs.java8.lambdas;

public class ReddestPeachPredicate implements PeachPredicate {

	@Override
	public boolean test(Peach peach) {
		
		return "blackred".equalsIgnoreCase(peach.getColor());
	}

}
