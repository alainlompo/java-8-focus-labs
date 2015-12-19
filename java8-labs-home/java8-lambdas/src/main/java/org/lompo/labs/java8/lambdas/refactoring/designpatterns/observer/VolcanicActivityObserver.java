package org.lompo.labs.java8.lambdas.refactoring.designpatterns.observer;

public interface VolcanicActivityObserver<T> {
	
	public void notify(Volcano<T> volcano);

}
