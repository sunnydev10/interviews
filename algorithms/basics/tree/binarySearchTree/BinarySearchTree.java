package org.something;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.algorithms.practice.tree.binarySearchTree.Node;

public class BinarySearchTree {
	static final int COUNT = 3;
	private Node root;

	public void insert(Integer data) {
		if (root == null) {
			root = new Node(data, new Node(null, null, null), new Node(null, null, null));
			return;
		}
		insertByRecursion(root, data);
	}

	private void insertByRecursion(Node root, Integer data) {
		if (root.getValue() == null) {
			root.setValue(data);
			return;
		}

		if (root.getValue() > data) {
			if (root.getLeft() == null) {
				root.setLeft(new Node(null, null, null));
			}
			insertByRecursion(root.getLeft(), data);
		} else {
			if (root.getRight() == null) {
				root.setRight(new Node(null, null, null));
			}
			insertByRecursion(root.getRight(), data);
		}
	}

	public void preOrderTraversalWithRecursion() {
		preOrderTraversalByRecursion(this.root);
	}

	private void preOrderTraversalByRecursion(Node current) {
		if (current == null) {
			return;
		}
		System.out.println(current.getValue());
		preOrderTraversalByRecursion(current.getLeft());
		preOrderTraversalByRecursion(current.getRight());
	}

	public void preOrderTraversalWithStack() {
		Stack<Node> stack = new Stack<>();
		stack.push(this.root);
		while (!stack.isEmpty()) {
			Node current = stack.pop();
			if (current != null) {
				System.out.println(current.getValue());
				stack.push(current.getRight());
				stack.push(current.getLeft());
			}
		}
	}

	public void inOrderTraversalWithRecursion() {
		inOrderTraversalByRecursion(this.root);
	}

	private void inOrderTraversalByRecursion(Node current) {
		if (current == null) {
			return;
		}
		inOrderTraversalByRecursion(current.getLeft());
		System.out.println(current.getValue());
		inOrderTraversalByRecursion(current.getRight());
	}

	public void inOrderTraversalWithStack() {
		Stack<Node> stack = new Stack<>();
		stack.push(this.root);
		stackLeftNodes(stack);
		while (!stack.isEmpty()) {
			Node current = stack.pop();
			System.out.println(current.getValue());
			if (current.getRight() != null) {
				stack.push(current.getRight());
				stackLeftNodes(stack);
			}
		}
	}

	public void postOrderTraversalWithRecursion() {
		postOrderTraversalByRecursion(this.root);
	}

	private void postOrderTraversalByRecursion(Node current) {
		if (current == null) {
			return;
		}
		postOrderTraversalByRecursion(current.getLeft());
		postOrderTraversalByRecursion(current.getRight());
		System.out.println(current.getValue());
	}

	public void postOrderTraversalWithStack() {
		Stack<Node> stack = new Stack<>();
		// As we go back if need to see if we visited node
		List<Integer> visited = new ArrayList<>();
		stack.push(this.root);
		stackLeftNodes(stack);
		while (!stack.isEmpty()) {
			Node current = stack.peek();
			if (current.getRight() != null && !visited.contains(current.getValue())) {
				visited.add(current.getValue());
				stack.push(current.getRight());
				stackLeftNodes(stack);
			} else {
				Node c = stack.pop();
				System.out.println(c.getValue());
			}
		}
	}

	private void stackLeftNodes(Stack<Node> stack) {
		while (stack.peek().getLeft() != null) {
			stack.push(stack.peek().getLeft());
		}
	}

	@Override
	public String toString() {
		return this.root.toString();
	}

	// Function to print binary tree in 2D
	// It does reverse inorder traversal
	static void print2DUtil(Node root, int space) {
		// Base case
		if (root == null)
			return;

		// Increase distance between levels
		space += COUNT;

		// Process right child first
		print2DUtil(root.getRight(), space);

		// Print current node after space
		// count
		System.out.print("\n");
		for (int i = COUNT; i < space; i++)
			System.out.print(" ");
		System.out.print(root.getValue() + "\n");

		// Process left child
		print2DUtil(root.getLeft(), space);
	}

	public Node getRoot() {
		return root;
	}
}
