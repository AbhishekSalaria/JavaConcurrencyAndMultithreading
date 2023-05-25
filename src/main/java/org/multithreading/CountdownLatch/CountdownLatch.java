package org.multithreading.CountdownLatch;

import java.util.concurrent.CountDownLatch;

/*
* Initial count is given to CountDownLatch object, any task that calls await() on that object will block
* until the count reaches to zero.
*
* Other tasks may call countDown() on the object to reduce the count, presumably when a task finishes its job.
*
* CountDownLatch -> counter can't be reset !!! (CyclicBarrier can be used instead for reset.)
*
* Tasks that call countDown() are not blocked when they make that call. Only the call to await()
* is blocked until the count reaches zero.
* */
public class CountdownLatch implements Runnable{

    private int id;
    private CountDownLatch countDownLatch;

    public CountdownLatch(int id,CountDownLatch countDownLatch){
        this.id = id;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        doWork();
        countDownLatch.countDown();
    }

    private void doWork() {
        System.out.println("Thread with id "+this.id+" starts working...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
