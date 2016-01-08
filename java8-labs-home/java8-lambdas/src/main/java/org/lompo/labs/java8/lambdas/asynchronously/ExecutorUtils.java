package org.lompo.labs.java8.lambdas.asynchronously;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * 
 * @author LOMPO
 *
 */
public class ExecutorUtils {
	
	private ExecutorUtils() {
		
	}
	
	/**
	 * Brian Goetz approximation to the right thread pool's size is:
	 * Nth = Ncpu * Ucpu * (1 + W/C);
	 * Ncpu ==> Number of cores: Runtime.getRuntime().availableProcessors()
	 * Ucpu ==> cpu utilisation (between 0 and 1)
	 * W/C ==> Wait time over Computing time
	 * Since our model is really not doing anything the application is almost all
	 * the time waiting for the Eshops responses
	 * @param eShops
	 * @return
	 */
	public static Executor getEShopCustomExecutorFor(List<EShop> eShops) {
		return Executors
				.newFixedThreadPool(Math.min(eShops.size(), 100),
						new ThreadFactory() {
					public Thread newThread(Runnable r) {
						Thread t = new Thread(r);
						t.setDaemon(true);
						return t;
					}
				}
						
						);
	}
	
	public static void main(String[] args) {
		System.out.println("Number of processors is : " + Runtime.getRuntime().availableProcessors());
		
	}

}
