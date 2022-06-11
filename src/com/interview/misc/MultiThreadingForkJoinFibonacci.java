package com.interview.misc;

import java.util.concurrent.RecursiveTask;

public class MultiThreadingForkJoinFibonacci extends RecursiveTask<Integer> {
	final int n;

	MultiThreadingForkJoinFibonacci(int n) {
		this.n = n;
	}

	@Override
	protected Integer compute() {

		if (n < 1)
			return n;
		MultiThreadingForkJoinFibonacci f1 = new MultiThreadingForkJoinFibonacci(n - 1);
		f1.fork();
		MultiThreadingForkJoinFibonacci f2 = new MultiThreadingForkJoinFibonacci(n - 2);
		f2.fork();
		return f1.join() + f2.join();
	}
}
