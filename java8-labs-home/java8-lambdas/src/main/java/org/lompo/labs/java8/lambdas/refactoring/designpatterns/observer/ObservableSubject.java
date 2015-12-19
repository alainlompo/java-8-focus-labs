package org.lompo.labs.java8.lambdas.refactoring.designpatterns.observer;

public interface ObservableSubject<T> {

	public void registerObserver(ConsumableObserver<T> observer);
	public void notifiyObservers(T usefullEventInfo);
	
}
