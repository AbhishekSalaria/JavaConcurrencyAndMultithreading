package org.multithreading.Semaphores;

import java.util.concurrent.Semaphore;

/*
* semaphore maintains a set of permits
* acquire() -> if permit is available, then take it.
* release() -> adds a permit
* */

// Creating singleton class with enum
enum SemaPhore {
    INSTANCE;

    // At the same time only 3 threads can download data
    private Semaphore semaphore = new Semaphore(3,true);

    public void downloadData() {
        try {
            semaphore.acquire();
            download();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void download() {
        System.out.println("Downloading Data...");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            semaphore.release();
        }
    }
}
