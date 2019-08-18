package ru.eugene.java.learn.np;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PermutationsAlgorithmImpl implements PermutationsAlgorithm {
    @Override
    public List<List<Integer>> findAllPermutations(Set<Integer> set) {
        List<List<Integer>> all = new LinkedList<>();
        for (Integer item : set){
            all = fill(item, all);
        }
        return all;
    }

    private List<List<Integer>> fill(Integer item, List<List<Integer>> all){
        if(all.isEmpty()){
            List<Integer> subAll = new LinkedList<>();
            subAll.add(item);
            all.add(subAll);
            return all;
        }
        List<List<Integer>> newAll = new LinkedList<>();
        for (List<Integer> subAll : all){
            for (int i = 0; i < subAll.size() + 1; i++) {
                List<Integer> newSubAll = new LinkedList<>(subAll);
                newSubAll.add(i, item);
                newAll.add(newSubAll);
            }
        }
        return newAll;
    }
}
