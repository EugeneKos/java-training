package ru.eugene.java.learn.sort;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SorterTest {
    private Sorter sorter;

    @Before
    public void init(){
        sorter = new SorterImpl();
    }

    @Test
    public void testSelectionSortArray(){
        int[] array = {45, 23, 1, 77, 10, 5, 98, 2, 1};
        int[] sorted = sorter.selectionSort(array);
        System.out.println("Sorted array: " + Arrays.toString(sorted));

        Assert.assertArrayEquals("compare arrays",
                new int[]{1, 1, 2, 5, 10, 23, 45, 77, 98},
                sorted);
    }

    @Test
    public void testSelectionSortList(){
        List<Integer> list = new ArrayList<>(Arrays.asList(45, 23, 1, 77, 10, 5, 98, 2, 1));
        List<Integer> sortedList = sorter.selectionSort(list);
        System.out.println("Sorted list: " + sortedList);

        Assert.assertEquals("compare list",
                Arrays.asList(1, 1, 2, 5, 10, 23, 45, 77, 98),
                sortedList);
    }
}