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

    @Test
    public void testBubblySort(){
        int[] array = {45, 23, 1, 77, 10, 5, 98, 2, 1};
        int[] sorted = sorter.bubblySort(array);
        System.out.println("Bubbly sorted array: " + Arrays.toString(sorted));

        Assert.assertArrayEquals("compare arrays",
                new int[]{1, 1, 2, 5, 10, 23, 45, 77, 98},
                sorted);
    }

    @Test
    public void testQuickSort(){
        int[] array = {45, 23, 1, 77, 10, 5, 98, 2, 1};
        int[] sorted = sorter.quickSort(array);
        System.out.println("Quick sorted array: " + Arrays.toString(sorted));

        Assert.assertArrayEquals("compare arrays",
                new int[]{1, 1, 2, 5, 10, 23, 45, 77, 98},
                sorted);
    }

    @Test
    public void quickSortTest_2(){
        int[] array = {45, 23, 1, 77, 10, 5, 98, 2, 1};
        Sorters.quickSort(array);
        System.out.println("Quick sorted array 2: " + Arrays.toString(array));

        Assert.assertArrayEquals("compare arrays",
                new int[]{1, 1, 2, 5, 10, 23, 45, 77, 98},
                array);
    }

    @Test
    public void benchmark(){
        int[] array = {45, 23, 1, 77, 10, 5, 98, 2, 1};

        long startTime = System.nanoTime();
        sorter.selectionSort(array);
        long finTime = System.nanoTime();
        System.out.println("Selection sort dif time: " + (finTime - startTime));

        startTime = System.nanoTime();
        sorter.bubblySort(array);
        finTime = System.nanoTime();
        System.out.println("Bubbly sort dif time: " + (finTime - startTime));

        startTime = System.nanoTime();
        sorter.quickSort(array);
        finTime = System.nanoTime();
        System.out.println("Quick sort dif time: " + (finTime - startTime));

        startTime = System.nanoTime();
        Sorters.quickSort(array);
        finTime = System.nanoTime();
        System.out.println("Quick sort 2 dif time: " + (finTime - startTime));
    }
}