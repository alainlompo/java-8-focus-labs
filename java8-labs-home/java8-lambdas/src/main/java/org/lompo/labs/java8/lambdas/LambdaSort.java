package org.lompo.labs.java8.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Example of using a lambda expression for sorting an array
 * of objects.
 * @author LOMPO
 *
 */
public class LambdaSort {
	
	public static void main(String[] args) {
		List<String> strings = new ArrayList<String>();
		strings.add("Amos");
		strings.add("Joel");
		strings.add("Abdias");
		strings.add("Christopher");
		strings.add("Franck");
		strings.add("Jean Marc");
		
		String[] asArray = strings.toArray(new String[0]);
		
		Arrays.sort(asArray, (String s1, String s2) -> s1.compareTo(s2) ) ;
		for (String s: asArray) {
			System.out.println(s);
		}
		
	}

}
