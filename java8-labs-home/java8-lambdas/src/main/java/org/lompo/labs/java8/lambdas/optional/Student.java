package org.lompo.labs.java8.lambdas.optional;

import java.util.Optional;

public class Student {
	private int gpa;
	private String name;
	
	public int getGpa() {
		return gpa;
	}
	
	public Optional<Integer> getGpaStream() {
		return Optional.ofNullable(gpa);
	}
	
	public void setGpa(int gpa) {
		this.gpa = gpa;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student(int gpa, String name) {
		super();
		this.gpa = gpa;
		this.name = name;
	}
	
	public String toString() {
		return name + ":" + gpa;
	}

}
