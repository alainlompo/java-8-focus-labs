package org.lompo.labs.java8.lambdas.pure.functional.currying;

import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;

public class MathsUtils {
	
	public static DoubleUnaryOperator getParabolicCurveOf(double a, double b, double c) {
		return (double x) -> a * x * x + b * x + c;
	}
	
	public static DoubleUnaryOperator getParabolaDerivative(double a, double b, double c) {
		return (double x) -> 2 * a * x +b ;
	}
	
	public static double optimaXOf(double a, double b, double c) {
		if (a == 0) {
			return 0.0D;
		}
		return -b / (2*a);
	}
	
	public static double getOptimaImage(double a, double b, double c) {
		DoubleUnaryOperator pCurve = getParabolicCurveOf(a, b, c);
		double optimaX = optimaXOf(a,b,c);
		return pCurve.applyAsDouble(optimaX);
	}
	
	public static void main(String[] args) {
		double a,b,c;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Input a,b,c as coefficients of the parabolic curve a.x^2 + b.x + c :");
			String aStr = sc.next();
			if ("EXIT".equalsIgnoreCase(aStr)) {
				break;
			}
			
			String bStr = sc.next();
			String cStr = sc.next();
			a = Double.parseDouble(aStr);
			b = Double.parseDouble(bStr);
			c = Double.parseDouble(cStr);
			
			double optimaX = optimaXOf(a,b,c);
			double optimaImg = getOptimaImage(a, b, c);
			
			System.out.println("The optima is found at x = " + optimaX + " and its value is " + optimaImg);
		}
		
	}

}
