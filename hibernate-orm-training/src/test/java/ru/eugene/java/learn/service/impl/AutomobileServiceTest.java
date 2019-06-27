package ru.eugene.java.learn.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.eugene.java.learn.config.SpringConfiguration;
import ru.eugene.java.learn.data.Automobile;
import ru.eugene.java.learn.data.Person;
import ru.eugene.java.learn.repository.AutomobileRepository;
import ru.eugene.java.learn.service.IAutomobileService;
import ru.eugene.java.learn.service.IPersonService;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class AutomobileServiceTest {
    @Autowired
    private IAutomobileService automobileService;
    @Autowired
    private IPersonService personService;
    @Autowired
    private AutomobileRepository automobileRepository;

    @Test
    public void testCreate(){
        Person person = personService.create("Eugene", "Kosinov");
        assertNotNull("person not null", person);

        Automobile automobile = automobileService.create("Audi", "S8", "о004АА77");
        assertNotNull("automobile not null", automobile);

        automobile.setPerson(person);
        Automobile savedAutomobile = automobileRepository.save(automobile);
        assertNotNull(savedAutomobile);
    }
}