package com.mosh.java.executorframework;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class FlightService {

	public CompletableFuture<Quote> getQuote(String site) {
		return CompletableFuture.supplyAsync(() -> {
			LongTask.simulate();
			Random random = new Random();
			System.out.println("Quote from "+site);
			return new Quote(site, 2000 + random.nextInt(10));
		});
	}

}
