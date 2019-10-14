package ru.eugene.java.learn.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ru.eugene.java.learn.config.SpringConfiguration;
import ru.eugene.java.learn.data.dto.AutomobileDTO;
import ru.eugene.java.learn.util.DTOUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AutomobileServiceTest {
    @Autowired
    private IAutomobileService automobileService;

    @Test
    public void updateTest(){
        AutomobileDTO automobileDTO = DTOUtils.createAutomobileDTO("Audi", "S8", "9090-MM");

        automobileDTO = automobileService.create(automobileDTO);
        Assert.assertNotNull(automobileDTO);
        Assert.assertNotNull(automobileDTO.getId());

        automobileDTO.setStateNumber("7070-AA");

        automobileDTO = automobileService.update(automobileDTO);
        Assert.assertNotNull(automobileDTO);
        Assert.assertEquals("7070-AA", automobileDTO.getStateNumber());
    }

    @Test
    public void getByStateNumberTest(){
        AutomobileDTO automobileDTO = DTOUtils.createAutomobileDTO("Audi", "S8", "9090-MM");

        automobileDTO = automobileService.create(automobileDTO);
        Assert.assertNotNull(automobileDTO);
        Assert.assertNotNull(automobileDTO.getId());

        AutomobileDTO foundedByStateNumber = automobileService.getByStateNumber("9090-MM");
        Assert.assertNotNull(foundedByStateNumber);
    }
}