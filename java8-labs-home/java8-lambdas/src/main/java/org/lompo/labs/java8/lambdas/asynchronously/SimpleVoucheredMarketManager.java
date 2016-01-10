package org.lompo.labs.java8.lambdas.asynchronously;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class SimpleVoucheredMarketManager  extends AbstractVoucheredMarketManager{

	@Override
	public List<String> getPricesListOf(String articleName) throws Exception {
		
		return this.getShops()
				.stream()
				// Encode the price and voucher code of the given article
				.map(shop -> shop.getArticle(articleName).getUnitPriceWithVoucher(shop.getShopName()))
				
				// Parse the precedently obtained string to an Invoice object
				.map(Invoice::parseInvoice)
				
				// Generate a String contained details of the article and the deduced total amount
				.map(InvoiceUtils::applyVoucher)
				.collect(toList())
				;
	}
	
	
	public static void main(String[] args) throws Exception {
		String articleName = "SuperBrush ZZ1";
		long startTime = System.nanoTime();
		SimpleVoucheredMarketManager sVM = new SimpleVoucheredMarketManager();
		System.out.println(sVM.getPricesListOf(articleName));
		double duration = (System.nanoTime() - startTime)/1000000.0D;
		System.out.println("Done in " + duration + " msecs");
	}
	
	

}
