package ru.eugene.java.learn;

import org.hibernate.LazyInitializationException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ru.eugene.java.learn.config.DomainConfiguration;
import ru.eugene.java.learn.data.Apartment;
import ru.eugene.java.learn.data.Automobile;
import ru.eugene.java.learn.data.Person;
import ru.eugene.java.learn.repository.PersonRepository;

import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DomainConfiguration.class)
@TestPropertySource("classpath:db-test-config.properties")
public class PersonRepositoryFetchExample {
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void findByLoginTest(){
        Person person = personRepository.findByLogin("login_1");
        Assert.assertNotNull(person);
    }

    // Получаем эксепшен поскольку получение автомобилей без fetch и вне транзакции.
    @Test(expected = LazyInitializationException.class)
    public void findByLoginLazyExceptionTest(){
        Person person = personRepository.findByLogin("login_1");
        Assert.assertNotNull(person);

        Set<Automobile> automobiles = person.getAutomobiles();
        Assert.assertNotNull(automobiles);
        Assert.assertNotEquals(0, automobiles.size());
    }

    // Получаем автомобили без fetch в транзакции поэтому все хорошо.
    @Test
    @Transactional
    public void findByLoginTransactionalTest(){
        Person person = personRepository.findByLogin("login_1");
        Assert.assertNotNull(person);

        Set<Automobile> automobiles = person.getAutomobiles();
        Assert.assertNotNull(automobiles);
        Assert.assertEquals(2, automobiles.size());
    }

    // Получаем автомобили используя ключевое слово fetch, работает без транзакции.
    @Test
    public void findByLoginWithAutomobileTest(){
        Person person = personRepository.findByLoginWithAutomobile("login_1");
        Assert.assertNotNull(person);

        Set<Automobile> automobiles = person.getAutomobiles();
        Assert.assertNotNull(automobiles);
        Assert.assertEquals(2, automobiles.size());
    }

    @Test
    @Transactional
    public void findAllTest(){
        List<Person> all = personRepository.findAll();
        Assert.assertNotNull(all);
        Assert.assertEquals(10, all.size());

        for (Person person : all){
            Set<Automobile> automobiles = person.getAutomobiles();
            Assert.assertNotNull(automobiles);
            Assert.assertEquals(2, automobiles.size());
        }
    }

    @Test
    public void findAllWithAutomobileTest(){
        List<Person> all = personRepository.findAllWithAutomobile();
        Assert.assertNotNull(all);
        Assert.assertEquals(10, all.size());

        for (Person person : all){
            Set<Automobile> automobiles = person.getAutomobiles();
            Assert.assertNotNull(automobiles);
            Assert.assertEquals(2, automobiles.size());
        }
    }

    @Test
    public void loadAllPersonApartmentsTest(){
        List<Person> people = personRepository.loadAllPersonApartments();
        Assert.assertNotNull(people);
        Assert.assertEquals(10, people.size());

        for (Person person : people){
            Set<Apartment> apartments = person.getApartments();
            Assert.assertNotNull(apartments);
            Assert.assertEquals(2, apartments.size());
        }
    }

    @Test
    public void loadAllPersonAutomobilesApartmentsTest(){
        Set<Person> people = personRepository.loadAllPersonAutomobilesApartments();
        Assert.assertNotNull(people);
    }
}
