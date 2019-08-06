package com.dixn.dxboot.juc.future;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client2 {
    public static void main(String[] args) {
        ExecutorService threadpool = Executors.newFixedThreadPool(3);
        final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        System.out.println("提交一个callable任务到线程池，现在时间是：" + sdf.format(new Date()));
        Future<String> future = threadpool.submit(new CallableTask());
        try {
            System.out.println("获取callable任务的结果：" + future.get() + "，现在时间是：" + sdf.format(new Date()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            if(threadpool!=null){
                threadpool.shutdown();
            }
        }
    }
}
