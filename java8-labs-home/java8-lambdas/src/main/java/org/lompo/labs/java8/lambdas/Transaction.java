package org.lompo.labs.java8.lambdas;

import java.math.BigDecimal;

public class Transaction {
	
	private String sourceAccountNum;
	private String targetAccountNum;
	private BigDecimal amount;
	private boolean credit;
	private boolean debit;
	private String currency;
	

	public Transaction(String sourceAccountNum, String targetAccountNum,
			BigDecimal amount, String currency) {
		this(sourceAccountNum, targetAccountNum, amount, false, false, currency);
		this.credit = amount.compareTo(BigDecimal.ZERO) > 0;
		this.debit = !this.credit;
	}
	
	
	public Transaction(String sourceAccountNum, String targetAccountNum,
			BigDecimal amount, boolean credit, boolean debit, String currency) {
		super();
		this.sourceAccountNum = sourceAccountNum;
		this.targetAccountNum = targetAccountNum;
		this.amount = amount;
		this.credit = credit;
		this.debit = debit;
		this.currency = currency;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSourceAccountNum() {
		return sourceAccountNum;
	}
	public void setSourceAccountNum(String sourceAccountNum) {
		this.sourceAccountNum = sourceAccountNum;
	}
	public String getTargetAccountNum() {
		return targetAccountNum;
	}
	public void setTargetAccountNum(String targetAccountNum) {
		this.targetAccountNum = targetAccountNum;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public boolean isCredit() {
		return credit;
	}
	public void setCredit(boolean credit) {
		this.credit = credit;
	}
	public boolean isDebit() {
		return debit;
	}
	public void setDebit(boolean debit) {
		this.debit = debit;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public String toString() {
		return "{Amount: " + amount 
				+ ", source account: " 
				+ sourceAccountNum 
				+ ", target account: " 
				+ targetAccountNum 
				+ ", credit :" 
				+ credit
				+ "}";
		
	}
	

}
