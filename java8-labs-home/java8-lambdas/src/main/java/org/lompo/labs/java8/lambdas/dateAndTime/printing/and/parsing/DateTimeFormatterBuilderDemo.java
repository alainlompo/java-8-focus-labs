package org.lompo.labs.java8.lambdas.dateAndTime.printing.and.parsing;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class DateTimeFormatterBuilderDemo {
	
	public static void main(String[] args) {
		DateTimeFormatterBuilder customFormatterBuilder =
				new DateTimeFormatterBuilder()
		.appendLiteral("[")
		.appendText(ChronoField.YEAR)
		.appendLiteral("]")
		.appendText(ChronoField.MONTH_OF_YEAR)
		.appendLiteral("..")
		.appendText(ChronoField.DAY_OF_MONTH)
		.appendLiteral("(")
		.appendText(ChronoField.DAY_OF_WEEK)
		.appendLiteral(")")
		.parseCaseInsensitive();
		DateTimeFormatter customFormatter = customFormatterBuilder.toFormatter(Locale.GERMAN);
		LocalDate date = LocalDate.now();
		System.out.println(date.format(customFormatter));
	}

}
