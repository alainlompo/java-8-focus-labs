package org.lompo.labs.java8.lambdas.refactoring.designpatterns.observer;

public class ObserverPatternWithLambdaSimpleDemo {
	
	public static void main(String[] args) {
		SimpleObservableSubject<String> concreteSubject = new ConcreteSimpleObservableSubject<String>();

		// We can use lambda on the functional interface that defines our observer.
		concreteSubject.registerObserver(t -> {System.out.println("The lenght of '" + t + "' is: " + t.length());});
		concreteSubject.notifyObservers("Hello world");

	}
	
}
