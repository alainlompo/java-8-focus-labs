package org.lompo.labs.java8.lambdas.streams.parallel;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class ApproachingParallelStreams {
	
	public static long productFromOneTo(long n) {
		return Stream.iterate(1L, i -> i+1)
				.limit(n)
				.reduce(1L, new BinaryOperator<Long>() {

					@Override
					public Long apply(Long l1, Long l2) {
						// TODO Auto-generated method stub
						return l1*l2;
					}
					
				});
	}
	
	public static long parallelProductFromOnteTo(long n) {
		return Stream.iterate(1L, i -> i+1)
				.limit(n)
				.parallel()
				.reduce(1L, new BinaryOperator<Long>() {

					@Override
					public Long apply(Long l1, Long l2) {
						// TODO Auto-generated method stub
						return l1*l2;
					}
					
				});
	}

}
