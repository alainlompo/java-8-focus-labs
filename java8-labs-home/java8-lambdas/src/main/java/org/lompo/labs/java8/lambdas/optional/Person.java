package org.lompo.labs.java8.lambdas.optional;

import java.util.Optional;

public class Person {
	private String firstName;
	private String lastName;
	private Optional<String> idCard;
	private Optional<String> securityCard;
	private Optional<Phone> mainPhone;
	public Person(String firstName, String lastName) {
		super();
		if (firstName == null || lastName == null) {
			throw new IllegalArgumentException("A person must have a first name and a last name...");
		}
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Optional<String> getIdCard() {
		return idCard;
	}
	public void setIdCard(Optional<String> idCard) {
		this.idCard = idCard;
	}
	public Optional<String> getSecurityCard() {
		return securityCard;
	}
	public void setSecurityCard(Optional<String> securityCard) {
		this.securityCard = securityCard;
	}
	public Optional<Phone> getMainPhone() {
		return mainPhone;
	}
	public void setMainPhone(Optional<Phone> mainPhone) {
		this.mainPhone = mainPhone;
	}
	
	
	
	
	

}
