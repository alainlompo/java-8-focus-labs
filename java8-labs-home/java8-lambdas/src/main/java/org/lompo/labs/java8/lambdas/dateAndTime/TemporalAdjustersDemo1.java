package org.lompo.labs.java8.lambdas.dateAndTime;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static java.time.temporal.TemporalAdjusters.*;

public class TemporalAdjustersDemo1 {
	public static void main(String[] args) {
		LocalDate date1 = LocalDate.of(2016, 02, 03);
		System.out.println(date1.toString());
		LocalDate date2 = date1.with(next(DayOfWeek.THURSDAY));
		System.out.println(date2.toString());
		LocalDate date3 = date2.with(nextOrSame(DayOfWeek.SATURDAY));
		System.out.println(date3.toString());
		LocalDate date4 = date3.with(dayOfWeekInMonth(3, DayOfWeek.FRIDAY));
		System.out.println(date4.toString());
		LocalDate date5 = date4.with(firstDayOfMonth());
		LocalDate date6 = date5.with(firstDayOfNextMonth());
		LocalDate date7 = date6.with(firstDayOfNextYear());
		LocalDate date8 = date7.with(firstDayOfYear());
		System.out.println(date5.toString());
		System.out.println(date6.toString());
		System.out.println(date7.toString());
		System.out.println(date8.toString());
		
		
	}

}
