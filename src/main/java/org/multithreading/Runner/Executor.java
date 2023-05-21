package org.multithreading.Runner;

import org.multithreading.Runner.ThreadClass;
import org.multithreading.Runner.RunnableInterface;

public class Executor {
    public static void main(String[] args) {

        Thread t1 = new Thread(new RunnableInterface());
        Thread t2 = new ThreadClass();
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<5;i++) {
                    System.out.println("Runner3: "+ i);
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();

        // Wait for these threads to finish before executing println line: join().
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finished with Execution...");
    }
}