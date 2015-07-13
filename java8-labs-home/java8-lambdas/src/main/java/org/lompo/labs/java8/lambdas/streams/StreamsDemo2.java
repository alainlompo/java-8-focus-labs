package org.lompo.labs.java8.lambdas.streams;

import java.math.BigDecimal;
import java.util.List;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

/**
 * Comparing the result from processing using .stream() and using .parallelStream();
 * @author LOMPO
 *
 */
public class StreamsDemo2 {
	
	public static void main(String[] args) {
		Account account = BankDataSet.generateAccountWith(25000);
		List<AccountOperation> operations = account.getAccountMouvements();
		
		long monoStartTime = System.currentTimeMillis();
		
		List<AccountOperation> lowAmountOps = operations.stream()
				.filter(op -> op.getAmount().compareTo (BigDecimal.valueOf(1000.0D) ) <0 )
				.sorted(comparing(AccountOperation::getAmount))
				.collect(toList());
		
		long monoEndTime = System.currentTimeMillis();
		
		for (AccountOperation aO: lowAmountOps) {
			System.out.println(aO);
		}
		
		long delta = monoEndTime - monoStartTime;
		
		
		System.out.println();
		System.out.println("********************");
		long parallelStartTime = System.currentTimeMillis();
		List<AccountOperation> lowAmountOpsP = operations.parallelStream()
				.filter(op -> op.getAmount().compareTo (BigDecimal.valueOf(1000.0D) ) <0 )
				.sorted(comparing(AccountOperation::getAmount))
				.collect(toList());
		long parallelEndTime = System.currentTimeMillis();
		
		for (AccountOperation aO: lowAmountOpsP) {
			System.out.println(aO);
		}
		
		long deltaP = parallelEndTime - parallelStartTime;
		System.out.println("Non parallel Computed in "  + delta + " milliseconds ");
		System.out.println("Parallel computed in " + deltaP + " milliseconds");

		
		
		
	}

}
