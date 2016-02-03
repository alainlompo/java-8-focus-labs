package org.lompo.labs.java8.lambdas.dateAndTime;

import java.time.LocalDate;

public class DateDemo1 {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2014,3,18);
		System.out.println(String.format(
				"Year: %d, month: %s, and day: %s, the  %s th",
				date.getYear(),
				date.getMonth().toString(),
				date.getDayOfWeek(),
				date.getDayOfMonth()
				));
		
		System.out.println(String.format("The year %d is ", date.getYear())
				+ ((date.isLeapYear())?"":"not") + " a leap year"
				);
		
		LocalDate rightNow = LocalDate.now();
		System.out.println("Today is " + rightNow.getDayOfWeek() + " the " + rightNow.getDayOfMonth() + " th of " + rightNow.getMonth().toString() + " "  +  rightNow.getYear());
		
		
		
	}

}
