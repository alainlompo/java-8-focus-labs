package org.lompo.labs.java8.lambdas.pure.functional.patternmatching;

import java.util.function.Supplier;

public class IfElseHandlerImpl<T> implements IfElseHandler<T> {

	/**
	 * Lazy style alternative for classic if else.
	 */
	@Override
	public T ifElse(boolean b, Supplier<T> trueCase, Supplier<T> falseCase) {
		return b? trueCase.get(): falseCase.get();
	}

}
