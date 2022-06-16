package com.codewithmosh.algorthm2.binarytrees;

public class Main {

	public static void main(String[] args) {
		BinarySearchTree bt = new BinarySearchTree();
		bt.insert(7);
		bt.insert(4);
		bt.insert(9);
		bt.insert(1);
		bt.insert(6);
		bt.insert(8);
		bt.insert(10);

		System.out.println(bt.find(6));

	}

}
