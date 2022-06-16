package com.udemy.concurrency;

public class AtomicOperationsDataRace {

	public static void main(String[] args) {

		Metrics metrics = new Metrics();

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < Integer.MAX_VALUE; i++) {
				metrics.increament();
			}
		});
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < Integer.MAX_VALUE; i++) {
				metrics.checkDataRace();
			}
		});
		t1.start();
		t2.start();

	}

	public static class Metrics {
		private volatile int x = 0;
		private volatile int y = 0;

		public void increament() {
			x++;
			y++;
		}

		public void checkDataRace() {
			if (y > x)
				System.out.println("Data race detected");
		}
	}

}
