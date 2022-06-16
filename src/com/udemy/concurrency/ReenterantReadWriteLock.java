package com.udemy.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReenterantReadWriteLock {
	public static final int HIGHEST_PRICE = 1000;

	public static void main(String[] args) {
		InventoryDatabase inventoryDatabase = new InventoryDatabase();
		Random random = new Random();

		for (int i = 0; i < 100000; i++) {
			inventoryDatabase.addItem(random.nextInt(HIGHEST_PRICE));
		}

		Thread writerThread = new Thread(() -> {
			while (true) {
				inventoryDatabase.addItem(random.nextInt(HIGHEST_PRICE));
				inventoryDatabase.removeItem(random.nextInt(HIGHEST_PRICE));
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		writerThread.setDaemon(true);
		writerThread.start();

		int numberOfReaderThreads = 7;
		List<Thread> readers = new ArrayList<Thread>();

		for (int i = 0; i < numberOfReaderThreads; i++) {
			Thread reader = new Thread(() -> {
				for (int j = 0; j < 100000; j++) {
					int upperBoundPrice = random.nextInt(HIGHEST_PRICE);
					int lowerBoundPrice = upperBoundPrice > 0 ? random.nextInt(upperBoundPrice) : 0;
					inventoryDatabase.numberOfItemsInPriceRange(upperBoundPrice, lowerBoundPrice);
				}
			});
			reader.setDaemon(true);
			readers.add(reader);
		}

		long startReadTime = System.currentTimeMillis();

		for (Thread readerThread : readers) {
			readerThread.start();
		}
		for (Thread readerThread : readers) {
			try {
				readerThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Time taken read ::" + (System.currentTimeMillis() - startReadTime));

	}

	public static class InventoryDatabase {
		private TreeMap<Integer, Integer> priceToCountMap = new TreeMap<Integer, Integer>();

		private ReentrantLock lock = new ReentrantLock();

		private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
		private Lock readLock = rwLock.readLock();
		private Lock writeLock = rwLock.writeLock();

		public int numberOfItemsInPriceRange(int upperBound, int lowerBound) {
			readLock.lock();
			try {
				Integer fromKey = priceToCountMap.ceilingKey(lowerBound);
				Integer toKey = priceToCountMap.ceilingKey(upperBound);

				if (fromKey == null || toKey == null) {
					return 0;
				}

				NavigableMap<Integer, Integer> rangeOfPrices = priceToCountMap.subMap(fromKey, true, toKey, true);

				int sum = 0;
				for (int numberOfItemsForPrice : rangeOfPrices.values()) {
					sum += numberOfItemsForPrice;
				}
				return sum;
			} finally {
				readLock.unlock();
			}

		}

		public void addItem(int price) {
			writeLock.lock();
			try {
				Integer numberOfItemsForPrice = priceToCountMap.get(price);
				if (numberOfItemsForPrice == null)
					priceToCountMap.put(price, 1);
				else
					priceToCountMap.put(price, numberOfItemsForPrice + 1);
			} finally {
				writeLock.unlock();
			}

		}

		public void removeItem(int price) {
			writeLock.lock();
			try {
				Integer numberOfItemsForPrice = priceToCountMap.get(price);
				if (numberOfItemsForPrice == null || numberOfItemsForPrice == 1)
					priceToCountMap.remove(price, 1);
				else
					priceToCountMap.put(price, numberOfItemsForPrice - 1);
			} finally {
				writeLock.unlock();
			}
		}
	}
}
