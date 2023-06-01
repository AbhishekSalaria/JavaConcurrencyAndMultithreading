package org.multithreading.ParallelSum;

import java.util.Random;

public class Executor {
    public static void main(String[] args) {

        int numberOfThreads = Runtime.getRuntime().availableProcessors();

        ParallelSum parallelSum = new ParallelSum(numberOfThreads);

        Random random = new Random();
        int []nums = new int[10000000];
        for(int i=0; i<nums.length; i++) {
            nums[i] = random.nextInt(100);
        }

        long start = System.currentTimeMillis();
        System.out.println("Sum is: " + parallelSum.sum(nums));
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end-start) + "ms.");
    }
}
