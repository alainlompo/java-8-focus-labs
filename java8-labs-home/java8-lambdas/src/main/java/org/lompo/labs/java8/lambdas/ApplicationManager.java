package org.lompo.labs.java8.lambdas;

/**
 * Illustrates default method on an interface
 * This mechanism allows java 8 to <<extends>> legacy classes
 * with the necessary method to make them compatible with java 8 additional stuffs
 * This is some kind of forward compatibility instead of traditionnal backward compatibility
 * @author LOMPO
 *
 */
public interface ApplicationManager {

	public void activate();
	public default void deActivate() {
		System.exit(0);
	}
}
