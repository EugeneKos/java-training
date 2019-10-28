package ru.eugene.java.learn.service.impl;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

import ru.eugene.java.learn.service.IExampleMBeanService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@ManagedResource
public class ExampleMBeanServiceImpl implements IExampleMBeanService {
    private Map<Integer, String> map = new ConcurrentHashMap<>();

    @ManagedAttribute
    public Map<Integer, String> getMap() {
        return map;
    }

    @Override
    public void updateMap() {
        map.clear();
        int random = (int) (Math.random() * 100);
        for (int i = 0; i < random; i++) {
            String randomStr = "Random: " + Math.random();
            map.put(i, randomStr);
        }
    }
}
