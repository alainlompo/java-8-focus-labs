package org.lompo.labs.java8.lambdas.pure.functional.extensions.combinators;

import java.util.function.Function;

public class CombinatorsDemo {
	public static void main(String[] args) {
		Function<Integer, Integer> f = x -> 2*x;
		Function<Integer, Integer> fPower3 = CombinatorsUtils.functionPower(3, f);
		System.out.println(String.format("f(f(f(4))) = %d", fPower3.apply(4)));
	}

}
