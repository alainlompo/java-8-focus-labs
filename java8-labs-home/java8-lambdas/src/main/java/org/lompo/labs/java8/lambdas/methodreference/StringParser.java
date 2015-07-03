package org.lompo.labs.java8.lambdas.methodreference;

import java.util.function.Function;

/**
 * We want to use parseInt from Integer class as a lambda expression on one hand
 * And as a method reference on the other hand
 * As expected the results from the two calls are the same
 * @author LOMPO
 *
 */
public class StringParser {
	
	public final static Function<String, Integer> PARSER = (s) -> Integer.parseInt(s);
	
	public static int fromStringToInteger(String s, Function<String, Integer> transformer) {
		return transformer.apply(s);
	}
	
	public static void main(String[] args) {
		String s1 = "356";
		int value1 = fromStringToInteger(s1, PARSER);
		int value2 = fromStringToInteger(s1, Integer::parseInt);
		
		assert value1 ==  value2: "How strange! the values are divergeant";
		System.out.println("As expected "+ value1 + " = " + value2);
	}

}
