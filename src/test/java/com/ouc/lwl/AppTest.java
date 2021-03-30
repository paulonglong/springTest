package com.ouc.lwl;

import static org.junit.Assert.assertTrue;

import com.ouc.lwl.dao.PersonDao;
import com.ouc.lwl.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public void springAop() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        PersonDao personDao = (PersonDao) applicationContext.getBean("personDaoProxy");
        personDao.add();
    }

    public void aspectJAop() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        PersonDao personDao = (PersonDao) applicationContext.getBean("personDao");
        personDao.add();
    }

    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        AccountService accountService = (AccountService) applicationContext.getBean("accountService");
        accountService.transfer("zhangsan", "lisi", 100);
    }
}
