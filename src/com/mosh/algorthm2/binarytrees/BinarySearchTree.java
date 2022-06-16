package com.mosh.algorthm2.binarytrees;

public class BinarySearchTree {
	private Node root;

	protected class Node {
		private Node leftChild, rightChild = null;
		private int value;

		public Node(int value) {
			this.value = value;
		}

		public Node getLeftChild() {
			return leftChild;
		}

		public Node getRightChild() {
			return rightChild;
		}

		public int getValue() {
			return value;
		}

		@Override
		public String toString() {
			return "Node [value=" + value + "leftChild=" + leftChild.value + ", rightChild=" + rightChild.value + "]";
		}

	}

	Node getRoot(){
		return root;
	}

	void printTree() {
		Node current = root;
		while (true) {
			System.out.print(root.value);
			if (current.leftChild != null)
				System.out.print(" " + current.leftChild.value);
			if (current.rightChild != null)
				System.out.print(" " + current.rightChild.value);

		}
	}

	void insert(int value) {

		if (root == null) {
			root = new Node(value);
			return;
		} else {
			Node current = root;
			while (true) {
				System.out.println("Inserting - " + value + " Current - " + current.value);
				if (value < current.value) {
					if (current.leftChild == null) {
						current.leftChild = new Node(value);
						System.out.println("<<<Inserted - " + value + " Current - " + current.value + "\n");
						break;
					} else {
						current = current.leftChild;
						System.out.println("<<<Moved - " + value + " Current - " + current.value);
						continue;
					}
				} else if (value > current.value) {
					if (current.rightChild == null) {
						current.rightChild = new Node(value);
						System.out.println(">>>Inserted - " + value + " Current - " + current.value + "\n");
						break;
					} else {
						current = current.rightChild;
						System.out.println(">>>>Moved - " + value + " Current - " + current.value);
						continue;
					}
				} else
					break;
			}

		}

	}

	boolean find(int value) {

		Node current = root;

		while (true) {

			if (current != null && current.value == value) {
				System.out.println("Found " + value);
				return true;
			}

			if (value < current.value) {
				System.out.println("Searching <<< of " + current.value);
				current = current.leftChild;
				continue;
			} else if (value > current.value) {
				System.out.println("Searching >>> of " + current.value);
				current = current.rightChild;
				continue;
			} else {
				System.out.println("Not Found");
				return false;

			}

		}

	}

}
