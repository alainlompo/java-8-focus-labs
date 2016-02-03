package org.lompo.labs.java8.lambdas.dateAndTime;

import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.Scanner;

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
		
		// Using temporal fields
		System.out.println("Using a temporal field: the day is : " + rightNow.get(ChronoField.DAY_OF_WEEK));
		
		System.out.println("Parsing demo...:");
		System.out.println("Input a date text and we will try to parse it....:");
		Scanner scanner = new Scanner(System.in);
		String inputDateTxt = scanner.next();
		LocalDate inputDate = LocalDate.parse(inputDateTxt);
		System.out.println("The week day of the input date was: " + inputDate.getDayOfWeek().toString());
		
	}

}
