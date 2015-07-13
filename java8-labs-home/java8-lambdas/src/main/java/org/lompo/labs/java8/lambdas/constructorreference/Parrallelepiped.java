package org.lompo.labs.java8.lambdas.constructorreference;

public class Parrallelepiped extends GeometricObject {
	
	private double width, height, depth;

	public static final TriFunction<Double, Double, Double, Parrallelepiped> CUBE_FACTORY = Parrallelepiped::new;
	public static final TriFunction<Double, Double, Double, Double> VOLUME_CALCULATOR = (x,y,z) -> x*y*z;
	public Parrallelepiped(double width, double height, double depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
	}

	@Override
	double circumference() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	double surface() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	double volume() {
		// TODO Auto-generated method stub
		return VOLUME_CALCULATOR.apply(this.width, this.height, this.depth);
	}
	
	public static Parrallelepiped getCube(double w, double h, double d) {
		return CUBE_FACTORY.apply(w, h, d);
	}
	

}
