package com.dixn.dxboot.java8.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    //姓名
    private String name;
    //年龄
    private Integer age;
    //性别
    private Integer sex;
    //所在省市
    private String address;
}