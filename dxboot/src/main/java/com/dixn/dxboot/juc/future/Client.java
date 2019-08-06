package com.dixn.dxboot.juc.future;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(new ShortTask());
        executorService.submit(new ShortTask());
        executorService.submit(new LongTask());
        executorService.submit(new ShortTask());
        executorService.shutdown();
        boolean isShutdown = executorService.isShutdown();
        System.out.println("线程池是否已经关闭：" + isShutdown);
        final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        try {
            while (!executorService.awaitTermination(1L, TimeUnit.SECONDS)){
                System.out.println("线程池中还有任务在执行，当前时间：" + sdf.format(new Date()));
            }
            System.out.println("线程池中已经没有在执行的任务，线程池已完全关闭！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
