package ru.eugene.java.learn.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.transaction.annotation.Transactional;
import ru.eugene.java.learn.config.SpringConfiguration;
import ru.eugene.java.learn.data.Bank;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class BankRepositoryTest {
    @Autowired
    private BankRepository bankRepository;

    @Test
    @Transactional
    @Rollback
    public void findByNameTest(){
        Bank bank = new Bank();
        bank.setName("SBER");

        bankRepository.saveAndFlush(bank);

        Bank byName = bankRepository.findByName("SBER");
        Assert.assertNotNull(byName);
    }
}