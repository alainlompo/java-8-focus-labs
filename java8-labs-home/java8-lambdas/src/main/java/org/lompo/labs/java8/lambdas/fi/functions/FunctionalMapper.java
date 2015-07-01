package org.lompo.labs.java8.lambdas.fi.functions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionalMapper<T,R> {
	
	public List<R> map(List<T> list, Function<T,R> function) {
		List<R> result = new ArrayList<>();
		for (T t: list) {
			result.add(function.apply(t));
		}
		
		return result;
	}

}
