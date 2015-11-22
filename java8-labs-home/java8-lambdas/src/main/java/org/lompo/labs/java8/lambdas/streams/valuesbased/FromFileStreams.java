package org.lompo.labs.java8.lambdas.streams.valuesbased;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * This example illustrates how to manipulate streams generated from files.
 * @author LOMPO
 *
 */
public class FromFileStreams {
	
	public static void main(String[] args) throws IOException {
		long numberOfWords = 0;
		Stream<String> lines =
				Files.lines(Paths.get("C:\\Hypernovae\\Life\\Saint - Cyro - Apostle to the Sloves Apostolic Statement.txt"),
						Charset.defaultCharset());
		numberOfWords = lines.flatMap(
				line -> Arrays.stream(line.split(" "))
				)
				.distinct()
				.count();
		System.out.println("The text has " + numberOfWords + " unique words...");
		
		
	}

}
