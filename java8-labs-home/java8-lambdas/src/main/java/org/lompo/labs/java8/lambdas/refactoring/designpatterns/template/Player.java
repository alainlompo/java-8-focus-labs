package org.lompo.labs.java8.lambdas.refactoring.designpatterns.template;

public class Player {
	private String name;
	private PlayerClass level;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PlayerClass getLevel() {
		return level;
	}
	public void setLevel(PlayerClass level) {
		this.level = level;
	}
	public Player(String name, PlayerClass level) {
		super();
		this.name = name;
		this.level = level;
	}
	
	

}
