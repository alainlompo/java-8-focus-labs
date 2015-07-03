package org.lompo.labs.java8.lambdas.methodreference;

/**
 * We will use this functional interface in demonstrating car's feature comparison
 * using on one hand a lambda such as (c1, c2) -> c1.numberOfGears.compareTo(c2.numberOfGears)
 * and on the other hand a method reference using the Car.compareByGear method.
 * @author LOMPO
 *
 * @param <T>
 */
@FunctionalInterface
public interface FeatureComparator<T> {
	
	public int compare(T t1, T t2);

}
