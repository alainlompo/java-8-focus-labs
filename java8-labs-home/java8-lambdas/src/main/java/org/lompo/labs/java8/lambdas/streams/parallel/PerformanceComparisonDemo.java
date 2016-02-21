package org.lompo.labs.java8.lambdas.streams.parallel;

import java.util.Scanner;
import java.util.function.Function;

public class PerformanceComparisonDemo {
	
	static Function<Long, Long> classicMethod = new Function<Long,Long>() {

		@Override
		public Long apply(Long t) {
			// TODO Auto-generated method stub
			return ApproachingParallelStreams.productFromOneTo(t);
		}
		
	};
	
	static Function<Long, Long> parallelMethod = new Function<Long, Long>() {

		@Override
		public Long apply(Long t) {
			// TODO Auto-generated method stub
			return ApproachingParallelStreams.parallelProductFromOnteTo(t);
		}
		
	};
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Input N (we will compute Product(from i = 1 to i = N) ");
			String inputValue = scanner.next();
			if ("EXIT".equals(inputValue.toUpperCase().trim())) {
				break;
			}
			
			int n = Integer.parseInt(inputValue);
			long classicMethodResult = MeasuringParallel.measureProductPerformance(classicMethod, n);
			long parallelMethodResult = MeasuringParallel.measureProductPerformance(parallelMethod, n);
			System.out.println("Classic approach finished in " + classicMethodResult + " msecs, while parallel approach finished in " + parallelMethodResult + " msecs ");	
		}
	}

}
