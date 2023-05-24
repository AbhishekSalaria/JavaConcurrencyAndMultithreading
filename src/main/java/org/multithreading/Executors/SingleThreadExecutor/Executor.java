package org.multithreading.Executors.SingleThreadExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Executor {

    public static void main(String[] args) {
        // Single thread is going to execute the task one after another
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for(int i=0;i<5;i++) {
            executorService.execute(new SingleThreadExecutor(i));
        }

        // we prevent the executor to execute any further tasks, but current tasks will be completed.
        executorService.shutdown();

        // NOTE:- It won't execute all the thread, if they don't complete before timeout.
        // terminate actual (running) tasks. (Forceful Termination after timeout).
        try {
            if(!executorService.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

    }
}
