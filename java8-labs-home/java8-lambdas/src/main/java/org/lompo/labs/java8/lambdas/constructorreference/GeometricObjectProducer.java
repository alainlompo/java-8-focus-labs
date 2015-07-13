package org.lompo.labs.java8.lambdas.constructorreference;

import java.util.HashMap;
import java.util.Map;

/**
 * Mapping objects names with constructor references provide an non - verbose and
 * elegant way to implement an object factory
 * @author LOMPO
 *
 */
public class GeometricObjectProducer {
	
	static 
	Map<String, TriFunction<Double, Double, Double, GeometricObject>> 
	map = new HashMap<String, TriFunction<Double, Double, Double, GeometricObject>>();
	
	static {
		map.put("parallelepiped", Parrallelepiped::new);
		map.put("pyramid", Pyramid::new);
	}
	
	public static GeometricObject getGeometricObject(String name, double l, double L, double h) {
		GeometricObject gO = map.get(name).apply(l, L, h);
		return gO;
	}
	

	

}
