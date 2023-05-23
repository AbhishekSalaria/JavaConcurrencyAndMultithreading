package org.multithreading.AtomicInt;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicInt {

    // Same way AtomicLong, AtomicBoolean etc. can be used.
    public AtomicInteger counter = new AtomicInteger(0);

    // No need to use synchronized keyword in method because AtomicInteger uses low level synchronization in order to avoid inconsistent states.
    public void increment() {
        for(int i=0; i<10000; i++) {
            counter.getAndIncrement();
        }
    }
}
