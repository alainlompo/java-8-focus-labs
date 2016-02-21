package org.lompo.labs.java8.lambdas.refactoring.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Volcano<T> {

	protected T keyParameter;
	protected final List<VolcanicActivityObserver<T>> observers = new ArrayList<VolcanicActivityObserver<T>>();
	public abstract String getActivityReport();
	
	public T getKeyParameter() {
		return keyParameter;
	}
	public void setKeyParameter(T keyParameter) {
		this.keyParameter = keyParameter;
	}
	
	public List<VolcanicActivityObserver<T>> getObservers() {
		return observers;
	}

	public abstract void registerObserver(VolcanicActivityObserver<T> observer);
	public abstract void notifyObservers();
	
}
