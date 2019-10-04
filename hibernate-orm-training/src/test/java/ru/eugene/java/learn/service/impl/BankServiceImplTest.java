package ru.eugene.java.learn.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ru.eugene.java.learn.config.SpringConfiguration;
import ru.eugene.java.learn.data.Bank;
import ru.eugene.java.learn.data.Person;
import ru.eugene.java.learn.repository.PersonRepository;
import ru.eugene.java.learn.service.IBankService;
import ru.eugene.java.learn.util.EntityUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class BankServiceImplTest {
    @Autowired
    private IBankService bankService;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void addPersonToBankTest(){
        Person person = EntityUtils.createPerson("name_1", "surname_1", "code_1");
        person = personRepository.saveAndFlush(person);
        Assert.assertNotNull(person);

        Bank bank = bankService.create("SBER");
        Assert.assertNotNull(bank);

        bankService.addPersonToBank(bank.getName(), person);
        bankService.removePersonFromBank(bank.getName(), person.getCode());
    }
}