package org.multithreading.Livelock.Issue;

public class Executor {
    public static void main(String[] args) {
        LiveLock liveLock = new LiveLock();

        // after java 8 it is possible to create thread like this
        new Thread(liveLock::worker1,"worker1").start();
        new Thread(liveLock::worker2,"worker2").start();
    }
}