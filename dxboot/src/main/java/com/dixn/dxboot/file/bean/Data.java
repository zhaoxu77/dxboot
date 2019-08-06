package com.dixn.dxboot.file.bean;

public class Data implements Val {

    public String content;

    public void setValue(String value) {
        this.content = value;
    }

    @Override
    public Object value() {
        return content;
    }
}
