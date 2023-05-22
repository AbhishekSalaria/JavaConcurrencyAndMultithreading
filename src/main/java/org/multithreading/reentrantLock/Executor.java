package org.multithreading.reentrantLock;

public class Executor {

    public static void main(String args[]) {

        ReentrantLocking reentrantLock = new ReentrantLocking();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.increment();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Counter is: "+reentrantLock.counter);

        ReentrantWorker worker = new ReentrantWorker();
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    worker.producer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    worker.consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t3.start();
        t4.start();

        try {
            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
