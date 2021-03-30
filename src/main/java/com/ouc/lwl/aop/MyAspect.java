package com.ouc.lwl.aop;

/**
 * @author Li Wenlong
 * @since 2021/3/25
 */
public class MyAspect {
    public void myBefore() {
        System.out.println("方法执行之前");
    }
    public void myAfter() {
        System.out.println("方法执行之后");
    }
}
