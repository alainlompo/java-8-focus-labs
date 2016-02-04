package org.lompo.labs.java8.lambdas.dateAndTime.printing.and.parsing;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PrintingAndParsingDemo1 {
	public static void main(String[] args) {
		LocalDate date = LocalDate.of(2016, 03, 18);
		String dateTxt1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
		String dateTxt2 = date.format(DateTimeFormatter.ISO_DATE);
		String dateTxt3 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
		String dateTxt4 = date.format(DateTimeFormatter.ISO_WEEK_DATE);
		System.out.println(dateTxt1);
		System.out.println(dateTxt2);
		System.out.println(dateTxt3);
		System.out.println(dateTxt4);
		
		System.out.println("Using a custom pattern...");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd<>MM<>yyyy");
		System.out.println(LocalDate.now().format(formatter));
	}
}
