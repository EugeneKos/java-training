package ru.eugene.java.learn.binary;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTest {
    @Test
    public void testBinarySearch(){
        int[] mas = initMas();

        BinarySearch binarySearch = new BinarySearch();
        int pos = binarySearch.binarySearch(mas, 51);

        assertEquals("compare position", 51, pos);
    }

    private int[] initMas(){
        int[] mas = new int[123];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = i;
        }
        return mas;
    }
}