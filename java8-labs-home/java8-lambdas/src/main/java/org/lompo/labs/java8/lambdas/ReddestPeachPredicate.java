package org.lompo.labs.java8.lambdas;

public class ReddestPeachPredicate implements PeachPredicate {

	@Override
	public boolean test(Peach peach) {
		// TODO Auto-generated method stub
		return "blackred".equalsIgnoreCase(peach.getColor());
	}

}
