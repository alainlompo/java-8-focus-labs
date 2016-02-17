package org.lompo.labs.java8.lambdas;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class BunchOfDatasForTestUtilsTest {
	
	@Test
	public void oneOf_with_null_elementsList_Test() {
		List<String> elements = null;
		assertNull(BunchOfDatasForTestUtils.oneOf(elements));		
	}
	
	@Test
	public void oneOf_correct_elementsList_Test() {
		List<String> elements = Arrays.asList("hello", "world", "we", "are", "coming");
		String pickedElt = BunchOfDatasForTestUtils.oneOf(elements);
		assertNotNull(pickedElt);
		assertTrue(elements.contains(pickedElt));
	}
	
	

}
