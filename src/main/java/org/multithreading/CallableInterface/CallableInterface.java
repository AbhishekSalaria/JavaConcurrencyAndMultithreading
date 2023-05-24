package org.multithreading.CallableInterface;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CallableInterface implements Callable<String> {

    private int id;

    public CallableInterface(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        TimeUnit.MILLISECONDS.sleep(1000);
        return "id:"+id;
    }
}
