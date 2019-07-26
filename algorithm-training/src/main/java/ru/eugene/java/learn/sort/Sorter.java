package ru.eugene.java.learn.sort;

import java.util.List;

public interface Sorter {
    int[] selectionSort(int[] array);

    List<Integer> selectionSort(List<Integer> list);

    int[] bubblySort(int[] array);
}
