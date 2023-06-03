package org.multithreading.ForkJoinFramework.ParallelMaxFinding;

import java.util.concurrent.RecursiveTask;

public class ParallelMaxFinding extends RecursiveTask<Integer> {

    private int[] nums;
    private int lowindex;
    private int highIndex;

    public ParallelMaxFinding(int[] nums, int lowindex, int highIndex) {
        this.nums = nums;
        this.lowindex = lowindex;
        this.highIndex = highIndex;
    }

    @Override
    protected Integer compute() {
        if(highIndex - lowindex < Executor.THREASHOLD) {
            return sequentialMaxFind();
        }
        else {
            int middleIndex = (lowindex + highIndex) /2;

            ParallelMaxFinding parallelMaxFinding1 = new ParallelMaxFinding(nums,lowindex,middleIndex);
            ParallelMaxFinding parallelMaxFinding2 = new ParallelMaxFinding(nums,middleIndex + 1,highIndex);

            // invokeAll(parallelMaxFinding1,parallelMaxFinding2) can also be used.
            parallelMaxFinding1.fork();
            parallelMaxFinding2.fork();

            int first = parallelMaxFinding1.join();
            int second = parallelMaxFinding2.join();

            return Math.max(first,second);
        }
    }

    private Integer sequentialMaxFind() {
        int max = nums[lowindex];

        for(int i = lowindex + 1; i<= highIndex; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}
