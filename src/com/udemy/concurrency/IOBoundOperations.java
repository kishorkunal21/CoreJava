package com.udemy.concurrency;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IOBoundOperations {

    private static final int NUMBER_OF_TASKS = 10000 ;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press enter to start");
        scanner.nextLine();
        System.out.printf("Running %d tasks\n", NUMBER_OF_TASKS);

        long start = System.currentTimeMillis();
        performTask();
        System.out.println("Time taken to complete task : " + (System.currentTimeMillis() - start));
    }

    private static void performTask() {
        //use try with resources so that the main thread waits for all tasks to complete
//        try (ExecutorService executorService = Executors.newCachedThreadPool()) {
//            for (int i = 0; i < NUMBER_OF_TASKS; i++) {
//                executorService.submit(() -> blockingIoOperation());
//            }
//        }
        //use fixed size thread pool to avoid crashing on load of 10000
        //this runs using pool of 1000 in 10 sec for 1 sec blocking call
        try (ExecutorService executorService = Executors.newFixedThreadPool(1000)) {
            for (int i = 0; i < NUMBER_OF_TASKS; i++) {
                executorService.submit(() -> blockingIoOperation());
            }
        }
    }

    private static void blockingIoOperation() {
        System.out.println("Executing blocking IO operation for : " + Thread.currentThread());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
