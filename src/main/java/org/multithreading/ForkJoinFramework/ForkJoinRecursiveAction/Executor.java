package org.multithreading.ForkJoinFramework.ForkJoinRecursiveAction;

import java.util.concurrent.ForkJoinPool;

/*
*  fork() asynchronously execute the given task in the pool
*         We can call this on RecursiveAction or RecursiveTask<T>
*
*  join() returns the result of the computation when it is done
*
*  invoke() execute the given task + return its result upon completion
* */
public class Executor {
    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());

        RecursiveActionClass recursiveActionClass = new RecursiveActionClass(120);
        pool.invoke(recursiveActionClass);

    }
}