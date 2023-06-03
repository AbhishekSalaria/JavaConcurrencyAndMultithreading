package org.multithreading.ForkJoinFramework.ParallelMergeSort;

import java.util.concurrent.ForkJoinPool;

public class Executor {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

        int nums[] = {3,454,545,445,6,627,67,62,767,8,788,232,2,23,243,4555,56};

        ParallelMergeSort parallelMergeSort = new ParallelMergeSort(nums,0,16);

        forkJoinPool.invoke(parallelMergeSort);

        for(int num: nums) {
            System.out.print(num + " ");
        }
    }
}
