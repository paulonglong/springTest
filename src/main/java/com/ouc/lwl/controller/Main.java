package com.ouc.lwl.controller;

import com.ouc.lwl.dao.PersonDao;
import com.ouc.lwl.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Li Wenlong
 * @since 03.25.2021
 */
public class Main {
    public static void main(String[] args) {
        // 1 创建Spring的ioc容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        // 从ioc容器对象中获取bean实例
        HelloWorld helloWorld = (HelloWorld) applicationContext.getBean("helloWorld");
        helloWorld.hello();

        // 通过容器获取personDao实例
        PersonDao personDao = (PersonDao) applicationContext.getBean("personDao");
        // 调用 personDao 的 add ()方法
        personDao.add();

        // 通过容器获取personService实例
        PersonService personService = (PersonService) applicationContext.getBean("personService");
        // 调用personService的addPerson()方法
        personService.addPerson();
    }
}
