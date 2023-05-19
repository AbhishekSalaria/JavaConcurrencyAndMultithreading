package org.multithreading;

/*
* Issue with synchronized block and method is that it acquires
* class level intrinsic locking, so if there are two synchronized blocks
* Second won't be able to operate until first thread has released the class level lock
* Even if both are independent of each other.
* */

public class SynchronizedBlock implements Runnable{
    public int counter1 = 0;
    public int counter2 = 0;

    // This method is only executed by one thread at a time
    public void increment1() {
        // class level locking
        synchronized (SynchronizedBlock.class) {
            counter1 += 1;
        }
    }
    public void increment2() {
        // Object level locking
        synchronized (this) {
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

        System.out.println("SynchronizedBlock: "+counter1);
        System.out.println("SynchronizedBlock: "+counter2);
    }
}