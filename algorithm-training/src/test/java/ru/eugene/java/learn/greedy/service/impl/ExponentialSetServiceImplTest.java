package ru.eugene.java.learn.greedy.service.impl;

import org.junit.Assert;
import org.junit.Test;
import ru.eugene.java.learn.greedy.service.ExponentialSetService;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExponentialSetServiceImplTest {
    @Test
    public void getAllVariablesTest(){
        ExponentialSetService<String> exponentialSetService = new ExponentialSetServiceImpl<>();

        Set<String> items = new HashSet<>(Arrays.asList("1", "2", "3", "4"));

        Set<Set<String>> allSubsets = exponentialSetService.getAllSubsets(items);

        Assert.assertEquals("compare subset size", 16, allSubsets.size());
        System.out.println("number subsets: " + allSubsets.size());

        for (Set<String> subset : allSubsets){
            System.out.println(subset);
        }
    }
}