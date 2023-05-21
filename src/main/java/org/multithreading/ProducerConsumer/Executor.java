package org.multithreading.ProducerConsumer;


import org.multithreading.ProducerConsumer.ProducerConsumerSingleLock;

public class Executor {
    public static void main(String[] args) {
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

        t10.start();
        t11.start();
    }
}