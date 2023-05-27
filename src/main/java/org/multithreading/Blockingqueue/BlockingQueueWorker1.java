package org.multithreading.Blockingqueue;

import java.util.concurrent.BlockingQueue;

/*
* BlockingQueue -> an interface the represents a queue that is thread safe.
* Put items or take items from it ...
*
* For example: one thread putting items into the queue and another thread taking items from it
*              at the same time. (can be done using Producer - Consumer Pattern)
*
* put() putting items to the queue.
* take() taking items from the queue.
* */
public class BlockingQueueWorker1 implements Runnable{

    private BlockingQueue<Integer> blockingQueue;

    public BlockingQueueWorker1(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        int counter = 0;

        while (true) {
            try {
                blockingQueue.put(counter);
                System.out.println("Putting items into the queue..."+counter);
                counter += 1;
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
