package org.lompo.labs.java8.lambdas.streams.reducing;

import java.util.List;

public class MapReduce {
	
	public static void doMapReduceDemo() {
		List<Grade> gradesList = Grade.getDemoGrades(3);
		double globalGrade 
		= gradesList.stream()
		.map(g -> g.getCoeff()* g.getGrade())
		.reduce(0.0D, (x,y) -> x+y);
		
		double globalCoeff =
				gradesList.stream()
				.map(g -> g.getCoeff())
				.reduce(0, (x,y) -> x+y);
		
		for (Grade g:gradesList) {
			System.out.println(g);
		}
		
		System.out.println("Global average is " + (globalGrade/globalCoeff));
		
	}
	
	public static void main(String[] args) {
		doMapReduceDemo();
	}

}
