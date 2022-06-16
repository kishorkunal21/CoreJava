package com.mosh.java.executorframework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Supplier;

public class Main {

	public static void main(String[] args) {

		FlightService service = new FlightService();
		CompletableFuture<Quote> site1 = service.getQuote("yatra");
		CompletableFuture<Quote> site2 = service.getQuote("makeMyTrip");
		CompletableFuture<Quote> site3 = service.getQuote("Bookings");

		// CompletableFuture.supplyAsync(site1)
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		CompletableFuture.allOf(site1, site2, site3).thenAccept((Quote) -> {
			try {
				System.out.println(site1.get());
				System.out.println(site2.get());
				System.out.println(site3.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

	}

	void timeout() {
		// handle timeout
		CompletableFuture<Integer> first = CompletableFuture.supplyAsync(() -> {
			LongTask.simulate();
			return 20;
		});

	}

	void fastestOutput() {
		// start second task on completions of both all task
		CompletableFuture<Integer> first = CompletableFuture.supplyAsync(() -> {
			LongTask.simulate();
			return 20;
		});
		CompletableFuture<Double> second = CompletableFuture.supplyAsync(() -> 70.7);

		CompletableFuture.anyOf(first, second).thenAccept((temp) -> {
			System.out.println(temp);
		});
	}

	void waitForAllTask() {

		// start second task on completions of both all task
		CompletableFuture<Double> first = CompletableFuture.supplyAsync(() -> 10.2);
		CompletableFuture<Double> second = CompletableFuture.supplyAsync(() -> 70.7);
		CompletableFuture<Double> third = CompletableFuture.supplyAsync(() -> 70.7);
		CompletableFuture.allOf(first, second, third).thenRun(() -> {
			try {
				System.out.println(first.get());
				System.out.println(second.get());
				System.out.println(third.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			System.out.println("DOne");
		});

	}

	void combine2TaskResult() {
		// start second task on completions of both task
		CompletableFuture<Double> first = CompletableFuture.supplyAsync(() -> 10.2);
		CompletableFuture<Double> second = CompletableFuture.supplyAsync(() -> 70.7);
		first.thenCombine(second, (price, exchangerate) -> price * exchangerate)
				.thenAccept((result) -> System.out.println(result));
	}

	void startOnComplete() {
		// start second task on completions of 1st task
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "email");
		future.thenCompose((email) -> CompletableFuture.supplyAsync(() -> "playlist"));
	}

	void transform() {
		// transforming to CompletableFuture
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 20);
		future.thenApply((x) -> toFsrenheit(x)).thenAccept((s) -> System.out.println(s));
		future.thenApply((celcius) -> ((celcius * 1.8) + 32));
	}

	static int toFsrenheit(int celcius) {
		return (int) (celcius * 1.8) + 32;
	}

	void handelingExceptions() {
		// handeling exceptions
		CompletableFuture future = CompletableFuture.runAsync(() -> {
			System.out.println("async run");
			throw new IllegalStateException();
		});

		try {
			System.out.println(future.exceptionally((ex) -> {
				return 1;
			}).get());// to avoid exception crash
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	static void get(Future future) {
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	void runTaskOnCompletion() {
		// ExecutorService executer = Executors.newFixedThreadPool(2);
		// running code on completion
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
			return 1;
		}, Executors.newFixedThreadPool(2));

		future.thenRun(() -> {
			System.out.println("Task 2");
		});
		future.thenRunAsync(() -> {
			System.out.println("Task 2 Aync");
		});
		try {
			System.out.println(future.get());
			Thread.sleep(5000);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		future.thenAccept((result) -> {
			System.out.println(Thread.currentThread().getName());
			System.out.println(result);
		});

		future.thenAcceptAsync((result) -> {
			System.out.println("Async" + Thread.currentThread().getName());
			System.out.println(result);
		});
	}

	void makingSyncWrapintoAsync() {
		MailService mail = new MailService();
		mail.sendAsync();

		System.out.println("Done");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	void usingCompletableFuture() {
		System.out.println("availableProcessors : " + Runtime.getRuntime().availableProcessors());

		Runnable task = () -> {
			System.out.println("runnable async call");
		};
		CompletableFuture.runAsync(task);

		Supplier<Integer> supplier = () -> {
			return 1;
		};
		Future<Integer> future = CompletableFuture.supplyAsync(supplier);

		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	void usingCallable() {

		ExecutorService executer = Executors.newFixedThreadPool(2);
		System.out.println(executer.getClass().getName());

		// using callable interface
		try {

			Future<Integer> future = executer.submit(() -> {
				System.out.println(Thread.currentThread().getName());
				LongTask.simulate();
				return 1;
			});
			System.out.println("Waiting for result..3  2  1 ");
			try {

				int val = future.get();// the current thread has to wait untill the result of task is ready
				System.out.println(val);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}

		} finally {
			executer.shutdown();
			System.out.println(executer.isShutdown());
		}
	}

	void usingRunnable(ExecutorService executer) {
		// using runnable interface
		try {
			for (int i = 0; i < 10; i++) {
				executer.submit(() -> {
					System.out.println(Thread.currentThread().getName());
				});
			}

		} finally {
			executer.shutdown();
		}
	}

}
