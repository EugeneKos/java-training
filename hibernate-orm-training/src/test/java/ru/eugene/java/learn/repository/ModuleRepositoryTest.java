package ru.eugene.java.learn.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.eugene.java.learn.config.SpringConfiguration;
import ru.eugene.java.learn.data.Module;
import ru.eugene.java.learn.data.Param;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
public class ModuleRepositoryTest {
    @Autowired
    private ModuleRepository moduleRepository;

    @Test
    public void testAdd(){
        Module module = new Module();
        module.setName("module-test");

        List<String> list = new ArrayList<>();
        list.add("alias 1");
        list.add("alias 2");
        list.add("alias 3");
        list.add("alias 4");

        module.setAliases(list);

        Map<Param, String> params = new HashMap<>();
        params.put(Param.GROUP_ID, "com.sbt.custodian");
        params.put(Param.ARTIFACT_ID, "custodian-api");
        params.put(Param.VERSION, "9.0");

        module.setParams(params);

        moduleRepository.save(module);
    }

    @Test
    public void testGet(){
        Module module = moduleRepository.findByName("module-test");
        assertNotNull(module);
        assertNotNull(module.getAliases());
        assertNotNull(module.getParams());
        System.out.println("Aliases: " + module.getAliases());
        System.out.println("Params: " + module.getParams());
    }
}