package org.lompo.labs.java8.lambdas.refactoring.designpatterns.chainofresponsibility;

public class HtmlProcessingDemo {
	public static void main(String[] args) {
		Processor<String> p1 = new HtmlUTagProcessor();
		Processor<String> p2 = new HtmlBTagProcessor();
		p1.setSuccessor(p2);
		
		String processingResult = p1.process("<h3><center>Hello World!</center></h3>");
		System.out.println("The processing resulted in: " + processingResult);
	}

}
