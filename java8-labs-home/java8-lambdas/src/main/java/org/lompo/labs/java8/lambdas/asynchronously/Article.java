package org.lompo.labs.java8.lambdas.asynchronously;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Article {

	private Random random = new Random();
	private String name;
	private double unitPrice;
	private String eShopName;
	
	public Article(String name) {
		this.name = name;
		
	}
	
	public void processArticlePrice() {
		
		this.unitPrice = assessPrice(this.getName());
		
	}

	public double assessPrice(String articleName) {
		
		// Simulate a time and resource consumming task
		// That causes a certain amount of delay
		TimeAndResourceConsumingTaskMock.doTimeAndResourceConsummingTaskMock();
		return InvoiceUtils.computePrice(articleName);
		
	}
	
	/**
	 * We use a CompletableFuture to hold the result of the computation
	 * Using a thread we can do the computation in an asynchronous way
	 * We use the complete method to assign the result to our CompletableFuture instance
	 * The Future instance will be returned without waiting for the completion
	 * of the price processing.
	 * @param articleName
	 * @return
	 */
	public Future<Double> getUnitPriceAsync(String articleName) {
		CompletableFuture<Double> futurePrice = new CompletableFuture<>();
		new Thread (() -> {
			double price = assessPrice(articleName);
			futurePrice.complete(price);
		}).start();
		return futurePrice;
	}
	
	
	/**
	 * This version of the getUniPriceAsync method is able to 
	 * make the client code with the Exception that caused the working thread
	 * from terminating normally. 
	 * @param articleName
	 * @return
	 */
	public Future<Double> getUnitPriceAsyncExceptionAble(String articleName) {
		CompletableFuture<Double> futurePrice = new CompletableFuture<>();
		new Thread(() -> {
			try {
				double price = assessPrice(articleName);
				futurePrice.complete(price);
			} catch (Exception ex) {
				futurePrice.completeExceptionally(ex);
			}
			
		}).start();
		return futurePrice;
	}
	
	/**
	 * This version uses the supplyAsync factory method. It takes
	 * a Supplier<T> as argument and uses an Executor from the ForkJoinPool
	 * to execute it. This method also propagates the knowledge of the exception
	 * like getUnitPriceAsyncExceptionAble method
	 * @see getUnitPriceAsyncExceptionAble
	 * @param articleName
	 * @return
	 */
	public Future<Double> getPriceUsingSupplyAsync(String articleName) {
		return CompletableFuture.supplyAsync(() ->  assessPrice(articleName));	
	}
	
	
	
	public Future<Double> getUnitPriceAsync() {
		return getUnitPriceAsync(this.name);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitPrice() {
		if (Double.valueOf(unitPrice).compareTo(Double.valueOf(0.0)) == 0 ) {
			processArticlePrice();
		}
		return unitPrice;
	}

	public String getUnitPriceWithVoucher(String eShopName) {
		if (Double.valueOf(unitPrice).compareTo(Double.valueOf(0.0)) == 0 ) {
			processArticlePrice();
		}
		
		// Simulate that there is a Voucher benefit
		// Picking it up randomly
		VoucherFamily voucher = VoucherFamily.values()[
		                                               random.nextInt(VoucherFamily.values().length)
		                                               ];
		
		return String.format("%s:%s:%.2f:%s",eShopName, name,unitPrice, voucher);
		
		
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String geteShopName() {
		return eShopName;
	}

	public void seteShopName(String eShopName) {
		this.eShopName = eShopName;
	}

	public Random getRandom() {
		return random;
	}
	
	
	
	
	
}
