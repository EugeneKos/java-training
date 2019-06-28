package ru.eugene.java.learn.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.eugene.java.learn.config.SpringConfiguration;
import ru.eugene.java.learn.service.IBindService;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class BindServiceImplTest {
    @Autowired
    private IBindService bindService;

    @Test
    public void testBindAutomobileToPerson(){
        bindService.bindAutomobileToPerson(102L, 1L);
    }

    @Test
    public void testUnbindAutomobileFromPerson(){
        bindService.unbindAutomobileFromPerson(102L);
    }

    @Test
    public void testBindAutomobileToCarService(){
        bindService.bindAutomobileToCarService(102L, 52L);
        bindService.bindAutomobileToCarService(152L, 52L);
    }

    @Test
    public void testUnbindAutomobileFromCarService(){
        bindService.unbindAutomobileFromCarService(102L, 52L);
    }
}