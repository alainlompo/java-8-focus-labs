package org.lompo.labs.java8.lambdas.pure.functional;

public class TreeHandler {
	
	public static <T> T lookup (String key, T defaultValue, Tree<T> tree) {
		if (tree == null) {
			return defaultValue;
		} 
		
		if (key.equals(tree.getKey())) {
			return tree.getValue();
		}
		
		return lookup(key, defaultValue, key.compareTo(tree.getKey())<0 ?tree.getLeft(): tree.getRight()  );
		
		
	}
	
	/**
	 * No side effects functional style tree update method
	 * We may use such a method to parse a complex mathematical expression for example
	 * @param key
	 * @param newValue
	 * @param tree
	 * @return
	 */
	public static <T> Tree<T> functionalUpdate(String key, T newValue, Tree<T> tree) {
		return (tree == null)?
				new Tree<T>(key, newValue, null, null):
					key.equals(tree.getKey())?
							new Tree<T>(key, newValue, tree.getLeft(), tree.getRight()):
								(key.compareTo(tree.getKey()) < 0)?
										new Tree<T>(tree.getKey(), tree.getValue(), functionalUpdate(key, newValue, tree.getLeft()), tree.getRight()):
											new Tree<T>(tree.getKey(), tree.getValue(), tree.getLeft(), functionalUpdate(key, newValue, tree.getRight()));										
	}

}
