package org.multithreading.synchronization;

import org.multithreading.synchronization.SynchronizedBlock;
import org.multithreading.synchronization.SynchronizedKeyword;
import org.multithreading.synchronization.SynchronizedLockingIssueResolution;

public class Executor {
    public static void main(String[] args) {
        Thread t5 = new Thread(new SynchronizedKeyword());
        Thread t6 = new Thread(new SynchronizedBlock());
        Thread t7 = new Thread(new SynchronizedLockingIssueResolution());

        t5.start();
        t6.start();
        t7.start();

    }
}