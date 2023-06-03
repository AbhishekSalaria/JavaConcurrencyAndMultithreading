package org.multithreading.ForkJoinFramework.ParallelMergeSort;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class ParallelMergeSort extends RecursiveAction {

    private int nums[];
    private int temp[];
    private int left;
    private int right;

    public ParallelMergeSort(int[] nums,int left,int right) {
        this.nums = nums;
        this.temp = new int[nums.length];
        this.left = left;
        this.right = right;
    }

    @Override
    protected void compute() {
        if((this.right - this.left) <= 10) {
            mergeSort(this.left,this.right);
            return;
        }
        int middleIndex = (this.left + this.right) / 2;

        ParallelMergeSort parallelMergeSort1 = new ParallelMergeSort(this.nums,this.left,middleIndex);
        ParallelMergeSort parallelMergeSort2 = new ParallelMergeSort(this.nums,middleIndex + 1, this.right);

        invokeAll(parallelMergeSort1,parallelMergeSort2);

        merge(this.left,middleIndex,this.right);
    }

    private void mergeSort(int left, int right) {
        if(left >= right) {
            return;
        }
        int middle = (left + right)/2;
        mergeSort(left,middle);
        mergeSort(middle+1,right);

        merge(left,middle,right);
    }

    private void merge( int left, int middle, int right) {

        for(int i = left; i <= right; i++) {
            this.temp[i] = this.nums[i];
        }

        int i = left;
        int j = middle + 1;
        int k = left;

        while ((i <= middle) && (j <= right)) {
            if(this.temp[i] <= this.temp[j]) {
                this.nums[k] = this.temp[i];
                i++;
                k++;
            }
            else {
                this.nums[k] = this.temp[j];
                j++;
                k++;
            }
        }

        while (i<=middle) {
            this.nums[k] = this.temp[i];
            i++;
            k++;
        }
        while (j<=right) {
            this.nums[k] = this.temp[j];
            j++;
            k++;
        }
    }
}
