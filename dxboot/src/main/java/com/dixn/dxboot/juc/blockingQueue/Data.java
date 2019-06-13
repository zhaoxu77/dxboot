package com.dixn.dxboot.juc.blockingQueue;

import java.io.Serializable;

public class Data<T> implements Serializable {
    private T data;

    public Data(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Data{" +
            "data=" + data +
            '}';
    }
}