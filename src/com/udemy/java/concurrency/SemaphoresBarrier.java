package com.udemy.java.concurrency;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SemaphoresBarrier {

	public static void main(String[] args) {
		int noOfWorkerThreads = 200;
		Barrier barrier = new Barrier(noOfWorkerThreads);
		Tasks task = new Tasks(barrier);

		for (int i = 0; i < noOfWorkerThreads; i++) {
			new Thread(task).start();
		}

		System.out.println("All done");
	}

	public static class Tasks implements Runnable {
		Barrier barrier;

		public Tasks(Barrier barrier) {
			this.barrier = barrier;
		}

		public void run() {
			task1();
			barrier.barrier();
			task2();
		}

		public void task1() {
			System.out.println("Task1 done for : " + Thread.currentThread().getName());
		}

		public void task2() {
			System.out.println("Task2 done for : " + Thread.currentThread().getName());
		}

	}

	public static class Barrier {
		private final int noOfWorkerThreads;
		private int counter = 0;

		Semaphore semaphore;
		Lock lock = new ReentrantLock();
		private boolean isLastWorker = false;

		public Barrier(int noOfWorkerThreads) {
			this.noOfWorkerThreads = noOfWorkerThreads;
			this.semaphore = new Semaphore(noOfWorkerThreads - 1);
		}

		public synchronized void barrier() {

			lock.lock();
			try {
				counter++;
				if (counter == noOfWorkerThreads)
					isLastWorker = true;

				System.out.println(Thread.currentThread().getName() + " Inside Barrier");
				System.out.println(
						"counter" + counter + " semaphore.availablePermits() :" + semaphore.availablePermits());
				if (counter == noOfWorkerThreads) {
					semaphore.release(1);
					System.out.println(Thread.currentThread().getName() + " Released");
				}

				else {
					try {
						semaphore.acquire();
						System.out.println(Thread.currentThread().getName() + " acquired");
						// semaphore.isFair();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			} finally {
				lock.unlock();
			}

		}

	}

}
