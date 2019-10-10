package ru.eugene.java.learn.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ru.eugene.java.learn.config.SpringConfiguration;
import ru.eugene.java.learn.data.Person;
import ru.eugene.java.learn.repository.PersonRepository;
import ru.eugene.java.learn.util.EntityUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class PersonServiceTest {
    @Autowired
    private IPersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void getByLoginTest(){
        String login = "zero";

        Person person = createAndSave("Eugene", "Kosinov", login);
        Assert.assertNotNull(person);

        person = personService.getByLogin(person.getLogin());
        Assert.assertNotNull(person);
        Assert.assertEquals(login, person.getLogin());
    }

    private Person createAndSave(String name, String surname, String login){
        Person person = EntityUtils.createPerson(name, surname, login);
        return personRepository.saveAndFlush(person);
    }
}