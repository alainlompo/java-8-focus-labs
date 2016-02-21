package org.lompo.labs.java8.lambdas.interfaces.defaultmethods;

public class CartesianObject implements CartesianMoveable {

	private double x, y;
	
	public CartesianObject(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}

	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}

	@Override
	public void setX(double x) {
		this.x = x;
		
	}

	@Override
	public void setY(double y) {
		this.y = y;
		
	}
	
	public String toString() {
		return "(" + x + "," + y + ")";
	}
	
	public static void main( String[] args) {
		CartesianObject balloon = new CartesianObject(125.5, 75.0);
		System.out.println("balloon is at :" + balloon);
		balloon.moveHorizontally(55);
		System.out.println("Now balloon is at: "+ balloon);
		balloon.combineMovements(-18.5, 41.5);
		System.out.println("And now balloon is at :" + balloon);
		
	}

}
