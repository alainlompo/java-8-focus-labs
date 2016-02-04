package org.lompo.labs.java8.lambdas.alternative.calendars;

import java.time.LocalDate;
import java.time.chrono.HijrahDate;
import java.time.chrono.IsoChronology;
import java.time.chrono.JapaneseDate;
import java.time.chrono.MinguoDate;
import java.time.chrono.ThaiBuddhistDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

public class HijraDateDemo1 {
	public static void main(String[] args) {
		System.out.println("Showing the various alternative calendars ....");
		LocalDate rightNow = LocalDate.now();
		HijrahDate hD = HijrahDate.from(rightNow);
		System.out.println("The date according to Hijrah calendar is " + hD);
		ThaiBuddhistDate tBD = ThaiBuddhistDate.from(rightNow);
		System.out.println("The date according to the thai buddhist calendar is :" + tBD);
		MinguoDate mD = MinguoDate.from(rightNow);
		System.out.println("The date according to the Minguo calendar is :" + mD);
		JapaneseDate jD = JapaneseDate.from(rightNow);
		System.out.println("According to the japanese calendar the date is " + jD);
		
		// What day would Ramadam be this year?
		System.out.println();
		HijrahDate ramadamDate = 
				HijrahDate.now()
				.with(ChronoField.MONTH_OF_YEAR, 9)
				.with(ChronoField.DAY_OF_MONTH, 1);
		System.out.println("The theorical start date of Ramadam this year is " + 
				IsoChronology.INSTANCE.date(ramadamDate)
				);
		System.out.println("The theorical end date of Ramadam this year is " + 
				IsoChronology.INSTANCE.date(ramadamDate.with(
						TemporalAdjusters.lastDayOfMonth()
						))
						
						);
		
				
	}

}
