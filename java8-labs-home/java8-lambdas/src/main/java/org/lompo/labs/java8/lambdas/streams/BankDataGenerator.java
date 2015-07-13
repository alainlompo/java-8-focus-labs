package org.lompo.labs.java8.lambdas.streams;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class BankDataGenerator {
	
	public static final List<String> ACCOUNT_NUMBERS = Arrays.asList("AC000145547", "AC548555654", "AC958456624", "AC98632511744", "AC968547556254");
	public static final List<BigDecimal> BALANCES = Arrays.asList(BigDecimal.valueOf(25485.56D),
			BigDecimal.valueOf(95847.69D),
			BigDecimal.valueOf(74584.69D),
			BigDecimal.valueOf(9685632.6321D),
			BigDecimal.valueOf(69587.44D)
			);
	
	public static final List<AccountOperationType> OPERATION_TYPES = Arrays.asList(AccountOperationType.CREDIT, AccountOperationType.DEBIT);
	
	static Account accountValueOf(String accountNumber, BigDecimal initialBalance) {
		Account acc = new Account(accountNumber, initialBalance);
		return acc;
	}
	
	static AccountOperation accountOperationValueOf(BigDecimal amount, AccountOperationType type, Date date) {
		AccountOperation operation = new AccountOperation(amount, type, date);
		return operation;
	}
	
	
	static AccountOperation accountOperationValueOf(BigDecimal amount, AccountOperationType type) {
		return accountOperationValueOf(amount, type, new Date());
	}
	
	

}
