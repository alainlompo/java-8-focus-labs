package org.lompo.labs.java8.lambdas.asynchronously;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Article {

	private String name;
	private double unitPrice;
	
	public Article(String name) {
		this.name = name;
		
	}
	
	private void processArticlePrice() {
		
		this.unitPrice = assessPrice(this.getName());
		
	}

	private double assessPrice(String articleName) {
		
		// Simulate a time and resource consumming task
		// That causes a certain amount of delay
		TimeAndResourceConsumingTaskMock.doTimeAndResourceConsummingTaskMock();
		return InvoiceUtils.computePrice(getName());
		
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

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	
	
}
