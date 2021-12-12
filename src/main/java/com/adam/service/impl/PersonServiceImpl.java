package com.adam.service.impl;


import com.adam.context.LoginContext;
import com.adam.service.PersonService;
import com.adam.shopping.Person;

public class PersonServiceImpl implements PersonService {
    @Override
    public void login(Person person) {
        if (!LoginContext.hasLogin()) {
            LoginContext.login(person);
        }
    }
}
