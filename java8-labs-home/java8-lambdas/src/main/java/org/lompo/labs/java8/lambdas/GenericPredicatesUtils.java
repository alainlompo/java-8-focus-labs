package org.lompo.labs.java8.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class GenericPredicatesUtils<T> {

	public GenericPredicatesUtils() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public  boolean  isNotNull (T t) {
		return t != null;
	}
	
	public boolean isNull(T t) {
		return !isNotNull(t);
	}
	
	public <Q> boolean  isInstanceOf (T t, Q q) {
		
		Class tClass = t.getClass();
		return tClass.isInstance(q);
	}
	
	public static <T> List<T> filter(List<T> elements, Predicate<T> assessor) {
		List<T> result = new ArrayList<T>();
		for (T element: elements) {
			if (assessor.test(element)) {
				result.add(element);
			}
		}
		return result;
	}
	

}
