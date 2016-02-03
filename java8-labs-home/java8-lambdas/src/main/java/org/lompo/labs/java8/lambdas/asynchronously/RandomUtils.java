package org.lompo.labs.java8.lambdas.asynchronously;

import java.util.Random;

public class RandomUtils {
	private static final Random RANDOM = new Random();
	
	/**
	 * With this method we will create a delay that can randomly vary
	 * 
	 * @param minDelayInMS: the minimal duration of the delay
	 * @param maxAdditionalDurationInMS. Total delay = minDelayInMS + maxAdditionalDurationInMS
	 */
	public static void randomDelay(int minDelayInMS, int maxAdditionalDurationInMS) {
		int totalDelay = minDelayInMS + RANDOM.nextInt(maxAdditionalDurationInMS);
		try {
			Thread.sleep(totalDelay);
		} catch (InterruptedException iE) {
			// TODO: handle the exception the appropriate way
		}
		
	}
	
	/**
	 * default method for calculating random delay
	 * min = 250 ms
	 * max = 1500 ms
	 */
	public static void randomDelay() {
		randomDelay(250, 1250);
	}

}
