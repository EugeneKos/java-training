package ru.eugene.java.learn;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ru.eugene.java.learn.config.DomainConfiguration;
import ru.eugene.java.learn.data.Apartment;
import ru.eugene.java.learn.data.Automobile;
import ru.eugene.java.learn.data.Group;
import ru.eugene.java.learn.data.Person;
import ru.eugene.java.learn.repository.ApartmentRepository;
import ru.eugene.java.learn.repository.AutomobileRepository;
import ru.eugene.java.learn.repository.GroupRepository;
import ru.eugene.java.learn.repository.PersonRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DomainConfiguration.class)
@TestPropertySource("classpath:db-init-test-config.properties")
public class DatabaseInitializer {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AutomobileRepository automobileRepository;

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Autowired
    private GroupRepository groupRepository;

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

            Apartment apartment_1 = new Apartment("apartment_address_a" + i);
            apartment_1.setPerson(person);

            Apartment apartment_2 = new Apartment("apartment_address_b" + i);
            apartment_2.setPerson(person);

            apartmentRepository.saveAndFlush(apartment_1);
            apartmentRepository.saveAndFlush(apartment_2);
        }
    }

    @Test
    public void fillGroups(){
        Group child_1Level_3 = new Group("child_1_level_3");
        Group child_2Level_3 = new Group("child_2_level_3");
        Group child_3Level_3 = new Group("child_3_level_3");

        groupRepository.saveAndFlush(child_1Level_3);
        groupRepository.saveAndFlush(child_2Level_3);
        groupRepository.saveAndFlush(child_3Level_3);

        Group child_1Level_2 = new Group("child_1_level_2");
        child_1Level_2.setChildrenGroups(new HashSet<>(Collections.singleton(child_1Level_3)));
        groupRepository.saveAndFlush(child_1Level_2);

        Group child_2Level_2 = new Group("child_2_level_2");
        child_2Level_2.setChildrenGroups(new HashSet<>(Collections.singleton(child_2Level_3)));
        groupRepository.saveAndFlush(child_2Level_2);

        Group child_3Level_2 = new Group("child_3_level_2");
        child_3Level_2.setChildrenGroups(new HashSet<>(Collections.singleton(child_3Level_3)));
        groupRepository.saveAndFlush(child_3Level_2);

        Group child_1Level_1 = new Group("child_1_level_1");
        child_1Level_1.setChildrenGroups(new HashSet<>(Collections.singleton(child_1Level_2)));
        groupRepository.saveAndFlush(child_1Level_1);

        Group child_2Level_1 = new Group("child_2_level_1");
        child_2Level_1.setChildrenGroups(new HashSet<>(Collections.singleton(child_2Level_2)));
        groupRepository.saveAndFlush(child_2Level_1);

        Group child_3Level_1 = new Group("child_3_level_1");
        child_3Level_1.setChildrenGroups(new HashSet<>(Collections.singleton(child_3Level_2)));
        groupRepository.saveAndFlush(child_3Level_1);


        Group parent = new Group("parent");
        parent.setChildrenGroups(new HashSet<>(Arrays.asList(child_1Level_1, child_2Level_1, child_3Level_1)));
        groupRepository.saveAndFlush(parent);
    }


}
