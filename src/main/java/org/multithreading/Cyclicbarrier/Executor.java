package org.multithreading.Cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Executor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("All the tasks are finished...");
            }
        });

        for(int i=1;i<=5;i++) {
            executorService.execute(new Cyclicbarrier(i,cyclicBarrier));
        }
        executorService.shutdown();
    }
}
