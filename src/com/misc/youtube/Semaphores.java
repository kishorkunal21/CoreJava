package com.misc.youtube;

import java.util.concurrent.Semaphore;

//https://www.youtube.com/watch?v=g19pjkJyGEU&list=TLPQMDkwNDIwMjULmDHWvItZVg&index=3
public class Semaphores {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(3);
        System.out.println(semaphore.availablePermits());
        semaphore.acquire();
        semaphore.acquire();

        System.out.println(semaphore.availablePermits());
        semaphore.release();

        System.out.println(semaphore.availablePermits());
    }
}
