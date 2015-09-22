package org.lompo.labs.java8.lambdas.fi.functions;

import java.util.function.Function;

/**
 * This is an illustration of functional composition
 * A definition such as that of F is almost a mathematical definition of a composition function
 * An since the result of applying F is another Function<Integer, Integer> we should be carrefu
 * as to how to apply it, the prondq variable is such an example of application
 * @author LOMPO
 *
 */
public class PRondQ {
	
	public static Function<Integer, Integer> F(Function<Integer, Integer> p, Function<Integer, Integer> q) {
		return x -> p.apply(q.apply (x));
	}
	
	public static void main(String[] args) {
		Function<Integer, Integer> pInst = new Function<Integer,Integer>() {
			public Integer apply(Integer x) {
				return Integer.valueOf(x.intValue() + 1);
			}
		};
		
		Function<Integer, Integer> qInst = new Function<Integer,Integer>() {
			public Integer apply(Integer x) {
				return Integer.valueOf(x.intValue() * x.intValue());
			}
		};
				
		Function<Integer, Integer> prondq = F(pInst, qInst);
		Integer x = Integer.valueOf(10);
		System.out.println(prondq.apply(x));
			
		
	}

}
