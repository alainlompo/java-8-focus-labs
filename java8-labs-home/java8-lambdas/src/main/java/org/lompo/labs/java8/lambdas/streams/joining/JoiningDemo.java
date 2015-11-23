package org.lompo.labs.java8.lambdas.streams.joining;

import java.util.List;

import org.lompo.labs.java8.lambdas.streams.reducing.Transaction;
import org.lompo.labs.java8.lambdas.streams.reducing.TransactionUtils;
import static java.util.stream.Collectors.joining;

public class JoiningDemo {
	public static void main(String[] args) {
		List<Transaction> trx = TransactionUtils.getDemoTransactions();
		String yearsList =
				trx.stream()
				
				.map(t -> t.getYear() + "")
				.distinct()
				.collect(joining(", "));
		
		System.out.println("Here is the distinct years transactions were done: " + yearsList);
		
	}

}
