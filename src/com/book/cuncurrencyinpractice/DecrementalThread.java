package com.book.cuncurrencyinpractice;

public class DecrementalThread extends Thread {

	Counter counter;

	ThreadLocal tl;

	public DecrementalThread(Counter c, ThreadLocal tl) {
		this.counter = c;
		this.tl = tl;
	}

	public void run() {

		System.out.println("Factor is - " + tl.get());

		decrement();
	}

	void decrement() {

		System.out.println(counter.decrement());

	}

}
