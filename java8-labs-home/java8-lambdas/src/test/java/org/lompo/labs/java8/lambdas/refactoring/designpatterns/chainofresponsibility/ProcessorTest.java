package org.lompo.labs.java8.lambdas.refactoring.designpatterns.chainofresponsibility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ProcessorTest {
	
	@Test
	public void process_with_null_input_Test() {
		Processor<String> processor = new HtmlBTagProcessor();
		String result = processor.process(null);
		assertNotNull(result);
		// TODO: we would rather have this result processed as though
		// There was no input at all so this unit test unveiled the
		// need for evolving the method
		assertEquals("<B>null</B>", result);
	}
	
	@Test
	public void process_with_null_input_and_not_null_successor_Test() {
		Processor<String> processor = new HtmlBTagProcessor();
		Processor<String> successor = new HtmlUTagProcessor();
		processor.setSuccessor(successor);
		String result = processor.process(null);
		assertNotNull(result);
		// TODO: certainly not the prefered behaviour for a null input
		// See comments in the above method (process_with_null_input_Test)
		assertEquals("<U><B>null</B></U>", result);
	}
	
	@Test
	public void process_with_input_not_null_and_successor_null_Test() {
		Processor<String> processor = new HtmlBTagProcessor();
		String result = processor.process("Hello world!");
		assertNotNull(result);
		assertEquals("<B>Hello world!</B>", result);
		
	}
	
	@Test
	public void process_with_input_not_null_and_successor_not_null_Test() {
		Processor<String> processor = new HtmlBTagProcessor();
		Processor<String> successor = new HtmlUTagProcessor();
		processor.setSuccessor(successor);
		String result = processor.process("Hello world!");
		assertNotNull(result);
		assertEquals("<U><B>Hello world!</B></U>", result);
	}

}


