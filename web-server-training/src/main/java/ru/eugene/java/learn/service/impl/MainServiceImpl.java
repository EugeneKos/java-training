package ru.eugene.java.learn.service.impl;

import org.springframework.stereotype.Service;
import ru.eugene.java.learn.service.IMainService;

import javax.cache.annotation.CacheKey;
import javax.cache.annotation.CacheResult;

@Service
public class MainServiceImpl implements IMainService {
    @Override
    @CacheResult(cacheName = "testCache")
    public String perform(@CacheKey String name, @CacheKey String surname) {
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return name + " : " + surname;
    }
}
