package org.multithreading.Executors.ScheduledExecutor;

import java.util.concurrent.TimeUnit;

public class ScheduledExecutor implements Runnable {

    @Override
    public void run() {
        System.out.println("Updating and Downloading Stock data from web...");
    }
}
