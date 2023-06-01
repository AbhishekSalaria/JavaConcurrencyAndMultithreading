package org.multithreading.ParallelMergeSort;

public class Executor {
    public static void main(String[] args) {
        int arr[] = {3,5,6,2,1,45,-2,4,-54,12,454,-343,34};

        int numberOfThreads = Runtime.getRuntime().availableProcessors();
        MergeSort mergeSort = new MergeSort(arr);
        mergeSort.parallelMergeSort(0,arr.length-1,numberOfThreads);
        mergeSort.showResult();
    }
}
