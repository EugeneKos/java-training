package ru.eugene.java.learn.sort;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SorterImpl implements Sorter {
    /**
     * Сортировка массива выбором, каждый раз находим наименьшее число в массиве, добавляем это число
     * в новый массив и удаляем его из исходного массива, путем копирования двух частей в новый массив.
     *
     * @param array sours array
     * @return sorted array
     */
    public int[] selectionSort(int[] array) {
        int length = array.length;
        int[] sortedArray = new int[length];
        for (int i = 0; i < length; i++) {
            int indexMinValue = findIndexMinValueOnArray(array);
            sortedArray[i] = array[indexMinValue];
            array = copyArrayWithoutValueByIndex(array, indexMinValue);
        }
        return sortedArray;
    }

    private int[] copyArrayWithoutValueByIndex(int[] array, int index) {
        int[] firstPart = Arrays.copyOfRange(array, 0, index);
        int[] secondPart = Arrays.copyOfRange(array, index + 1, array.length);
        int[] result = new int[firstPart.length + secondPart.length];
        System.arraycopy(firstPart, 0, result, 0, firstPart.length);
        System.arraycopy(secondPart, 0, result, firstPart.length, secondPart.length);
        return result;
    }

    private int findIndexMinValueOnArray(int[] array) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < array[index]) {
                index = i;
            }
        }
        return index;
    }

    /**
     * Сортировка списка выбором, каждый раз находим наименьшее число в списке, добавляем это число
     * в новый список и удаляем его из исходного списка.
     *
     * @param list sours list
     * @return sorted list
     */
    public List<Integer> selectionSort(List<Integer> list) {
        List<Integer> sortedList = new LinkedList<>();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int indexMinValue = findIndexMinValueOnList(list);
            sortedList.add(list.remove(indexMinValue));
        }
        return sortedList;
    }

    private int findIndexMinValueOnList(List<Integer> list) {
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < list.get(index)) {
                index = i;
            }
        }
        return index;
    }

    /**
     * Сортировка массива пузырьковым методом.
     *
     * @param array sours array
     * @return sorted array
     */
    @Override
    public int[] bubblySort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                int current = array[j];
                int next = array[j + 1];
                if(next < current){
                    array[j] = next;
                    array[j + 1] = current;
                }
            }
        }
        return array;
    }
}
