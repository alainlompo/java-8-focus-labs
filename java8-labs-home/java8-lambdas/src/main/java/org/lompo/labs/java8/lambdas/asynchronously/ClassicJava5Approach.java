package org.lompo.labs.java8.lambdas.asynchronously;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;



public class ClassicJava5Approach {
	
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		Future<String> futureResult =  executor.submit(new Callable<String>() {
			public String call() {
				
				// TODO: will execute a time and resource consuming operation here
				return doTimeAndResourceConsummingProcessing();
			}
		});
		
		// Do something else...
		doSomethingElse();
		
		try {
			
			// Obtain the result of the asynchronous operation
			// It may block it can the result is not yet available
			// but will wait at most 1 second
			String result = futureResult.get(1, TimeUnit.SECONDS);
			
		} catch(ExecutionException ee) {
			
		} catch(InterruptedException ie) {
			
		} catch (Exception ex) {
			
		}
	}
	
	static String doTimeAndResourceConsummingProcessing() {
		return "RESULT_OF_CONSUMING_PROCESSING";
	}
	static void doSomethingElse() {
		
	}

}
