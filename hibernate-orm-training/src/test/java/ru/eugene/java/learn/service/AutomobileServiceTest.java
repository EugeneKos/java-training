package ru.eugene.java.learn.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ru.eugene.java.learn.config.SpringConfiguration;
import ru.eugene.java.learn.data.Automobile;
import ru.eugene.java.learn.repository.AutomobileRepository;
import ru.eugene.java.learn.util.EntityUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AutomobileServiceTest {
    @Autowired
    private IAutomobileService automobileService;

    @Autowired
    private AutomobileRepository automobileRepository;

    @Test
    public void getByStateNumberTest(){
        String stateNumber = "x9090MM";

        Automobile automobile = createAndSave("Audi", "S8", stateNumber);
        Assert.assertNotNull(automobile);

        automobile = automobileService.getByStateNumber(stateNumber);
        Assert.assertNotNull(automobile);
        Assert.assertEquals(stateNumber, automobile.getStateNumber());
    }

    private Automobile createAndSave(String mark, String model, String stateNumber){
        Automobile automobile = EntityUtils.createAutomobile(mark, model, stateNumber);
        return automobileRepository.saveAndFlush(automobile);
    }
}