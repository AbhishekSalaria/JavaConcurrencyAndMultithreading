package org.multithreading;

// Making Thread By implementing the Runnable Interface
public class Runner1 implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<5;i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runner1: "+ i);
        }
    }
}
