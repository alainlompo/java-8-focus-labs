package org.lompo.labs.java8.lambdas.pure.functional.patternmatching;

import java.util.Random;
import java.util.function.Supplier;

public class IfElseHandlerDemo {
	
	/**
	 * Lambda and functional are powerful. No more cumbersome if else....
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Random rand = new Random();
		IfElseHandler<Integer> handler = new IfElseHandlerImpl<Integer>();
		while(true) {
			System.out.println("Generating a decision value for the boolean condition...");
			int decider = rand.nextInt();
			boolean b = decider % 2 ==0;
			Supplier<Integer> trueCase = () -> rand.nextInt(5000) *2;
			Supplier<Integer> falseCase = () -> rand.nextInt(5000) * 2 + 1;
			System.out.println("The boolean condition is :" + b);
			System.out.println("The generated value is ...." + handler.ifElse(b, trueCase, falseCase));
			Thread.sleep(1500);
		}
	}

}
