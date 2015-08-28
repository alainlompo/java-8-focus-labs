package org.lompo.labs.java8.lambdas.streams.filtering;

public class WordInfo {
	
	private String word;
	private int weight;
	
	public WordInfo(String word, int weight) {
		this.word = word;
		this.weight = weight;
	}
	
	public WordInfo() {
		
	}
	
	public WordInfo(String word) {
		this.word = word;
		this.weight = getWeightFor(word);
	}
	
	public static int getWeightFor(String word) {
		int result = 0;
		for (int i = 0; i < word.length(); i++) {
			result += word.charAt(i);
		}
		
		return result;
		
	}
	
	public String toString() {
		return "Word: " + word + ", weight: " + weight;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	
}
