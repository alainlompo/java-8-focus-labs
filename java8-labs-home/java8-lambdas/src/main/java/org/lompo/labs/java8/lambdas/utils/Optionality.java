package org.lompo.labs.java8.lambdas.utils;

import java.util.Optional;

public class Optionality {
	private Optionality() {
		
	}
	
	public static Optional<Integer> parseInt(String s) {
		try {
			return Optional.of(Integer.parseInt(s));
			
		} catch (NumberFormatException nFE) {
			return Optional.empty();
		}
	}
	
	public static Optional<Integer> decode(String s) {
		try {
			return Optional.of(Integer.decode(s));
			
		} catch (NumberFormatException nFE) {
			return Optional.empty();
		}
	}

}
