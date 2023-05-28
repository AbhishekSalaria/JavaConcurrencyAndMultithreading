package org.multithreading.PriorityblockingQueue.ForStrings;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Executor {
    public static void main(String[] args) {

        BlockingQueue<String> queue = new PriorityBlockingQueue<>();

        new Thread(new PriorityblockingQueueWorker1(queue)).start();
        new Thread(new PriorityblockingQueueWorker2(queue)).start();
    }
}
