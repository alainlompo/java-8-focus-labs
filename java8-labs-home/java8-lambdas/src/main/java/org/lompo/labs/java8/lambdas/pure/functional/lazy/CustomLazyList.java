package org.lompo.labs.java8.lambdas.pure.functional.lazy;

import java.util.function.Supplier;

public class CustomLazyList<T> implements CList<T>{

	final T head;
	final Supplier<CList<T>> tail;
	
	/**
	 * 
	 * @param head
	 * @param tail
	 */
	public CustomLazyList(T head, Supplier<CList<T>> tail) {
		this.head = head;
		this.tail = tail;
	}
	@Override
	public T head() {
		return head;
	}

	/**
	 * Lazyness behaviour implemented using Supplier<T>.get method
	 */
	@Override
	public CList<T> tail() {
		return tail.get();
	}
	
	public boolean isEmpty() {
		return false;
	}

}
