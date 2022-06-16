package com.udemy.concurrency;

import java.util.Random;

public class AtomicOperations {

	public static void main(String[] args) {

		Metrics metrics = new Metrics();
		BusinessLogic businessLogicThread1 = new BusinessLogic(metrics);
		BusinessLogic businessLogicThread2 = new BusinessLogic(metrics);

		MetricsPrinter printer = new MetricsPrinter(metrics);
		businessLogicThread1.start();
		businessLogicThread2.start();
		printer.start();

	}

	public static class MetricsPrinter extends Thread {
		private Metrics metrics;

		public MetricsPrinter(Metrics metrics) {
			this.metrics = metrics;
		}

		@Override
		public void run() {

			while (true) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				double currentAverage = metrics.getAverage();
				System.out.println("currentAverage is ::" + currentAverage);
			}

		}

	}

	public static class BusinessLogic extends Thread {
		private Metrics metrics;
		private Random random = new Random();

		public BusinessLogic(Metrics metrics) {
			this.metrics = metrics;
		}

		@Override
		public void run() {

			while (true) {
				long startTime = System.currentTimeMillis();
				try {

					Thread.sleep(random.nextInt(10));

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				long endTime = System.currentTimeMillis();

				metrics.addSample(endTime - startTime);
			}

		}
	}

	public static class Metrics {
		private long count = 0;
		private double average = 0;

		public synchronized void addSample(long sample) {
			double currentSum = sample * count;
			count++;
			average = (currentSum + sample) / count;
		}

		public double getAverage() {
			return average;
		}
	}

}
