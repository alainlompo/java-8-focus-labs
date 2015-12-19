package org.lompo.labs.java8.lambdas.refactoring.designpatterns.observer;

import java.util.function.Consumer;

public interface ConsumableObserver<T> extends Consumer<T>  {
	public void notify(T usefullEventInfo);

}
