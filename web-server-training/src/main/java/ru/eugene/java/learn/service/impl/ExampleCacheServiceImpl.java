package ru.eugene.java.learn.service.impl;

import org.springframework.stereotype.Service;
import ru.eugene.java.learn.service.IExampleCacheService;

import javax.cache.annotation.CacheKey;
import javax.cache.annotation.CacheResult;

@Service
public class ExampleCacheServiceImpl implements IExampleCacheService {
    @Override
    @CacheResult(cacheName = "exampleCache")
    public String perform(@CacheKey String name, @CacheKey String surname) {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return name + " : " + surname;
    }

    @Override
    @CacheResult(cacheName = "exampleCache")
    public String perform() {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "fix result";
    }
}
