package org.lompo.labs.java8.lambdas.asynchronously;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

/**
 * In this implementation the following tasks are performed
 * Asynchronous retrieval of the article's price from each shop before applying the voucher
 * Parsing the price info String into an Invoice when it becomes available
 * Compose the resulting Future with another asynchronous task in which the voucher is applied
 * Wait for the completion of all the Futures and extract their respective result.
 * By executing the simple measure main method you will notice it is much faster than the
 * SimpleVoucheredMarketManager example
 * We have omitted the ParallelStream illustration since it will be slower than the CompletableFuture present
 * example and since it does not scale as well as this one (as seen in previous examples)
 * @see SimpleVoucheredMarketManager
 * @see ParallelMarketManager 
 * @author LOMPO
 *
 */
public class CompletableFutureVoucheredMarketManager extends AbstractVoucheredMarketManager {

	@Override
	public List<String> getPricesListOf(String articleName) throws Exception {
		
		Executor executor = ExecutorUtils.getEShopCustomExecutorFor(this.getShops());
		List<CompletableFuture<Object>> priceFutures
		= this.getShops()
		.stream()
		.map(
				shop -> CompletableFuture.supplyAsync(
						() -> 
						shop.getArticle(articleName)
						.getUnitPriceWithVoucher(shop.getShopName())
						,executor
				)
			)
			.map(future -> future.thenApply(Invoice::parseInvoice))
			.map(future -> future.thenCompose(
					invoice ->
					CompletableFuture.supplyAsync(
							() -> InvoiceUtils.applyVoucher(
									invoice
									)
							,executor
							)
					)
			)
			.collect(toList());
		
		List<Object>  lstObj = priceFutures.stream()
				
				.map(CompletableFuture::join)
				.collect(toList());
		List<String> result = new ArrayList<String>();
		for (Object o: lstObj) {
			result.add(o.toString());
		}
		
		return result;
		
	}
	
	public static void main(String[] args) throws Exception {
		String articleName = "SuperBrush ZZ1";
		long startTime = System.nanoTime();
		CompletableFutureVoucheredMarketManager cFVM = new CompletableFutureVoucheredMarketManager();
		System.out.println(cFVM.getPricesListOf(articleName));
		double duration = (System.nanoTime() - startTime)/1000000.0D;
		System.out.println("Done in " + duration + " msecs");
	}
	
	

}
