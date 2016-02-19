package org.lompo.labs.java8.lambdas.pure.functional.patternmatching;

import java.util.function.Supplier;

public interface IfElseHandler<T> {
	
	 T ifElse(boolean b, Supplier<T> trueCase, Supplier<T> falseCase);

}
