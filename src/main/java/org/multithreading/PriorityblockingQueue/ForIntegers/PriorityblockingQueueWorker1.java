package org.multithreading.PriorityblockingQueue.ForIntegers;

import java.util.concurrent.BlockingQueue;

/*
* It implements the blocking queue Interface
*
*  - unbounded concurrent queue
*  - It uses the same ordering rules as the PriorityQueue class -> Have to implement the Comparable interfacce
*       The comparable interface will determine what will be the order in the queue
*       The priority can be the same compare() == 0 case
*
*  - no null items !!!
* */
public class PriorityblockingQueueWorker1 implements Runnable{

    private BlockingQueue<Integer> blockingQueue;

    public PriorityblockingQueueWorker1(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        try {
            blockingQueue.put(7);
            blockingQueue.put(23);
            blockingQueue.put(2);
            Thread.sleep(1000);
            blockingQueue.put(1);
            Thread.sleep(1000);
            blockingQueue.put(34);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
