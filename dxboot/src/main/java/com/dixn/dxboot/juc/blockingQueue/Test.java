package com.dixn.dxboot.juc.blockingQueue;

public class Test {

    public static void main(String[] args) {

        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        new Thread(producer).start();
        new Thread(consumer).start();

    }
}
