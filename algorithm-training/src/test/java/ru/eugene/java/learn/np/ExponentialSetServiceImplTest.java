package ru.eugene.java.learn.np;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class ExponentialSetServiceImplTest {
    private static final int NUM_ITEMS = 4;

    @Test
    public void getAllVariablesTest(){
        ExponentialSetService<String> exponentialSetService = new ExponentialSetServiceImpl<>();

        Set<String> items = getItems();

        Set<Set<String>> allSubsets = exponentialSetService.getAllSubsets(items);

        System.out.println("number subsets: " + allSubsets.size());

        for (Set<String> subset : allSubsets){
            System.out.println(subset);
        }
    }

    private Set<String> getItems(){
        Set<String> items = new HashSet<>();
        for (int i = 0; i < NUM_ITEMS; i++) {
            items.add(String.valueOf(i));
        }
        return items;
    }
}