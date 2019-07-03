package ru.eugene.java.learn.service.impl;

import org.junit.Ignore;
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
        bindService.bindAutomobileToPerson("о005АА77", "code_14");
    }

    @Test
    public void testUnbindAutomobileFromPerson(){
        bindService.unbindAutomobileFromPerson("о005АА77");
    }

    @Test
    public void testBindAutomobileToCarService(){
        bindService.bindAutomobileToCarService("о005АА77", "kotmar-auto");
    }

    @Test
    public void testUnbindAutomobileFromCarService(){
        bindService.unbindAutomobileFromCarService("о005АА77", "kotmar-auto");
    }

    @Test
    public void testBindPassportToPerson(){
        bindService.bindPassportToPerson("uin-120845-kosinov-0875", "code_14");
    }

    @Test
    public void testUnbindPassportFromPerson(){
        bindService.unbindPassportFromPerson("uin-120845-kosinov-0875");
    }
}