package com.codewithmosh.java.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

	public static void main(String[] args) {

		Map<Integer, String> collection = new ConcurrentHashMap<Integer, String>();

		Thread t1 = new Thread(() -> {
			collection.put(1, "KK");
			collection.put(2, "NK");
		});

		Thread t2 = new Thread(() -> {
			collection.put(1, "KK");
			collection.put(2, "MOTU");
			collection.put(3, "TUNTUN");
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(collection);

	}

	void syncCollection() {
		Collection<Integer> collection = Collections.synchronizedCollection(new ArrayList<Integer>());

		Thread t1 = new Thread(() -> {
			collection.addAll(Arrays.asList(1, 2, 3, 4, 5));
		});

		Thread t2 = new Thread(() -> {
			collection.addAll(Arrays.asList(6, 7, 8));
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(collection);
	}

	void Threads() {

		List<Thread> threads = new ArrayList<Thread>();
		List<DownloadFileTask> downloadFileTasks = new ArrayList<DownloadFileTask>();

		for (int i = 0; i < 10; i++) {
			DownloadFileTask task = new DownloadFileTask();
			downloadFileTasks.add(task);
			Thread thread = new Thread(task);
			thread.start();
			threads.add(thread);
		}
		try {
			for (Thread t : threads)
				t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		int totalBytes = 0;
		for (DownloadFileTask d : downloadFileTasks) {
			System.out.println(d.getStatus() + " " + d.getStatus().getTotalBytesAtomic());
			totalBytes = totalBytes + d.getStatus().getTotalBytesAtomic();
		}
		System.out.println("Download status :" + totalBytes);

	}

	void interrupt(Thread thread) {
		try {
			thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread.interrupt();
	}

	void join(Thread thread) {
		try {
			thread.join();// wait main thread to complete this thread
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("File is ready to be scanned.");
	}

	void multipleThread() {
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(new DownloadFileTask());
			thread.start();
		}
	}

	void process() {

		System.out.println(Thread.currentThread().getName());
		System.out.println(Thread.activeCount());
		System.out.println(Runtime.getRuntime().availableProcessors());
	}

}
