package org.lompo.labs.java8.lambdas;

public class XOrLogicalCompositePredicate<T> extends LogicalCompositePredicate<T> {

	@Override
	/**
	 * For readability sake such expressions as this.getAndPredicate().test(t) == false
	 * are left as is and not turned into something like: !this.getAndPredicate().test(t)
	 */
	public boolean apply(T t) {
		boolean result = false;
		result = (this.getPredicate() != null) && (this.getPredicate().test(t));
		if (null != this.getAndPredicate()) {
			
			if ( ((result == true) & (this.getAndPredicate().test(t) == false)) 
                 ||
                 ((result == false) & (this.getAndPredicate().test(t) == true))
					){
				result = true;
			} else {
				result = false;
			}
		}
		return result;
	}
}