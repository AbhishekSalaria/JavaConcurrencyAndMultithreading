package org.multithreading.DiningPhilosopherProblem;

import java.util.Random;

public class Philosopher implements Runnable{

    private  int id;
    private volatile boolean full;
    private Chopstick leftChopStick;
    private Chopstick rightChopStick;
    private Random random;
    private  int eatingCounter;

    public Philosopher(int id, Chopstick leftChopStick, Chopstick rightChopStick) {
        this.id = id;
        this.leftChopStick = leftChopStick;
        this.rightChopStick = rightChopStick;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            // after eating a lot(1000) then we will terminate the given thread.
            while (!full) {
                think();
                if(leftChopStick.pickUp(this,State.LEFT)) {
                    // Philosopher is able to acquire the left chopstick
                    if(rightChopStick.pickUp(this,State.RIGHT)) {
                        // Philosopher is able to acquire the right chopstick
                        eat();
                        rightChopStick.putDown(this,State.RIGHT);
                    }
                    leftChopStick.putDown(this,State.LEFT);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void think() throws InterruptedException {
        System.out.println(this+ " is thinking...");
        // Think for a random amount of time
        Thread.sleep(random.nextInt(1000));
    }

    private void eat() throws InterruptedException {
        System.out.println(this+ " is eating...");
        eatingCounter += 1;
        // Eat for a random amount of time
        Thread.sleep(random.nextInt(1000));
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public boolean isFull() {
        return this.full;
    }

    public int getEatingCounter() {
        return this.eatingCounter;
    }

    @Override
    public String toString() {
        return "Philosopher " + id;
    }
}
