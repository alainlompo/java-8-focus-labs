package org.lompo.labs.java8.lambdas.refactoring;

public class ShortSentenceRule implements RuleChecker {
	
	public RuleCheckingResult validateRuleAgainst(String codeToCheck) {
		return (codeToCheck != null && codeToCheck.length() <= RuleUtils.SHORT_SENTENCE_LENGTH)?RuleCheckingResult.PASSED:
			RuleCheckingResult.FAILED;
		
	}

}
