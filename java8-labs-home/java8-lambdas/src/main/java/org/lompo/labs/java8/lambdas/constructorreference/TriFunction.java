package org.lompo.labs.java8.lambdas.constructorreference;

/**
 * On the same pattern as Function and BiFunction we can creae a tri-function
 * that works exactly the same way
 * @author LOMPO
 *
 * @param <X>
 * @param <Y>
 * @param <Z>
 * @param <R>
 */
public interface TriFunction<X,Y,Z,R> {
	R apply(X x,Y y,Z z);
}
