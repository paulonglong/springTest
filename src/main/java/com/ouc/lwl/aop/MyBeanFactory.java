package com.ouc.lwl.aop;

import com.ouc.lwl.dao.PersonDao;
import com.ouc.lwl.dao.PersonDaoImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Li Wenlong
 * @since 2021/3/25
 */
public class MyBeanFactory {
    public static PersonDao getJdkBean() {
        // 准备目标类
        final PersonDao personDao = new PersonDaoImpl();
        // 创建切面类实例
        final MyAspect myAspect = new MyAspect();

        // 使用代理类，进行增强
        return (PersonDao) Proxy.newProxyInstance(
                MyBeanFactory.class.getClassLoader(),
                new Class[]{PersonDao.class}, new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method,
                                         Object[] args) throws Throwable {
                        myAspect.myBefore(); // 前增强
                        Object obj = method.invoke(personDao, args);
                        myAspect.myAfter(); // 后增强
                        return obj;
                    }
                });
    }

    public static GoodsDao getCglibBean() {
        // 准备目标类
        final GoodsDao goodsDao = new GoodsDao();
        // 创建切面类实例
        final MyAspect myAspect = new MyAspect();
        // 生成代理类，CGLIB在运行时，生成指定对象的子类，增强
        Enhancer enhancer = new Enhancer();
        // 确定需要增强的类
        enhancer.setSuperclass(goodsDao.getClass());
        // 添加回调函数
        enhancer.setCallback(new MethodInterceptor() {
            // intercept 相当于 jdk invoke，前三个参数与 jdk invoke—致
            @Override
            public Object intercept(Object proxy, Method method, Object[] args,
                                    MethodProxy methodProxy) throws Throwable {
                myAspect.myBefore(); // 前增强
                Object obj = method.invoke(goodsDao, args); // 目标方法执行
                myAspect.myAfter(); // 后增强
                return obj;
            }
        });
        // 创建代理类
        GoodsDao goodsDaoProxy = (GoodsDao) enhancer.create();
        return goodsDaoProxy;
    }

    public static void main(String[] args) {
        MyBeanFactory.getJdkBean().add();

        MyBeanFactory.getCglibBean().add();
    }
}

