package com.mosh.java.executorframework;
import java.util.concurrent.CompletableFuture;
public class MailService {
	
	public void send() {
		LongTask.simulate();
		System.out.println("Mail sent");
	}
	
	public CompletableFuture<Void> sendAsync(){		
		return CompletableFuture.runAsync(()->{this.send();});
	}

}
