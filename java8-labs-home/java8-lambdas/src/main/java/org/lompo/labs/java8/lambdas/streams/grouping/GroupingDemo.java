package org.lompo.labs.java8.lambdas.streams.grouping;
import java.util.List;
import java.util.Map;

import org.lompo.labs.java8.lambdas.streams.reducing.Transaction;
import org.lompo.labs.java8.lambdas.streams.reducing.TransactionUtils;

import static java.util.stream.Collectors.*;

public class GroupingDemo {
	
	public static enum TransactionType { GOLD, SILVER, BRONZE};
	
	public static void groupTransactionsByType (List<Transaction> source) {
		Map<TransactionType, List<Transaction>>
		trxByType = source.stream()
		.collect(
				groupingBy(
						tx -> {
							if (tx.getAmount() < 500) return TransactionType.BRONZE;
							else if (tx.getAmount() < 1000) return TransactionType.SILVER;
							return TransactionType.GOLD;
						}
						)
				);
		
		for (TransactionType tT: trxByType.keySet()) {
			System.out.println("Type: " + tT);
			System.out.println("====================");
			System.out.println(trxByType.get(tT));
		}
		
	}
	public static void groupTransactionsByYear(List<Transaction> source) {
		Map<Integer, List<Transaction>> 
		trxByYear = source.stream()
		.collect(groupingBy(Transaction::getYear));
		
		for (Integer y: trxByYear.keySet()) {
			System.out.println("Year: " + y);
			System.out.println("====================");
			System.out.println(trxByYear.get(y));
		}
	}
	
	public static void main(String[] args) {
		List<Transaction> transactions = TransactionUtils.getDemoTransactions();
		groupTransactionsByYear(transactions);
		System.out.println();
		System.out.println("Now classifying transactions according to their significance...");
		groupTransactionsByType(transactions);
	}

}
