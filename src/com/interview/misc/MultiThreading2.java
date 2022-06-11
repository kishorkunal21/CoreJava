package com.interview.misc;

public class MultiThreading2 {

	public static void main(String[] args) {

		Inventory inventory = new Inventory();
		Thread t1 = new Thread(new IncrementCounter(inventory));
		Thread t2 = new Thread(new DecrementCounter(inventory));
		try {
			t1.start();
			t2.start();

			t1.join();
			t2.join();
			System.out.println(inventory.getItem());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// approach 2
	static class Inventory {
		private int item = 0;

		Object lock1 = new Object();
		Object lock2 = new Object();

		public void increment() {
			synchronized (lock1) {
				item++;
			}

		}

		public synchronized void decrement() {
			synchronized (lock1) {
				item--;
			}
		}

		public int getItem() {
			synchronized (lock1) {
				return item;
			}
		}

	}

	// approach 1
	static class Inventory2 {
		private int item = 0;

		public synchronized void increment() {
			item++;
		}

		public synchronized void decrement() {
			item--;
		}

		public int getItem() {
			return item;
		}

	}

	static class IncrementCounter extends Thread {

		Inventory inventory;

		public IncrementCounter(Inventory inventory) {
			this.inventory = inventory;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10000; i++) {
				inventory.increment();
			}

		}

	}

	static class DecrementCounter extends Thread {

		Inventory inventory;

		public DecrementCounter(Inventory inventory) {
			this.inventory = inventory;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10000; i++) {
				inventory.decrement();
			}

		}

		void decrement() {
			inventory.item--;
		}
	}

}
