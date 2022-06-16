package com.misc.javadocs.ocp.threads;

public class MyThread extends Thread {

	public static void main(String[] args) {
		Thread.currentThread().setName("abc");
		System.out.println(Thread.currentThread().getName());
		
		/*MyThread m = new MyThread();
		Thread t1 = new Thread(m);
		t1.setName("T1");
		t1.start();
		System.out.println(t1.getState());
		Thread t2=new Thread(m);
		
		System.out.println(t2.getState());
		t2.setName("T2");
		t2.start();
		t2.setName("T3");
		System.out.println(t2.getState());
		System.out.println(Thread.currentThread().getName());*/
		testThreads();

	}
	public static void testThreads()
	{
		Runnable r=()->{
			for (int i = 0; i < 5; i++) {
				System.out.println("Runnable running" +i);
			}			
		};
		Thread tt=new Thread(r);
		tt.start();
	}
	public void run()
	{
		System.out.println("inside run");
		System.out.println(Thread.currentThread().getName());
		
	}
	
	//overload run
	public void run(String s)
	{
		System.out.println("inside runs" +s);
	}

}
