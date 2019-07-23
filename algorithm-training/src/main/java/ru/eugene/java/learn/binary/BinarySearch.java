package ru.eugene.java.learn.binary;

public class BinarySearch {
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
