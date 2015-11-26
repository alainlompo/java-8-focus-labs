package org.lompo.labs.java8.lambdas.streams.grouping;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.counting;

import org.lompo.labs.java8.lambdas.streams.reducing.Transaction;
import org.lompo.labs.java8.lambdas.streams.reducing.TransactionUtils;

import static java.util.Comparator.comparingDouble;
import static java.util.stream.Collectors.groupingBy;


public class GroupingDemo {
	
	public static enum TransactionType { GOLD, SILVER, BRONZE};
	
	public static void groupMaxAmountTransactionsByType(List<Transaction> source) {
		Map<TransactionType, Optional<Transaction>> maxAmountByType 
		= source.stream()
		.collect(
				groupingBy(
						tx -> {
							if (tx.getAmount() < 500) return TransactionType.BRONZE;
							else if (tx.getAmount() < 1000) return TransactionType.SILVER;
							return TransactionType.GOLD;
						},
						maxBy(comparingDouble(Transaction::getAmount))
						)
				
				);
		for (TransactionType tT: maxAmountByType.keySet()) {
			System.out.println("Type: " + tT);
			System.out.println("====================");
			System.out.println(maxAmountByType.get(tT));
		}
	}
	
	public static void groupTransactionsByTypeAndCounting(List<Transaction> source) {
		Map<TransactionType, Long>
		trxByType = source.stream()
		.collect(
				groupingBy(
						tx -> {
							if (tx.getAmount() < 500) return TransactionType.BRONZE;
							else if (tx.getAmount() < 1000) return TransactionType.SILVER;
							return TransactionType.GOLD;
						}, counting()
						)
				);
		
		for (TransactionType tT: trxByType.keySet()) {
			System.out.println("Type: " + tT);
			System.out.println("====================");
			System.out.println(trxByType.get(tT));
		}
	}
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
		System.out.println();
		System.out.println("Now group and count....");
		groupTransactionsByTypeAndCounting(transactions);
		System.out.println();
		System.out.println("Now group by type and display, for each group the trx with max amount...");
		groupMaxAmountTransactionsByType(transactions);
	}

}
