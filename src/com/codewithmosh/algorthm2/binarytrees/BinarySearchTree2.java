package com.codewithmosh.algorthm2.binarytrees;

public class BinarySearchTree2 {

	private Node root = null;

	private class Node {
		private Node leftChild, rightChild = null;
		private int value = 0;

		public Node(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node:" + value;
		}
	}

	public void insert(int value) {
		// 10 20 25
		if (root == null) {
			root = new Node(value);
		} else {
			Node current = root;
			while (true) {
				if (value < current.value) {
					if (current.leftChild == null) {
						current.leftChild = new Node(value);
						break;
					}
					current = current.leftChild;
				} else {
					if (current.rightChild == null) {
						current.rightChild = new Node(value);
						break;
					}
					current = current.rightChild;
				}
			}
		}

	}

	public boolean find(int value) {

		if (root != null) {
			if (value == root.value)
				return true;
			Node current = root;
			while (current != null) {
				if (value < current.value) {
					if (current.leftChild != null && current.leftChild.value == value)
						return true;
					else
						current = current.leftChild;
				} else {
					if (current.rightChild != null && current.rightChild.value == value)
						return true;
					else
						current = current.rightChild;
				}
			}
		}

		return false;
	}

	public void breadthFirstTraversal() {
		System.out.print("breadthFirstTraversal : ");
		breadthFirstTraversal(root);// root
	}

	public void depthFirstTraversal() {
		System.out.print("\ntraversePreOrder : ");
		traversePreOrder(root);// root left right

		System.out.print("\ntraverseInOrder : ");
		traverseInOrder(root);// root left right

		System.out.print("\ntraversePostOrder : ");
		traversePostOrder(root);// left right root
		System.out.println("\n");
	}

	private void traversePreOrder(Node root) {
		if (root == null)
			return;
		System.out.print(root.value + " ");
		traversePreOrder(root.leftChild);
		traversePreOrder(root.rightChild);

	}

	private void traverseInOrder(Node root) {
		if (root == null)
			return;
		traverseInOrder(root.leftChild);
		System.out.print(root.value + " ");
		traverseInOrder(root.rightChild);
	}

	private void traversePostOrder(Node root) {
		if (root == null)
			return;
		traversePostOrder(root.leftChild);
		traversePostOrder(root.rightChild);
		System.out.print(root.value + " ");

	}

	public void height() {
		System.out.println("Height : " + height(root));
	}

	private int height(Node root) {
		if (root == null)
			return -1;

		if (root.leftChild == null && root.rightChild == null)
			return 0;

		return 1 + Math.max(height(root.leftChild), height(root.rightChild));
	}

	public void min() {
		System.out.println("min : " + min(root));
	}

	private int min(Node root) {
		if (root == null)
			return -1;
		if (root.leftChild == null && root.rightChild == null)
			return root.value;

		int left = min(root.leftChild);
		int right = min(root.rightChild);

		return Math.min(Math.min(left, right), root.value);

	}

	public boolean equals(BinarySearchTree2 b2) {

		return equals(root, b2.root);

	}

	private boolean equals(Node root1, Node root2) {

		if (root1 == null || root2 == null)
			return true;

		if (root1 != null && root2 != null) {
			return root1.value == root2.value && equals(root1.leftChild, root2.leftChild)
					&& equals(root1.rightChild, root2.rightChild);
		}

		return false;
	}

	public boolean validateTree() {
		return validateTree(root);
	}

	private boolean validateTree(Node root) {
		if (root == null)
			return false;
		if (root.leftChild != null)
			if (root.value < root.leftChild.value)
				return false;
		if (root.rightChild != null)
			if (root.value > root.rightChild.value)
				return false;
		validateTree(root.leftChild);
		validateTree(root.rightChild);

		return true;
	}

	public void nodesAtDistance(int distance) {
		nodesAtDistance(root, distance);
	}

	private void nodesAtDistance(Node root, int distance) {
		if (root == null)
			return;
		if (distance == 0)
			System.out.println("Node at level " + distance + " :" + root.value);

		nodesAtDistance(root.leftChild, distance - 1);
		nodesAtDistance(root.rightChild, distance - 1);

	}

	// TODO
	private void breadthFirstTraversal(Node root) {
		if (root == null)
			return;
		System.out.print(root.value + " ");
		Node current = root;
		while (true) {
			if (current.leftChild != null)
				System.out.println(current.leftChild.value);
			if (current.rightChild != null)
				System.out.println(current.rightChild.value);
			if (current.leftChild != null) {
				current = current.leftChild;
				continue;
			}
			if (current.rightChild != null) {
				current = current.rightChild;
				continue;
			}
		}

	}
}
