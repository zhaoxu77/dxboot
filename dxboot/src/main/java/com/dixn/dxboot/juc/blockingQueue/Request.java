package com.dixn.dxboot.juc.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

public class Request {

    public static ArrayBlockingQueue<Data> queue = new ArrayBlockingQueue<Data>(10);

    public static class InnerSingleton {
        private static Request request = new Request();
    }

    public static Request getInstance() {
        return InnerSingleton.request;
    }

    public void put(Data data) throws InterruptedException {
        queue.put(data);
    }

    public Data take() throws InterruptedException {
        return queue.take();
    }

}
