package com.codewithmosh.algorthm2;

public class AVLTreeK {
	private Node root = null;
	int hleft = 0;
	int hright = 0;

	private class Node {
		private Node leftChild, rightChild = null;
		private int value = 0;
		private int height = 0;
		int height_left = 0;
		int height_right = 0;

		public Node(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node:" + value;
		}
	}

	public void insert(int value) {
		insert(root, value);
	}

	private Node insert(Node root, int value) {
		if (root == null) {
			if (this.root == null)
				this.root = new Node(value);
			return new Node(value);
		} else if (value < root.value) {
			root.leftChild = insert(root.leftChild, value);
		} else if (value > root.value) {
			root.rightChild = insert(root.rightChild, value);
		}
		return root;
	}

	public void height() {
		setHeight(root);
	}

	private Node setHeight(Node root) {

		if (root == null)
			return root;

		setHeight(root.leftChild);
		setHeight(root.rightChild);
		if (root != null) {
			if (root.leftChild != null) {
				hleft++;
				root.height_left = hleft;
			}

			if (root.rightChild != null) {
				hright++;
				root.height_right = hright;
			}
		}
		System.out.println("root.value:" + root.value + " | height_left:" + root.height_left + " height_right:"
				+ root.height_right);

		balance(root);

		return root;
	}

	private void balance(Node node) {
		// 3 5 -2
		System.out.println("balanceFactor=="+balanceFactor(node));
		if (balanceFactor(node) > 1) {
			if (balanceFactor(node.leftChild) < 0)
				System.out.println("Right rotate" + node.leftChild.value);

			System.out.println("Balance factor -" + " Left heavvy :Right rotation on "+node.value);
		} else if (balanceFactor(node) < -1) {
			if (balanceFactor(node.rightChild) > 0)
				System.out.println("Right rotate" + node.rightChild.value);
			System.out.println("Balance factor -" + " Right heavvy :Left rotation on " + node.value);

		}

		else
			System.out.println("Balance factor - Balanced");
	}

	private int balanceFactor(Node node) {
		return (node == null) ? 0 : (root.height_left - root.height_right);
	}

}
