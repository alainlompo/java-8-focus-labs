package org.lompo.labs.java8.lambdas.pure.functional.patternmatching;

import java.util.function.Function;
import java.util.function.Supplier;

import org.lompo.labs.java8.lambdas.constructorreference.TriFunction;

public class PatternMatchingUtils {

	/**
	 * Based on the type of e, it will execute one of the three options
	 * - the binaryOpCase TriFunction which will access the properties of the operation
	 * - The numericCase function which applies on an integer value (in this case e is Numeric)
	 * - or the default case when we don't know if e is numeric or a BinaryOperation
	 * This is an illustration of pattern matching. Such languages as Scala are far more expressive
	 * than the current Java edition (1.8) regarding pattern matching
	 * @param e
	 * @param binaryOpCase
	 * @param numericCase
	 * @param defaultCase
	 * @return
	 */
	static <T> T patternMatchExpression(
				Expression e,
				TriFunction<String, Expression, Expression, T> binaryOpCase,
				Function<Integer, T> numericCase,
				Supplier<T> defaultCase	
			) {
		return 
				(e instanceof BinaryOperation)?
						binaryOpCase.apply(((BinaryOperation)e).getOpName(),
								((BinaryOperation)e).getLeft(),
								((BinaryOperation)e).getRight()
								)
						:
						(e instanceof Number)?
								numericCase.apply(((Number)e).intValue())
								:
								defaultCase.get();
						
	}
}
