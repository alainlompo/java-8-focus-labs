package org.lompo.labs.java8.lambdas.refactoring;

/**
 * We are simulating a code quality metrics framework
 * This interface will be implemented by all rules
 * @author LOMPO
 *
 */
public interface RuleChecker {
	
	public RuleCheckingResult validateRuleAgainst(String codeToCheck);
}
