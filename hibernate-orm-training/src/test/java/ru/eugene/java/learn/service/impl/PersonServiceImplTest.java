package ru.eugene.java.learn.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.eugene.java.learn.config.SpringConfiguration;
import ru.eugene.java.learn.data.Person;
import ru.eugene.java.learn.service.IPersonService;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class PersonServiceImplTest {
    @Autowired
    private IPersonService personService;

    @Test
    public void testCreate(){
        Person person = personService.create("Eugene", "Kosinov");
        assertNotNull("person not null", person);
    }

    @Test
    public void testGetById(){
        Person person = personService.getById(2L);
        assertNotNull(person);
        assertNotNull(person.getAutomobiles());
        //System.out.println(person.getAutomobiles());
        System.out.println(person.getPassport());
    }
}