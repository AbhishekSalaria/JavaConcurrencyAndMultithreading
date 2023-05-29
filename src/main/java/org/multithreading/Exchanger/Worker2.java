package org.multithreading.Exchanger;

import java.util.concurrent.Exchanger;

public class Worker2 implements Runnable{

    private  int counter;
    private Exchanger<Integer> exchanger;

    public Worker2(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {

        while (true) {
            counter = counter - 1;
            System.out.println("Worker2 decremented the counter: "+counter);
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
