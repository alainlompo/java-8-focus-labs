package org.lompo.labs.java8.lambdas.pure.functional.lazy;

public class CLinkedListDemo {
	public static void main(String[] args) {
		CList<Integer> l = new CLinkedList(5, new CLinkedList<>(10, new CEmpty<>()));
	}

}
