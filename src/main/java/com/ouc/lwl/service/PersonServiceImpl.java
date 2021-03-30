package com.ouc.lwl.service;

import com.ouc.lwl.dao.PersonDao;

public class PersonServiceImpl implements  PersonService{

    private PersonDao personDao;

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }
    @Override
    public void addPerson() {
        personDao.add(); // 调用PersonDao中的add()方法
        System.out.println("addPerson()执行了...");
    }
}
