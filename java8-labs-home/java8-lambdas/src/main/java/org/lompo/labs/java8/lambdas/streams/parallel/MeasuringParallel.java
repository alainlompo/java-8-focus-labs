package org.lompo.labs.java8.lambdas.streams.parallel;

import java.util.function.Function;

public class MeasuringParallel {
	
	public static long measureProductPerformance(Function<Long, Long> multiplyer, long n) {
		long bestTime = Long.MAX_VALUE;
		System.out.println("Starting BIG " + bestTime);
		for (int i = 0; i < 10; i++) {
			long start = System.nanoTime();
			long product = multiplyer.apply(n);
			long duration = (System.nanoTime()-start)/1_000_000;
			System.out.println("Product computed at iteration n" + i + ": " + product);
			if (duration < bestTime) {
				bestTime = duration;
			}
		}
		return bestTime;
	}

}
