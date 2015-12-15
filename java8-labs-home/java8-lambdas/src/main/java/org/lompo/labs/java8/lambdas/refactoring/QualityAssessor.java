package org.lompo.labs.java8.lambdas.refactoring;

import java.util.List;
import java.util.function.Supplier;

/**
 * This class is responsible for applying a set of rules to a code
 * depending on the rule checking level it was set at.
 * @author LOMPO
 *
 */
public class QualityAssessor {
	
	private final RuleCheckingLevel ruleCheckingLevel;
	private List<RuleChecker> currentRules;
	
	public QualityAssessor(RuleCheckingLevel ruleCheckingLevel) {
		this.ruleCheckingLevel = ruleCheckingLevel;
	}

	public RuleCheckingLevel getRuleCheckingLevel() {
		return ruleCheckingLevel;
	}
	
	public boolean isApplicable(RuleCheckingLevel level) {
		return (ruleCheckingLevel.getOrder() >= level.getOrder());
	}

	public List<RuleChecker> getCurrentRules() {
		return currentRules;
	}

	public void setCurrentRules(List<RuleChecker> currentRules) {
		this.currentRules = currentRules;
	}
	
	
	/**
	 * The lambda based approach is better.
	 * @param level
	 * @param codeToCheck
	 * @param ruleSupplier
	 * @return
	 */
	public RuleCheckingResult checkRuleFor(RuleCheckingLevel level, String codeToCheck, Supplier<RuleChecker> ruleSupplier) {
		if (this.isApplicable(level)) {
			return checkRuleFor(codeToCheck, ruleSupplier.get());
		} else {
			return RuleCheckingResult.FAILED;
		}
	}
	
	public RuleCheckingResult checkRuleFor(RuleCheckingLevel level, String codeToCheck, RuleChecker rule) {
		if (ruleCheckingLevel.getOrder() >= level.getOrder()) {
			return rule.validateRuleAgainst(codeToCheck);
		} else {
			return RuleCheckingResult.FAILED;
		}
		
	}
	
	public RuleCheckingResult checkRuleFor(String codeToCheck, RuleChecker rule) {
		return rule.validateRuleAgainst(codeToCheck);
	}
	
	public RuleCheckingResult checkRulesFor(String codeToCheck) {
		if (currentRules == null || codeToCheck == null) {
			return RuleCheckingResult.FAILED;
		}
		
		RuleCheckingResult result = RuleCheckingResult.PASSED;
		for (RuleChecker rule: currentRules) {
			
			if (rule.validateRuleAgainst(codeToCheck) == RuleCheckingResult.FAILED) {
				result = RuleCheckingResult.FAILED;
			}
		}
		
		return result;
	}
	
	

}
