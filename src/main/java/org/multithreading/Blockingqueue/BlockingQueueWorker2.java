package org.multithreading.Blockingqueue;

import java.util.concurrent.BlockingQueue;

public class BlockingQueueWorker2 implements Runnable{

    private BlockingQueue<Integer> blockingQueue;

    public BlockingQueueWorker2(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        while (true) {
            try {
                int number = blockingQueue.take();
                System.out.println("Taking item from the queue..."+number);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
