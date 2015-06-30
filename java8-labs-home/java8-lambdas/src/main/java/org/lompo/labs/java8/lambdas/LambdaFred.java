package org.lompo.labs.java8.lambdas;

import java.util.Scanner;

public class LambdaFred {

	public static void main(String[] args)  {
		Scanner scanner = new Scanner(System.in);
		System.out.println("What's your name?");
		String name = scanner.next();
		Thread baseHelloThread = new Thread(()-> {
			while(true) {
				System.out.println("Hello world!....");
				try {
					Thread.sleep(800);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}  );
		
		Thread nameHelloThread = new Thread(()-> {
			while(true) {
				System.out.println("Hello "+ name);
				try {
					Thread.sleep(400);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}  );
		
		baseHelloThread.start();
		nameHelloThread.start();
				
	}
}
