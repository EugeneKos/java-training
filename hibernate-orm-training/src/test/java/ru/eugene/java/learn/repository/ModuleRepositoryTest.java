package ru.eugene.java.learn.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.eugene.java.learn.config.SpringConfiguration;
import ru.eugene.java.learn.data.Module;

import java.util.ArrayList;
import java.util.List;

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

        moduleRepository.save(module);
    }
}