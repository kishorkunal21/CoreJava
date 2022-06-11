package com.udemy.java.concurrency;

import java.util.List;

public class MultiExecutor {

    // Add any necessary member variables here
	private List<Runnable> tasks;

    /* 
     * @param tasks to executed concurrently
     */
    public MultiExecutor(List<Runnable> tasks) {
        this.tasks=tasks;       
    }

    /**
     * Starts and executes all the tasks concurrently
     */
    public void executeAll() {
    	for(Runnable task:tasks) {
    		new Thread(task).start();
    	}
    }
}
