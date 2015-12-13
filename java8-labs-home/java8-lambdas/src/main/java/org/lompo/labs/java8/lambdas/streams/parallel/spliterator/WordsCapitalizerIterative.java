package org.lompo.labs.java8.lambdas.streams.parallel.spliterator;

import java.util.Scanner;

public class WordsCapitalizerIterative {
	
	
	
	public static String capitalizeWordsIteratively (String s) {
		
		StringBuilder resultBuilder = new StringBuilder();
		
		CharacterState previousCharState = CharacterState.UNSET;
		CharacterState currentCharState = CharacterState.UNSET;
		
		for (char c: s.toCharArray()) {
			previousCharState = currentCharState;
			if (Character.isWhitespace(c)) {
				resultBuilder.append(c);
				
				currentCharState = CharacterState.WHITE;
			} else {
				if (previousCharState == CharacterState.WHITE || previousCharState == CharacterState.UNSET) {
					resultBuilder.append(Character.toUpperCase(c));
				} else {
					resultBuilder.append(c);					
				}
				
				currentCharState = CharacterState.NOT_WHITE;
			}
		}
		
		return resultBuilder.toString();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String sentence = sc.nextLine();
		System.out.println("Inputed line is :" + sentence);
		String transformed = capitalizeWordsIteratively(sentence);
		System.out.println("Transformed sentence:");
		System.out.println("---------------------");
		System.out.println(transformed);
		
	}

}
