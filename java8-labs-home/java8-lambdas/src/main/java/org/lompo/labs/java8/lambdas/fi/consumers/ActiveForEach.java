package org.lompo.labs.java8.lambdas.fi.consumers;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ActiveForEach<T> {
	
	private static int accumulator;
	
	public void forEach(List<T> list, Consumer<T> consumer) {
		for (T t: list) {
			consumer.accept(t);
		}
		
	}
	
	public static void main(String[] args) {
		
		ActiveForEach<Integer> intForEach = new ActiveForEach<Integer>();
		intForEach.forEach(Arrays.asList(1,2,3,4,5,6,7,8,9,10), (Integer i) -> {
			System.out.println(i);
			accumulator += i;
			} );
		System.out.println("The sum of all these values is :" + accumulator);
	}

}
