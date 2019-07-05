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
        Person person = personService.create("Eugene", "Kosinov", "code_14");
        assertNotNull("person not null", person);
    }

    @Test
    public void testGetByCode(){
        Person person = personService.getByCode("code_14");
        assertNotNull(person);
    }

    @Test
    public void testDeleteByCode(){
        personService.deleteByCode("code_14");
    }
}