package org.lompo.labs.java8.lambdas.refactoring.designpatterns.chainofresponsibility;

public class HtmlUTagProcessor extends Processor<String>{

	@Override
	protected String executeTask(String input) {
		return "<U>" + input +"</U>";
	}

}
