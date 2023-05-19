package org.multithreading;

public class SynchronizedKeyword implements Runnable{

    public int counter = 0;

    // This method is only executed by one thread at a time
    public synchronized void increment() {
        counter += 1;
    }

    @Override
    public void run() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<100;i++) {
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i<100;i++) {
                    increment();
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

        System.out.println("SynchronizedKeyword: "+counter);
    }
}
