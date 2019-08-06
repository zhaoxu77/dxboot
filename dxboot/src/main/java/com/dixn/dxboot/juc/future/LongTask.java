package com.dixn.dxboot.juc.future;

import java.util.concurrent.TimeUnit;

public class LongTask implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(10l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
