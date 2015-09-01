package org.lompo.labs.java8.lambdas.streams.reducing;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Grade {
	private String topic;
	private double grade;
	private int coeff;
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public double getGrade() {
		return grade;
	}
	public void setGrade(double grade) {
		this.grade = grade;
	}
	public int getCoeff() {
		return coeff;
	}
	public void setCoeff(int coeff) {
		this.coeff = coeff;
	}
	
	public Grade(String topic, double grade, int coeff) {
		super();
		this.topic = topic;
		this.grade = grade;
		this.coeff = coeff;
	}
	
	public String toString() {
		return "[Topic: " + topic +", grade: " + grade + ", coefficient: " + coeff+"]";
	}
	
	public static List<Grade> getDemoGrades(int numberOfGrades) {
		
		Grade[] grades = new Grade[numberOfGrades];
		Random r = new Random();
		for (int i = 0; i < numberOfGrades; i++) {
			int coeff = r.nextInt(11);
			coeff = (coeff == 0)?1:coeff;
			Grade g = new Grade("Topic" + i,  r.nextDouble() * 20, coeff);
			grades[i] = g;
		}
		
		return Arrays.asList(grades);	
	}
	
	
	

}
