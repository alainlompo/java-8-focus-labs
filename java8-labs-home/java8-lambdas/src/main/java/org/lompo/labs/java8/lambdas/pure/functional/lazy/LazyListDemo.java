package org.lompo.labs.java8.lambdas.pure.functional.lazy;

public class LazyListDemo {
	public static CustomLazyList<Integer> from(int n)  {
		return new CustomLazyList<Integer>(n, () -> from (n+1));
	}

}
