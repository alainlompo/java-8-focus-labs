package org.lompo.labs.java8.lambdas.streams.reducing;

public class Transaction {
	
	private int year;
	private double amount;
	private Trader trader;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Trader getTrader() {
		return trader;
	}
	public void setTrader(Trader trader) {
		this.trader = trader;
	}
	public Transaction(int year, double amount, Trader trader) {
		super();
		this.year = year;
		this.amount = amount;
		this.trader = trader;
	}
	
	
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return "Year: " + year + " -- Amount: " + amount + "-- Trader: " + trader.getFullName() + "(" + trader.getCity() + ")";
		
	}
	
	
	

}
