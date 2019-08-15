package ru.eugene.java.learn.greedy.service.impl;

import ru.eugene.java.learn.greedy.service.ExponentialSetService;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class ExponentialSetServiceImpl<T> implements ExponentialSetService<T> {
    @Override
    public Set<Set<T>> getAllSubsets(Set<T> set) {
        int bitDepth = set.size();
        int numSubsets = (int) Math.pow(2, bitDepth);

        Set<Set<T>> allSubsets = new HashSet<>();
        Map<Integer, T> mapping = getMapping(set);

        for (int i = 0; i < numSubsets; i++) {
            int[] binaryRepresentation = binaryRepresentation(i, bitDepth);
            Set<T> subset = createSubset(mapping, binaryRepresentation);
            allSubsets.add(subset);
        }

        return allSubsets;
    }

    private Set<T> createSubset(Map<Integer, T> mapping, int[] binaryRepresentation){
        Set<T> subset = new HashSet<>();
        for (int i = 0; i < binaryRepresentation.length; i++) {
            if(binaryRepresentation[i] == 1){
                T item = mapping.get(i);
                subset.add(item);
            }
        }
        return subset;
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
