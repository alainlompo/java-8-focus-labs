package org.lompo.labs.java8.lambdas.streams;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountOperation {
	private BigDecimal amount;
	private AccountOperationType type;
	private Date date;
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public AccountOperationType getType() {
		return type;
	}
	public void setType(AccountOperationType type) {
		this.type = type;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public AccountOperation(BigDecimal amount, AccountOperationType type,
			Date date) {
		super();
		this.amount = amount;
		this.type = type;
		this.date = date;
	}
	public AccountOperation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		SimpleDateFormat sDF = new SimpleDateFormat("dd/MM/yyyy");
		String dateText=null;
		try {
			dateText = sDF.format(date);
			
		} catch (Exception ex) {
			
		}
		return "Amout: " + amount + ", Type: " + type + ", Date: " + ((null !=dateText)?dateText:"UNSPECIFIED");
		
	}
	
	
	

}
