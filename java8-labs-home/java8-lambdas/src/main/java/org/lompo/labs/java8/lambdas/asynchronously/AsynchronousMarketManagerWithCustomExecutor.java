package org.lompo.labs.java8.lambdas.asynchronously;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsynchronousMarketManagerWithCustomExecutor extends CustomExecutorSupplyAsyncBasedManager {
	
	public List<String> getPrices(String articleName) throws Exception {
		List<CompletableFuture<String>> futurePrices = this.getPricesListOf(articleName);
		return futurePrices.stream()
				.map(CompletableFuture::join)
				.collect(toList());
	}
	
	/**
	 * We are using a Custom Executor instead of one picked from the default executors pool
	 * We are now comparing CompletableFutureAsynchronousMarketManager with this
	 * and the test show that the new version is faster (and fast is good)
	 * Therefore this last approach is the best and by far over the use of ParallelStream
	 * considering also the fact that the laziness of a Stream can make it hard to correctly assess
	 * when the wait actually occurs (when using ParallelStream)
	 * @param args
	 * @throws Exception
	 * @throws ExecutionException
	 * @see ParallelMarketManager
	 * @see SequentialMarketManager
	 * @see CompletableFutureAsynchronousMarketManager
	 * 
	 */
	public static void main(String[] args) throws Exception, ExecutionException {
		String articleName = "SuperBrush ZZ1";
		long startTime = System.nanoTime();
		AsynchronousMarketManagerWithCustomExecutor mm = new AsynchronousMarketManagerWithCustomExecutor();
		System.out.println(mm.getPrices(articleName));
		double duration = (System.nanoTime() - startTime)/1000000.0D;
		System.out.println("Done in " + duration + " msecs");
		
		
	}

}
