package org.lompo.labs.java8.lambdas.pure.functional.extensions.combinators;

import java.util.function.Function;

public class CombinatorsUtils {
	
	static <X,Y,Z> Function<X,Z> compose(Function<Y,Z> g, Function<X,Y> f) {
		return x -> g.apply(f.apply(x));
	}
	
	
	/**
	 * Similar to mathematical power function but applied to composition
	 * @param n
	 * @param f
	 * @return
	 */
	static <A> Function<A,A> functionPower (int n, Function<A,A> f) {
		return n== 0?
				x -> x
				:
				compose(f, functionPower(n-1, f));
	}

}
