package org.lompo.labs.java8.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Examples of using java 8 streams on collections
 * @author LOMPO
 *
 */
public class StreamsOne {

	
	public static void main(String[] args) {
	
		List<String> books = new ArrayList<String>();
		books.add("Pro Java 8 programming");
		books.add("AngularJS TDD Development");
		books.add("Architecting mobile solutions for the enterprise");
		books.add("Beginning Spring");
		books.add("Beginning webgl for html5");
		books.add("Functional JavaScript...");
		books.add("Functional programming in Java");
		books.add("Functional programming in JavaScript");
		books.add("Pro Spring batch");
		books.add("Pro WPF 4.5 in C#");
		books.add("C# 4 ASP. NET and WPF with Visual Studio");
		books.add("Java 2 core language little black book");
		
		
		List<String> javaBooks = books.stream()
				.filter(e -> e.toUpperCase().contains("JAVA"))
				.collect(Collectors.toList());
		
		System.out.println("The Java books of the collection are...");
		System.out.println(javaBooks);
		
		List<String> proBooks = books.stream()
				.filter(book -> book.toUpperCase().contains("PRO "))
				.collect(Collectors.toList());
		
		System.out.println();
		System.out.println("Here are the pros books...");
		System.out.println(proBooks);
		
		
	}
}
