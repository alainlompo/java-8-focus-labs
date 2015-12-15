package org.lompo.labs.java8.lambdas.refactoring;

/**
 * There are four rule checking levels
 * Depending on the chosen level, a certain number of rules will be run against the code
 * The highest level is GURU: all the rules apply at that level
 * @author LOMPO
 *
 */
public enum RuleCheckingLevel {
	
	NOVICE(1),
	MASTER(2),
	EXPERT(3),
	GURU(4);
	
	private final int order;
	public int getOrder() {
		return order;
	}
	
	private RuleCheckingLevel(int order) {
		this.order = order;
	}

}
