package ru.eugene.java.learn.dynamic.backpack;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BackpackTaskImplTest {
    @Test
    public void findTheBestCombinationOfThingsTest(){
        Set<Thing> allThings = new HashSet<>(Arrays.asList(
                new Thing("Аббатство", 1, 7),
                new Thing("Глобус", 1, 6),
                new Thing("Галлерея", 2, 9),
                new Thing("Музей", 4, 9),
                new Thing("Собор", 1, 8)
        ));

        Backpack backpack = new Backpack(4);

        BackpackTask backpackTask = new BackpackTaskImpl();
        Set<Thing> theBestCombinationOfThings = backpackTask.findTheBestCombinationOfThings(allThings, backpack);

        for (Thing thing : theBestCombinationOfThings){
            System.out.println(thing);
        }
    }
}