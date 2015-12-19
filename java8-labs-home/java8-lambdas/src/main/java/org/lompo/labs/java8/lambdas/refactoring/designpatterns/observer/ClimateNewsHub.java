package org.lompo.labs.java8.lambdas.refactoring.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class ClimateNewsHub implements ObservableSubject<Integer> {

	private final List<ConsumableObserver<Integer>> observers = new ArrayList<ConsumableObserver<Integer>>();
	@Override
	public void registerObserver(ConsumableObserver<Integer> observer) {
		observers.add(observer);
		
	}

	@Override
	public void notifiyObservers(Integer usefullEventInfo) {
		this.observers.forEach(observer -> observer.notify(usefullEventInfo));
		
	}

}
