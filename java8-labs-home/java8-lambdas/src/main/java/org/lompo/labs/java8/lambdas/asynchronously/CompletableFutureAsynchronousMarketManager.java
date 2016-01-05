package org.lompo.labs.java8.lambdas.asynchronously;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.util.stream.Collectors.toList;

public class CompletableFutureAsynchronousMarketManager extends SupplyAsyncBasedMarketManager {

	public List<String> getPrices(String articleName) throws Exception {
		List<CompletableFuture<String>> futurePrices = this.getPricesListOf(articleName);
		return futurePrices.stream()
				.map(CompletableFuture::join)
				.collect(toList());
	}
	
	/**
	 * Looking carefully at this result (we four shops: es1...es4) we may notice that
	 * the computation time is lower than the SequentialMarketManager version
	 * yet is seems bigger than the ParallelMarketManager version which sounds
	 * a little bit desappointing but will be clarified with the proper explanations
	 * The parallel version can run the four tasks in parallel thus performing well (able to allocate
	 * one thread for each task). If we add more eShops than the number of available threads
	 * for the parallel stream its processing time will dramatically increase
	 * For example I increased the number of shop to five (added es5) and I can notice
	 * that now the CompletableFutureAsynchronousMarketManager version is a little bit
	 * faster than the ParallelMarketManager version
	 * We can make it better by using a CustomExecutor instead of the default executors
	 * taken from the pool
	 * @param args
	 * @throws Exception
	 * @throws ExecutionException
	 * @see ParallelMarketManager
	 * @see SequentialMarketManager
	 * 
	 */
	public static void main(String[] args) throws Exception, ExecutionException {
		String articleName = "SuperBrush ZZ1";
		long startTime = System.nanoTime();
		CompletableFutureAsynchronousMarketManager mm = new CompletableFutureAsynchronousMarketManager();
		System.out.println(mm.getPrices(articleName));
		double duration = (System.nanoTime() - startTime)/1000000.0D;
		System.out.println("Done in " + duration + " msecs");
		
		
	}
}
