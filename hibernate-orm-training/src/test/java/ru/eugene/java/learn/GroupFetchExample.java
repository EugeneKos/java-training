package ru.eugene.java.learn;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ru.eugene.java.learn.config.DomainConfiguration;
import ru.eugene.java.learn.data.Group;
import ru.eugene.java.learn.dao.GroupDao;
import ru.eugene.java.learn.repository.GroupRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DomainConfiguration.class)
@TestPropertySource("classpath:db-test-config.properties")
public class GroupFetchExample {
    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private GroupDao groupDao;

    @Test
    public void findByNameWithLoadChildrenTest(){
        Group parent = groupDao.findByNameWithLoadChildren("parent", 3);
        Assert.assertNotNull(parent);
    }

    @Test
    public void getGroupTreeByParentNameTest(){
        Group groupTreeByParentName = groupDao.getGroupTreeByParentName("parent");
        Assert.assertNotNull(groupTreeByParentName);
    }

    @Test
    public void findByNameTest(){
        Group parent = groupRepository.findByName("parent");
        Assert.assertNotNull(parent);
    }

    @Test
    public void findByNameFetchChildrenTest(){
        Group parent = groupRepository.findByNameFetchChildren("parent");
        Assert.assertNotNull(parent);
    }

    @Test
    public void loadGroupWithChildrenByNameTest(){
        Group parent = groupRepository.loadGroupWithChildrenByName("parent");
        Assert.assertNotNull(parent);
    }

    @Test
    @Transactional
    public void findAllGroupsWithTheirChildrenAndByNameTest(){
        groupRepository.findAllGroupsWithTheirChildren();

        Group parent = groupRepository.findByName("parent");
        Assert.assertNotNull(parent);
    }
}
