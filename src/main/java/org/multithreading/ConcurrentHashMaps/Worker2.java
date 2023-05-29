package org.multithreading.ConcurrentHashMaps;

import java.util.concurrent.ConcurrentMap;

public class Worker2 implements Runnable{

    private ConcurrentMap<String,Integer> map;

    public Worker2(ConcurrentMap<String, Integer> map) {
        this.map = map;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(5000);
            System.out.println(map.get("A"));
            Thread.sleep(1000);
            System.out.println(map.get("E"));
            System.out.println(map.get("C"));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}