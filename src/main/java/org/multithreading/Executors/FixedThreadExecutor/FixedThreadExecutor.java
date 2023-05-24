package org.multithreading.Executors.FixedThreadExecutor;

import java.util.concurrent.TimeUnit;

public class FixedThreadExecutor implements Runnable {

    private int id;

    public FixedThreadExecutor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Task with id " + id +" is in work - Thread id: "+Thread.currentThread().getName());
        long duration = (long) (Math.random()*5);
        try {
            TimeUnit.SECONDS.sleep(duration); // Alternate to thread sleep
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
