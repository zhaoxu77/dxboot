package com.dixn.dxboot.juc.future;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CallableTask implements Callable {
    @Override
    public Object call() throws Exception {
        TimeUnit.SECONDS.sleep(5L);
        return "success";
    }
}
