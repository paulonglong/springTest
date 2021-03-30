package com.ouc.lwl.controller;

/**
 * @author wlli
 * @date 2021-03-25
 */
public class HelloWorld {
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void hello() {
        System.out.println("hello   :  " + name + "  " + age);
    }
}
