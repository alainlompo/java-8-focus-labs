package org.lompo.labs.java8.lambdas.streams;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountBuilder {
	
	private Account account;
	
	public AccountBuilder() {
		account = new Account();
	}
	
	public AccountBuilder(String accountNumber, BigDecimal initialBalance) {
		account = BankDataGenerator.accountValueOf(accountNumber, initialBalance);
	}
	
	public AccountBuilder addAccountNumber(String accountNumber) {
		if (null == account) {
			account = new Account();
		}
		account.setAccountNumber(accountNumber);
		return this;
	}
	
	public AccountBuilder addBalance(BigDecimal balance) {
		if (null == account) {
			account = new Account();
		}
		account.setBalance(balance);
		return this;
		
	}
	
	public AccountBuilder addOperation(BigDecimal amount, AccountOperationType type, Date date) {
		if (null == account) {
			account = new Account();
		}
		List<AccountOperation> operations = account.getAccountMouvements();
		if (operations == null) {
			operations = new ArrayList<>();
			account.setAccountMouvements(operations);
		}
		
		operations.add(BankDataGenerator.accountOperationValueOf(amount, type, date));
		return this;
		
	}
	
	public Account toAccount() {
		return account;
	}

}
