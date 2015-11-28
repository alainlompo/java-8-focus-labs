package org.lompo.labs.java8.lambdas.streams.collecting;


import org.lompo.labs.java8.lambdas.streams.reducing.Transaction;
import org.lompo.labs.java8.lambdas.streams.reducing.TransactionUtils;

import java.util.List;


public class ToListCollectorDemo {
	
	public static void main(String[] args) {
		List<Transaction> demoTrx = TransactionUtils.getDemoTransactions();
		List<Transaction> processedTrx
		= demoTrx.stream()
		.collect(new ToListCollector<Transaction>());
		System.out.println(processedTrx);
	}

}
