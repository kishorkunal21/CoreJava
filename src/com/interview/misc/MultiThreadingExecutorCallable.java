package com.interview.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreadingExecutorCallable {

	public static void main(String[] args) {

		String report_content = "";
		ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

		List<Future> futureList = new ArrayList();

		Future<String> f = service.submit(new BorrowerRatingReport());

		futureList.add(service.submit(new BorrowerRatingReport()));
		futureList.add(service.submit(new FinalRatingReport()));
		futureList.add(service.submit(new InterimRatingReport()));
		futureList.add(service.submit(new FinancialsReport()));
		try {
			for (Future ff : futureList) {
				report_content += ff.get();// block if task is not complete - SOL'N - CALLABLE FUTURE
				System.out.println(report_content);
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	private static class BorrowerRatingReport implements Callable<String>, MisReports {
		@Override
		public String call() throws Exception {
			Thread.sleep(3000);
			return getReport();
		}

		@Override
		public String getReport() {
			return "BorrowerRatingReport..";
		}

	}

	private static class FinalRatingReport implements Callable<String>, MisReports {
		@Override
		public String call() throws Exception {
			Thread.sleep(3000);
			return getReport();
		}

		@Override
		public String getReport() {
			return "FinalRatingReport..";
		}

	}

	private static class InterimRatingReport implements Callable<String>, MisReports {
		@Override
		public String call() throws Exception {
			Thread.sleep(3000);
			return getReport();
		}

		@Override
		public String getReport() {
			return "InterimRatingReport..";
		}

	}

	private static class FinancialsReport implements Callable<String>, MisReports {
		@Override
		public String call() throws Exception {
			Thread.sleep(3000);
			return getReport();
		}

		@Override
		public String getReport() {
			return "FinancialsReport..";
		}

	}

}
