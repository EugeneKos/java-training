package ru.eugene.java.learn.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import ru.eugene.java.learn.data.Person;
import ru.eugene.java.learn.parent.PersonAutomobileTestParent;
import ru.eugene.java.learn.service.IPersonService;

import java.util.Set;

public class PersonServiceImplTest extends PersonAutomobileTestParent {
    @Autowired
    private IPersonService personService;

    @Test
    public void getAllWithAutomobileTest(){
        initDB();

        Set<Person> allWithAutomobiles = personService.getAllWithAutomobiles();
        Assert.assertNotNull(allWithAutomobiles);
    }
}