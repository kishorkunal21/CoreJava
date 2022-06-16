package com.mosh.java.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DownloadStatus {

	private boolean isDone;
	
	//private int totalBytes;
	private AtomicInteger totalBytes = new AtomicInteger();
	private int totalFiles;

	Lock lock = new ReentrantLock();// synchronised
	Object sync1 = new Object();
	Object sync2 = new Object();//dedicated motinor object so that not entire class method gets locked

	
	public int getTotalBytesAtomic() {
		return totalBytes.getAndIncrement();
	}
	
	public int getTotalBytes() {
		return totalBytes.get();
	}

	public void incrementByte() {
		synchronized (sync1) {
			totalFiles++;
		}
	}
	
	public void incrementByte_sync() {
		synchronized (sync1) {
			totalFiles++;
		}
	}

	public void incrementFiles() {
		synchronized (sync2) {
			totalFiles++;
		}
	}

	// using lock
	public void incrementByteLock() {

		try {
			lock.lock();
			//totalBytes++;

		} finally {

			lock.unlock();
		}
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

}
