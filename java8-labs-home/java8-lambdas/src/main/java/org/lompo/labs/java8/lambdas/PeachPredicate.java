package org.lompo.labs.java8.lambdas;

/**
 * This is a predicate interface from which we will create a bunch of Predicate
 * assessing various conditions on the Peach objects
 * We will apply Behaviro parameterization using a pattern similar to the strategy design pattern
 * @author LOMPO
 *
 */
public interface PeachPredicate {
	boolean test(Peach peach);

}
