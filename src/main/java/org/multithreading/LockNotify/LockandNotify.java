package org.multithreading.LockNotify;

//Both of the functions will get intrinsic lock on LockandNotify
public class LockandNotify {
    public void produce() throws  InterruptedException {
        synchronized (this) {
            System.out.println("Running the produce method...");
            wait();
            System.out.println("Again in the producer method...");
        }
    }
    public void consume() throws  InterruptedException {
        Thread.sleep(200);

        synchronized (this) {
            System.out.println("Consume method is executed...");
            notify();
            // Even after notify, it is going to first execute all the statements in the synchronized block before going in producer (i.e. lock not released till its finished).
            Thread.sleep(200);
            System.out.println("Consume method after notify...");
        }
    }
}
