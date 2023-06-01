package org.multithreading.ParallelMergeSort;


// If the size of array is small like under a million then use sequential merge sort, it will be faster.
// If the size is more than that, then use parallel mergesort, that will be faster.
public class MergeSort {
    private int arr[];
    private int tempArr[];

    public MergeSort(int[] arr) {
        this.arr = arr;
        this.tempArr = new int[arr.length];
    }

    private Thread mergeSortParallel(int left, int right, int numOfThreads) {
       return new Thread() {
           @Override
           public void run() {
               parallelMergeSort(left,right,numOfThreads/2);
           }
       };
    }

    public void parallelMergeSort(int left, int right, int numberOfThreads) {
        if(numberOfThreads <= 1) {
            mergeSort(left,right);
            return;
        }
        int mid = (left + right) / 2;

        Thread leftSorter = mergeSortParallel(left,mid,numberOfThreads);
        Thread rightSorter = mergeSortParallel(mid + 1,right,numberOfThreads);

        leftSorter.start();
        rightSorter.start();

        try {
            leftSorter.join();
            rightSorter.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        merge(left,mid,right);
    }

    public void merge(int left, int mid, int right) {

        for(int i = left; i <= right; i++) {
            this.tempArr[i] = this.arr[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while ((i <= mid) && (j <= right)) {
            if(this.tempArr[i] <= this.tempArr[j]) {
                this.arr[k] = this.tempArr[i];
                i++;
            }
            else {
                this.arr[k] = this.tempArr[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            this.arr[k] = this.tempArr[i];
            i++;
            k++;
        }
        while (j <= right) {
            this.arr[k] = this.tempArr[j];
            j++;
            k++;
        }
    }

    public void mergeSort(int left, int right) {

        if(left >= right) {return;}

        int mid = (left + right)/2;

        mergeSort(left, mid);
        mergeSort(mid + 1, right);

        merge(left,mid, right);
    }

    public void showResult() {
        for (int num:this.arr) {
            System.out.print(num + " ");
        }
        System.out.println("");
    }
}
