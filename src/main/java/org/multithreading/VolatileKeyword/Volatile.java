package org.multithreading.VolatileKeyword;

public class Volatile implements Runnable {

    // Using volatile keyword guarantees that CPU is not going to cache this variable.
    // Meaning, it will be stored and read from the main memory not cache.
    private  volatile boolean terminated;

    @Override
    public  void  run() {
        while (!terminated) {
            System.out.println("Volatile class is running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean isTerminated() {
        return terminated;
    }
    public void setTerminated(boolean terminated) {
        this.terminated = terminated;
    }
}
