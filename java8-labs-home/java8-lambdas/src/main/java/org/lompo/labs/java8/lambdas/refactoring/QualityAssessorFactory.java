package org.lompo.labs.java8.lambdas.refactoring;

public class QualityAssessorFactory {
	
	public QualityAssessor getQualityAssessorAtLevel(RuleCheckingLevel level) {
		return new QualityAssessor(level);
	}
	
	public QualityAssessor getDefaultLevelQualityAssessor() {
		return new QualityAssessor(RuleCheckingLevel.MASTER);
	}

}
