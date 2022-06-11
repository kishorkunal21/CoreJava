package com.book.cuncurrencyinpractice;

import java.util.HashMap;
import java.util.Map;

public class Counter {

	private int index = 0;

	public final Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public int increment() {
		return index++;
	}

	public int decrement() {
		return index--;
	}

	public int getIndex() {
		return index;
	}

}
