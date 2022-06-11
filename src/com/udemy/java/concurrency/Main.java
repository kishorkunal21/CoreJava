package com.udemy.java.concurrency;

public class Main {

	public static void main(String[] args) {

	}

	private static class ThreadByClass extends Thread {
		@Override
		public void run() {
			try {
				this.sleep(5000);
				System.out.println("Inside class thread : " + this.getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	static void uncaughtExceptionHandler() {

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				throw new RuntimeException("Intentional exception");
			}
		});

		thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("Uncaught exception handler");
			}
		});
		thread.start();

	}

	static void startThread() {

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("We're now in Thread - " + Thread.currentThread().getName() + "Priority - "
						+ Thread.currentThread().getPriority());
			}
		});
		thread.setName("New worker thread");
		thread.setPriority(Thread.MAX_PRIORITY);
		System.out.println("Before statring thread - " + Thread.currentThread().getName());
		thread.start();
		System.out.println("After statring thread - " + Thread.currentThread().getName());

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
