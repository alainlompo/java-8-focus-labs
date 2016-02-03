package org.lompo.labs.java8.lambdas.dateAndTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTimeDemo1 {
	public static void main(String[] args) {
		LocalDateTime lDT = LocalDateTime.of(
				LocalDate.of(2016, 01, 17), 
				LocalTime.of(23, 11, 25));
		
		System.out.println("The date and time is : " + lDT.toString());
		System.out.println("The strict date is :" + lDT.toLocalDate().toString());
		System.out.println("The strict time is :" + lDT.toLocalTime().toString());
	}

}
