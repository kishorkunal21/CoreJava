package com.codewithmosh.algorthm2;

import java.util.Arrays;

import com.codewithmosh.algorthm2.binarytrees.BinarySearchTree2;

public class Main {

	public static void main(String[] args) {
		// TODO:Heap sort
		int[] numbers = { 15, 10, 3, 8, 12, 9, 4, 1, 24 };
		Heap h = new Heap();
		for (int i : numbers) {
			h.insert(i);
		}
		h.printHeap();
		h.remove();
		System.out.println("");
		h.printHeap();

		Arrays.sort(numbers);
		System.out.println(Arrays.toString(numbers));

	}

	private void heap() {
		Heap h = new Heap();
		h.insert(15);
		h.insert(10);
		h.insert(3);
		h.insert(8);
		h.insert(12);
		h.insert(9);
		h.insert(4);
		h.insert(1);
		h.insert(24);
		h.printHeap();
		h.remove(15);
		System.out.println("After remove 15");
		h.printHeap();

	}

	private void AVLTree() {

		// recurssion(5);

		AVLTreeK bt = new AVLTreeK();
		bt.insert(10);
		bt.insert(30);
		bt.insert(20);
		/*
		 * bt.insert(7); bt.insert(4); bt.insert(9); bt.insert(1); bt.insert(6);
		 * bt.insert(8); bt.insert(10);
		 * 
		 * bt.insert(16); bt.insert(66); bt.insert(86); bt.insert(17);
		 */
		bt.height();

	}

	private void BinaryTree() {

		BinarySearchTree2 bt = new BinarySearchTree2();
		bt.insert(7);
		bt.insert(4);
		bt.insert(9);
		bt.insert(1);
		bt.insert(6);
		bt.insert(8);
		bt.insert(10);

		BinarySearchTree2 bt2 = new BinarySearchTree2();
		bt2.insert(7);
		bt2.insert(4);
		bt2.insert(9);
		bt2.insert(1);
		bt2.insert(6);
		bt2.insert(8);
		bt2.insert(11);
		bt.depthFirstTraversal();
		bt2.depthFirstTraversal();
		System.out.println("Equals:" + bt.equals(bt2));
		System.out.println("validateTree:" + bt.validateTree());
		bt.nodesAtDistance(2);

		// bt.breadthFirstTraversal();
		// bt.depthFirstTraversal();
		bt.height();
		bt.min();

		/*
		 * System.out.println(bt.find(101)); factorial(5);
		 * System.out.println(recurssion(5));
		 */

	}

	// n!=n*(n-1)!
	private static int recurssion(int num) {
		System.out.println(num);
		// base condiiton
		if (num == 0)
			return 1;
		int result = num * (recurssion(num - 1));
		System.out.println(result);
		return result;// num * (recurssion(num - 1));
	}

	private static int factorial(int num) {

		int factorial = 1;
		for (int i = num; i > 1; i--) {
			factorial *= i;
		}

		System.out.println(factorial);
		return factorial;

	}

}
