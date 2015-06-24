package org.lompo.labs.java8.lambdas;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.stream.Collectors.*;

/**
 * This example shows how to use Collectors.groupingBy along with filter() and collect() methods
 * from the java 8 stream object
 * @author LOMPO
 *
 */
public class StreamSecond {

	public static void main(String[] args) {
		List<Transaction> dataList = TransactionsDataSet.getABunchOfTransactions();
		Map<String, List<Transaction>> transactionsByCurrencies
		= dataList.stream()
		.filter( (Transaction t) -> t.getAmount().compareTo(BigDecimal.valueOf(500L)) > 0)
		.collect(groupingBy(Transaction::getCurrency));
		
		Set<String> currencies = transactionsByCurrencies.keySet();
		
		for (String currency: currencies) {
			System.out.println("Transactions corresponding to " + currency);
			System.out.println("------------------------");
			System.out.println(transactionsByCurrencies.get(currency));
		}
		
		
				
	}
}
