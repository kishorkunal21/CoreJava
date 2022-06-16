package com.misc.interview;

import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreading {

	public static void main(String[] args) {

		Thread t1 = new Thread(new InterruptThread());
		Thread t2 = new Thread(new InterruptThread());
		Thread t3 = new Thread(new InterruptThread());

		try {
			t1.start();
			t2.start();
			t3.start();
			t1.join();

			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void checkAtomicThread() {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			new Thread(() -> new AtomicLikes().increment()).start();
		}
		System.out.println("Time : " + (System.currentTimeMillis() - startTime));

	}

	static class SynchronizedLikes {
		static int counter = 1;

		synchronized void increment() {
			counter++;
			System.out.println(counter);
		}

		void decrement() {
			counter--;
			System.out.println(counter);
		}
	}

	static class AtomicLikes {
		static AtomicInteger counter = new AtomicInteger(1);

		synchronized void increment() {
			counter.incrementAndGet();
			System.out.println(counter);
		}

		void decrement() {
			counter.decrementAndGet();
			System.out.println(counter);
		}
	}

	static class InterruptThread implements Runnable {
		static AtomicInteger counter = new AtomicInteger(1);

		synchronized void increment() {
			counter.incrementAndGet();
			System.out.println(counter);
		}

		void decrement() {
			counter.decrementAndGet();
			System.out.println(counter);
		}

		@Override
		public void run() {
			try {
				System.out.println(Thread.currentThread().getName());
				Thread.sleep(3000);
				for (int i = 0; i < 1000; i++) {
					increment();
				}

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Interrupted...");
				return;
			}

		}
	}

}
