package com.book.cuncurrencyinpractice;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

	public static void main(String[] args) {
		Counter c = new Counter();
		c.map.put(10, 10);
		c.map.put(20, 20);
		c.map.put(20, 25);
		CounterTheadSafe ct = new CounterTheadSafe();

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Map<Integer, Integer> smap = Collections.synchronizedMap(map);
		ConcurrentHashMap<Integer, Integer> cmap = new ConcurrentHashMap<Integer, Integer>();

//		cmap.rep
//		ThreadLocals tl = new ThreadLocals();
//
//		for (int i = 0; i < 1000; i++) {
//			new IncrementalThread(ct, tl).start();
//			new DecrementalThread(ct, tl).start();
//		}

		System.out.println("\n Final index :" + c.getIndex());

	}

}
