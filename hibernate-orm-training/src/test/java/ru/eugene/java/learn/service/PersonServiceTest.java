package ru.eugene.java.learn.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ru.eugene.java.learn.config.SpringConfiguration;
import ru.eugene.java.learn.data.dto.PersonDTO;
import ru.eugene.java.learn.util.DTOUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class PersonServiceTest {
    @Autowired
    private IPersonService personService;

    @Test
    public void updateTest(){
        PersonDTO personDTO = DTOUtils.createPersonDTO("Eugene", "Kosinov", "Kos123");

        personDTO = personService.create(personDTO);
        Assert.assertNotNull(personDTO);
        Assert.assertNotNull(personDTO.getId());

        personDTO.setSurname("Modychev");

        personDTO = personService.update(personDTO);
        Assert.assertNotNull(personDTO);
        Assert.assertEquals("Modychev", personDTO.getSurname());
    }

    @Test
    public void getByLoginTest(){
        PersonDTO personDTO = DTOUtils.createPersonDTO("Eugene", "Kosinov", "Kos123");

        personDTO = personService.create(personDTO);
        Assert.assertNotNull(personDTO);
        Assert.assertNotNull(personDTO.getId());

        PersonDTO foundedByLogin = personService.getByLogin("Kos123");
        Assert.assertNotNull(foundedByLogin);
    }

    @Test
    public void deleteByLoginTest(){
        PersonDTO personDTO = DTOUtils.createPersonDTO("Eugene", "Kosinov", "Kos123");

        personDTO = personService.create(personDTO);
        Assert.assertNotNull(personDTO);
        Assert.assertNotNull(personDTO.getId());
        Assert.assertNotNull(personDTO.getLogin());

        personService.deleteByLogin(personDTO.getLogin());

        personDTO = personService.getByLogin(personDTO.getLogin());
        Assert.assertNull(personDTO);
    }
}