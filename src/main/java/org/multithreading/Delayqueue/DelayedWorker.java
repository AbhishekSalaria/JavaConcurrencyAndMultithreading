package org.multithreading.Delayqueue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/*
* This is an unbounded BlockingQueue of objects that implement the delayed interface
*
* DelayQueue keeps the elements internally until a certain delay has expired.
*
* an object can only be taken from the queue when its delay has expired !!!
*
* We cannot place null items in the queue - The queue are sorted so that the object at the head has a delay that has expired for the longest time.
*
* If no delay has expired, then there is no head element and poll() will return null
*
* size() returns the count of both expired and unexpired items !!!
* */
public class DelayedWorker implements Delayed {

    private long duration;
    private String message;

    public DelayedWorker(long duration, String message) {
        this.duration = System.currentTimeMillis() + duration;
        this.message = message;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(duration-System.currentTimeMillis(),TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if(this.duration < ((DelayedWorker) o).getDuration()) {
            return -1;
        }
        if(this.duration > ((DelayedWorker) o).getDuration()) {
            return +1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
