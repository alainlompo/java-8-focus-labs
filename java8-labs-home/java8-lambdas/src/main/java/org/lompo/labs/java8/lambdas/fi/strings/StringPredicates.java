package org.lompo.labs.java8.lambdas.fi.strings;

import java.util.function.Predicate;

public class StringPredicates {
	
	private StringPredicates() {
		
	}
	
	public static final Predicate<String> NOT_EMPTY_STRING_PREDICATE = (String s) -> !s.isEmpty();
	public static final Predicate<String> NOT_NULL_STRING_PREDICATE = (String s) -> s != null;
	public static final Predicate<String> IS_UPPERCASE_PREDICATE = (String s) -> s.equals(s.toUpperCase());
	public static final Predicate<String> IS_LOWERCASE_PREDICATE = (String s) -> s.equals(s.toLowerCase());

}
