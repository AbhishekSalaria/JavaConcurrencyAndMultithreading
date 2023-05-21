package org.multithreading.LockNotify;


import org.multithreading.LockNotify.LockandNotify;

public class Executor {
    public static void main(String[] args) {
        LockandNotify process = new LockandNotify();

        Thread t8 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t9 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t8.start();
        t9.start();
    }
}