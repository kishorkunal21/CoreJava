package com.udemy.java.concurrency;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreadTerminateJoin {

	public static void main(String[] args) throws InterruptedException {

		
		List<Long> inputNumbers = Arrays.asList(0L,343L,3435L,3535L);
		
		ArrayList<FactorialThread> threads = new ArrayList<FactorialThread>();
		
		for(long i:inputNumbers) {
			threads.add(new FactorialThread(i));
		}
		
		for(Thread t:threads) {
			t.start();
		}
		
		for(Thread t:threads) {
			t.join(3000);
		}
		
		
		for(int i=0;i<inputNumbers.size();i++) {
			FactorialThread ft = threads.get(i);
			if(ft.IsFinished()) {
				System.out.println("Factorial of "+ft.inputNumber()+" : "+ft.getResult());
			}
			else
				System.out.println("Thread running for "+inputNumbers.get(i));
		}
		
	}

	public static void interrupt() {
		// Thread t = new Thread(new LongComputationTask(new BigInteger("2"),new
		// BigInteger("10")));
		Thread t = new Thread(new LongComputationTask(new BigInteger("20000"), 
				new BigInteger("1000000")));
		t.start();
		t.setDaemon(true);//marks the thread to run in background 
		t.interrupt();
	}

	public static class LongComputationTask implements Runnable {
		private BigInteger base;
		private BigInteger power;

		public LongComputationTask(BigInteger base, BigInteger power) {
			this.base = base;
			this.power = power;
		}

		@Override
		public void run() {
			System.out.println(base + " ^ " + power + " = " + calculate());
		}

		private BigInteger calculate() {
			BigInteger result = BigInteger.ONE;
			for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
				if (Thread.currentThread().isInterrupted()) {
					System.out.println("Premeturely interrupted");
					return BigInteger.ONE;
				}
				result = result.multiply(base);
			}
			return result;
		}

	}

	private void blockInterrupt() {
		Thread thread = new Thread(new BlockingTask());
		thread.start();

		thread.interrupt();
	}

	public static class BlockingTask implements Runnable {

		@Override
		public void run() {
			try {
				Thread.sleep(50000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
