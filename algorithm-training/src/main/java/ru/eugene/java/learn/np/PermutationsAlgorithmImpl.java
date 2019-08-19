package ru.eugene.java.learn.np;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PermutationsAlgorithmImpl<T> implements PermutationsAlgorithm<T> {
    @Override
    public List<List<T>> findAllPermutations(Set<T> set) {
        List<List<T>> all = new LinkedList<>();
        for (T item : set){
            all = fill(item, all);
        }
        return all;
    }

    private List<List<T>> fill(T item, List<List<T>> all){
        if(all.isEmpty()){
            List<T> subAll = new LinkedList<>();
            subAll.add(item);
            all.add(subAll);
            return all;
        }
        List<List<T>> newAll = new LinkedList<>();
        for (List<T> subAll : all){
            for (int i = 0; i < subAll.size() + 1; i++) {
                List<T> newSubAll = new LinkedList<>(subAll);
                newSubAll.add(i, item);
                newAll.add(newSubAll);
            }
        }
        return newAll;
    }
}
