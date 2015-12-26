package org.lompo.labs.java8.lambdas.optional;

import java.util.Optional;

public class Customer {
	
	private String businessName;
	private Optional<Adress> businessAdress;
	private Optional<Person> businessContactPerson;
	private Optional<Phone> mainBusinessPhone;
	private Optional<Phone> secondaryBusinessPhone;
	private Optional<Email> businessEmail;
	private Optional<Email> secondaryEmail;
	public Customer(String businessName) {
		super();
		if (businessName == null) {
			throw new IllegalArgumentException("business name is mandatory....");
		}
		this.businessName = businessName;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public Optional<Adress> getBusinessAdress() {
		return businessAdress;
	}
	public void setBusinessAdress(Optional<Adress> businessAdress) {
		this.businessAdress = businessAdress;
	}
	public Optional<Person> getBusinessContactPerson() {
		return businessContactPerson;
	}
	public void setBusinessContactPerson(Optional<Person> businessContactPerson) {
		this.businessContactPerson = businessContactPerson;
	}
	public Optional<Phone> getMainBusinessPhone() {
		return mainBusinessPhone;
	}
	public void setMainBusinessPhone(Optional<Phone> mainBusinessPhone) {
		this.mainBusinessPhone = mainBusinessPhone;
	}
	public Optional<Phone> getSecondaryBusinessPhone() {
		return secondaryBusinessPhone;
	}
	public void setSecondaryBusinessPhone(Optional<Phone> secondaryBusinessPhone) {
		this.secondaryBusinessPhone = secondaryBusinessPhone;
	}
	public Optional<Email> getBusinessEmail() {
		return businessEmail;
	}
	public void setBusinessEmail(Optional<Email> businessEmail) {
		this.businessEmail = businessEmail;
	}
	public Optional<Email> getSecondaryEmail() {
		return secondaryEmail;
	}
	public void setSecondaryEmail(Optional<Email> secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}
	
	
	

}
