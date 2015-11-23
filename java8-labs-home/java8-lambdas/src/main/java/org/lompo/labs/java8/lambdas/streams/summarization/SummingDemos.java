package org.lompo.labs.java8.lambdas.streams.summarization;

import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.lompo.labs.java8.lambdas.streams.reducing.Transaction;
import org.lompo.labs.java8.lambdas.streams.reducing.TransactionUtils;

import static java.util.stream.Collectors.summingDouble;
import static java.util.stream.Collectors.averagingDouble;
import static java.util.stream.Collectors.summarizingDouble;

public class SummingDemos {
	
	public static void main(String[] args) {
		List<Transaction> trx = TransactionUtils.getDemoTransactions();
		double totalAmount = trx.stream()
				.collect(summingDouble(Transaction::getAmount));
		System.out.println("The total amount of all the transactions =" + totalAmount);
		

		double averageAmount = trx.stream()
				.collect(averagingDouble(Transaction::getAmount));
		
		System.out.println("The average amount of a transaction is " +averageAmount);
		
		DoubleSummaryStatistics trxStats =
				trx.stream()
				.collect(summarizingDouble(Transaction::getAmount));
		
		System.out.println("Collected stats....");
		System.out.println("-------------------");
		System.out.println(trxStats);
		
	}

}
