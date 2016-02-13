package org.lompo.labs.java8.lambdas.pure.functional;

public class Tree<T> {
	
	private String key;
	private T value;
	private Tree<T> left, right;
	public Tree(String key, T value, Tree<T> left, Tree<T> right) {
		this.key = key;
		this.value = value;
		this.left = left;
		this.right = right;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public Tree<T> getLeft() {
		return left;
	}
	public void setLeft(Tree<T> left) {
		this.left = left;
	}
	public Tree<T> getRight() {
		return right;
	}
	public void setRight(Tree<T> right) {
		this.right = right;
	}

	

}
