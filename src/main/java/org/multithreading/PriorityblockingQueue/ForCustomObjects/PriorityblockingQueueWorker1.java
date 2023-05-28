package org.multithreading.PriorityblockingQueue.ForCustomObjects;

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

    private BlockingQueue<Person> blockingQueue;

    public PriorityblockingQueueWorker1(BlockingQueue<Person> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        try {
            blockingQueue.put(new Person(10,"first"));
            blockingQueue.put(new Person(35,"second"));
            blockingQueue.put(new Person(12,"third"));
            Thread.sleep(1000);
            blockingQueue.put(new Person(11,"fourth"));
            Thread.sleep(1000);
            blockingQueue.put(new Person(3,"fifth"));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
