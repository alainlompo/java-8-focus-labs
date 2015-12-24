package org.lompo.labs.java8.lambdas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Test;

public class PeachManagerJUnitTest {
	
	
	@Test
	public void filterPeachesTest() {
		List<Peach> peaches = new ArrayList<Peach>();
		peaches.add(new Peach("Blue", 55));
		peaches.add(new Peach("Green", 25));
		peaches.add(new Peach("Green", 30));
		peaches.add(new Peach("Green", 70));
		Predicate<Peach> predicate1 = p -> "Green".equalsIgnoreCase(  p.getColor());
		List<Peach> greenPeaches = PeachManager.filterPeaches(peaches, predicate1);
		assertNotNull(greenPeaches);
		assertEquals(3, greenPeaches.size());
		Predicate<Peach> greenAndHeavyPredicate = p -> "Green".equalsIgnoreCase(p.getColor()) && 50 <= p.getWeight();
		List<Peach> greenAndHeavyOnes = PeachManager.filterPeaches(peaches, greenAndHeavyPredicate);
		assertNotNull(greenAndHeavyOnes);
		assertEquals(1, greenAndHeavyOnes.size());
	}
		

}
