package org.lompo.labs.java8.lambdas.asynchronously;

import java.util.Random;

public class InvoiceUtils {

	private static final Random RANDOM = new Random();
	private InvoiceUtils() {}
	public static double computePrice(String articleName) {
		int leftWeight = articleName.charAt(0) + 1;
		int rightWeight = articleName.charAt(articleName.length() -1) + 1;
		int totalWeight = 0;
		for (char c: articleName.toCharArray()) {
			totalWeight += c;
		}
		
		double leftPart = RANDOM.nextDouble() * leftWeight;
		double rightPart = RANDOM.nextDouble() * rightWeight;
		double totalPart = RANDOM.nextDouble() *  totalWeight;
		return (1.0/3.0) * (leftPart + rightPart + totalPart);
	}
	
	public static void main(String[] args) {
		
		String article1 = "HP Pavilion GQ 47";
		String article2 = "Apple II C";
		double price1 = computePrice(article1);
		double price2 = computePrice(article2);
		
		System.out.println(article1  +", price:" + price1);
		System.out.println(article2  +", price:" + price2);
		
	}
	
	/**
	 * To make things simple we assume that the initial amount on the article
	 * is greater than any voucher's amount
	 * @return
	 */
	public static double apply (double price, VoucherFamily voucher) {
		TimeAndResourceConsumingTaskMock.doTimeAndResourceConsummingTaskMock();
		return price - voucher.getAmount();
	}
	
	public static String applyVoucher(Invoice invoice) {
		return invoice.E_SHOP_NAME + " / " + invoice.ARTICLE_NAME + " amount after deduction is...." 
				 + InvoiceUtils.apply(invoice.PRICE, invoice.VOUCHER);
	}
}
