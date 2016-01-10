package org.lompo.labs.java8.lambdas.asynchronously;

/**
 * This is to demonstrate some concepts so the rule of computing the values
 * of the invoice is taking into account the existance of a voucher
 * When there is a voucher, its amount is deduced from the invoice's total
 * @author LOMPO
 *
 */
public class Invoice {
	
	public final String E_SHOP_NAME;
	public final double PRICE;
	public final VoucherFamily VOUCHER;
	public final String ARTICLE_NAME;
	
	public Invoice(String eShopName,String articleName, double price, VoucherFamily voucher) {
		E_SHOP_NAME = eShopName;
		ARTICLE_NAME = articleName;
		PRICE = price;
		VOUCHER = voucher;
				
	}
	
	/**
	 * parse a string and extract the elements of the invoice
	 * @param infoString
	 * @return
	 */
	public static Invoice parseInvoice(String infoString) {
		String[] elements = infoString.split(":");
		String eShopName = elements[0];
		String articleName = elements[1];
		double price = Double.parseDouble(elements[2].replace(",", "."));
		VoucherFamily voucher = VoucherFamily.valueOf(elements[3]);
		return new Invoice(eShopName, articleName, price, voucher);
		
	}

	
	
	

}
