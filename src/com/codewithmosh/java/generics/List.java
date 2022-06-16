package com.codewithmosh.java.generics;

public class List {

	private int[] items = new int[10];
	private int count = 0;

	public void add(int val) {
		items[count++] = val;
	}

	public int get(int index) {
		return items[index];
	}

}
