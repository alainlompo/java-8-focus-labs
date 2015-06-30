package org.lompo.labs.java8.lambdas.fi.strings;

import java.util.Scanner;

import org.apache.commons.lang.StringUtils;

public class StringManipulations {
	
	/**
	 * Because we use a functional interface as parameter to customize the processing
	 * of this method we are applying behaviour parameterization and we may define as
	 * much lambdas based fields to pass as processor parameter to the method
	 * @see palyndromeMatcher and upperCaseProducer below for illustrations
	 * @param s
	 * @param processor
	 * @return
	 */
	public static boolean isIdemPotant(String s, Transformable processor) {
		String transformation = processor.transform(s);
		return (transformation != null) && (transformation.trim().equalsIgnoreCase(s));
	}
	
	
	
	public static Transformable palyndromeMatcher = (String s) -> StringUtils.reverse(s);
	public static Transformable upperCaseProducer = (String s) -> s.toUpperCase();
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("Input a word");
			String word = scanner.next();
			if (word.equalsIgnoreCase("EXIT")) {
				System.out.println("so long...");
				break;
			}
			if (isIdemPotant(word, palyndromeMatcher)) {
				System.out.println(word + " is a palyndrome");
			}
		}
	}
	
}
