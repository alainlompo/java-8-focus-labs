package org.lompo.labs.java8.lambdas.constructorreference;
import java.util.function.*;

/**
 * Shows usage of andThen and compose to combine functions
 * @author LOMPO
 *
 */
public class FunctionComposition {
	
	public Function<Double, Double> sinus = x -> Math.sin(x);
	public Function<Double, Double> absoluteValue = x -> Math.abs(x);
	public Function<Double, Double> absolueValueOfSinus = sinus.andThen(absoluteValue);
	
	public Function<Double, Double> logarithm = x -> Math.log(x);
	public Function<Double, Double> checkedLog = logarithm.compose(absoluteValue);
	
	public static void main(String[] args) {
		FunctionComposition composer = new FunctionComposition();
		double log5 = composer.logarithm.apply(5.0D);
		double minus5Log = composer.checkedLog.apply(-5.0D);
		
		assert log5 == minus5Log;
	}

}
