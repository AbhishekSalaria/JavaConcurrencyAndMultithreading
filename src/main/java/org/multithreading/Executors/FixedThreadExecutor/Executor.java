package org.multithreading.Executors.FixedThreadExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor {

    public static void main(String[] args) {
        // Executor with 2 threads in the pool
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for(int i=0;i<5;i++) {
            executorService.execute(new FixedThreadExecutor(i));
        }
        executorService.shutdown();
    }
}
