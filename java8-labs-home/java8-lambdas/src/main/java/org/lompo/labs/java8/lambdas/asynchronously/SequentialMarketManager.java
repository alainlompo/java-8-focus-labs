package org.lompo.labs.java8.lambdas.asynchronously;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static java.util.stream.Collectors.toList;

public class SequentialMarketManager extends MarketManager {

	@Override
	public List<String> getPricesListOf(String articleName) throws Exception {
		return 
				this.getShops()
				.stream()
				.map(eShop -> String.format("in %s shop, %s price is %.2f", eShop.getShopName(), articleName, 
						(eShop.getArticle(articleName) !=null)?
						eShop.getArticle(articleName).getUnitPrice():0.0D ))
						.collect(toList());
	}
	
	
	public static void main(String[] args) throws Exception, ExecutionException {
		String articleName = "SuperBrush ZZ1";
		long startTime = System.nanoTime();
		SequentialMarketManager sMM = new SequentialMarketManager();
		System.out.println(sMM.getPricesListOf(articleName));
		double duration = (System.nanoTime() - startTime)/1000000.0D;
		System.out.println("Done in " + duration + " msecs");
		
		
	}

}
