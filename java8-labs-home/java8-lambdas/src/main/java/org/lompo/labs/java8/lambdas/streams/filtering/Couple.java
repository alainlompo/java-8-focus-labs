package org.lompo.labs.java8.lambdas.streams.filtering;

public class Couple {
	private char letter;
	private int number;
	public Couple(char letter, int number) {
		super();
		this.letter = letter;
		this.number = number;
	}
	public char getLetter() {
		return letter;
	}
	public void setLetter(char letter) {
		this.letter = letter;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String toString() {
		return "(" + letter + "," + number + ")";
	}

}
