package ru.eugene.java.learn.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ru.eugene.java.learn.data.Person;
import ru.eugene.java.learn.parent.PersonAutomobileTestParent;
import ru.eugene.java.learn.service.IPersonService;

import java.util.Set;

@Transactional
public class PersonServiceImplTest extends PersonAutomobileTestParent {
    @Autowired
    private IPersonService personService;

    @Test
    @Rollback
    public void getAllWithAutomobileTest(){
        initDB();

        Set<Person> allWithAutomobiles = personService.getAllWithAutomobiles();
        Assert.assertNotNull(allWithAutomobiles);
    }

    @Test
    @Rollback
    public void getByCodeTest(){
        initDB();

        Person person = personService.getByCode("code_1");
        Assert.assertNotNull(person);
    }
}