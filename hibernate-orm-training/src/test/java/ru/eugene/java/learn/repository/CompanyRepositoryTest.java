package ru.eugene.java.learn.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.eugene.java.learn.config.SpringConfiguration;
import ru.eugene.java.learn.data.Bank;
import ru.eugene.java.learn.data.Company;
import ru.eugene.java.learn.data.Person;
import ru.eugene.java.learn.service.IPersonService;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class CompanyRepositoryTest {
    @Autowired
    private IPersonService personService;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void testManyToMany(){
        Company company = new Company();
        company.setName("OOO Jet Soft");
        companyRepository.save(company);

        Person person1 = personService.create("Eugene", "Kosinov", "code_44");
        Person person2 = personService.create("Eugene", "Bad", "code_99");

        person1.setCompany(company);
        person2.setCompany(company);

        Bank bankVTB = new Bank();
        bankVTB.setName("VTB");
        bankVTB.setPeople(Arrays.asList(person1, person2));

        Bank bankSberbank = new Bank();
        bankSberbank.setName("Sberbank");
        bankSberbank.setPeople(Arrays.asList(person1, person2));

        bankRepository.save(bankVTB);
        bankRepository.save(bankSberbank);

        personRepository.save(person1);
        personRepository.save(person2);
    }

    @Test
    public void testGetLazy(){
        Company company = companyRepository.findByName("OOO Jet Soft");
        assertNotNull(company);
    }

    @Test
    public void testGetFetchPeople(){
        Company company = companyRepository.findByNameFetchPeople("OOO Jet Soft");
        assertNotNull(company);

        Bank bank = bankRepository.findByNameFetchPeople("VTB");
        assertNotNull(bank);

        Person person = personRepository.findByCodeFetchBanks("code_99");
        assertNotNull(person);
    }
}