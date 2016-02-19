package org.lompo.labs.java8.lambdas.pure.functional.lazy;

public class CEmpty<T> implements CList<T> {

	@Override
	public T head() {
		throw new UnsupportedOperationException();
	}

	@Override
	public CList<T> tail() {
		throw new UnsupportedOperationException();
	}

}
