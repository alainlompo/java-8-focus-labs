package org.lompo.labs.java8.lambdas.streams.reducing;

import java.util.Comparator;

public class TransactionAmountComparator implements Comparator<Transaction> {

	@Override
	public int compare(Transaction tr1, Transaction tr2) {
	
		return Double.valueOf(tr1.getAmount()).compareTo(Double.valueOf(tr2.getAmount()));
	}

}
