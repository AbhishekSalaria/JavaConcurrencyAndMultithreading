package org.multithreading.Executors.SingleThreadExecutor;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public class SingleThreadExecutor implements Runnable {

    private int id;

    public  SingleThreadExecutor(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Task with id " + id +" is in work - Thread id: "+Thread.currentThread().getName());
        long duration = (long) (Math.random()*5);
        try {
            TimeUnit.SECONDS.sleep(duration); // Alternate to thread sleep
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // for forceful termination
        }
    }
}
