package org.lompo.labs.java8.lambdas.asynchronously;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CustomExecutorSupplyAsyncBasedManager extends CompletableFutureMarketManager {

	@Override
	public List<CompletableFuture<String>> getPricesListOf(String articleName)
			throws Exception {
		return this.getShops()
				.stream()
				.map(
						eShop ->CompletableFuture.supplyAsync
						(
								()
								->  "In shop: " +
								eShop.getShopName() + ", article: " +
								articleName + " price is: " +								
								eShop.getArticle(articleName).getUnitPrice(),
								ExecutorUtils.getEShopCustomExecutorFor(this.getShops())
						)
				)
				.collect( toList());
	}
	
	

}
