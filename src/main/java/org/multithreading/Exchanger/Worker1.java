package org.multithreading.Exchanger;

import java.util.concurrent.Exchanger;

/*
* With the help of Exchanger Class, two threads can exchange objects.
* exchange() method will be used for exchanging objects
* */
public class Worker1 implements Runnable{

    private  int counter;
    private Exchanger<Integer> exchanger;

    public Worker1(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {

        while (true) {
            counter = counter + 1;
            System.out.println("Worker1 incremented the counter: "+counter);
            try {
                counter = exchanger.exchange(counter);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
