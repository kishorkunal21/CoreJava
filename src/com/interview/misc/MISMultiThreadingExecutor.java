package com.interview.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MISMultiThreadingExecutor {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

	}

	static void Futures() throws InterruptedException, ExecutionException {
		ExecutorService service = Executors.newFixedThreadPool(10);

		Future<String> ff = service.submit(() -> new MISSubReport1().data());

		System.out.println(ff.get());
		List<Future> futures = new ArrayList<Future>();

		for (int i = 0; i < 10; i++) {
			futures.add(service.submit(() -> new MISSubReport1().data()));
		}

		try {
			for (Future f : futures) {
				System.out.println(f.get());
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	static class MISSubReport1 implements MISReports, Callable<String> {

		StringBuilder sb = new StringBuilder();

		@Override
		public String call() throws Exception {
			return data();
		}

		@Override
		public void fetchData() {
			data();

		}

		String data() {
			return sb.append("\n Report fetched - " + counter.incrementAndGet()).toString();
		}

	}

	static void RejctedHandler() {
		ExecutorService service = new ThreadPoolExecutor(10, 10, 5, TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(10), new RejectedExecutonHandlerImpl());
		for (int i = 0; i < 100; i++) {
			System.out.println("\nRunning 1 at a time in sequence : schedule()");
			service.execute(() -> new MISBorrowerReports().fetchData());
		}
	}

	static class RejectedExecutonHandlerImpl implements RejectedExecutionHandler {

		@Override
		public void rejectedExecution(Runnable arg0, ThreadPoolExecutor arg1) {
			System.out.println("rejectedExecution exception");

		}
	}

	static void SingleThreadExecutor() {
		ExecutorService service = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 10; i++) {
			System.out.println("\nRunning 1 at a time in sequence : schedule()");
			service.execute(() -> new MISBorrowerReports().fetchData());
		}
	}

	// runs at fixed delay or rate
	static void scheduledThreadPool() {

		ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
		for (int i = 0; i < 10; i++) {
			System.out.println("\nRunning after 10 sec : schedule()");
			service.schedule(() -> new MISBorrowerReports().fetchData(), 10, TimeUnit.SECONDS);// run after 10 sec

			System.out.println("\nRunning every 10 sec : scheduleAtFixedRate()");
			service.scheduleAtFixedRate(() -> new MISBorrowerReports().fetchData(), 2, 5, TimeUnit.SECONDS);

			System.out.println("\nRunning every 10 sec : scheduleAtFixedRate()");
			service.scheduleWithFixedDelay(() -> new MISBorrowerReports().fetchData(), 2, 5, TimeUnit.SECONDS);

		}

	}

	// 1 thred at a time scheduled - checks if any idle thread then reassign else
	// create new
	// Uses sysncronous queue - kills a process if it is idle >60 sec
	static void cachedThreadPool() {
		ExecutorService service = Executors.newCachedThreadPool();
		for (int i = 0; i < 100; i++) {
			service.execute(() -> new MISBorrowerReports().fetchData());
			service.execute(() -> new MISFinancialReports().fetchData());
		}
	}

	// uses blockingqueue - means no enqueye if puool is full no deque if pool is
	// empty
	static void fixedThreadPool() {
		ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		MISBorrowerReports m = new MISBorrowerReports();
		for (int i = 0; i < 100; i++) {
			service.execute(() -> new MISBorrowerReports().fetchData());
			service.execute(() -> new MISFinancialReports().fetchData());
		}
	}

	static interface MISReports {

		static AtomicInteger counter = new AtomicInteger(0);

		void fetchData();

	}

	static class MISBorrowerReports implements MISReports {

		@Override
		public void fetchData() {

			System.out.println("Borrower Report generated" + counter.incrementAndGet());

		}

	}

	static class MISFinancialReports implements MISReports {

		@Override
		public void fetchData() {

			System.out.println("Financial Report generated" + counter.incrementAndGet());

		}

	}

}
