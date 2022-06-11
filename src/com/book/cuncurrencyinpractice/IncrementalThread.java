package com.book.cuncurrencyinpractice;

public class IncrementalThread extends Thread {

	Counter counter;
	ThreadLocal tl;

	public IncrementalThread(Counter c, ThreadLocal tl) {
		this.counter = c;
		this.tl = tl;
	}

	public void run() {
		System.out.println(tl.get());
		increment();
	}

	void increment() {

		System.out.println(counter.increment());

	}

}
