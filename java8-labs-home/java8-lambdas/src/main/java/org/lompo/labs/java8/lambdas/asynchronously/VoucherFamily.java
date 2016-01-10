package org.lompo.labs.java8.lambdas.asynchronously;

public enum VoucherFamily {
	GOLDEN(200),
	SILVER(100),
	BRONZE(50),
	NONE(0);
	
	private final int amount;
	private VoucherFamily(int amount) {
		this.amount = amount;
	}
	
	public int getAmount() {
		return amount;
	}

}
