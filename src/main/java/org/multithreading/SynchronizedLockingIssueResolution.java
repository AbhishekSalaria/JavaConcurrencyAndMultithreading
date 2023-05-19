package org.multithreading;

public class SynchronizedLockingIssueResolution implements  Runnable{

    public int counter1 = 0;
    public int counter2 = 0;

    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void increment1() {
        // custom object locking
        synchronized (lock1) {
            counter1 += 1;
        }
    }
    public void increment2() {
        // custom object locking
        synchronized (lock2) {
            counter2 += 1;
        }
    }

    @Override
    public void run() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    increment1();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    increment2();
                }
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

        System.out.println("SynchronizedLockingIssueResolution: "+counter1);
        System.out.println("SynchronizedLockingIssueResolution: "+counter2);
    }

}
