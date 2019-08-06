package com.dixn.dxboot.juc.blockingQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) {

        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        executorService.submit(producer);
        executorService.submit(consumer);

//        new Thread(producer).start();
//        new Thread(consumer).start();

    }
}
