package org.lompo.labs.java8.lambdas.constructorreference;

/**
 * Using this functional interface to demonstrate constructor reference
 * @author LOMPO
 *
 * @param <T>
 */
@FunctionalInterface
public interface FruitFactory<T> {
	
	T get();

}
