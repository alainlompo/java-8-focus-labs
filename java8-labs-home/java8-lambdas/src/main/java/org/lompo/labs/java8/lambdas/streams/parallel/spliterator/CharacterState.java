package org.lompo.labs.java8.lambdas.streams.parallel.spliterator;

public enum CharacterState {
	WHITE ("White space"),
	NOT_WHITE ("Alphabet, digit or other non white space"),
	UNSET("Undefined state");
	
	private final String description;
	public String getDescription() {
		return description;
	}
	
	private  CharacterState(String description) {
		this.description = description;
	}
	
	public String toString() {
		return description;
	}
}
