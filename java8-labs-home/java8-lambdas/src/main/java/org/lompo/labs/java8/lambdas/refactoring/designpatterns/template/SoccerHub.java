package org.lompo.labs.java8.lambdas.refactoring.designpatterns.template;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class SoccerHub {
	// TODO: Similar to SoccerClub abstract method.
	// TODO: the same can be done with lambdas and using the Consumer<T> interface
	// TODO: Now it's up to a call to recruitPlayer to define how to entice the given player
		
	public void recruitPlayer(Player player, Consumer<Player> enticer) {
		BigDecimal baseSalary = null;
		if (player.getLevel() == PlayerClass.GALACTIC) {
			baseSalary = BigDecimal.valueOf(500000);
		} else if (player.getLevel() == PlayerClass.GOOD) {
			baseSalary = BigDecimal.valueOf(25000);
		} else {
			baseSalary = BigDecimal.valueOf(75000);
		}
			
		System.out.println("Your salary shall be: " + baseSalary.toString());
		enticer.accept(player);
	}

}
