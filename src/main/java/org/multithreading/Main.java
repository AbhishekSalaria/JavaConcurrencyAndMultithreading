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

        ProducerConsumerSingleLock newProcess = new ProducerConsumerSingleLock();

        Thread t10 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    newProcess.producer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t11 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    newProcess.consumer();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        t11.start();
        // Wait for these threads to finish before executing println line: join().
        try {
            t8.join();
            t9.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finished with Execution...");
    }
}