package org.lompo.labs.java8.lambdas.streams.matching;

import java.util.List;

import org.lompo.labs.java8.lambdas.streams.filtering.Programmer;

public class AnyMatchSample {
	
	public static void main(String[] args) {
		List<Programmer> geeks = Programmer.getDemoGeeks();
		boolean weHaveAHaxGeek = geeks.stream().anyMatch(Programmer::hasHaxeSkills);
		if (weHaveAHaxGeek) {
			System.out.println("Wow, we have a haxe programmer...");
		} else {
			System.out.println("Ooops, no haxe guy...");
		}
		
		boolean weHaveDotNet = geeks.stream().anyMatch(Programmer::hasDotNetSkills);
		System.out.println((weHaveDotNet)?"We have a dot net geek":"Oops, no dot net");	
	}

}
