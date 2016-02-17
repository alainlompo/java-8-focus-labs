package org.lompo.labs.java8.lambdas.constructorreference;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.lompo.labs.java8.lambdas.Peach;

public class ConstructorReferenceWithFunctionTest {
	
	@Test
	public void getWeightyPeach_nominal_case_Test() {
		int weight = 250;
		Peach peach = ConstructorReferenceWithFunction.getWeightyPeach(weight);
		assertNotNull(peach);
		assertEquals(weight, peach.getWeight());
	}
	
	@Test
	public void getWeightyPeach2_nominal_case_Test() {
		int weight = 250;
		Peach peach = ConstructorReferenceWithFunction.getWeightyPeach(weight);
		assertNotNull(peach);
		assertEquals(weight, peach.getWeight());	
	}
}
