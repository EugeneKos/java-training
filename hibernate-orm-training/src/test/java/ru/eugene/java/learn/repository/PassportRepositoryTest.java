package ru.eugene.java.learn.repository;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ru.eugene.java.learn.data.Passport;
import ru.eugene.java.learn.data.Person;
import ru.eugene.java.learn.parent.PersonPassportParentTest;

@Transactional
public class PassportRepositoryTest extends PersonPassportParentTest {
    @Test
    @Rollback
    public void findByNumberTest(){
        initDB();

        Passport passport = passportRepository.findByNumber("0456-234-ASFR");
        Assert.assertNotNull(passport);

        Person person = passport.getPerson();
        Assert.assertNotNull(person);
    }
}