package ru.eugene.java.learn;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ru.eugene.java.learn.config.DomainConfiguration;
import ru.eugene.java.learn.data.Automobile;
import ru.eugene.java.learn.data.Person;
import ru.eugene.java.learn.repository.AutomobileRepository;
import ru.eugene.java.learn.repository.PersonRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DomainConfiguration.class)
@TestPropertySource("classpath:db-init-test-config.properties")
public class DatabaseInitializer {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AutomobileRepository automobileRepository;

    @Test
    public void fillDatabase(){
        for (int i = 0; i < 10; i++) {
            Person person = new Person("name_" + i, "surname_" + i, "login_" + i);
            person = personRepository.saveAndFlush(person);

            Automobile automobile_1 = new Automobile(
                    "mark_a" + i, "model_a" + i, "state_num_a" + i
            );
            automobile_1.setPerson(person);

            Automobile automobile_2 = new Automobile(
                    "mark_b" + i, "model_b" + i, "state_num_b" + i
            );
            automobile_2.setPerson(person);

            automobileRepository.saveAndFlush(automobile_1);
            automobileRepository.saveAndFlush(automobile_2);
        }
    }


}
