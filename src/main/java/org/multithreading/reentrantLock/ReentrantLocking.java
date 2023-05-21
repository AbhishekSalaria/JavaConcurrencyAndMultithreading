package org.multithreading.reentrantLock;

/*
*  1) It has the same behaviour as the synchronized block + additional features
*  2) new ReentrantLock(boolean fairnessParameter) => if fairnessParameter == true, then longest waiting thread will get the lock, otherwise there is no access order !!!.
*  3) IMPORTANT: - We have to use try-catch block while dealing with critical section, that may throw exceptions.
*                - We call unlock() in the finally block !!!
* */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocking {

    public int counter = 0;
    public Lock lock = new ReentrantLock();

    public void increment() {

        lock.lock();

        try{
            // try finally or try catch is optional but its best practice.
            for(int i = 0; i < 10000; i++) {
                counter += 1;
            }
        }
        finally {
            // Unlocking the given lock no matter what to avoid deadlock.
            lock.unlock();
        }
    }
}