package org.multithreading;

//Runs in background
//Automatically Stops Execution when last working thread finishes its task
public class DaemonThread implements Runnable{
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Executing Daemon Thread");
        }
    }
}
