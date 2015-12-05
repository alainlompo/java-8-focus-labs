package org.lompo.labs.java8.lambdas.streams.grouping;

import java.util.Scanner;

public class IsPerfectCubeTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int valueToCheck = 0;
		String token = null;
		System.out.println("Enter the number to check, type exit to finish");
		while (true) {
			token = sc.next();
			if ("EXIT".equalsIgnoreCase(token.trim())) {
				System.out.println("Program terminated....");
				break;
			}
			
			valueToCheck = Integer.parseInt(token);
			PartitionCubeRootsDemo demo = new PartitionCubeRootsDemo();
			String msg = (demo.isPerfectCube(valueToCheck))?" is a perfect cube":" is not a perfect cube";
			System.out.println(valueToCheck + msg);
			
			
		}
		
	}

}
