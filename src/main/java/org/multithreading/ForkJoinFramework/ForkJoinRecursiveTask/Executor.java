package org.multithreading.ForkJoinFramework.ForkJoinRecursiveTask;

import java.util.concurrent.ForkJoinPool;

public class Executor {
    public static void main(String[] args) {

        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

        RecursiveTaskClass recursiveTaskClass = new RecursiveTaskClass(120);
        System.out.println(forkJoinPool.invoke(recursiveTaskClass));
    }
}
