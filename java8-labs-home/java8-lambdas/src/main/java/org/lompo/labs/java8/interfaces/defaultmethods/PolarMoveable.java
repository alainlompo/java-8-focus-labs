package org.lompo.labs.java8.interfaces.defaultmethods;

public interface PolarMoveable {
	
	double getR();
	double getTheta();
	
	void setR(double r);
	void setTheta(double theta);
	
	default void moveRadially(double distance) {
		setR(getR() + distance);
	}
	
	default void moveAngularly(double angle) {
		setTheta(getTheta() + angle);
	}
	
	default void combineMovements(double distance, double angle) {
		moveRadially(distance);
		moveAngularly(angle);
	}

}
