package org.lompo.labs.java8.lambdas.streams.filtering;

import static java.util.stream.Collectors.toList;

import java.util.List;
public class FilteringDemo {
	
	public static void main(String[] args) {
		List<Programmer> geeks = Programmer.getDemoGeeks();
		List<Programmer> realJavaGeeks
		= geeks.stream()
		.filter(d -> {
		
			if (d.hasJavaSkills()) {
				System.out.println(d.getGeekName());
			}
			return d.hasJavaSkills();
		})
		.filter(d -> {
			if (d.hasDotNetSkills()) {
				System.out.println("==> Wow, the guy is also a dot net geek...");
			}
			return d.hasDotNetSkills();
		})
		.collect(toList());
		
		
	}

}
