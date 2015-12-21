package org.lompo.labs.java8.lambdas.refactoring.designpatterns.factory;

public class Laptop {
	protected int storageInGo;
	protected int screenSizeInInch;
	protected int numberOfKeysOnKeyboard;
	protected String processor;
	protected String graphicCard;
	public int getStorageInGo() {
		return storageInGo;
	}
	public void setStorageInGo(int storageInGo) {
		this.storageInGo = storageInGo;
	}
	public int getScreenSizeInInch() {
		return screenSizeInInch;
	}
	public void setScreenSizeInInch(int screenSizeInInch) {
		this.screenSizeInInch = screenSizeInInch;
	}
	public int getNumberOfKeysOnKeyboard() {
		return numberOfKeysOnKeyboard;
	}
	public void setNumberOfKeysOnKeyboard(int numberOfKeysOnKeyboard) {
		this.numberOfKeysOnKeyboard = numberOfKeysOnKeyboard;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public String getGraphicCard() {
		return graphicCard;
	}
	public void setGraphicCard(String graphicCard) {
		this.graphicCard = graphicCard;
	}
	
	public String toString() {
		return String.format("Processor: %s, storage: %d Go, graphic card: %s, screen size: %d, number of keys: %d",  this.processor, this.storageInGo, this.graphicCard, this.screenSizeInInch, this.numberOfKeysOnKeyboard);
		
	}

}
