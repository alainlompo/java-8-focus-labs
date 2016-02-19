package org.lompo.labs.java8.lambdas.pure.functional.patternmatching;

public class BinaryOperation extends Expression {
	
	private String opName;
	private Expression left;
	private Expression right;
	
	public BinaryOperation() {
		super("");
	}
	
	public BinaryOperation(String valueExpression) {
		super(valueExpression);
	}
	public String getOpName() {
		return opName;
	}
	public void setOpName(String opName) {
		this.opName = opName;
	}
	public Expression getLeft() {
		return left;
	}
	public void setLeft(Expression left) {
		this.left = left;
	}
	public Expression getRight() {
		return right;
	}
	public void setRight(Expression right) {
		this.right = right;
	}
	
	

}
