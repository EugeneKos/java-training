package ru.eugene.java.learn.service.impl;



import org.junit.Before;
import org.junit.Test;
import ru.eugene.java.learn.data.EncryptModel;
import ru.eugene.java.learn.service.EncryptService;
import ru.eugene.java.learn.service.EncryptServiceCreator;

import java.util.Arrays;

import static org.junit.Assert.*;

public class EncryptServiceImplTest {
    private EncryptService encryptService;

    @Before
    public void init(){
        EncryptServiceCreator creator = new EncryptServiceImplCreator();
        encryptService = creator.createEncryptService("KeyPass123456");
    }

    @Test
    public void testStringObject(){
        String test = "Test String 1234";

        EncryptModel<String> model = encryptService.encrypt("test", test, String.class);
        System.out.println(Arrays.toString(model.getEncryptData()));

        String decryptTest = encryptService.decrypt(model);

        assertEquals(test, decryptTest);
    }

    @Test
    public void testLongObject(){
        Long l = 23L;

        EncryptModel<Long> model = encryptService.encrypt("num", l, Long.class);

        Long ll = encryptService.decrypt(model);

        assertEquals(l, ll);
    }
}
