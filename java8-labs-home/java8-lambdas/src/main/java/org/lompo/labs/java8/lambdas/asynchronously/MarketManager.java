package org.lompo.labs.java8.lambdas.asynchronously;

import java.util.ArrayList;
import java.util.List;

public abstract class MarketManager {
	
	private List<EShop> shops;
	
	public MarketManager() {
		shops = new ArrayList<EShop>();
		setupDefaultShops();
	}
	
	public MarketManager addShop(EShop shop) {
		shops.add(shop);
		return this;
	}
	
	public List<EShop> getShops() {
		return shops;
	}
	
	
	public void setupDefaultShops() {
		EShop es1 = new EShop("Addictive Notes");
		es1.add(new Article("SuperBrush ZZ1"));
		EShop es2 = new EShop("Bright shoping");
		es2.add(new Article("SuperBrush ZZ1"));
		EShop es3 = new EShop("Cross Corner Turn");
		es3.add(new Article("SuperBrush ZZ1"));
		EShop es4 = new EShop("Best choice");
		es4.add(new Article("SuperBrush ZZ1"));
		this.addShop(es1)
		.addShop(es2)
		.addShop(es3)
		.addShop(es4);
	}
	
	public abstract List<String> getPricesListOf(String articleName) throws Exception;

}
