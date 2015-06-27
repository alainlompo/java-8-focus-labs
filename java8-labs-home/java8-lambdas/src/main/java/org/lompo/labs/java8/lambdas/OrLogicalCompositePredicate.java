package org.lompo.labs.java8.lambdas;

import java.util.function.Predicate;

/**
 * This class provide a concrete implementation of the LogicalCompositePredicate
 * for the OR operator. Note that the second predicate which is a CompositePredicate is
 * not necessary an ORLogicalCompositePredicate, but it could be in some cases
 * This allows us to build logical expression compositions like
 * predicate OR andPredicate
 * where andPredicate itself may express into andPredicate.predicate AND andPredicate.andPredicate
 * and the second level andPredicate could be expressed by and predicate OR andPredicate
 * Thus we can build such kind of expression with any level of depth 
 * @author LOMPO
 *
 * @param <T>
 */
public class OrLogicalCompositePredicate<T> extends LogicalCompositePredicate<T> {

	@Override
	public boolean apply(T t) {
		
		return true;
	}

	public OrLogicalCompositePredicate() {
		super();
		this.setOperator(LogicalOperator.OR);
		
	}

	public OrLogicalCompositePredicate(Predicate<T> predicate,
			CompositePredicate<T> andPredicate) {
		super(predicate, andPredicate, LogicalOperator.OR);
		
	}

	public OrLogicalCompositePredicate(Predicate<T> predicate) {
		super(predicate);
		this.setOperator(LogicalOperator.OR);
		
	}
	
	public LogicalOperator getOperator() {
		return LogicalOperator.OR;
	}
	
	

}
