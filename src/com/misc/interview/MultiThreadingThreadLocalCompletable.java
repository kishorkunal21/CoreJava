package com.misc.interview;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadingThreadLocalCompletable {

	public static void main(String[] args) throws InterruptedException {

		CompletableFuture.runAsync(() -> new BorrowerReport());

	}

	static interface MISReports {

		AtomicInteger counter = new AtomicInteger(0);
		StringBuilder finalreport = new StringBuilder();

		String generateReport();

	}

	static class BorrowerReport implements MISReports, Callable<String> {

		@Override
		public String call() throws Exception {
			// TODO Auto-generated method stub
			return generateReport();
		}

		@Override
		public String generateReport() {
			finalreport.append("BorrowerReport done" + counter.getAndIncrement());
			return "BorrowerReport done" + counter.getAndIncrement();
		}

	}

	static class FinancialReport implements MISReports, Callable<String> {

		String financialReport = "";

		@Override
		public String call() throws Exception {
			// TODO Auto-generated method stub
			return generateReport();
		}

		@Override
		public String generateReport() {
			finalreport.append("BorrowerReport done" + counter.getAndIncrement());
			// this.financialReport="FinancialReport done" + counter.getAndIncrement();
			return "FinancialReport done" + counter.getAndIncrement();

		}

	}

	static class MergeReports implements MISReports, Callable<String> {

		@Override
		public String call() throws Exception {
			// TODO Auto-generated method stub
			return generateReport();
		}

		@Override
		public String generateReport() {
			return "Merging done" + counter.getAndIncrement();
		}

	}

}
