package org.lompo.labs.java8.lambdas.streams.filtering;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.function.Function;

/**
 * This illustrates mapping abilities of java 8
 * We take a bunch of words and we map each one of them
 * to a WordInfo object computing the word's weight in the same time
 * 
 * We also use the forEach terminal operation to print the results.
 * @author LOMPO
 *
 */
public class HeavyWords {
	
	public static final Function<String, WordInfo> wIFunction = (w) -> new WordInfo(w);

	public static List<WordInfo> toWordInfos(String sentence) {
		
		String[] words = sentence.split("\\s");
		assert null!= words;
		assert words.length > 0;
		
		List<String> wordsList = java.util.Arrays.asList(words);
		List<WordInfo> result =
				wordsList
				.stream()
				.map(wIFunction)
				.collect(java.util.stream.Collectors.toList());
		
		
		return result;
				
	}
	
	public static void display (List<WordInfo> infos) {
		infos
		.stream()
		.filter(wI -> wI.getWeight() > 10)
		.forEach(System.out::println);
	}
	
	public static void main(String[] args) throws UnknownHostException {
		
		//InetAddress iA = InetAddress.getByName("104.83.229.110");
		
		display(
				toWordInfos("People who live in glass houses should not throw stones.")
				);
	}
}
