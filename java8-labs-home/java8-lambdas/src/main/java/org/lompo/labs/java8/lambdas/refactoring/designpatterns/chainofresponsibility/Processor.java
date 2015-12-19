package org.lompo.labs.java8.lambdas.refactoring.designpatterns.chainofresponsibility;

public abstract class Processor<T> {
	protected Processor<T> successor;
	public void setSuccessor(Processor<T> successor) {
		this.successor = successor;
	}
	
	public T process(T input) {
		T taskExecutionResult = executeTask(input);
		if (successor != null) {
			return successor.process(taskExecutionResult);
		} else {
			return taskExecutionResult;
		}
		
	}
	
	abstract protected T  executeTask(T input);

}
