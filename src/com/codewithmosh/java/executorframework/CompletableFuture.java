package com.codewithmosh.java.executorframework;

public class CompletableFuture {
	
	public static void main(String [] args) {
		System.out.println(Runtime.getRuntime().availableProcessors());
		
		Runnable task = ()->{System.out.println("runnable async call");};
		
	}

}
