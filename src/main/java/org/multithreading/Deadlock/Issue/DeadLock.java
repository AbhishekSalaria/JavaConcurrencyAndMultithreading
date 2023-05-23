package org.multithreading.Deadlock.Issue;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
* Deadlock occurs when workers try to acquire the lock in reverse order.
* like, worker1 -> lock1 then lock2
* worker2 -> lock2 then lock1
* */

public class DeadLock {

    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public void worker1() {
        lock1.lock();
        System.out.println("Worker1 acquires the lock1...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lock2.lock(); // Not Acquired (Waiting for worker2 to release lock2)
        System.out.println("Worker1 will not be Able to acquire lock2 (Deadlocked)...");

        lock1.unlock();
        lock2.unlock();
    }

    public void worker2() {
        lock2.lock();
        System.out.println("Worker2 acquires the lock2...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lock1.lock(); // Not Acquired (Waiting for worker1 to release lock1)
        System.out.println("Worker2 will not be Able to acquire lock1 (Deadlocked)...");

        lock2.unlock();
        lock1.unlock();
    }
}
