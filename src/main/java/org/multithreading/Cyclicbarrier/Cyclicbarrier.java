package org.multithreading.Cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/*
* Latch -> Multiple threads can wait for each other.
*
* It is used to create group of tasks to perform work in parallel + wait until all are finished
* before moving on the next step.
*
* new CyclicBarrier(N) -> N threads will wait for each other.
*
* We cannot reuse latches (One-shot-events), but we can reuse CyclicBarriers -> reset().
*/
public class Cyclicbarrier implements Runnable{

    private int id;
    private Random random;
    private CyclicBarrier cyclicBarrier;

    public Cyclicbarrier(int id,CyclicBarrier cyclicBarrier) {
        this.id = id;
        this.random = new Random();
        this.cyclicBarrier = cyclicBarrier;
    }
    @Override
    public void run() {
        doWork();
    }

    private void doWork() {
        System.out.println("Thread with ID "+id+" starts the task...");
        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Thread with ID "+id+" finished...");

        try {
            cyclicBarrier.await();
            System.out.println("After await codes...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString(){
     return "" + this.id;
    }
    }