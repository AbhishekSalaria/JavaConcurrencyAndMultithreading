package org.multithreading.ConcurrentHashMaps;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Executor {
    public static void main(String[] args) {

        ConcurrentMap<String,Integer> map = new ConcurrentHashMap<>();

        new Thread(new Worker1(map)).start();
        new Thread(new Worker2(map)).start();
    }
}
