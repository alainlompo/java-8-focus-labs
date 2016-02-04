package org.lompo.labs.java8.lambdas.in.time.and.zones;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;

public class TimeZoneDemo1 {
	/**
	 * Check time zones on the IANA time and zone database
	 * @param args
	 */
	public static void main(String[] args) {
		ZoneId casaZone = ZoneId.of("Africa/Casablanca");
		ZoneId defaultZone = TimeZone.getDefault().toZoneId();
		LocalDate rightNow = LocalDate.now();
		ZonedDateTime zoneDateTime = rightNow.atStartOfDay(casaZone);
		ZoneId parisZone = ZoneId.of("Europe/Paris");
		LocalDateTime rightNowInTime = LocalDateTime.now();
		ZonedDateTime rightNowInTimeInParis = rightNowInTime.atZone(parisZone);
		Instant thisMoment = Instant.now();
		ZonedDateTime thisMomentInCasa = thisMoment.atZone(casaZone);
		ZoneId tokyoZone = ZoneId.of("Asia/Tokyo");
		LocalDate thisInstantInTokyo = rightNowInTime.toLocalDate();
		LocalDateTime timeFromThisMomentInTokyo = LocalDateTime.ofInstant(thisMoment, tokyoZone);
		System.out.println(String.format("In Tokyo right now is %s", timeFromThisMomentInTokyo.toString() ));
		
		
		
	}

}
