package org.lompo.labs.java8.lambdas.streams;

import java.math.BigDecimal;
import java.util.List;
public class Account {
	private String accountNumber;
	private BigDecimal balance;
	private List<AccountOperation> accountMouvements;
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public List<AccountOperation> getAccountMouvements() {
		return accountMouvements;
	}
	public void setAccountMouvements(List<AccountOperation> accountMouvements) {
		this.accountMouvements = accountMouvements;
	}
	
	public Account(String accountNumber, BigDecimal balance,
			List<AccountOperation> accountMouvements) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.accountMouvements = accountMouvements;
	}
	
	public Account(String accountNumber, BigDecimal balance
			) {
		this(accountNumber, balance, null);
		
	}
	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
