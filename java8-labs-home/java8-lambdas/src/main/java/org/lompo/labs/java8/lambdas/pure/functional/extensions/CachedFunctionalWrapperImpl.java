package org.lompo.labs.java8.lambdas.pure.functional.extensions;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Illustative example of a cache wrapper
 * Though we use a HashMap to illustrate the concepts
 * HashMap  is not synchronized
 * @see the javadoc for HashMap
 * One of the great benefits of the functional style is that we don't have to worry
 * that the call to another functional style method is synchronized since there  is no
 * shared mutable state at all
 * @author LOMPO
 *
 * @param <I>
 * @param <R>
 */
public class CachedFunctionalWrapperImpl<I, R> implements CachedFunctionalWrapper<I, R> {

	private Function<I, R> function;
	protected final Map<I, R> cache = new HashMap<I,R>();
	
	@Override
	public void register(Function<I, R> function) {
		this.function = function;
		
	}

	@Override
	public R applyWithCache(I i) {
		R result = cache.get(i);
		if (result == null) {
			result = function.apply(i);
			cache.put(i, result);
		}
		return result;
	}

}
