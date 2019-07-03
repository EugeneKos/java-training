package ru.eugene.java.learn.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.eugene.java.learn.config.SpringConfiguration;
import ru.eugene.java.learn.data.CarService;
import ru.eugene.java.learn.service.ICarServiceService;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class CarServiceServiceImplTest {
    @Autowired
    private ICarServiceService carServiceService;

    @Test
    public void testCreate(){
        CarService carService = carServiceService.create("kotmar-auto");
        assertNotNull("car service not null", carService);
    }

    @Test
    public void testGetByName(){
        CarService carService = carServiceService.getByName("kotmar-auto");
        assertNotNull(carService);
    }
}