package com.example.demo;

import lombok.Getter;


public enum Phone {

    //枚举的实质就是具有指定数量实例的类
    XIAOMI(1999, "FOXCONN", 2020),
    HUAWEI(3999, "BYD", 2019);

    //成员变量
    private int price;
    private String origin;
    private int age;

    //构造方法
    Phone(int price, String origin, int age) {
        this.price = price;
        this.origin = origin;
        this.age = age;
    }

    //getter
    public int price() {
        return price;
    }

    public String origin() {
        return origin;
    }

    public int age() {
        return age;
    }
}
