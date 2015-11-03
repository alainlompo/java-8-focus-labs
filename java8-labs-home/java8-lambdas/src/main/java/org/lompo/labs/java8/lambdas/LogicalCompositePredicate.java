package org.lompo.labs.java8.lambdas;

import java.util.function.Predicate;


/**
 * A composite predicate that implements logical operators
 * @author LOMPO
 *
 * @param <T>
 */
public abstract class LogicalCompositePredicate<T> extends CompositePredicate<T> {
	
	private LogicalOperator operator;

	public LogicalOperator getOperator() {
		return operator;
	}

	public void setOperator(LogicalOperator operator) {
		this.operator = operator;
	}

	public LogicalCompositePredicate() {
		super();
		
	}

	public LogicalCompositePredicate(Predicate<T> predicate,
			CompositePredicate<T> andPredicate) {
		super(predicate, andPredicate);
		
	}

	public LogicalCompositePredicate(Predicate<T> predicate) {
		super(predicate);
		
	}

	public LogicalCompositePredicate(Predicate<T> predicate,
			CompositePredicate<T> andPredicate, LogicalOperator operator) {
		super(predicate, andPredicate);
		this.operator = operator;
	}
	
	/**
	 * the logical operators AND and OR are considered the basic operators
	 * but in case any new operator is detected the apply method will
	 * trigger a custom behavior allowing this method to execute additional processing:
	 * this is behavior parameterization.
	 *
	 */
	public boolean test(T t) {
		if ((null != this.operator) && (LogicalOperator.AND == this.operator)) {
			return super.test(t);
		} else if ((null != this.operator) && (LogicalOperator.OR == this.operator)) {
			return applyOrOperator(t);
			
		}
		
		// Behavior parametrization pattern
		return apply(t);
	}
	
	/**
	 * This method applies the Or operator in a short - circuited fashion
	 * @param t
	 * @return
	 */
	public boolean applyOrOperator(T t) {
		
		boolean result = false;
		result = (this.getPredicate() != null) && (this.getPredicate().test(t));
		if (null != this.getAndPredicate()) {
			result = (result) || (this.getAndPredicate().test(t))    ;
		}
		return result;
		
	}
	
	
	public abstract boolean apply(T t);

}
