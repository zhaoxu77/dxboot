package com.dixn.dxboot.juc.design;

public class CollectProcess extends ProcessHook {
    @Override
    public void process2() {
        System.out.println("collect process2");
    }

    @Override
    public void process3() {
        System.out.println("collect process3");
    }
}
