package org.lompo.labs.java8.lambdas.streams.reducing;

import java.util.Comparator;

public class TraderFullNameComparator implements Comparator<Trader> {

	@Override
	public int compare(Trader trd1, Trader trd2) {
		if (trd1 == null || trd2 ==null) {
			return -1;
		} 
		
		if (trd1.getFullName() == null) {
			return -1;
		}
		
		if (trd2.getFullName() == null) {
			return +1;
		}
		
		return trd1.getFullName().compareToIgnoreCase(trd2.getFullName());
		
		
		
	}
	

}
