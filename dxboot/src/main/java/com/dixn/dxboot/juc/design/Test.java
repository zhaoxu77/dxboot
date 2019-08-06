package com.dixn.dxboot.juc.design;

public class Test {


    public static void main(String[] args) {

        CollectProcess collectProcess = new CollectProcess();
        ControlProcess controlProcess = new ControlProcess();

        collectProcess.prepareProcess();

        controlProcess.prepareProcess();
    }
}
