package org.lompo.labs.java8.lambdas.streams.collecting;

import org.lompo.labs.java8.lambdas.streams.reducing.Transaction;
import org.lompo.labs.java8.lambdas.streams.reducing.TransactionAmountComparator;
import org.lompo.labs.java8.lambdas.streams.reducing.TransactionUtils;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.*;

public class CollectingDemos {
	public static Map<Integer, List<Transaction>> getTransactionsByYear(List<Transaction> source) {
		return
				source.stream()
				.collect(groupingBy(Transaction::getYear));
		
	}
	
	public static Transaction getBiggestTransaction(List<Transaction> source) {
		Comparator<Transaction> trxComparator = new TransactionAmountComparator();
		Optional<Transaction> biggestAmountTransaction
		= source.stream()
		.collect(maxBy(trxComparator));
		
		if (biggestAmountTransaction.isPresent()) {
			return biggestAmountTransaction.get();
		}
		
		return null;
		
	}
	
	public static double getTotalAmountOfAllTransactions(List<Transaction> source) {
		double total =
				source.stream()
				.collect(summingDouble(Transaction::getAmount));
		return total;
	}
	
	public static double getAverageAmountOfATransaction(List<Transaction> source) {
		double average =
				source.stream()
				.collect(averagingDouble(Transaction::getAmount));
		return average;
	}
	
	public static void main(String[] args) {
		System.out.println("Obtaining all transactions....");
		List<Transaction> transactions = TransactionUtils.getDemoTransactions();
		System.out.println("Grouping transactions by year...");
		Map<Integer, List<Transaction>> groups = getTransactionsByYear(transactions);
		
		//System.out.println(groups.entrySet());
		
		Set<Integer> years = groups.keySet();
		
		for (Integer year: years) {
			System.out.println("For the year: " + year);
			System.out.println("======================");
			System.out.println(groups.get(year));
			System.out.println();
		}
		
		System.out.println("And the biggest transaction is:...");
		System.out.println(getBiggestTransaction(transactions));
		System.out.println();
		System.out.println("The total amount of all transactions is: " + getTotalAmountOfAllTransactions(transactions));
		System.out.println();
		System.out.println("The average transaction amount is:..." + getAverageAmountOfATransaction(transactions));
	}

}
