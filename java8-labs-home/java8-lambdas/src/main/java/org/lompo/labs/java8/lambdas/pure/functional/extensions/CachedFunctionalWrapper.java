package org.lompo.labs.java8.lambdas.pure.functional.extensions;

import java.util.function.Function;

/**
 * The idea here is to have some kind of cache.
 * Since functional style implies side effect free as well as immutable structures
 * we don't need to re-compute costly operations each time they are requested
 * and instead we can get them back from a cache. The referential transparency
 * guaranties that each time the function is called with the exact same parameters
 * it produces the same result
 * @author LOMPO
 *
 */
public interface CachedFunctionalWrapper<I,R> {
	
	void register(Function<I,R> function);
	R applyWithCache(I i);
	

}
