package org.lompo.labs.java8.lambdas.streams.collecting;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.*;

import org.lompo.labs.java8.lambdas.streams.reducing.Transaction;
import org.lompo.labs.java8.lambdas.streams.reducing.TransactionUtils;

public class SummarizingAndReducing {
	
	public static void printTotalTransactionsAmount(List<Transaction> source) {
		double totalAmount
		= source.stream()
		.collect(reducing(
				0.0D,
				Transaction::getAmount,
				(am1, am2) -> am1 + am2
				));
		System.out.println("The total amount of all transactions is: " + totalAmount);
		
		
	}
	
	public static void printBiggestTransaction(List<Transaction> source) {
		Optional<Transaction> biggestTransaction
		= source.stream()
		.collect(reducing(
				(t1, t2) -> t1.getAmount() > t2.getAmount()? t1:t2
				));
		if (biggestTransaction.isPresent()) {
			System.out.println("The biggest transaction is: " + biggestTransaction.get());
		} else {
			System.out.println("Humm....we could not get the biggest transaction, how strange...");
		}
	}
	
	public static void main(String[] args) {
		List<Transaction> transactions = TransactionUtils.getDemoTransactions();
		printTotalTransactionsAmount(transactions);
		System.out.println();
		printBiggestTransaction(transactions);
		
		
		
	}

}
