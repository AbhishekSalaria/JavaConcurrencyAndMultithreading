package org.multithreading.ForkJoinFramework.ForkJoinRecursiveTask;

import java.util.concurrent.RecursiveTask;

public class RecursiveTaskClass extends RecursiveTask<Integer> {

    private  int simulatedWork;

    public RecursiveTaskClass(int simulatedWork) {
        this.simulatedWork = simulatedWork;
    }

    @Override
    protected Integer compute() {
        if(simulatedWork > 100) {
            System.out.println("Parallel execution needed because of the huge task..." + simulatedWork);

            RecursiveTaskClass recursiveTaskClass1 = new RecursiveTaskClass(simulatedWork/2);
            RecursiveTaskClass recursiveTaskClass2 = new RecursiveTaskClass(simulatedWork/2);

            recursiveTaskClass1.fork();
            recursiveTaskClass2.fork();

            int solution = 0;
            solution += recursiveTaskClass1.join();
            solution += recursiveTaskClass2.join();

            return solution;
        }
        else {
            System.out.println("No need for parallel execution..." + simulatedWork);
            return 2*simulatedWork;
        }
    }
}
