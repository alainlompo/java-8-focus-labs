package org.lompo.labs.java8.lambdas.refactoring.designpatterns.chainofresponsibility;

public class HtmlBTagProcessor extends Processor<String>{

	@Override
	protected String executeTask(String input) {
		return "<B>" + input + "</B>";
	}

}
