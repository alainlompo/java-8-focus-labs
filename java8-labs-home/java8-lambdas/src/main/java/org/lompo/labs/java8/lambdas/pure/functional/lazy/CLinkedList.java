package org.lompo.labs.java8.lambdas.pure.functional.lazy;

public class CLinkedList<T> implements CList<T> {

	private final T head;
	private final CList<T> tail;
	
	public CLinkedList(T head, CList<T> tail) {
		this.head = head;
		this.tail = tail;
	}
	
	@Override
	public T head() {
		return head;
	}

	@Override
	public CList<T> tail() {
		return tail;
	}
	
	public boolean isEmpty() {
		return false;
	}

}
