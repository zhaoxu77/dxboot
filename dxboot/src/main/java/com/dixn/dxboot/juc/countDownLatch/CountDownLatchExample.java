package com.dixn.dxboot.juc.countDownLatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        Service service = new Service(countDownLatch);

        Runnable task = () -> service.exec();

        for (int i=0; i<5; i++) {
            Thread thread = new Thread(task);
            thread.start();
        }

        System.out.println("main thread await. ");
        countDownLatch.await();
        System.out.println("main thread finishes await. ");
    }
}
