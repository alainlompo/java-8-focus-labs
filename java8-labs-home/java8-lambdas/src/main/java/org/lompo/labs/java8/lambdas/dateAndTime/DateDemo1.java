package org.lompo.labs.java8.lambdas.dateAndTime;

import java.time.LocalDate;

public class DateDemo1 {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2014,3,18);
		System.out.println(String.format(
				"Year: %d, month: %s, and day: %s",
				date.getYear(),
				date.getMonth().toString(),
				date.getDayOfMonth()
				));
	}

}
