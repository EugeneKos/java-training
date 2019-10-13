package ru.eugene.java.learn.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ru.eugene.java.learn.config.SpringConfiguration;
import ru.eugene.java.learn.data.dto.NodeDTO;
import ru.eugene.java.learn.data.dto.StandDTO;
import ru.eugene.java.learn.util.DTOUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class StandServiceTest {
    @Autowired
    private IStandService standService;

    @Test
    public void editStandTest(){
        StandDTO standDTO = DTOUtils.createStandDTO("Platon", "description 1");

        NodeDTO nodeDTO1 = DTOUtils.createNodeDTO("10.10.10.10", "2020", "desctipton 1");
        NodeDTO nodeDTO2 = DTOUtils.createNodeDTO("10.10.10.10", "2030", "desctipton 2");

        standDTO.setNodeDTOSet(new HashSet<>(Arrays.asList(nodeDTO1, nodeDTO2)));

        standDTO = standService.editStand(standDTO);
        Assert.assertNotNull(standDTO);
    }

    @Test
    public void editStand_2Test(){
        StandDTO standDTOByName = standService.getStandByName("Platon");
        Assert.assertNotNull(standDTOByName);

        Set<NodeDTO> nodeDTOSet = standDTOByName.getNodeDTOSet();
        Assert.assertNotNull(nodeDTOSet);

        nodeDTOSet.iterator().next().setIpAddress("10.10.10.20");

        StandDTO editedStand = standService.editStand(standDTOByName);
        Assert.assertNotNull(editedStand);
    }
}