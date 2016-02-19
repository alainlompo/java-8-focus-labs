package org.lompo.labs.java8.lambdas.pure.functional.lazy;

public interface CList<T> {
	T head();
	CList<T> tail();
	
	default boolean isEmpty() {
		return true;
	}

}
