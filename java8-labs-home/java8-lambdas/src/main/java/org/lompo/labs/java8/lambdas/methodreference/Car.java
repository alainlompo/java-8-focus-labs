package org.lompo.labs.java8.lambdas.methodreference;

public class Car {
	private int numberOfGears;
	private boolean hasAirConditioned;
	private boolean canFly;
	private boolean canDive;
	private int maximumSpeed;
	private int maximumAcceleration;
	
	
	public int getNumberOfGears() {
		return numberOfGears;
	}
	public void setNumberOfGears(int numberOfGears) {
		this.numberOfGears = numberOfGears;
	}
	public boolean isHasAirConditioned() {
		return hasAirConditioned;
	}
	public void setHasAirConditioned(boolean hasAirConditioned) {
		this.hasAirConditioned = hasAirConditioned;
	}
	public boolean isCanFly() {
		return canFly;
	}
	public void setCanFly(boolean canFly) {
		this.canFly = canFly;
	}
	public boolean isCanDive() {
		return canDive;
	}
	public void setCanDive(boolean canDive) {
		this.canDive = canDive;
	}
	public int getMaximumSpeed() {
		return maximumSpeed;
	}
	public void setMaximumSpeed(int maximumSpeed) {
		this.maximumSpeed = maximumSpeed;
	}
	public int getMaximumAcceleration() {
		return maximumAcceleration;
	}
	public void setMaximumAcceleration(int maximumAcceleration) {
		this.maximumAcceleration = maximumAcceleration;
	}
	
	public static int compareByGears(Car c1, Car c2) {
		return Integer.valueOf(c1.numberOfGears).compareTo(Integer.valueOf(c2.numberOfGears));
	}
	
	
	public static int compareByAirConditioner(Car c1, Car c2) {
		if (c2 == null) {
			return 1;
		} else if (c1 == null) {
			return -1;
		}
		
		if (!c2.hasAirConditioned) {
			return 1;
		} else if (!c1.hasAirConditioned) {
			return -1;
		}
		
		return 0;
	}
	

}
