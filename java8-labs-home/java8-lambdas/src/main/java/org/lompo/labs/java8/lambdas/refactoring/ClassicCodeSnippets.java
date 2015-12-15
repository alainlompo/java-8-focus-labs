package org.lompo.labs.java8.lambdas.refactoring;

public class ClassicCodeSnippets {
	
	public void doClassicClientCodeDemo() {
		
		String codeToCheck = "for (DataSet set: dataSources) {....}";
		// TODO: get an instance of the factory
		QualityAssessorFactory qualityFactory = new QualityAssessorFactory();
		
		// TODO: Obtain the QualityAssessor from a factory
		QualityAssessor assessor = qualityFactory.getDefaultLevelQualityAssessor();
		
		// TODO: Now we want to apply the bunch of rules that corresponds to the
		// TODO: configuration level of the quality assessor
		
		if (assessor.isApplicable(RuleCheckingLevel.GURU)) {
			assessor.checkRuleFor(codeToCheck, new GuruLevelRule());
		}
		
		// TODO: what we just did is not a good approach because
		// TODO: 1. The state of the quality assessor (what bunch of rules config it supports) is exposed
		// TODO:    via the isApplicable method
		// TODO: 2. Every time we want to assess a rule we have to query the state of the quality assessor (code cluttering)
		// TODO:    makes it less readable
		
		// TODO: Instead use a method from the QualityAssesor that does it internally
		
		assessor.checkRuleFor(RuleCheckingLevel.GURU, codeToCheck, new GuruLevelRule());
		
		// TODO: it's a better approach: cleaner and more readable (not cluttered) code
		// TODO: yet the best approach would be to use a lambda with the method overload 
		// TODO: that uses a Supplier<T> parameter to provide the rule
		
		assessor.checkRuleFor(RuleCheckingLevel.GURU, codeToCheck, () -> new RuleChecker() {

			@Override
			public RuleCheckingResult validateRuleAgainst(String codeToCheck) {
				// TODO: implements the rule's logic here
				return null;
			}
			
		} );
		
	}

}
