package com.dixn.dxboot.juc.blockingQueue;

import java.util.concurrent.Callable;

public class Consumer implements Callable {

    @Override
    public Object call() throws Exception {
        while (true) {
            try {
                Object obj = Request.getInstance().take();
                System.out.println(Thread.currentThread().getName() + " consume :" + obj.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.yield();
        }
    }
}
