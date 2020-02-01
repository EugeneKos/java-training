package ru.eugene.java.learn.sort;

public final class Sorters {
    private static final int START_POSITION = 0;

    public static void quickSort(int[] array) {
        quickSort(array, START_POSITION);
    }

    private static void quickSort(int[] array, int startPos) {
        int minValue = Integer.MAX_VALUE;
        int minValuePos = -1;

        for (int i = startPos; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
                minValuePos = i;
            }
        }

        int valueByStartPos = array[startPos];
        array[startPos] = minValue;
        array[minValuePos] = valueByStartPos;

        if(startPos == (array.length - 2)){
            return;
        }

        quickSort(array, ++startPos);
    }
}
