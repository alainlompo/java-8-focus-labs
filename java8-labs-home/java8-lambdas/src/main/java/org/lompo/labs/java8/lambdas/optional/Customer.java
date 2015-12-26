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
	
	
	

}
