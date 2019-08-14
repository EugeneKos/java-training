package ru.eugene.java.learn.greedy.service.impl;

import ru.eugene.java.learn.greedy.service.ExponentialSetService;

import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class ExponentialSetServiceImpl<T> implements ExponentialSetService<T> {
    @Override
    public Set<Set<T>> getAllSubsets(Set<T> set) {
        int bitDepth = set.size();
        int numSubsets = (int) Math.pow(2, bitDepth);

        List<Set<T>> allSubsets = initialSubsets(numSubsets);
        Map<Integer, T> mapping = getMapping(set);

        int count = 0;
        for (Set<T> subset : allSubsets) {
            int[] binaryRepresentation = binaryRepresentation(count, bitDepth);
            fillingSubset(subset, mapping, binaryRepresentation);
            count++;
        }

        return new HashSet<>(allSubsets);
    }

    private void fillingSubset(Set<T> subset, Map<Integer, T> mapping, int[] binaryRepresentation){
        for (int i = 0; i < binaryRepresentation.length; i++) {
            if(binaryRepresentation[i] == 1){
                T item = mapping.get(i);
                subset.add(item);
            }
        }
    }

    private List<Set<T>> initialSubsets(int size){
        List<Set<T>> allSubsets = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            allSubsets.add(new HashSet<>());
        }
        return allSubsets;
    }

    private Map<Integer, T> getMapping(Set<T> set){
        Map<Integer, T> map = new HashMap<>();
        int position = 0;
        for (T item : set){
            map.put(position, item);
            position++;
        }
        return map;
    }

    private int[] binaryRepresentation(int number, int bitDepth){
        int[] bits = new int[bitDepth];
        divideOnTwo(number, bits, 0);
        return bits;
    }

    private void divideOnTwo(int number, int[] bits, int position){
        int quotient = number / 2;
        int remain = number % 2;
        if(position < bits.length){
            bits[position] = remain;
        }
        if(quotient == 1 || quotient == 0){
            if(position + 1 < bits.length){
                bits[position + 1] = quotient;
            }
            return;
        }
        divideOnTwo(quotient, bits, position + 1);
    }
}
