package org.lompo.labs.java8.interfaces.defaultmethods;

// Any class that implements this interface
// will automatically benefit from these default methods without needing to redefine them
// This way some kind of ascending compatibility can be defined. So the new methods introduced by java 8 and its functional model
// do not break former apis from former java version. Similar to C# extension methods
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
