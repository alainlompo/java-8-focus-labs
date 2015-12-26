package org.lompo.labs.java8.lambdas.optional;

import java.util.Optional;

public class Email {

	private String prefix;
	private String suffix;
	public Email(String prefix, String suffix) {
		super();
		if (prefix == null || suffix == null) {
			throw new IllegalArgumentException("Incorrect email format...");
		}
		this.prefix = prefix;
		this.suffix = suffix;
	}
	
	
	
}
