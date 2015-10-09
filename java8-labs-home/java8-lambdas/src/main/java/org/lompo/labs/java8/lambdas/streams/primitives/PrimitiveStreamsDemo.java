package org.lompo.labs.java8.lambdas.streams.primitives;

import java.util.List;
import java.util.OptionalDouble;

import org.lompo.labs.java8.lambdas.streams.reducing.Transaction;
import org.lompo.labs.java8.lambdas.streams.reducing.TransactionUtils;
public class PrimitiveStreamsDemo {
	
	/**
	 * Illustrates the use of a primitive stream. In this case a DoubleStream
	 * which allows to do computing with primitive types instead of boxing types
	 * and improves efficiency
	 * @param transactions
	 */
	public static void computeGlobalAmount(List<Transaction> transactions) {
		double globalAmount =
				transactions.stream()
				.mapToDouble(Transaction::getAmount)
				.sum();
		System.out.println("The global amount for this bunch of transactions is...." + globalAmount);
		
	}
	
	
	/**
	 * Illustrates the use of primitive double stream with OptionalDouble
	 * to compute the max of a stream
	 * @param transactions
	 */
	public static void showBiggestTransaction(List<Transaction> transactions) {
		OptionalDouble biggestTransaction = 
				transactions.stream()
				.mapToDouble(Transaction::getAmount)
				.max();
		if (biggestTransaction.isPresent()) {
			System.out.println("The biggest transaction's amount is: " + biggestTransaction.getAsDouble());
		} else {
			System.out.println("hum.... something went wrong somewhere...");
		}
	}
	
	public static void main(String[] args) {
		List<Transaction> myTransactions = TransactionUtils.getDemoTransactions(); 
		computeGlobalAmount(myTransactions);
		showBiggestTransaction(myTransactions);
		
	}

}
