package org.lompo.labs.java8.lambdas.pure.functional.patternmatching;

public class Expression extends Number {

	private String valueExpression;
	
	public Expression(String valueExpression) {
		super();
		this.valueExpression = valueExpression;
	}
	@Override
	public int intValue() {
		int result = 0;
		try {
			result = Integer.parseInt(valueExpression);
		} catch (Exception ex) {
			
		}
		return result;
	}

	@Override
	public long longValue() {
		long result = 0;
		try {
			result = Long.parseLong(valueExpression);
		} catch (Exception ex) {
			
		}
		
		return result;
	}

	@Override
	public float floatValue() {
		float result = 0.0F;
		try {
			result = Float.parseFloat(valueExpression);
		} catch (Exception ex) {
			
		}
		return result;
	}

	@Override
	public double doubleValue() {
		double result = 0.0D;
		try {
			result = Double.parseDouble(valueExpression);
		} catch (Exception ex) {
			
		}
		return result;
	}

}
