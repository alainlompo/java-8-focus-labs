package org.lompo.labs.java8.lambdas.streams.collecting;

import org.lompo.labs.java8.lambdas.streams.reducing.Transaction;
import org.lompo.labs.java8.lambdas.streams.reducing.TransactionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * This demo shows how to use an overload version of the collect
 * method to perform a customized collect operation without
 * defining a fully fledged Collector class
 * @author LOMPO
 *
 */
public class CollectOverloadDemo {
	
	public static void doDemo() {
		List<Transaction> trx = TransactionUtils.getDemoTransactions();
		List<Transaction> processedTrx
		= trx.stream()
		.collect(
				// Supplier
				ArrayList::new,
				// Accumulator
				List::add,
				// Combiner
				List::addAll
				
				);
		System.out.println(processedTrx);
		
	}
	public static void main(String[] args) {
		
		doDemo();
		
	}

}
