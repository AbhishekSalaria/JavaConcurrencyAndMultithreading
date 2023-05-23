package org.multithreading.Livelock.Issue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


// LiveLock thread are not blocked but they are too busy responding to each other to resume work.
// Resolution: Avoid cyclic dependencies.
public class LiveLock {

    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public void worker1() {
       while(true) {
           try {
               lock1.tryLock(50, TimeUnit.MILLISECONDS);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
           System.out.println("Worker1 acquires the lock1...");
           System.out.println("Worker1 tries to get lock2...");

           // tryLock() acquires the lock only if it's free at the time of invocation.
           if(lock2.tryLock()) {
                   System.out.println("Worker1 acquires the lock2...");
                   lock2.unlock();
           }
           else {
                   System.out.println("Worker1 can not acquire lock2...");
                   continue;
           }
           break;
       }
        lock1.unlock();
        lock2.unlock();
    }

    public void worker2() {
        while(true) {
            try {
                lock2.tryLock(50, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Worker2 acquires the lock2...");
            System.out.println("Worker2 tries to get lock1...");

            if(lock1.tryLock()) {
                    System.out.println("Worker2 acquires the lock1...");
                    lock1.unlock();
            }
            else {
                    System.out.println("Worker2 can not acquire lock1...");
                    continue;
            }
            break;
        }
        lock1.unlock();
        lock2.unlock();
    }
}
