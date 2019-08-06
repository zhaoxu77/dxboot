package com.dixn.dxboot.juc.threadLocal;

import java.util.concurrent.TimeUnit;

public class ThreadLocalExample {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new MyThreadLocal<>();
        Runnable task1 = () -> {
            threadLocal.set("task1");
            sleep(2);
            threadLocal.get();
        };

        Runnable task2 = () -> {
            sleep(1);
            threadLocal.set("task2");
            sleep(2);
            threadLocal.get();
        };

        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        thread1.start();
        thread2.start();
    }

    private static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static final class MyThreadLocal<T> extends ThreadLocal<T> {
        @Override
        public T get() {
            T result = super.get();
            System.out.println(Thread.currentThread().getName() + " invoke get method, result is " + result);
            return result;
        }

        @Override
        public void set(T value) {
            System.out.println(Thread.currentThread().getName() + " invoke set method, value is " + value);
            super.set(value);
        }
    }
}