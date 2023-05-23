package org.multithreading.VolatileKeyword;

public class Executor {

    public static void main(String args[]) {

        Volatile worker = new Volatile();

        Thread t1 = new Thread(worker);
        t1.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        worker.setTerminated(true);
        System.out.println("Algorithm is terminated...");
    }
}
