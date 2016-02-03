package org.lompo.labs.java8.lambdas.dateAndTime;

import java.time.Duration;
import java.time.Instant;

public class DurationDemo1 {
	
	public static void main(String[] args) {
		Instant i3 = Instant.ofEpochMilli(195856);
		Instant i4 = Instant.ofEpochMilli(159500000);
		Duration d1 = Duration.between(i3, i4);
		System.out.println(String.format("The number of spanned seconds between %s and %s is %d seconds", i3.toString(), i4.toString(), d1.getSeconds()));
		
	}

}
