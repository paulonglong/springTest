package com.ouc.lwl.aop.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author Li Wenlong
 * @since 2021/3/25
 */
public class MyAspect implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        System.out.println("方法执行之前aop");
        // 执行目标方法
        Object obj = mi.proceed();
        System.out.println("方法执行之后aop");
        return obj;
    }
}