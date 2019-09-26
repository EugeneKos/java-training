package ru.eugene.java.learn.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import ru.eugene.java.learn.data.Automobile;

@Transactional
public class AutomobileRepositoryTest extends PersonAutomobileTestParent {
    @Test
    @Rollback
    public void findByStateNumberTest(){
        initDB();

        Automobile automobile = automobileRepository.findByStateNumber("state_number_1");
        Assert.assertNotNull(automobile);
        Assert.assertEquals("state_number_1", automobile.getStateNumber());
    }
}