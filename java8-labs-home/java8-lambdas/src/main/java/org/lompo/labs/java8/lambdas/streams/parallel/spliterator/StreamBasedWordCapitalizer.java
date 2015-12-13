package org.lompo.labs.java8.lambdas.streams.parallel.spliterator;

import java.util.Scanner;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

public class StreamBasedWordCapitalizer {
	
	public static void doStreamBasedWordCapitalizerDemo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Input the sentence to capitalize....");
		
		String sentence= sc.nextLine();
		Stream<Character> stream = IntStream.range(0, sentence.length())
				.mapToObj(sentence::charAt);
		String transformed = capitalizeWords(stream.parallel());
		System.out.println("transformed version:");
		System.out.println("--------------------");
		System.out.println(transformed);
		
		System.out.println();
		System.out.println("Using spliterator...");
		String transformedII = capitalizeWordsWithSpliterator(sentence);
		System.out.println("New result:");
		System.out.println(transformedII);
	}
	
	
	public static String capitalizeWordsWithSpliterator(String sentence) {
		Spliterator<Character> spliterator = new WordCapitalizerSplitIterator(sentence);
		Stream<Character> stream = StreamSupport.stream(spliterator, true);
		return capitalizeWords(stream);
	}
	
	public static String capitalizeWords(Stream<Character> stream) {
		WordCapitalizer capitalizer = stream.reduce(new WordCapitalizer(new StringBuilder(), CharacterState.UNSET)
		, WordCapitalizer::accumulate
		, WordCapitalizer::combine
				);
		return capitalizer.getBuilder().toString();
				
	}
	
	public static void main(String[] args) {
		doStreamBasedWordCapitalizerDemo();
	}

}
