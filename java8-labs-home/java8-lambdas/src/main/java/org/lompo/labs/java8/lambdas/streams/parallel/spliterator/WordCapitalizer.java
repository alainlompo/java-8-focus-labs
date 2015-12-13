package org.lompo.labs.java8.lambdas.streams.parallel.spliterator;

public class WordCapitalizer {
	
	private final StringBuilder builder;
	private final CharacterState lastCharacterState;
	
	public WordCapitalizer(StringBuilder builder, CharacterState lastCharacterState) {
		this.builder = builder;
		this.lastCharacterState = lastCharacterState;
	}
	
	
	public StringBuilder getBuilder() {
		return builder;
	}
	
	public WordCapitalizer combine(WordCapitalizer wordCapitalizer) {
		StringBuilder newBuilder = new StringBuilder(builder.append(wordCapitalizer.builder.toString()));
		
		return new WordCapitalizer(newBuilder, wordCapitalizer.lastCharacterState);
		
	}
	
	public WordCapitalizer accumulate(Character c) {
		
		if (Character.isWhitespace(c)) {
			if (lastCharacterState == CharacterState.WHITE || lastCharacterState == CharacterState.UNSET)  {
				builder.append(c);
				return this;
			} else {
				return new WordCapitalizer(new StringBuilder(c + ""), CharacterState.WHITE );
			}
					
		} else {
			if (lastCharacterState == CharacterState.WHITE || lastCharacterState == CharacterState.UNSET)  {
				return new WordCapitalizer(new StringBuilder(Character.toUpperCase(c)), CharacterState.NOT_WHITE);
				
			} else {
				builder.append(c);
				return this;
				
			}
		}
	}

}
