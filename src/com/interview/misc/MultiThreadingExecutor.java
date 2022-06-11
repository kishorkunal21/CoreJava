package com.interview.misc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class MultiThreadingExecutor {

	public static void main(String[] args) {

		int[] i = { 10, 20, 30, 40, 50, 60, 70, 80 };
		int jj = IntStream.of(i).min().getAsInt();
		System.out.println(jj);
		IntStream.of(i).distinct().sorted().limit(3).forEach(System.out::println);
		IntStream.of(i).min().ifPresent(System.out::println);// method referance

		// scheduleFixedTheadPoolException();
		// scheduledTheadPool();
	}

	static void scheduleFixedTheadPoolException() {

		/*
		 * ExecutorService service = new ThreadPoolExecutor(corePoolSize, int
		 * maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable>
		 * workQueue, ThreadFactory threadFactory, RejectedExecutionHandler);
		 */

		try {
			ExecutorService service = new ThreadPoolExecutor(10, 10, 1, TimeUnit.SECONDS,
					new ArrayBlockingQueue<Runnable>(1), new CustomRejectionHandler());

			System.out.println("newFixedThreadPool....");
			for (int i = 0; i < 10; i++)
				service.submit(new MisReportThrads());
		} catch (RejectedExecutionException e) {
			e.printStackTrace();
		}

	}

	static class CustomRejectionHandler implements RejectedExecutionHandler {

		@Override
		public void rejectedExecution(Runnable arg0, ThreadPoolExecutor arg1) {
			System.out.println("RejectedExecutionHandler...");

		}

	}

	RejectedExecutionException rejectedExecutionExceptionHandler() {
		System.out.println("RejectedExecutionExceptionHandler...");
		return new RejectedExecutionException();

	}

	void scheduleFixedTheadPool() {

		ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

		System.out.println("newFixedThreadPool....");
		for (int i = 0; i < 10; i++)
			service.submit(new MisReportThrads());

	}

	static void scheduledTheadPool() {

		ScheduledExecutorService service = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());
		System.out.println("scheduledTheadPool....");

		System.out.println("run after 10 sec delay - ");
		service.schedule(new MisReportThrads(), 10, TimeUnit.SECONDS);

		/*
		 * System.out.println("run every 10 sec repeteadly ");
		 * service.scheduleAtFixedRate(new MisReportThrads(), 10, 15,
		 * TimeUnit.SECONDS);// task,delay,period,unit
		 */

		System.out.println("run every after wait of 10 sec  ");
		service.scheduleWithFixedDelay(new MisReportThrads(), 10, 15, TimeUnit.SECONDS);

		service.submit(new MisReportThrads());

	}

	void singleTheadPool() {
		ExecutorService singleService = Executors.newSingleThreadExecutor();// run in sequence

		System.out.println("singleTheadPool....");
		for (int i = 0; i < 10; i++) {
			singleService.submit(new MisReportThrads());
		}
	}

	private static class MisReportThrads implements Runnable, MisReports {

		@Override
		public void run() {

			System.out.println("Thread name : " + Thread.currentThread().getName());

		}

		@Override
		public String getReport() {
			return null;
		}

	}
}
