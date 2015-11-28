package org.lompo.labs.java8.lambdas.streams.grouping;

import java.util.List;
import java.util.function.Predicate;

public class TakeWhileConcept {
	public static <I> List<I> takeWhile(List<I> list, Predicate<I> p) {
		int a = 0;
		for (I item: list) {
			if (!p.test(item)) {
				return list.subList(0, a);
			}
			a++;
		}
		return list;
	}

}
