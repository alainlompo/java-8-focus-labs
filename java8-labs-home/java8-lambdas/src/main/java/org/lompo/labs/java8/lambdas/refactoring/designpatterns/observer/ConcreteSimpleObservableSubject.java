package org.lompo.labs.java8.lambdas.refactoring.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSimpleObservableSubject<T> implements SimpleObservableSubject<T> {

	private final List<SimpleObserver<T>> observers = new ArrayList<SimpleObserver<T>>();
	@Override
	public void registerObserver(SimpleObserver<T> observer) {
		observers.add(observer);
		
	}

	@Override
	public void notifyObservers(T t) {
		observers.forEach(observer -> observer.notify(t));
		
	}

}
