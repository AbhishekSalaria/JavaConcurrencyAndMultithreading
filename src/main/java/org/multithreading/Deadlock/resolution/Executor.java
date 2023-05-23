package org.multithreading.Deadlock.resolution;

public class Executor {
    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();

        // after java 8 it is possible to create thread like this
        new Thread(deadLock::worker1,"worker1").start();
        new Thread(deadLock::worker2,"worker2").start();
    }
}
