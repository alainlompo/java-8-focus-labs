package org.lompo.labs.java8.lambdas.refactoring.designpatterns.observer;

public class VolcanoLavaHeightObserver implements VolcanicActivityObserver<Integer> {

	@Override
	public void notify(Volcano<Integer> volcano) {
		System.out.println("Here is the report about the volcano's lava's height: " + volcano.getActivityReport());
		
	}

}
