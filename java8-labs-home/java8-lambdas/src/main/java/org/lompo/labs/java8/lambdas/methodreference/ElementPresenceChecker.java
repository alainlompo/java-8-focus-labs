package org.lompo.labs.java8.lambdas.methodreference;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

/**
 * In this illustration, we use a method reference from an instance of this class
 * to compare with the lambda expression. Using the BiPredicate type of predicate
 * we can assess weither or not a list contains a given item
 * 
 * @author LOMPO
 *
 * @param <T>
 */
public class ElementPresenceChecker<T> {
	
	public  final BiPredicate<List<T>, T> CHECKER = (list,item) -> list.contains(item);
	
	public boolean doesListContains(List<T> list, T item, BiPredicate<List<T>, T> checker) {
		return checker.test(list, item);
	}
	
	public boolean doesListContains(List<T> list, T item) {
		return list.contains(item);
	}
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
		ElementPresenceChecker<Integer> instance = new ElementPresenceChecker<>();
		boolean test1 = instance.doesListContains(numbers, 7, instance.CHECKER);
		boolean test2 = instance.doesListContains(numbers, 7, instance::doesListContains );
		
		assert test1;
		assert test2;
		
		System.out.println("the results are the same....");
		
		// TODO: write a method reference from a  class that is equivalent to the lambda
		// expression instead of using an instance method reference
	}

}
