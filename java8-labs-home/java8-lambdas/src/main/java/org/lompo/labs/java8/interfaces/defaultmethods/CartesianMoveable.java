package org.lompo.labs.java8.interfaces.defaultmethods;

public interface CartesianMoveable {
	double getX();
	double getY();
	
	void setX(double x);
	void setY(double y);
	
	default void moveHorizontally(double distance) {
		setX(getX() + distance);
	}
	
	default void moveVertically(double distance) {
		setY(getY() + distance);
	}
	
	default void combineMovements(double horizontalMove, double verticalMove) {
		moveHorizontally(horizontalMove);
		moveVertically(verticalMove);
	}

}
