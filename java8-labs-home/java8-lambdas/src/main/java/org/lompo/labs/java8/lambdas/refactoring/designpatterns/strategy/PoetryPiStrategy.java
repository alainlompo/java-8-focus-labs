package org.lompo.labs.java8.lambdas.refactoring.designpatterns.strategy;

import java.math.BigDecimal;

public class PoetryPiStrategy implements PiComputingStrategy {

	private static final String PI_POETRY = "Que j'aime a faire apprendre un nombre utile aux sages";
	@Override
	public BigDecimal execute() {
		
		StringBuilder piBuilder = new StringBuilder();
		
		int currentLenght = 0;
		boolean isFirstWord = true;
		for (int i = 0; i < PI_POETRY.length(); i++) {
			if (!Character.isWhitespace(PI_POETRY.charAt(i))) {
				currentLenght++;
				if (PI_POETRY.charAt(i) == '\'') {
					piBuilder.append("3.1");
					currentLenght = 0;
					isFirstWord = false;
				}
			} else {
				if (!isFirstWord) {
					piBuilder.append(currentLenght+"");
				}
				currentLenght = 0;
			}
			
		}
		
		return BigDecimal.valueOf(Double.valueOf(piBuilder.toString()));
	}
	
	public static void main(String[] args) {
		System.out.println((new PoetryPiStrategy()).execute().toString());
	}

}
