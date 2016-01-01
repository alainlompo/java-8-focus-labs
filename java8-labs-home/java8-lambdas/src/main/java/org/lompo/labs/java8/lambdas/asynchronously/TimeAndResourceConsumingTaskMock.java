package org.lompo.labs.java8.lambdas.asynchronously;

public class TimeAndResourceConsumingTaskMock {
	
	/**
	 * This a time and resource consuming task simulator
	 */
	public static void doTimeAndResourceConsummingTaskMock() {
		try {
			Thread.sleep(1200L);
			
		} catch (InterruptedException iE) {
			
		}
	}
	
	

}
