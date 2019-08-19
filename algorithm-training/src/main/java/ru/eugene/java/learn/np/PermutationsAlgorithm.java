package ru.eugene.java.learn.np;

import java.util.List;
import java.util.Set;

public interface PermutationsAlgorithm<T> {
    /**
     * Алгоритм нахождения всех перестановок.
     *
     * @param set Множество каких-либо объектов
     * @return Список всех перестановок, в котором каждый элемент это список объектов.
     * Каждый следующий список объектов отличается от предыдущего.
     */
    List<List<T>> findAllPermutations(Set<T> set);
}
