package ru.eugene.java.learn.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.eugene.java.learn.config.SpringConfiguration;
import ru.eugene.java.learn.data.Automobile;
import ru.eugene.java.learn.service.IAutomobileService;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class AutomobileServiceTest {
    @Autowired
    private IAutomobileService automobileService;

    @Test
    public void testCreate(){
        Automobile automobile = automobileService.create("Audi", "S8", "о005АА77");
        assertNotNull("automobile not null", automobile);
    }

    @Test
    public void testGetById(){
        Automobile automobile = automobileService.getById(1L);
        assertNotNull("automobile not null", automobile);
        assertNotNull(automobile.getPerson());
        System.out.println(automobile.getPerson());
        System.out.println(automobile.getCarServices());
    }
}