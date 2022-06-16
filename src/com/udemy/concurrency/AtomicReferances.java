package com.udemy.concurrency;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferances {

	public static void main(String[] args) {
		String oldValue = "Nishu";
		String newValue = "Motu";

		AtomicReference<String> atomicReference = new AtomicReference<String>(oldValue);
		if (atomicReference.compareAndSet(oldValue, newValue)) {
			System.out.println("new value is " + atomicReference.get());
		} else
			System.out.println("Not set");
	}
}
