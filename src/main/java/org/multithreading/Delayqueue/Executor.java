package org.multithreading.Delayqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class Executor {

    public static void main(String[] args) {

        BlockingQueue<DelayedWorker> blockingQueue = new DelayQueue<>();

        try {
            blockingQueue.put(new DelayedWorker(1000, "This is the first message..."));
            blockingQueue.put(new DelayedWorker(10000, "This is the second message..."));
            blockingQueue.put(new DelayedWorker(4000, "This is the third message..."));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        while (!blockingQueue.isEmpty()) {
            try {
                System.out.println(blockingQueue.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
