package com.udemy.java.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CaseStudyVault {

	private static int MAX_PASSWORD = 9999;
	
	public static void main(String[] args) {
		Random random = new Random();
		
		Vault vault = new Vault(random.nextInt(MAX_PASSWORD));
		
		List<Thread> threads = new ArrayList<Thread>();
		threads.add(new AscendingHacker(vault));
		threads.add(new DecendingHacker(vault));
		threads.add(new Police());
		
		for(Thread thread:threads)
			thread.start();
	}

	private static class Vault {
		private int password;

		public Vault(int password) {
			this.password = password;
		}

		public boolean isCorrectPassword(int guess) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return guess == this.password;
		}
	}

	private static abstract class HackerThread extends Thread {

		protected Vault vault;

		public HackerThread(Vault vault) {
			this.vault = vault;
			this.setName(this.getClass().getSimpleName());
			this.setPriority(Thread.MAX_PRIORITY);
		}

		@Override
		public void start() {
			System.out.println("Starting thread : " + this.getName());
			super.start();
		}

	}

	public static class AscendingHacker extends HackerThread {

		public AscendingHacker(Vault vault) {
			super(vault);
		}

		@Override
		public void run() {
			for (int i = 0; i <= MAX_PASSWORD; i++) {
				if (super.vault.isCorrectPassword(i)) {
					System.out.println(this.getName() + " guessed the password : " + i);
					break;
				}

			}
		}

	}

	public static class DecendingHacker extends HackerThread {

		public DecendingHacker(Vault vault) {
			super(vault);
		}

		@Override
		public void run() {
			for (int i = MAX_PASSWORD; i >= 0; i--) {
				if (super.vault.isCorrectPassword(i)) {
					System.out.println(this.getName() + " guessed the password :" + i);
					break;
				}

			}
		}

	}

	private static class Police extends Thread {
		@Override
		public void run() {
			for (int i = 10; i >= 0; i--) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(i+" seconds remaining");
			}
			System.out.println("Game over hackers !!");
		}
	}

}
