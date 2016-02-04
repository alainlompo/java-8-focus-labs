package org.lompo.labs.java8.lambdas.in.time.and.zones;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

public class ZoneOffsetsDemo1 {
	public static void main(String[] args) {
		ZoneOffset newYorkOffset = ZoneOffset.of("-05:00");
		LocalDateTime rightNowInTime = LocalDateTime.now();
		OffsetDateTime dateTimeInNY = OffsetDateTime.of(rightNowInTime, newYorkOffset);
		System.out.println("The date and time in NY: " + dateTimeInNY);
		
	}

}
