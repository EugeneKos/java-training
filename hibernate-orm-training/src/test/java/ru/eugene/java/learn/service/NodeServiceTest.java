package ru.eugene.java.learn.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ru.eugene.java.learn.config.SpringConfiguration;
import ru.eugene.java.learn.data.dto.NodeDTO;
import ru.eugene.java.learn.exception.NotUniqueException;

import static ru.eugene.java.learn.util.DTOUtils.createNodeDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class NodeServiceTest {
    @Autowired
    private INodeService nodeService;

    @Test
    public void editNodeTest(){
        NodeDTO dto = createNodeDTO("10.10.10.10", "4040", "description 1");

        dto = nodeService.editNode(dto);
        Assert.assertNotNull(dto);
        Assert.assertEquals("description 1", dto.getDescription());

        dto.setDescription("description 2");

        dto = nodeService.editNode(dto);
        Assert.assertNotNull(dto);
        Assert.assertEquals("description 2", dto.getDescription());

        dto.setPort("5555");

        dto = nodeService.editNode(dto);
        Assert.assertNotNull(dto);
        Assert.assertEquals("5555", dto.getPort());
    }

    @Test(expected = NotUniqueException.class)
    public void editNodeWithException_1Test(){
        NodeDTO dto1 = createNodeDTO("10.10.10.10", "4040", "description 1");
        NodeDTO dto2 = createNodeDTO("10.10.10.11", "4050", "description 2");

        dto1 = nodeService.editNode(dto1);
        dto2 = nodeService.editNode(dto2);

        Assert.assertNotNull(dto1);
        Assert.assertNotNull(dto2);

        dto2.setIpAddress("10.10.10.10");
        dto2.setPort("4040");

        nodeService.editNode(dto2);
    }

    @Test(expected = NotUniqueException.class)
    public void editNodeWithException_2Test(){
        NodeDTO dto1 = createNodeDTO("10.10.10.10", "4040", "description 1");
        NodeDTO dto2 = createNodeDTO("10.10.10.10", "4040", "description 2");

        dto1 = nodeService.editNode(dto1);
        Assert.assertNotNull(dto1);

        nodeService.editNode(dto2);
    }
}