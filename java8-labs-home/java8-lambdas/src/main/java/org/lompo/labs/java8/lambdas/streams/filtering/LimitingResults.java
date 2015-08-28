package org.lompo.labs.java8.lambdas.streams.filtering;


import static java.util.stream.Collectors.toList;

import java.util.List;

public class LimitingResults {
	
	public static void main(String[] args) {
		List<Programmer> dreamTeam = Programmer.getDemoGeeks()
		.stream()
		.filter(p -> p.hasHaxeSkills())
		.filter(p -> (p.hasDotNetSkills() | p.hasJavaSkills() ) )
		.limit(7)
		.collect(toList());
		
		System.out.println("And the dream team is...." + dreamTeam);
	}

}
