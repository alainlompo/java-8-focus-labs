package org.lompo.labs.java8.lambdas.constructorreference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import org.lompo.labs.java8.lambdas.Peach;

public class PeachWeightMapper {
	
	List<Integer> weights = Arrays.asList(154,223,545,305,125,85,95,856,247,111);
	
	List<Peach> heavyPeaches = map(weights, Peach::new);
	
	public static List<Peach> map(List<Integer> list, Function<Integer, Peach> f) {
		List<Peach> result = new ArrayList<>();
		for (Integer e: list) {
			result.add(f.apply(e));
		}
		
		return result;
		
	}
	
	public static void main(String[] args) {
		PeachWeightMapper pWM = new PeachWeightMapper();
		System.out.println(pWM.heavyPeaches);
	}

}
