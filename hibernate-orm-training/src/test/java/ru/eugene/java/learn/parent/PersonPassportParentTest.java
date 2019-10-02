package ru.eugene.java.learn.parent;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ru.eugene.java.learn.config.SpringConfiguration;
import ru.eugene.java.learn.data.Passport;
import ru.eugene.java.learn.data.Person;
import ru.eugene.java.learn.repository.PassportRepository;
import ru.eugene.java.learn.repository.PersonRepository;
import ru.eugene.java.learn.util.EntityUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class PersonPassportParentTest {
    @Autowired
    protected PersonRepository personRepository;

    @Autowired
    protected PassportRepository passportRepository;

    protected void initDB(){
        Person person = EntityUtils.createPerson("name_1", "surname_1", "code_1");
        personRepository.saveAndFlush(person);

        Passport passport = EntityUtils.createPassport("0456-234-ASFR", "77-908");
        passport.setPerson(person);

        passportRepository.saveAndFlush(passport);
    }
}
