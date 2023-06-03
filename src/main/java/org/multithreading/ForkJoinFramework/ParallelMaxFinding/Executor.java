package org.multithreading.ForkJoinFramework.ParallelMaxFinding;

import java.util.concurrent.ForkJoinPool;

public class Executor {
    public static final int THREASHOLD = 10;

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

        int nums[] = {3,454,545,445,6,627,67,62,767,8,788,232,2,23,243,4555};

        ParallelMaxFinding parallelMaxFinding = new ParallelMaxFinding(nums,0,15);

        System.out.println(forkJoinPool.invoke(parallelMaxFinding));
    }
}
