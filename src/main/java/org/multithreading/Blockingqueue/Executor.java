package org.multithreading.Blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Executor {
    public static void main(String[] args) {
        BlockingQueue blockingQueue = new ArrayBlockingQueue<>(10);

        BlockingQueueWorker1 worker1 = new BlockingQueueWorker1(blockingQueue);
        BlockingQueueWorker2 worker2 = new BlockingQueueWorker2(blockingQueue);

        new Thread(worker1).start();
        new Thread(worker2).start();
    }
}
