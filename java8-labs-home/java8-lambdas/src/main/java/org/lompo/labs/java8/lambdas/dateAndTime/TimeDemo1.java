package org.lompo.labs.java8.lambdas.dateAndTime;

import java.time.LocalTime;

public class TimeDemo1 {
	
	public static void main(String[] args) {
		LocalTime time = LocalTime.of(14, 35);
		LocalTime time2 = LocalTime.of(14, 35, 23);
		LocalTime time3 = LocalTime.ofNanoOfDay(655658598);
		LocalTime time4 = LocalTime.ofSecondOfDay(18565);
		
		System.out.println(String.format("time2 hour is %d and it's minute is %d ...", time2.getHour(), time2.getMinute() ));
		System.out.println(String.format("time3 hour is %d and it's minute is %d ...", time3.getHour(), time3.getMinute() ));
		
	}

}
