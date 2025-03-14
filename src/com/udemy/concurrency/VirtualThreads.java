package com.udemy.concurrency;

import java.util.ArrayList;
import java.util.List;

public class VirtualThreads {

    private static final int NUMBER_OF_VIRTUAL_THREADS = 2000;

    public static void main(String[] args) throws InterruptedException {
        //platformThread();
        //virtualThread();
        virtualThreadWithBlockingIO();

    }

    private static void platformThread() throws InterruptedException {
        System.out.println(System.getProperty("java.version"));
        Runnable runnable = ()-> {System.out.println("Inside Thread : "+Thread.currentThread());};
        Thread platformThread = Thread.ofPlatform().unstarted(runnable);
        platformThread.start();
        platformThread.join();//wait for operation to complete
        //Inside Thread : Thread[#21,Thread-0,5,main]
        //ID 21 , name - Thread-0, priority 5, parent : main
    }

    private static void virtualThreadWithBlockingIO() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for(int i=0;i<NUMBER_OF_VIRTUAL_THREADS;i++){
            threads.add( Thread.ofVirtual().unstarted(new BlockingIO()));
        }

        for(Thread vt : threads){
            vt.start();
        }

        for(Thread vt : threads){
            vt.join();
        }
//        Inside Thread : VirtualThread[#22]/runnable@ForkJoinPool-1-worker-2
//        Inside Thread : VirtualThread[#21]/runnable@ForkJoinPool-1-worker-1
        //runnable@ForkJoinPool-1 - name
        //worker-1 carrier thread
    }

    private static void virtualThread() throws InterruptedException {
        Runnable runnable = ()-> {System.out.println("Inside Thread : "+Thread.currentThread());};
        List<Thread> threads = new ArrayList<>();

        for(int i=0;i<NUMBER_OF_VIRTUAL_THREADS;i++){
            threads.add( Thread.ofVirtual().unstarted(runnable));
        }

        for(Thread vt : threads){
            vt.start();
        }

        for(Thread vt : threads){
            vt.join();
        }
//        Inside Thread : VirtualThread[#22]/runnable@ForkJoinPool-1-worker-2
//        Inside Thread : VirtualThread[#21]/runnable@ForkJoinPool-1-worker-1
        //runnable@ForkJoinPool-1 - name
        //worker-1 carrier thread
    }

    private static class BlockingIO implements Runnable{

        @Override
        public void run() {
            System.out.println("Blocking operation : START "+Thread.currentThread());
            try {
                Thread.sleep(1000);
                System.out.println("Blocking operation : END "+Thread.currentThread());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
