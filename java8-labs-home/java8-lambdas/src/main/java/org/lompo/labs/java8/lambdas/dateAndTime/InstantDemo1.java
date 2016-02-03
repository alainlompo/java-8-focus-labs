package org.lompo.labs.java8.lambdas.dateAndTime;

import java.time.Instant;

public class InstantDemo1 {

	public static void main(String[] args) {
		Instant i1 = Instant.ofEpochMilli(5856);
		System.out.println(i1.toString());
		Instant i2 = Instant.now();
		System.out.println(i2.toString());
		Instant i3 = Instant.ofEpochMilli(-98595654);
		System.out.println(i3.toString());
	}
}
