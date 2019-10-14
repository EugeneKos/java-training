package ru.eugene.java.learn.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ru.eugene.java.learn.config.SpringConfiguration;
import ru.eugene.java.learn.data.dto.AutomobileDTO;
import ru.eugene.java.learn.data.dto.PersonDTO;
import ru.eugene.java.learn.util.DTOUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class BindAutomobileServiceTest {
    @Autowired
    private IPersonService personService;
    @Autowired
    private IAutomobileService automobileService;
    @Autowired
    private IBindAutomobileService bindAutomobileService;

    @Test
    public void bindUnbindAutomobileTest(){
        PersonDTO personDTO = DTOUtils.createPersonDTO("Eugene", "Kosinov", "Kos123");

        personDTO = personService.create(personDTO);
        Assert.assertNotNull(personDTO);

        AutomobileDTO automobileDTO = DTOUtils.createAutomobileDTO("Audi", "S8", "9090-MM");

        automobileDTO = automobileService.create(automobileDTO);
        Assert.assertNotNull(automobileDTO);

        bindAutomobileService.bindAutomobile(personDTO.getId(), automobileDTO.getId());

        bindAutomobileService.unbindAutomobile(automobileDTO.getId());
    }
}