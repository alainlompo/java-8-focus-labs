package org.lompo.labs.java8.lambdas.asynchronously;

import java.util.concurrent.Future;

public class AsyncClientCodeSample {
	
	public static void main(String[] args) {
		Article article = new Article("Sony Power Headset");
		long beginTime = System.nanoTime();
		Future<Double> computedPrice = article.getUnitPriceAsync();
		double invocationTime = ((System.nanoTime() - beginTime) / 1000000.0D);
		System.out.println("Invocation returned after " + invocationTime + " msecs");
		
		// additional processings here
		doSomethingMore();
		
		try {
			double price = computedPrice.get();
			System.out.printf("Price is %.2f%n", price);
			
		} catch(Exception ex) {
			throw new RuntimeException (ex);	
		}
		
		double timeAfterProcessing = ((System.nanoTime() - beginTime )/ 1000000.0D );
		System.out.println("Price definitely returned after " + timeAfterProcessing + " msecs");
		
		
	}
	
	static void doSomethingMore() {
		
		System.out.println("Additional processing here while the price of the article is being processed...");
	}

}
