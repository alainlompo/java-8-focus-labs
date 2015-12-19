package org.lompo.labs.java8.lambdas.refactoring.designpatterns.observer;

public interface SimpleObservableSubject<T> {
	
	public void registerObserver(SimpleObserver<T> observer);
	public void notifyObservers(T t);

}
