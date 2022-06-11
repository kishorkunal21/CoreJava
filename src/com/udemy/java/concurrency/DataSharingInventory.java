package com.udemy.java.concurrency;

public class DataSharingInventory {

	public static void main(String[] args) {
		try {
			new DataSharingInventory().runThreads();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void runThreads() throws InterruptedException {
		InventoryCounter ic = new InventoryCounter();

		Thread incrementingThread = new IncrementThread(ic);
		Thread decrementingThread = new DecrementThread(ic);

		incrementingThread.start();
		decrementingThread.start();

		incrementingThread.join();
		decrementingThread.join();

		System.out.println("Items :::" + ic.getItems());

	}

	public class IncrementThread extends Thread {
		private InventoryCounter inventoryCounter;

		public IncrementThread(InventoryCounter inventoryCounter) {
			this.inventoryCounter = inventoryCounter;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10000; i++)
				inventoryCounter.increment();
		}
	}

	public class DecrementThread extends Thread {
		private InventoryCounter inventoryCounter;

		public DecrementThread(InventoryCounter inventoryCounter) {
			this.inventoryCounter = inventoryCounter;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10000; i++)
				inventoryCounter.decrement();
		}
	}

	public class InventoryCounter {
		Object lock1 = new Object();
		private int items = 0;

		// public synchronized void increment() {//using synchronized on method
		public void increment() {
			synchronized (lock1) {// Using object lock
				items++;
			}
		}

		// public synchronized void decrement() {//using synchronized on method
		public synchronized void decrement() {
			synchronized (lock1) {// Using object lock
				items--;
			}
		}

		// public synchronized int getItems() {//using synchronized on method
		public synchronized int getItems() {// using synchronized on method
			synchronized (lock1) {
				return items;
			}
		}
	}

}
