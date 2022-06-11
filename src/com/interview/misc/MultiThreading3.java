package com.interview.misc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MultiThreading3 {

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

		// Object lock1 = new Object();
		// Object lock2 = new Object();

		Object lock11 = new ReentrantLock();

		volatile int ii = 10;
		volatile String iii = "KK";
		Lock lock1 = new ReentrantLock();
		ReentrantReadWriteLock lockReadWrite = new ReentrantReadWriteLock();
		Lock readlock = lockReadWrite.readLock();// multiple threads
		Lock writelock = lockReadWrite.readLock();// single threads
		// Lock lock2 = new ReentrantLock();

		public void increment() {
			/*
			 * synchronized (lock1) { item++; }
			 */

			readlock.lock();
			item++;
			readlock.unlock();

		}

		public synchronized void decrement() {
			/*
			 * synchronized (lock1) { item--; }
			 */
			lock1.lock();
			item--;
			lock1.unlock();
		}

		public int getItem() {
			try {
				lock1.lock();
				return item;
			} finally {
				lock1.unlock();
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
