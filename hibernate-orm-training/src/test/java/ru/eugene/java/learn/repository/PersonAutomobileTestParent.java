package ru.eugene.java.learn.repository;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.eugene.java.learn.config.SpringConfiguration;
import ru.eugene.java.learn.data.Automobile;
import ru.eugene.java.learn.data.Person;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class PersonAutomobileTestParent {
    @Autowired
    protected PersonRepository personRepository;

    @Autowired
    protected AutomobileRepository automobileRepository;

    void initDB(){
        Person person_1 = createPerson("name_1", "surname_1", "code_1");
        person_1 = personRepository.saveAndFlush(person_1);
        Assert.assertNotNull(person_1);

        Person person_2 = createPerson("name_2", "surname_2", "code_2");
        person_2 = personRepository.saveAndFlush(person_2);
        Assert.assertNotNull(person_2);

        Person person_3 = createPerson("name_3", "surname_3", "code_3");
        person_3 = personRepository.saveAndFlush(person_3);
        Assert.assertNotNull(person_3);

        Automobile automobile_1 = createAutomobile("mark_1", "model_1", "state_number_1");
        automobile_1.setPerson(person_1);
        automobile_1 = automobileRepository.saveAndFlush(automobile_1);
        Assert.assertNotNull(automobile_1);

        Automobile automobile_2 = createAutomobile("mark_2", "model_2", "state_number_2");
        automobile_2.setPerson(person_1);
        automobile_2 = automobileRepository.saveAndFlush(automobile_2);
        Assert.assertNotNull(automobile_2);

        Automobile automobile_3 = createAutomobile("mark_3", "model_3", "state_number_3");
        automobile_3.setPerson(person_2);
        automobile_3 = automobileRepository.saveAndFlush(automobile_3);
        Assert.assertNotNull(automobile_3);

        Automobile automobile_4 = createAutomobile("mark_4", "model_4", "state_number_4");
        automobile_4 = automobileRepository.saveAndFlush(automobile_4);
        Assert.assertNotNull(automobile_4);
    }

    private Person createPerson(String name, String surname, String code){
        Person person = new Person();
        person.setName(name);
        person.setSurname(surname);
        person.setCode(code);
        return person;
    }

    private Automobile createAutomobile(String mark, String model, String stateNumber){
        Automobile automobile = new Automobile();
        automobile.setMark(mark);
        automobile.setModel(model);
        automobile.setStateNumber(stateNumber);
        return automobile;
    }
}
