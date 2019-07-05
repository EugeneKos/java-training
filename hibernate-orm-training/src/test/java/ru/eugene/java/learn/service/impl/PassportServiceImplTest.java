package ru.eugene.java.learn.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.eugene.java.learn.config.SpringConfiguration;
import ru.eugene.java.learn.data.Passport;
import ru.eugene.java.learn.service.IPassportService;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class PassportServiceImplTest {
    @Autowired
    private IPassportService passportService;

    @Test
    public void testCreate(){
        Passport passport = passportService.create("uin-120845-kosinov-0875");
        assertNotNull("passport not null", passport);
    }

    @Test
    public void testGetByUIN(){
        Passport passport = passportService.getByUIN("uin-120845-kosinov-0875");
        assertNotNull(passport);
    }

    @Test
    public void testDeleteByUIN(){
        passportService.deleteByUin("uin-120845-kosinov-0875");
    }
}
