package org.multithreading.Executors.ScheduledExecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Executor {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(1);

        // it will execute ScheduledExecuter every 2 seconds until stopped.
        scheduledExecutor.scheduleAtFixedRate(new ScheduledExecutor(),1000,2000, TimeUnit.MILLISECONDS);
    }
}
