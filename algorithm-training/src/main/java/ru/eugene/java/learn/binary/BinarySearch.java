package ru.eugene.java.learn.binary;

public class BinarySearch {
    /**
     * Алгоритм бинарного поиска элемента в массиве.
     *
     * @param mas sours massive
     * @param value value to find
     * @return position of the desired value or -1 if not found
     */
    public int binarySearch(int[] mas, int value){
        int min = 0;
        int max = mas.length - 1;
        while (min <= max){
            int middle = (min + max) / 2;
            if(mas[middle] == value){
                return middle;
            } else if(mas[middle] < value){
                min = middle + 1;
            } else if(mas[middle] > value){
                max = middle - 1;
            }
        }
        return -1;
    }
}
