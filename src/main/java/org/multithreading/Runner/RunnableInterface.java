package org.multithreading.Runner;

// Making Thread By implementing the Runnable Interface
public class RunnableInterface implements Runnable{
    @Override
    public void run() {
        for(int i=0;i<5;i++) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runnable Interface: "+ i);
        }
    }
}
