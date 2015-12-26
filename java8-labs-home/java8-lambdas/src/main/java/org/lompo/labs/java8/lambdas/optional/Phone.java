package org.lompo.labs.java8.lambdas.optional;

import java.util.Optional;

public class Phone {
	private String phoneNumber;
	private Optional<String> countryCode = Optional.of("+212");
	private Optional<Boolean> dualSimCards = Optional.of(Boolean.valueOf(false));
	public Phone(String phoneNumber) {
		super();
		if (phoneNumber == null) {
			throw new IllegalArgumentException("Phone number is mandatory...");
		}
		this.phoneNumber = phoneNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public Optional<String> getCountryCode() {
		return countryCode;
	}
	
	public void setCountryCode(String countryCode) {
		this.countryCode = Optional.ofNullable(countryCode);
	}
	
	public void setCountryCode(Optional<String> countryCode) {
		this.countryCode = countryCode;
	}
	public Optional<Boolean> getDualSimCards() {
		return dualSimCards;
	}
	
	/**
	 * Here we want the user to be able to pass a null value
	 * and in that case the Optional.empty will be assigned to 
	 * the field. Therefor we will use the static factory method Optional.ofNullable
	 * @param dualSimCards
	 */
	public void setDualSimCards(Boolean dualSimCards) {
		this.dualSimCards = Optional.ofNullable(dualSimCards);
		
	}
	public void setDualSimCards(Optional<Boolean> dualSimCards) {
		this.dualSimCards = dualSimCards;
	}
	
	

}
