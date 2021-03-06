package org.lompo.labs.java8.lambdas.refactoring.designpatterns.template;

import java.math.BigDecimal;
import java.util.function.Consumer;

/**
 * The derived concrete class will provide
 * an implementation for the enticePlayer method.
 * @author LOMPO
 *
 */
public abstract class SoccerClub {
	
	public void hirePlayer(Player player) {
		BigDecimal baseSalary = null;
		if (player.getLevel() == PlayerClass.GALACTIC) {
			baseSalary = BigDecimal.valueOf(500000);
		} else if (player.getLevel() == PlayerClass.GOOD) {
			baseSalary = BigDecimal.valueOf(25000);
		} else {
			baseSalary = BigDecimal.valueOf(75000);
		}
		
		System.out.println("Your salary shall be: " + baseSalary.toString());
		enticePlayer(player);
	}
	
	// TODO: the specialized concrete classes will override this method and provide its content
	abstract void enticePlayer(Player player);
	
	
	
	

}
