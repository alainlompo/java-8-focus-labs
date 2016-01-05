package org.lompo.labs.java8.lambdas.asynchronously;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class ParallelMarketManager extends MarketManager {

	@Override
	public List<String> getPricesListOf(String articleName) throws Exception {
		return this.getShops()
				.parallelStream()
				.map(eShop -> String.format("in %s shop, %s price is %.2f", eShop.getShopName(), articleName, 
						(eShop.getArticle(articleName) !=null)?
						eShop.getArticle(articleName).getUnitPrice():0.0D ))
						.collect(toList());
	}
	
	/**
	 * Comparing the parallel version to the sequential version we find out
	 * it is by far faster than the sequential version.
	 * @see SequentialMarketManager
	 * @param args
	 * @throws Exception
	 * @throws ExecutionException
	 */
	public static void main(String[] args) throws Exception, ExecutionException {
		String articleName = "SuperBrush ZZ1";
		long startTime = System.nanoTime();
		ParallelMarketManager pMM = new ParallelMarketManager();
		System.out.println(pMM.getPricesListOf(articleName));
		double duration = (System.nanoTime() - startTime)/1000000.0D;
		System.out.println("Done in " + duration + " msecs");
		
		
	}

}
