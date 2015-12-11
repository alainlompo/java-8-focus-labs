package org.lompo.labs.java8.lambdas.streams.parallel.forkjoin;

import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ProductComputing 
extends RecursiveTask<Long>{

	private final long[] values;
	private final int start;
	private final  int end;
	
	private static final long THRESHOLD = 4;
	
	
	
	public ProductComputing(long[] values) {
		this(values, 0, values.length);
	}



	public ProductComputing(long[] values, int start, int end) {
		super();
		this.values = values;
		this.start = start;
		this.end = end;
	}



	@Override
	protected Long compute() {
		int length = end-start;
		if (length <= THRESHOLD) {
			return evalSequence();
		}
		
		ProductComputing leftProcessor = 
				new ProductComputing (values, start, start + length/2);
		leftProcessor.fork();
		
		ProductComputing rightProcessor =
				new ProductComputing(values, start + length/2, end);
		Long rightResult= rightProcessor.compute();
		Long leftResult = leftProcessor.join();
		return leftResult * rightResult;
		
	}
	
	private long evalSequence() {
		long product = 1;
		for (int i = start; i < end; i++) {
			product *= values[i];
		}
		return product;
	}
	
	public static long computeProductUsingForkJoin(long n) {
		long[] values = LongStream.rangeClosed(1, n).toArray();
		ForkJoinTask<Long> task = new 	ProductComputing(values);
		return new ForkJoinPool().invoke(task);
	}
	
	public static void main(String[] args) {
		String token;
		Scanner sc = new Scanner(System.in);
		while (true) {
			token = sc.next();
			if (("EXIT").equalsIgnoreCase(token)) {
				break;
			}
			long result = computeProductUsingForkJoin(Integer.parseInt(token));
			System.out.println("Le produit allant de 1 a" + token + " vaut: " + result);
			
		}
	}
	
	

	
}
