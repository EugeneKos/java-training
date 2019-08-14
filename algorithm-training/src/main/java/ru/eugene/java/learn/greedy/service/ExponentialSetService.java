package ru.eugene.java.learn.greedy.service;

import java.util.Set;

public interface ExponentialSetService<T> {
    /**
     * Получение всевозможных вариантов элементов в множестве. Так называемое степенное множество.
     * В конечном множестве должно содержаться 2 в степени n подмножеств.
     *
     * @param set Множество элементов.
     * @return Множество подмножеств с вариантами элементов.
     */
    Set<Set<T>> getAllSubsets(Set<T> set);
}
