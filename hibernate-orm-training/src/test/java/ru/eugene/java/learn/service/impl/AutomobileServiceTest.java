package ru.eugene.java.learn.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.eugene.java.learn.config.SpringConfiguration;
import ru.eugene.java.learn.data.Automobile;
import ru.eugene.java.learn.service.IAutomobileService;

import java.util.List;

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
    public void testGetByStateNumber(){
        Automobile automobile = automobileService.getByStateNumber("о005АА77");
        assertNotNull("automobile not null", automobile);
    }

    @Test
    public void testGetAllAutomobileByPersonCode(){
        List<Automobile> automobiles = automobileService.getAllAutomobilesByPersonCode("code_14");
        assertNotNull(automobiles);
        assertEquals("automobile size by person code", 1, automobiles.size());
    }
}