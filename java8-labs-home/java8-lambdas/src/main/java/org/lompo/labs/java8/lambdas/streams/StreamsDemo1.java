package org.lompo.labs.java8.lambdas.streams;

import java.math.BigDecimal;
import java.util.List;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;


public class StreamsDemo1 {
	
	public static void main(String[] args) {
		Account account = BankDataSet.generateAccountWith(15);
		List<AccountOperation> operations = account.getAccountMouvements();
		List<AccountOperation> lowAmountOps = operations.stream()
				.filter(op -> op.getAmount().compareTo (BigDecimal.valueOf(1000.0D) ) <0 )
				.sorted(comparing(AccountOperation::getAmount))
				.collect(toList());
		
		for (AccountOperation aO: lowAmountOps) {
			System.out.println(aO);
		}
		
		
	}

}
