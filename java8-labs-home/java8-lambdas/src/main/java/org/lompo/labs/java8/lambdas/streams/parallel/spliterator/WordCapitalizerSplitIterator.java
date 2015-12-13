package org.lompo.labs.java8.lambdas.streams.parallel.spliterator;

import java.util.Spliterator;
import java.util.function.Consumer;

public class WordCapitalizerSplitIterator implements Spliterator<Character> {

	private static final int MINIMUM_SIZE = 10;
	private final String string;
	private int currentCharIndex = 0;
	
	public WordCapitalizerSplitIterator(String string) {
		this.string = string;
	}
	
	@Override
	public int characteristics() {
		
		return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE ;
	}

	@Override
	public long estimateSize() {
		
		return string.length() - currentCharIndex;
	}

	@Override
	public boolean tryAdvance(Consumer<? super Character> action) {
		action.accept(string.charAt(currentCharIndex++));
		return currentCharIndex < string.length();
	}

	@Override
	public Spliterator<Character> trySplit() {
		int currentSize = string.length() - currentCharIndex;
		if (currentSize < MINIMUM_SIZE) {
			return null;
		}
		
		for (int splitPos = currentSize/2 + currentCharIndex; 
				splitPos < string.length();
				splitPos++
				) {
			if (Character.isWhitespace(string.charAt(splitPos))) {
				Spliterator<Character> spliterator = 
						new WordCapitalizerSplitIterator(string.substring(currentCharIndex, splitPos));
				currentCharIndex = splitPos;
				return spliterator;
			}
		}
		return null;
	}

}
