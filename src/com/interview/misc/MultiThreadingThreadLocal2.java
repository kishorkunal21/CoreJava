package com.interview.misc;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MultiThreadingThreadLocal2 {

	private ThreadLocal<String> threadLocal = new ThreadLocal<String>();

	public static void main(String[] args) throws InterruptedException {
		Inventory inv = new Inventory(10);
		MyDateFormatter dateLocal = new MyDateFormatter();

		List<Thread> threads = new ArrayList<Thread>();
		FormatterToUpperThreadLocal ftl = new FormatterToUpperThreadLocal();

		Thread t1 = new Thread(new InventoryThreadIncreament(inv, ftl.get()));
		t1.setPriority(Thread.MAX_PRIORITY);
		for (int i = 0; i < 100; i++) {
			threads.add(new Thread(new InventoryThreadIncreament(inv, ftl.get())));
		}

		for (Thread t : threads) {
			t.start();

		}

	}

	static class Inventory {
		int item;

		public Inventory(int item) {
			this.item = item;
		}

		public int getItem() {
			return item;
		}

		public void increment() {
			item++;
		}

		public void decrement() {
			item--;
		}
	}

	static class MyDateFormatter {

		private ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = new ThreadLocal<>();

		public String format(Date date) {
			SimpleDateFormat simpleDateFormat = getThreadLocalSimpleDateFormat();
			return simpleDateFormat.format(date);
		}

		private SimpleDateFormat getThreadLocalSimpleDateFormat() {
			SimpleDateFormat simpleDateFormat = simpleDateFormatThreadLocal.get();
			if (simpleDateFormat == null) {
				simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				simpleDateFormatThreadLocal.set(simpleDateFormat);
			}
			return simpleDateFormat;
		}
	}

	static class FormatterToUpperThreadLocal {
		private ThreadLocal<String> threadLocal = new ThreadLocal<String>();

		public void set(String name) {
			threadLocal.set(name);
		}

		public ThreadLocal<String> get() {
			return new ThreadLocal<String>();
		}

	}

	static class InventoryThreadIncreament implements Runnable {
		Inventory inventory;
		ThreadLocal<String> threadLocal;

		public InventoryThreadIncreament(Inventory inventory, ThreadLocal<String> threadLocal) {
			this.inventory = inventory;
			this.threadLocal = threadLocal;
		}

		@Override
		public void run() {
			inventory.increment();
			threadLocal.set(Thread.currentThread().getName());
			System.out.println(threadLocal.get());
//			try {
//				inventory.increment();
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//			}

		}
	}

}
