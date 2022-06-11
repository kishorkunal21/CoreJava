package com.book.cuncurrencyinpractice;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterTheadSafe extends Counter {
	private final AtomicInteger count = new AtomicInteger(0);

	public int increment() {
		return count.incrementAndGet();
	}

	public int decrement() {
		return count.decrementAndGet();
	}

}
