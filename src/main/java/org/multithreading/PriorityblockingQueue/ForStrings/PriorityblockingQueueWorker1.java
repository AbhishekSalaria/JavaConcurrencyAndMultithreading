package org.multithreading.PriorityblockingQueue.ForStrings;

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

    private BlockingQueue<String> blockingQueue;

    public PriorityblockingQueueWorker1(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        try {
            blockingQueue.put("B");
            blockingQueue.put("H");
            blockingQueue.put("F");
            Thread.sleep(1000);
            blockingQueue.put("A");
            Thread.sleep(1000);
            blockingQueue.put("E");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
