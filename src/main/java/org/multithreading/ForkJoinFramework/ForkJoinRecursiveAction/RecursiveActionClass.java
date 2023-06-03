package org.multithreading.ForkJoinFramework.ForkJoinRecursiveAction;

import java.util.concurrent.RecursiveAction;

public class RecursiveActionClass extends RecursiveAction {

    private int simulateWork;

    public RecursiveActionClass(int simulateWork) {
        this.simulateWork = simulateWork;
    }

    @Override
    protected void compute() {

        if(simulateWork > 100) {

            System.out.println("Parallel execution and split task..."+simulateWork);

            RecursiveActionClass recursiveActionClass1 = new RecursiveActionClass(simulateWork/2);
            RecursiveActionClass recursiveActionClass2 = new RecursiveActionClass(simulateWork/2);

            recursiveActionClass1.fork();
            recursiveActionClass2.fork();
        }
        else {
            System.out.println("No need for parallel execution, sequential algorithm is OK "+simulateWork);
        }

    }
}
