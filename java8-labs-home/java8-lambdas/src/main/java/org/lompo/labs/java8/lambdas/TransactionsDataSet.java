package org.lompo.labs.java8.lambdas;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.lompo.labs.java8.lambdas.BunchOfDatasForTestUtils.*;

/**
 * Bunch of datas for prooving concepts
 * @author LOMPO
 *
 */
public class TransactionsDataSet {
	
	private static final List<String> SOURCE_ACCOUNTS = Arrays.asList(
		"ABC1456584586LMK",
		"KSJ856954SSS8995",
		"SJS999548SS633SS"
	);
	
	private static final List<String> TARGET_ACCOUNTS = Arrays.asList(
			"1456584586LMKAAB",
			"KSJ856954SSS8KKS",
			"SJS999548SS633SQQ",
			"5585SSSZED668FCFD"
		);
	
	private static final List<BigDecimal> SAMPLE_AMOUNTS = Arrays.asList(
			BigDecimal.valueOf(458.58D),
			BigDecimal.valueOf(8954.85D),
			BigDecimal.valueOf(45522),
			BigDecimal.valueOf(15845L),
			BigDecimal.valueOf(154.89D),
			BigDecimal.valueOf(586.56D)
			);
	
	private static final List<String> SAMPLE_CURRENCIES = Arrays.asList(
			"MAD",
			"EUR","USD",
			"ECU",
			"DNR",
			"CFA"
			);
	
	
	public static List<Transaction> getABunchOfTransactions () {
		List<Transaction> result = new ArrayList<Transaction>();
		int numberOfTransactions = 30;
		for (int i = 0; i < numberOfTransactions; i++) {
			boolean credit = oneOf(true, false);
			result.add( new Transaction(
					oneOf(SOURCE_ACCOUNTS),
					oneOf(TARGET_ACCOUNTS),
					oneOf(SAMPLE_AMOUNTS),
					credit,
					!credit,
					oneOf(SAMPLE_CURRENCIES)
					)
			);
			
		}
		
		return result;
	}

}
