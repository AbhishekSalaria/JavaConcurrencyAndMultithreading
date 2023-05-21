package org.multithreading;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerSingleLock {

    private List<Integer> list = new ArrayList<>();
    private static final int UPPER_LIMIT = 5;
    private static final int LOWER_LIMIT = 0;
    private final Object lock = new Object();
    private int value = 0;

    private int count = 0;

    public void producer() throws InterruptedException {
        synchronized (lock) {

            /*

            if while(true) in producer-consumer, it will run infinitely until stopped,
            it will keep on adding 0,1,2,4 and then removing 4,3,2,1,0 until manually stopped.
            So, that's why kept limit of 10, So it only performs cycle one time.

             */

            while (count<10) {
                if (list.size() == UPPER_LIMIT) {
                    System.out.println("Waiting for removing items...");
                    // Invoking wait() on lock not the ProducerConsumerSingleLock
                    lock.wait();
                }
                else {
                    System.out.println("Adding: "+value);
                    list.add(value++);
                    lock.notify();
                }
                count += 1;
            }
        }
    }

    public void consumer() throws InterruptedException {
        synchronized (lock) {
            while (count<10) {
                if (list.size() == LOWER_LIMIT) {
                    System.out.println("Waiting for adding items...");
                    value = 0;
                    // Invoking wait() on lock not the ProducerConsumerSingleLock
                    lock.wait();
                }
                else {
                    System.out.println("Removing: "+list.remove(list.size()-1));
                    lock.notify();
                }
                count += 1;
            }
        }
    }
}
