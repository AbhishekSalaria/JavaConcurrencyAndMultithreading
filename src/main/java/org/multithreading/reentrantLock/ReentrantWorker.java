package org.multithreading.reentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantWorker {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void producer() throws InterruptedException {
        lock.lock();
        System.out.println("Producer method...");
        condition.await();
        System.out.println("Producer again...");
        lock.unlock();
    }

    public void consumer() throws  InterruptedException {
        lock.lock();
        Thread.sleep(1000);
        System.out.println("Consumer method...");
        condition.signal();
        lock.unlock();
    }
}
