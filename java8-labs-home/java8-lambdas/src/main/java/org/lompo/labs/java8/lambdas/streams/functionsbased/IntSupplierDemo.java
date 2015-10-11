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
	
	
	public static void  customSuiteStream(int limit) {
		IntSupplier supplier = new IntSupplier() {
			private int prev = 0;
			private int cur = 1;
			private int sign = -1;
			public int getAsInt() {
				int oldPrev = this.prev;
				int nextVal = this.cur + sign * this.prev;
				sign *= -1;
				this.prev = this.cur;
				this.cur = nextVal;
				return oldPrev;
			}
			
		};
		
		IntStream.generate(supplier).limit(limit).forEach(System.out::println);
		
		
		
	}
	
	public static void main(String[] args) {
		IntStream iS = getRandomIntStream();
		
		iS.limit(20)
		.forEach(System.out::println);
		
		System.out.println("Now a function F(n) = F(n-1) + (-1^n)*F(n-2)... 20 first images...");
		customSuiteStream(100);
	}

}
