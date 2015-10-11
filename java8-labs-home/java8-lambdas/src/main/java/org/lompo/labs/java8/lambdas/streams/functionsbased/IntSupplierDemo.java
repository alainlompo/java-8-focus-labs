package org.lompo.labs.java8.lambdas.streams.functionsbased;

import java.util.Random;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;


public class IntSupplierDemo {
	private static final Random r = new Random();
	
	/**
	 * The other approaches used for IntStream.generate are side effect free
	 * while using an anonymous class, we can modify the state through object fields
	 * @return
	 */
	public static IntStream getRandomIntStream() {
		IntStream result = IntStream.generate(new IntSupplier() {

			@Override
			public int getAsInt() {
				double d = r.nextDouble() * 1000.0D;
				int result = (int)Math.floor(d);
				return result;
			}
			
		});
		return result;
	}
	
	public static void main(String[] args) {
		IntStream iS = getRandomIntStream();
		
		iS.limit(20)
		.forEach(System.out::println);
	}

}
