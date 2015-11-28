package org.lompo.labs.java8.lambdas.streams.grouping;

import java.util.List;
import java.util.function.Predicate;

import org.lompo.labs.java8.lambdas.streams.reducing.Transaction;
import org.lompo.labs.java8.lambdas.streams.reducing.TransactionAmountComparator;
import org.lompo.labs.java8.lambdas.streams.reducing.TransactionUtils;

public class TakeWhileConceptDemo {
	
	public static void main(String[] args) {
		doTakeWhileDemo();
	}
	
	public static void doTakeWhileDemo() {
		List<Transaction> trxs = TransactionUtils.getDemoTransactions();
		trxs.sort(new TransactionAmountComparator());
		Transaction minTrx = trxs.get(0);
		Transaction maxTrx = trxs.get(trxs.size()-1);
		double mediumAmount = (minTrx.getAmount() + maxTrx.getAmount())/2;
		Predicate<Transaction> discriminator = t -> t.getAmount() < mediumAmount;
		List<Transaction> smallerThanMediumList = TakeWhileConcept.takeWhile(trxs, discriminator);
		System.out.println("Medium value: " + mediumAmount);
		System.out.println("Lesser than medium values....");
		for (Transaction trx: smallerThanMediumList) {
			System.out.println(trx);
		}
	}

}
