package org.multithreading.Exchanger;
import java.util.concurrent.Exchanger;

public class Executor {
    public static void main(String[] args) {
        Exchanger<Integer> exchanger = new Exchanger<>();

        new Thread(new Worker1(exchanger)).start();
        new Thread(new Worker2(exchanger)).start();
    }
}
