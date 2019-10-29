package ru.eugene.java.learn.experiment;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ru.eugene.java.learn.config.SpringConfiguration;
import ru.eugene.java.learn.data.Node;
import ru.eugene.java.learn.data.Stand;
import ru.eugene.java.learn.repository.NodeRepository;
import ru.eugene.java.learn.repository.StandRepository;

import java.util.Arrays;
import java.util.HashSet;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class StandNodeExperimentTest {
    @Autowired
    private NodeRepository nodeRepository;

    @Autowired
    private StandRepository standRepository;

    @Test
    @Transactional
    @Commit
    public void saveStandNodeTest(){
        Node node1 = new Node();
        node1.setIpAddress("10.10.10.10");
        node1.setPort("4040");

        Node node2 = new Node();
        node2.setIpAddress("10.10.10.10");
        node2.setPort("4041");

        node1 = nodeRepository.saveAndFlush(node1);
        node2 = nodeRepository.saveAndFlush(node2);

        Stand stand = new Stand();
        stand.setName("Platon");
        stand.setNodes(new HashSet<>(Arrays.asList(node1, node2)));

        stand = standRepository.saveAndFlush(stand);
        Assert.assertNotNull(stand);
    }

    @Test
    @Transactional
    @Commit
    public void findAndEditStandNode_1Test(){
        Node node1 = nodeRepository.findByIpAddressAndPort("10.10.10.10", "4040");

        Node node2 = nodeRepository.findByIpAddressAndPort("10.10.10.10", "4041");

        node1.setPort("4058");
        node1 = nodeRepository.saveAndFlush(node1);

        Stand stand = standRepository.findByName("Platon");

        stand.setNodes(new HashSet<>(Arrays.asList(node1, node2)));

        standRepository.saveAndFlush(stand);
    }

    @Test
    @Transactional
    @Commit
    public void findAndEditStandNode_2Test(){
        Node node1 = nodeRepository.findByIpAddressAndPort("10.10.10.10", "4040");

        Node node2 = nodeRepository.findByIpAddressAndPort("10.10.10.10", "4041");

        Node newNode1 = new Node();
        newNode1.setId(node1.getId());
        newNode1.setIpAddress(node1.getIpAddress());
        newNode1.setPort("4058");

        Node newNode2 = new Node();
        newNode2.setId(node2.getId());
        newNode2.setIpAddress(node2.getIpAddress());
        newNode2.setPort(node2.getPort());

        newNode1 = nodeRepository.saveAndFlush(newNode1);
        newNode2 = nodeRepository.saveAndFlush(newNode2);

        Node new1Node1 = new Node();
        new1Node1.setId(newNode1.getId());
        new1Node1.setIpAddress(newNode1.getIpAddress());
        new1Node1.setPort(newNode1.getPort());

        Node new1Node2 = new Node();
        new1Node2.setId(newNode2.getId());
        new1Node2.setIpAddress(newNode2.getIpAddress());
        new1Node2.setPort(newNode2.getPort());

        Stand stand = standRepository.findByName("Platon");

        Stand newStand = new Stand();
        newStand.setId(stand.getId());
        newStand.setName(stand.getName());
        newStand.setNodes(new HashSet<>(Arrays.asList(new1Node1, new1Node2)));

        standRepository.saveAndFlush(newStand);
    }
}
