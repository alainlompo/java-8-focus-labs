package org.lompo.labs.java8.lambdas.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class UsingOptionalAsStreamDemo {
	public static void main(String[] args) {
		List<Student> students= new ArrayList<Student>();
		students.add(new Student(15, "James Brown"));
		students.add(new Student(18, "Garry Pit"));
		students.add(new Student(19, "Mohamed Elsam"));
		students.add(new Student(11, "Roud Yes Boumhediyenne"));
		System.out.println("And the accepted students are....:");
		for (Student s:students) {
			printInfos(formatStudentResult(s));
		}
		
	}
	
	public static void printInfos(Optional<String> infos) {
		infos.ifPresent(s -> System.out.println(s));
	}
	
	public static Optional<String> formatStudentResult(Student student) {
		return Optional.ofNullable(student)				
				.flatMap(Student::getGpaStream)
				.filter(gpa -> gpa >= 15)
				.map(new Function<Integer, String>() {

					@Override
					public String apply(Integer t) {
						
						if (t.intValue() > 0) {
							return student.toString();
						} else {
							return student.getName() + ": FAILED!";
						}
					}
					
				});
				
				
	}

}
