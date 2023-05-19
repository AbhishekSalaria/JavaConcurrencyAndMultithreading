package org.multithreading;

// Making Thread By Extending the Thread Class
public class Runner2 extends Thread{
    @Override
    public void run() {
        for(int i=0;i<5;i++) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Runner2: "+ i);
        }
    }
}
