package org.lompo.labs.java8.lambdas.streams;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

public class BankDataSet {
	
	private static Random random = new Random();
	public static Account generateAccountWith(int numberOfOperations) {
		AccountBuilder accountBuilder = new AccountBuilder();
		accountBuilder.addAccountNumber(
				BankDataGenerator.ACCOUNT_NUMBERS.get(
						random.nextInt(
								BankDataGenerator.ACCOUNT_NUMBERS.size())))
					.addBalance(
				BankDataGenerator.BALANCES.get(
						random.nextInt(
								BankDataGenerator.BALANCES.size()
								)))
					;
		for (int i = 0; i < numberOfOperations; i++) {
			
			accountBuilder.addOperation(BigDecimal.valueOf(random.nextDouble()*2500.0D), 
					BankDataGenerator.OPERATION_TYPES.get(random.nextInt(BankDataGenerator.OPERATION_TYPES.size())), 
					new Date());
		}
		
		return accountBuilder.toAccount();
							
	}

}
