package com.codewithmosh.java.concurrency;

public class DownloadFileTask implements Runnable {

	private DownloadStatus  status;
	

	public DownloadFileTask() {
		this.status=new DownloadStatus();
	}
	
	@Override
	public void run() {
		System.out.println("Downloading file : " + Thread.currentThread().getName());

		try {
			//Thread.sleep(1000);//sleep
			//for(int i=0;i<Integer.MAX_VALUE;i++) {
			for(int i=0;i<10000;i++) {
				if(Thread.interrupted())
				{
					System.out.println("Thread.interrupted() !!");
					return;
				}
				//this.status.incrementByte();
				this.status.getTotalBytesAtomic();
				System.out.println("Downloading byte : "+i);
			}
			
			System.out.println("Download complete : " + Thread.currentThread().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public DownloadStatus getStatus() {
		return status;
	}

}
