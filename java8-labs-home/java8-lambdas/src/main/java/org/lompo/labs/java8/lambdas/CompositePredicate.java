package org.lompo.labs.java8.lambdas;

import java.util.function.Predicate;

/**
 * This class encapsulates a predicate and an instance of itself
 * This way we predicate test is true only if it is true all the way to the last predicate
 * in the chained list of predicates
 * This is close to the Composite pattern with a small difference of implementation
 * but the concept being the same.
 * A logical operator (default is an AND) will be applied between predicate and andPredicate
 * But to reach andPredicate result a logical operator shall be applied between andPredicate.predicate
 * and andPredicate.andPredicate and so on.....
 * @author LOMPO
 *
 * @param <T>
 */
public class CompositePredicate<T> {
	
	
	private Predicate<T> predicate;
	private CompositePredicate<T> andPredicate;
	
	public CompositePredicate(Predicate<T> predicate, CompositePredicate<T> andPredicate) {
		this.predicate = predicate;
		this.andPredicate = andPredicate;
	}
	
	public CompositePredicate(Predicate<T> predicate) {
		this.predicate = predicate;
	}
	
	public CompositePredicate() {
		super();
	}

	public Predicate<T> getPredicate() {
		return predicate;
	}

	public void setPredicate(Predicate<T> predicate) {
		this.predicate = predicate;
	}

	public CompositePredicate<T> getAndPredicate() {
		return andPredicate;
	}

	public void setAndPredicate(CompositePredicate<T> andPredicate) {
		this.andPredicate = andPredicate;	
	}
	
	public boolean test(T t) {
		boolean result = false;
		result = (this.predicate != null) && (this.predicate.test(t));
		if (null != this.andPredicate) {
			result = (result) && (this.andPredicate.test(t))    ;
		}
		return result;
	}
	
	public static <U> CompositePredicate<U> getShell(Class<U> clazz) {
		return new CompositePredicate<U>();
		
	}
	
	public CompositePredicate<T> predicate(Predicate<T> pred) {
		this.predicate = pred;
		return this;
	}
	
	public CompositePredicate<T> and(CompositePredicate<T> cP) {
		this.andPredicate = cP;
		return this;
	}
	
	
	
}
