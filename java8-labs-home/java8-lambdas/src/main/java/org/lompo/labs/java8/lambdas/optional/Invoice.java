package org.lompo.labs.java8.lambdas.optional;

import java.util.Optional;

public class Invoice {
	
	private String reference;
	private Optional<Customer> customer;
	private int quantity;
	private double unitPrice;
	public Invoice(String reference, int quantity, double unitPrice) {
		super();
		if (reference == null) {
			throw new IllegalArgumentException("The reference can't be null...");
		}
		this.reference = reference;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public Optional<Customer> getCustomer() {
		return customer;
	}
	/**
	 * Here we do not want the client code to be able to set a null customer
	 * If a null is passed as argument we want an exception to be immediately
	 * raised: so we use the static factory method Optional.of
	 * @param customer
	 */
	public void setCustomer(Customer customer) {
		this.customer = Optional.of(customer);
		
	}
	public void setCustomer(Optional<Customer> customer) {
		this.customer = customer;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public double getTotal() {
		return unitPrice * quantity;
	}
	

}
