package org.lompo.labs.java8.lambdas.methodreference;

import java.util.Arrays;
import java.util.List;

/**
 * Illustration of method reference for sorting strings
 * We can reference the compareToIgnoreCase method from the String class
 * @author LOMPO
 *
 */
public class StringSorter {
	
	public static void sort(List<String> stringStore) {
		stringStore.sort(String::compareToIgnoreCase);
	}
	
	public static void main(String[] args) {
		List<String> strings = Arrays.asList("Hello", "World", "Java 8", "Is really", "Fun", "Cool stuff", "In", "There", "Come and ", "check for", "yourself");
		sort(strings);
		
		System.out.println(strings);
		
	}

}
