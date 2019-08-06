package com.dixn.dxboot.juc.blockingQueue;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Callable {

    @Override
    public Object call() throws Exception {
        while (true) {
            String v = String.valueOf(ThreadLocalRandom.current().nextInt());
            Data data = new Data(v);
            try {
                Request.getInstance().put(data);
                System.out.println(Thread.currentThread().getName() + " produce :" + data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.yield();
        }
    }
}
