package org.lompo.labs.java8.lambdas;

public class Peach {
	
	private String color;
	private int weight;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public Peach(String color, int weight) {
		super();
		this.color = color;
		this.weight = weight;
	}
	
	public String toString() {
		return "[Color: " + color +", weight: " + weight + "]";
	}
	
	

}
