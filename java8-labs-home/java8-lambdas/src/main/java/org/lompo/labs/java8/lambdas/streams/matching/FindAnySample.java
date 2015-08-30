package org.lompo.labs.java8.lambdas.streams.matching;

import java.util.List;


import org.lompo.labs.java8.lambdas.streams.filtering.Programmer;
public class FindAnySample {
	
	public static void main(String[] args) {
		List<Programmer> geeks = Programmer.getDemoGeeks();
		
		 geeks.stream()
		.filter(Programmer::hasDotNetSkills)
		.findAny()
		.ifPresent(p -> System.out.println("The dot net geek is: " + p));
		
	}

}
