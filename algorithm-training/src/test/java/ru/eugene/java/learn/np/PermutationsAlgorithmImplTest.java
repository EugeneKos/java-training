package ru.eugene.java.learn.np;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsAlgorithmImplTest {
    @Test
    public void findAllPermutationsTest(){
        Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        PermutationsAlgorithm permutationsAlgorithm = new PermutationsAlgorithmImpl();

        List<List<Integer>> lists = permutationsAlgorithm.findAllPermutations(set);

        for (List<Integer> subLists : lists){
            System.out.println(subLists);
        }

        System.out.println("size: " + lists.size());
    }
}