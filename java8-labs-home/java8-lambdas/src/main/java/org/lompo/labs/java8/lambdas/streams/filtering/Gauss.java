package org.lompo.labs.java8.lambdas.streams.filtering;


import java.util.List;
import java.util.Arrays;
import java.util.function.Function;

/**
 * Using the gaussian function to illustrating the skipping capability of 
 * a stream: we neglect a few first values as the area they determine is
 * very small.
 * @author LOMPO
 *
 */
public class Gauss {
	
	public static final double sigma = 0.2F;
	public static final double mu = 0.0F;
	public static final double a = 1/(sigma * Math.sqrt(2*Math.PI) );
	public static final double b = mu;
	public static final double c = sigma;
	
	public static final Function<Double, Double> gauss = (x) -> a * Math.exp(-((x-b)*(x-b)/(2*c*c) ) );
	
	public static void main(String[] args) {
		List<Double> abcisses = Arrays.asList(-5.0,-4.0,-3.0,-2.0,-1.0,0.0,1.0,2.0,3.0,4.0,5.0);
		
		List<Double> images = abcisses
		.stream()
		.skip(4)
		.map(gauss)
		.collect(java.util.stream.Collectors.toList());
		
		System.out.println("number of images =" + images.size());
		int index = 4;
		for (Double d: images) {
			System.out.println("gauss (" + abcisses.get(index++) + ") =" + d);
		}
		
		System.out.println("---------------");
		System.out.println("Direct computing from the gaussian function...");
		for (Double d: abcisses) {
			System.out.println("gauss (" + d + ") =" + gauss.apply(d));
			
		}
		
	}

}
