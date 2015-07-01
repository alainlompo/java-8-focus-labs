package org.lompo.labs.java8.lambdas.fi.functions;

import java.util.Arrays;
import java.util.List;

public class FunctionalMapperExamples {
	
	public static void main(String[] args) {
		FunctionalMapper<String, Integer> fM = new FunctionalMapper<String,Integer>();
		List<Integer> lengths = fM.map(Arrays.asList("Hello","Everybody", "This is Java8", "It's fantastic"), (String s)-> s.length() );
		for (Integer i: lengths) {
			System.out.println(i.toString());
		}
	}

}
