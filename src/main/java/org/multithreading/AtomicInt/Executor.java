package org.multithreading.AtomicInt;

public class Executor {
    public static void main(String[] args) {
        AtomicInt atomicInt = new AtomicInt();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                atomicInt.increment();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                atomicInt.increment();
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

        System.out.println("Counter: " + atomicInt.counter);
    }
}
