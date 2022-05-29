 package com.algorithms.practice.tree.binarySearchTree;

public class Node {
	Integer value;
	Node left;
	Node right;

	public Node(Integer value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(final Integer value) {
		this.value = value;
	}

	public Node getNext() {
		return left;
	}

	public void setNext(final Node next) {
		this.left = next;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(final Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(final Node right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "Node value is : " + this.getValue().toString() ;
	}
}
