package com.dixn.dxboot.juc.design;

public abstract class ProcessHook {

    public final void prepareProcess() {
        process1();
        process2();
        process3();
        if (customerCondiments()) {
            process4();
        }
    }


    public abstract void process2();

    public abstract void process3();

    public final void process1() {
        System.out.println("process1");
    }

    public final void process4() {
        System.out.println("process4");
    }

    public boolean customerCondiments() {
        return true;
    }

}
