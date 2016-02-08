package org.lompo.labs.java8.lambdas.pure.functional;

import java.util.Scanner;

/**
 * In this definition of the factorial, the recursive call is the
 * last things that takes place inside the function: this is an optimal
 * way of doing recursion compared to the classic approach of computing factorial
 * @author LOMPO
 *
 */
public class TRFactorial {
	
	public static long trFactorial(long n) {
		return doFactorialStep(1, n);
	}
	public static long doFactorialStep(long cumul, long n) {
		if (n == 1) {
			return cumul;
		} else {
			return doFactorialStep(cumul * n, n-1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String dataStr = "";
		System.out.println("Keep input the value for which you wish to compute factorial... type exit to finish....");
		while (true) {
			dataStr = sc.next();
			if ("EXIT".equalsIgnoreCase(dataStr)) {
				System.out.println("exiting ...");
				break;
			}
			
			long data = Long.parseLong(dataStr);
			System.out.println(data + "! =" + trFactorial(data));
		}
		
	}

}
