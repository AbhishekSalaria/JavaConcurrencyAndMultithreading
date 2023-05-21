package org.multithreading.Daemon;

import org.multithreading.Daemon.DaemonThread;

public class Executor {
    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0 ; i < 5; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Thread 1: " + i);
                }
            }
        });

        Thread t2 = new Thread(new DaemonThread());
        t2.setDaemon(true);

        t1.start();
        t2.start();
    }
}