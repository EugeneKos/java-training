package ru.eugene.java.learn;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ru.eugene.java.learn.config.DomainConfiguration;
import ru.eugene.java.learn.data.*;
import ru.eugene.java.learn.repository.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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

    @Autowired
    private StandRepository standRepository;

    @Autowired
    private NodeRepository nodeRepository;

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


    @Test
    public void standsNodesDBInitialize(){
        Node n1 = new Node("111.22.33.44", "1122");
        Node n2 = new Node("111.22.33.45", "1123");
        Node n3 = new Node("111.22.33.46", "1124");
        Node n4 = new Node("111.22.33.47", "1125");
        Node n5 = new Node("111.22.33.48", "1126");
        Node n6 = new Node("111.22.33.49", "1127");

        Set<Node> nodes = new HashSet<>(Arrays.asList(n1, n2, n3, n4, n5, n6));
        nodeRepository.saveAll(nodes);

        Set<Stand> stands = new HashSet<>();

        Stand s1 = new Stand("stand_1");
        s1.setNodes(new HashSet<>(Arrays.asList(n1, n2, n4)));
        stands.add(s1);

        Stand s2 = new Stand("stand_2");
        s2.setNodes(new HashSet<>(Arrays.asList(n1, n3, n6)));
        stands.add(s2);

        Stand s3 = new Stand("stand_3");
        s3.setNodes(new HashSet<>(Arrays.asList(n4, n2, n5)));
        stands.add(s3);

        Stand s4 = new Stand("stand_4");
        s4.setNodes(new HashSet<>(Arrays.asList(n3, n6, n5)));
        stands.add(s4);

        standRepository.saveAll(stands);
    }

}
