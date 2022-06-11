package com.interview.misc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class MultiThreadingExecutorCallableFuture {

	public static void main(String[] args) {

		String report_content = "";
		/*
		 * ExecutorService service =
		 * Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		 * 
		 * List<Future> futureList = new ArrayList();
		 */

		CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> new BorrowerRatingReport().getReport())
				.thenApply(a -> new FinalRatingReport().getReport())
				.thenApply(a -> new InterimRatingReport().getReport())
				.thenApply(a -> new FinancialsReport().getReport());

		try {
			System.out.println(cf.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static class Exceptional extends Throwable {

	}

	private static class BorrowerRatingReport implements MisReports {
		@Override
		public String getReport() {
			return "BorrowerRatingReport..";
		}

	}

	private static class FinalRatingReport implements MisReports {
		@Override
		public String getReport() {
			return "FinalRatingReport..";
		}

	}

	private static class InterimRatingReport implements MisReports {

		@Override
		public String getReport() {
			return "InterimRatingReport..";
		}

	}

	private static class FinancialsReport implements MisReports {

		@Override
		public String getReport() {
			return "FinancialsReport..";
		}

	}

}
