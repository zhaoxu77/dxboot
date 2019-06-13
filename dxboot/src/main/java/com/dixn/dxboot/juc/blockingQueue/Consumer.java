package com.dixn.dxboot.juc.blockingQueue;

public class Consumer implements Runnable {

    @Override
    public void run() {
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
