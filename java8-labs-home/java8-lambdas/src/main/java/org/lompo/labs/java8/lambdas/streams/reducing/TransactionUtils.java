package org.lompo.labs.java8.lambdas.streams.reducing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TransactionUtils {
	
	public static final Random RANDOMIZER = new Random();
	public static final List<String> TRADER_NAMES = Arrays.asList("Alain Lompo", "Kone Mokhtar", "Moustapha Akhtah Hulk", "John Doe", "Tammy Jhones");
	public static final List<String> TRADER_CITIES = Arrays.asList("Dublin", "Berlin", "London", "Casablanca", "Niamey", "Paris", "Zurich");
	
	
	public static final List<Trader> getDemoTraders() {
		int numberOfElements = 20 + RANDOMIZER.nextInt(20);
		List<Trader> result = new ArrayList<Trader>();
		for (int i = 0; i < numberOfElements; i++) {
			result.add(
					new Trader(
							TRADER_NAMES.get(
									RANDOMIZER.nextInt(TRADER_NAMES.size())
									),
							TRADER_CITIES.get(
									RANDOMIZER.nextInt(TRADER_CITIES.size())
									)
							)
					);
			
		}
		return result;
	}
	
	
	public static final List<Transaction> getDemoTransactions() {
		List<Trader> traders = getDemoTraders();
		List<Transaction> result = new ArrayList<Transaction>();
		int numberOfTransactions = RANDOMIZER.nextInt(30) + 30;
		for (int i = 0; i < numberOfTransactions; i++) {
			result.add(
					new Transaction(
							2000 + RANDOMIZER.nextInt(15),
							100 + RANDOMIZER.nextDouble()*1000.D,
							traders.get(RANDOMIZER.nextInt(traders.size()))
							)
					);
		}
		return result;
	}
	
	public static void showAllTransactionsSortedAscInYear(int year) {
		List<Transaction> transactions = getDemoTransactions();
		
		List<Transaction> target
		= transactions.stream()
		.filter(t -> t.getYear() == year)
		.sorted(new TransactionAmountComparator())
		.collect(Collectors.toList());
		
		for (Transaction t: target) {
			System.out.println(t);
		}
	}
	
	
	public static void showTradersFrom(String city) {
		List<Trader> traders = getDemoTraders();
		List<Trader> cityTraders =
				traders.stream()
				.filter(t -> t.getCity().equalsIgnoreCase(city))
				.sorted(new TraderFullNameComparator())
				.collect(Collectors.toList());
				
		for (Trader t: cityTraders) {
			System.out.println(t);
		}
				
	}
	
	
	public static boolean isAnyTraderFrom(String city) {
		List<Trader> traders = getDemoTraders();
		List<Trader> cityTraders =
				traders.stream()
				.filter(t -> t.getCity().equalsIgnoreCase(city))
				.sorted(new TraderFullNameComparator())
				.collect(Collectors.toList());
		
		return (cityTraders != null && cityTraders.size() >= 1);
		
	}
	public static String getAllTradersNames() {
		
		List<Trader> traders = getDemoTraders();
		String result = 
				traders.stream()
				.map(t -> t.getFullName())
				.reduce("", (s1, s2) -> s1.concat(" ").concat(s2));
		return result;
	}
	
	public static void showTradersCities () {
		List<Trader> traders = getDemoTraders();
		List<String> cities
		= traders.stream()
		.map(t -> t.getCity())
		.distinct()
		.collect(Collectors.toList());
		
		System.out.println(cities);
		
		
	}
	
	public static void printAllTransactionValues(String city) {
		List<Transaction> transactions = getDemoTransactions();
		List<Double> values =
		transactions.stream()
		.filter(t -> t.getTrader().getCity().equalsIgnoreCase(city))
		.map(t -> Double.valueOf( t.getAmount()))
		.collect(Collectors.toList());
		
		for (Double d: values) {
			System.out.println(d);
		}
	}
	
	public static void printTransactionsHighestValue() {
		List<Transaction> transactions = getDemoTransactions();
		Optional<Double> highestValue
		= transactions.stream()
		.map(t -> Double.valueOf(t.getAmount()))
		.max(Double::compareTo)
		;
		
		if (highestValue.isPresent()) {
			System.out.println("The highest value is...." + highestValue.get());
		}
		
	}
	
	/**
	 * Returns the transaction that has the smallest amount
	 * @return
	 */
	public static Transaction smallestValueTransaction() {
		List<Transaction> transactions = getDemoTransactions();
		Optional<Transaction> result =
				transactions.stream()
				.sorted(new TransactionAmountComparator())
				.findFirst();
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
		
	}
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input the year...");
		int year = scanner.nextInt();
		System.out.println("The transactions for year " + year + " are: ");
		showAllTransactionsSortedAscInYear(year);
		
		System.out.println();
		System.out.println("The traders cities...");
		showTradersCities();
		
		System.out.println();
		System.out.println("Pickup a city...");
		String city = scanner.next();
		
		showTradersFrom(city);
		System.out.println();
		
		System.out.println("A String containing all traders names...");
		System.out.println(getAllTradersNames());
		
		System.out.println();
		System.out.println("Let's see if there are any traders from Dublin...");
		String postText = (isAnyTraderFrom("Dublin"))?"traders living in Dublin":"no traders living in Dublin ";
		
		System.out.println("There are " + postText    );
		
		System.out.println();
		System.out.println("Let's print all transaction values from Dublin...");
		
		printAllTransactionValues("Dublin");
		
		System.out.println();
		printTransactionsHighestValue();
		
		System.out.println();
		System.out.println("Now let's find the transaction with the smallest value...");
		Transaction t = smallestValueTransaction();
		if (t != null) {
			System.out.println(" the transaction is: " + t);
		}
		
	}

}
