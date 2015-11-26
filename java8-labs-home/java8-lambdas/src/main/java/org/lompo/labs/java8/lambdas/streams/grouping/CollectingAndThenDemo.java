package org.lompo.labs.java8.lambdas.streams.grouping;

import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.collectingAndThen;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.lompo.labs.java8.lambdas.streams.reducing.Transaction;
import org.lompo.labs.java8.lambdas.streams.reducing.TransactionUtils;

public class CollectingAndThenDemo {
	
public static enum TransactionType { GOLD, SILVER, BRONZE};
	
	public static void groupMaxAmountTransactionsByType(List<Transaction> source) {
		
		//Map<TransactionType, Optional<Transaction>> maxAmountByType
		// Using collectingAndThen method we can avoid using the Optional<T>
		Map<TransactionType, Transaction> maxAmountByType
		= source.stream()
		.collect(
				groupingBy(
						// Customized classification function
						tx -> {
							if (tx.getAmount() < 500) return TransactionType.BRONZE;
							else if (tx.getAmount() < 1000) return TransactionType.SILVER;
							return TransactionType.GOLD;
						},
						
						//maxBy(comparingDouble(Transaction::getAmount))
						collectingAndThen(								
								maxBy(comparingDouble(Transaction::getAmount)), // wrapped collector
								
								Optional::get)  // Transformation function
						)
				
				);
		for (TransactionType tT: maxAmountByType.keySet()) {
			System.out.println("Type: " + tT);
			System.out.println("====================");
			System.out.println(maxAmountByType.get(tT));
		}
	}
	
	public static void main(String[] args) {
		List<Transaction> transactions = TransactionUtils.getDemoTransactions();
		System.out.println();
		System.out.println("Now group by type and display, for each group the trx with max amount...");
		groupMaxAmountTransactionsByType(transactions);
	}

}
