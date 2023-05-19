package org.multithreading;

public class Main {
    public static void main(String[] args) {

        Thread t1 = new Thread(new Runner1());
        Thread t2 = new Runner2();
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<5;i++) {
                    System.out.println("Runner3: "+ i);
                }
            }
        });
        Thread t4 = new Thread(new DaemonThread());
        t4.setDaemon(true);

        Thread t5 = new Thread(new SynchronizedKeyword());
        Thread t6 = new Thread(new SynchronizedBlock());
        Thread t7 = new Thread(new SynchronizedLockingIssueResolution());

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        // Wait for these threads to finish before executing println line: join().
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finished with Execution...");
    }
    }