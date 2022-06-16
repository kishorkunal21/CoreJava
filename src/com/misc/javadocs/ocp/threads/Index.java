package com.misc.javadocs.ocp.threads;

public class Index extends Thread {

	public static void main(String[] args) {
		

	}
	public void run()
	{
		System.out.println("inside run");
	}
	public void run(String s)
	{
		System.out.println("inside runs" +s);
	}

}
