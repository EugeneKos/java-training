package ru.eugene.java.learn;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ru.eugene.java.learn.config.DomainConfiguration;
import ru.eugene.java.learn.data.Node;
import ru.eugene.java.learn.data.Stand;
import ru.eugene.java.learn.repository.StandRepository;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DomainConfiguration.class)
@TestPropertySource("classpath:db-test-config.properties")
public class StandsNodesExample {
    @Autowired
    private StandRepository standRepository;

    @Test
    public void findByNameTest(){
        Stand stand_1 = standRepository.findByName("stand_1");
        Assert.assertNotNull(stand_1);

        Set<Node> nodes = stand_1.getNodes();
        Assert.assertNotNull(nodes);
        Assert.assertEquals(3, nodes.size());
    }

    @Test
    public void findAllByNameTest(){
        List<Stand> allByName = standRepository.findAllByName("stand_1");
        Assert.assertNotNull(allByName);
        Assert.assertEquals(3, allByName.size());
    }

    @Test
    public void findAllByDescriptionTest(){
        Set<Stand> allByDescription = standRepository.findAllByDescription("11");
        Assert.assertNotNull(allByDescription);
        Assert.assertEquals(2, allByDescription.size());

        Iterator<Stand> standIterator = allByDescription.iterator();

        assertNodesSizeEquals(standIterator.next(), 3);
        assertNodesSizeEquals(standIterator.next(), 3);
    }

    private void assertNodesSizeEquals(Stand stand, int nodesSize){
        Assert.assertNotNull(stand);

        Set<Node> nodes = stand.getNodes();
        Assert.assertNotNull(nodes);
        Assert.assertEquals(nodesSize, nodes.size());
    }
}
