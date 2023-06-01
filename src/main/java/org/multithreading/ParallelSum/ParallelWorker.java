package org.multithreading.ParallelSum;

public class ParallelWorker extends Thread{

    private int arr[];
    private int left;
    private int right;
    private int partialSum;

    public ParallelWorker(int[] arr, int left, int right) {
        this.arr = arr;
        this.left = left;
        this.right = right;
    }

    public int getPartialSum() {
        return this.partialSum;
    }

    @Override
    public void run() {
        this.partialSum = 0;

        for(int i=this.left; i < this.right;i++) {
            this.partialSum += this.arr[i];
        }
    }
}
