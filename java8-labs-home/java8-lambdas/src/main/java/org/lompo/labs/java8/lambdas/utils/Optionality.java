package org.lompo.labs.java8.lambdas.utils;

import java.util.Optional;

public class Optionality {
	private Optionality() {
		
	}
	
	public static Optional<Integer> parseInt(String s) {
		try {
			return Optional.of(Integer.parseInt(s));
			
		} catch (NumberFormatException nFE) {
			// A non integer text value would trigger a number format exception, therefore we should intercept it
			// And send an Optional.empty() result
			return Optional.empty();
		}
	}
	
	public static Optional<Integer> decode(String s) {
		try {
			return Optional.of(Integer.decode(s));
			
		} catch (NumberFormatException nFE) {
			return Optional.empty();
		}
	}
	
	// Sample illustration of the Optional.ifPresent method
	public static void displayValueWithAMessage(String message, Optional<Integer> valueContainer, java.io.OutputStream outStream) {
		
		if (valueContainer == null) {
			return;
		}
		
		OutputStreamWriter streamWriter = new OutputStreamWriter(outStream);
		BufferedWriter bufferedWriter  = new BufferedWriter(streamWriter);
		valueContainer.ifPresent(i -> {
			try {
				bufferedWriter.write(String.format(message + " %1$d", i));
				bufferedWriter.flush();
			} catch (IOException ex) {
				
			}
		});
	}
}
