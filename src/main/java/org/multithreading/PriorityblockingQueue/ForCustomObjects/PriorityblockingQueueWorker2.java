package org.multithreading.PriorityblockingQueue.ForCustomObjects;

import java.util.concurrent.BlockingQueue;
public class PriorityblockingQueueWorker2 implements Runnable{

    private BlockingQueue<Person> blockingQueue;

    public PriorityblockingQueueWorker2(BlockingQueue<Person> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(5000);
            System.out.println(blockingQueue.take());
            Thread.sleep(1000);
            System.out.println(blockingQueue.take());
            Thread.sleep(1000);
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
