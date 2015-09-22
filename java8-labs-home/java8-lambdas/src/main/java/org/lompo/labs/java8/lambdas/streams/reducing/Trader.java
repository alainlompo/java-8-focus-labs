package org.lompo.labs.java8.lambdas.streams.reducing;

public class Trader {
	
	private String fullName;
	private String city;
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Trader(String fullName, String city) {
		super();
		this.fullName = fullName;
		this.city = city;
	}
	public Trader() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		return fullName + "[" + city + "]";
	}
	
	
	

}
