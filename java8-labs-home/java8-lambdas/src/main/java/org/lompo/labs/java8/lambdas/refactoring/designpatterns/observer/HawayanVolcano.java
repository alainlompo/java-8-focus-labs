package org.lompo.labs.java8.lambdas.refactoring.designpatterns.observer;

public class HawayanVolcano extends Volcano<Integer> {

	@Override
	public String getActivityReport() {
		// TODO Auto-generated method stub
		return "Produces a very high column of smoke...Currnently the height is " + this.getKeyParameter() + " meters";
	}
	
	public HawayanVolcano() {
		super();
		this.keyParameter = 120;
	}

	@Override
	public void registerObserver(VolcanicActivityObserver<Integer> observer) {
		this.observers.add(observer);
		
	}

	/**
	 * Using lambda and the forEach method
	 */
	@Override
	public void notifyObservers() {
		
		this.observers.forEach(observer -> observer.notify(this));
	}

}
